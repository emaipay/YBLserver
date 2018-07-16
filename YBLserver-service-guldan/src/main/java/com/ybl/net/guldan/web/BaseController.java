package com.ybl.net.guldan.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.ybl.net.commom.util.UboxConstants;

public abstract class BaseController {
	
	//private transient final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected static final String PRODUCT_NAME_REGEX = "[(a-z0-9)]";
	private static final String JSON_TYPE = "application/json;charset=utf-8";
	
	//登录用户信息属性
	protected static final String USERID = "userId";			   //用户名或登录名
	protected static final String USERNAME = "username";			   //用户名或登录名
	protected static final String MOBILE = "mobile";				  //手机号码
	protected static final String EMAIL = "email";					 //邮箱
	protected static final String NAME = "name";					//联系人名字
	protected static final String CUSTOMERCODE = "customerCode";   //客户编号
	protected static final String ORIGIN = "origin";              //来源
	
	/**
	 * 获取登录用户信息
	 * @param request
	 * @return  返回一个map，返回的用户信息有：username（用户名登录名）、mobile（手机号码）、email（邮箱）、
	 * 			name（联系人名字）、customerCode（客户编号）、origin（来源UBOX|TPA）
	 */
	protected Map<String, Object> getUserAttributes(HttpServletRequest request){
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion == null) {
			return null;
		}
		AttributePrincipal principal = assertion.getPrincipal();
		Map<String, Object> attributes = principal.getAttributes();
		attributes.put(USERNAME, principal.getName());
		return attributes;
	}
	
	/**
	 * 获取用户名
	 */
	protected String getUsername(HttpServletRequest request) {
		Map<String, Object> attributes = this.getUserAttributes(request);
		if(attributes == null) {
			return null;
		}
		return (String)attributes.get(USERNAME);
	}
	
	/**
	 * 获取用户ID
	 */
	@SuppressWarnings("unchecked")
	protected int getUserId(HttpServletRequest request) {
		Map<String, Object> attributes = (Map<String, Object>)request.getSession().getAttribute(UboxConstants.LOGIN_USER);
		return (Integer)attributes.get(USERID);
	}
	
	/**
	 * 单独获取登录用户的某个信息
	 * @param request
	 * @param attributeName 属性名
	 */
	protected Object getAttribute(HttpServletRequest request, String attributeName) throws Exception{
		return this.getUserAttributes(request).get(attributeName);
	}
	
	protected void writer(Object obj, String jsoncallback, HttpServletResponse response) throws Exception {
		if (StringUtils.isEmpty(jsoncallback)) {
			writeJSON(obj, response);
			return;
		}
		writeJSONP(obj, jsoncallback, response);
	}

	protected void writeJSONP(Object obj, String jsoncallback, HttpServletResponse response) throws Exception {
		writer(jsoncallback + "(" + JSONObject.toJSONString(obj) + ")", response, JSON_TYPE);
	}
	
	protected void writeJSON(Object obj, HttpServletResponse response) throws Exception {
		writer(JSONObject.toJSONString(obj), response, JSON_TYPE);
	}

	private void writer(String string, HttpServletResponse response, String type) throws IOException, Exception {
		response.setContentType(type);
		PrintWriter writer = response.getWriter();
		writer.print(string);
		writer.flush();
		writer.close();
	}
}
