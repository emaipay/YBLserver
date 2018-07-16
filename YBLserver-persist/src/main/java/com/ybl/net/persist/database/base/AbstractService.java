package com.ybl.net.persist.database.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;  
  
public class AbstractService<T> implements BaseService<T> {  
  
    protected Logger logger = LoggerFactory.getLogger(getClass());  
    @Autowired  
    protected Mapper<T> baseMapper;  
  
    private Class<?> clazz = null;  
  
    protected Class<?> getEntityClass() {  
        if (clazz == null) {  
            clazz = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
        }  
        return clazz;  
    }  
  
    /**
     * 2018-04-23
     * @author cheng
     *
     * @param <T>
     */
    @Override  
    public int insert(T entity) {  
        return baseMapper.insert(entity);  
    }  
  
    /**
	 * 插入，null会被保存
	 * @param entity
	 * @return
	 */
    @Override  
    public int insertSelective(T entity) {  
        return baseMapper.insertSelective(entity);  
    }  
  
    /** 
     * 添加非空值，null不会被保存，使用数据库默认值 
     *  
     * @param entity 
     * @return 
     */  
    @Override  
    public int updateByPrimaryKey(T entity) {  
        return baseMapper.updateByPrimaryKey(entity);  
    }  
  
    /**
     * 根据主键更新，null值也会更新
     * @param entity
     * @return
     */
    @Override  
    public int updateByPrimaryKeySelective(T entity) {  
        return baseMapper.updateByPrimaryKeySelective(entity);  
    }  
  
    /**
     * 根据主键删除
     * @param primaryKey
     * @return
     */
    @Override  
    public int deleteByPrimaryKey(Object primaryKey) {  
        return baseMapper.deleteByPrimaryKey(primaryKey);  
    }  
  
    /**
     * 根据多个主键删除
     * @param primarykeys
     * @return
     */
    @Override  
    public int deleteByPrimaryKeys(List<Object> primaryKeys) {  
        int resulrt = 0;  
        for (Object primaryKey : primaryKeys) {  
            resulrt += baseMapper.deleteByPrimaryKey(primaryKey);  
        }  
        return resulrt;  
    }  
  
    /** 
     * 根据指定字段值删除，判断条件为等号 
     *  
     * @param field 
     * @param value 
     * @return 
     */  
    @Override  
    public int deleteByField(String field, Object value) {  
        return deleteByFields(new String[] { field }, new Object[] { value });  
    }  
  
    /**
     * 根据多个字段段和等于删除
     * @param fields
     * @param values
     * @return
     */
    @Override  
    public int deleteByFields(String[] fields, Object[] values) {  
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {  
            return 0;  
        }  
        Example example = new Example(getEntityClass());  
        Criteria criteria = example.createCriteria();  
        for (int i = 0; i < fields.length; i++) {  
        	if(values[i]==null) {
        		continue;
        	}
            criteria.andEqualTo(fields[i], values[i]);  
        }  
        return baseMapper.deleteByExample(example);  
    }  
  
    /** 
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号 
     *  
     * @param entity 
     * @return 
     */  
    @Override  
    public T selectOne(T entity) {  
        return baseMapper.selectOne(entity);  
    }  
    /**
     * 主键查询
     * @param primaryKey
     * @return
     */
    @Override  
    public T selectByPrimaryKey(Object primaryKey) {  
        return baseMapper.selectByPrimaryKey(primaryKey);  
    }  
  
    /** 
     * 单表分页查询 
     *  
     * <pre> 
     * selectPage(0,0) return all 
     * </pre> 
     *  
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    @Override  
    public List<T> selectPage(int pageNum, int pageSize) {  
        PageHelper.startPage(pageNum, pageSize);  
        return baseMapper.selectAll();  
    }  
    /** 
     * 根据指定字段值模糊分页查询 
     *  
     * @param field 
     * @param value 
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    @Override  
    public List<T> selectByField(String field, Object value, int pageNum, int pageSize) {  
        return selectByFields(new String[] { field }, new Object[] { value }, pageNum, pageSize);  
    }  
    /** 
     * 根据指定字段值模糊分页查询 
     *  
     * @param fields 
     * @param values 
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    @Override  
    public List<T> selectByFields(String[] fields, Object[] values, int pageNum, int pageSize) {  
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {  
            return null;  
        }  
        Example example = new Example(getEntityClass());  
        for (int i = 0; i < fields.length; i++) {  
        	if(values[i]==null) {
        		continue;
        	}
            example.or().andLike(fields[i], "%"+values[i]+"%");  
        }  
        PageHelper.startPage(pageNum, pageSize);  
        return baseMapper.selectByExample(example);  
    }  
  
    /** 
     * 根据指定字段值分页查询 
     *  
     * @param field 
     * @param value 
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    @Override  
    public List<T> selectByEqField(String field, Object value, int pageNum, int pageSize) {  
        return selectByEqFields(new String[] { field }, new Object[] { value }, pageNum, pageSize);  
    }  
  
    /** 
     * 根据指定字段值分页查询 
     *  
     * @param field 
     * @param value 
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    @Override  
    public List<T> selectByEqFields(String[] fields, Object[] values, int pageNum, int pageSize) {  
        if (null == fields || null == values || fields.length == 0 || fields.length != values.length) {  
            return null;  
        }  
        Example example = new Example(getEntityClass());  
        Criteria criteria = example.createCriteria();  
        for (int i = 0; i < fields.length; i++) {  
        	if(values[i]==null) {
        		continue;
        	}
            criteria.andEqualTo(fields[i], values[i]);  
        }  
        PageHelper.startPage(pageNum, pageSize);  
        return baseMapper.selectByExample(example);  
    }  
  
}
