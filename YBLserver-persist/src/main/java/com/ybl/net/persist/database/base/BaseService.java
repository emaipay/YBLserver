package com.ybl.net.persist.database.base;

import java.util.List;  
  /**
   * 2018-04-23
   * @author cheng
   *
   * @param <T>
   */
public interface BaseService<T> {  
	/**
	 * 插入，null会被保存
	 * @param entity
	 * @return
	 */
	int insert(T entity);  
	  
    /** 
     * 添加非空值，null不会被保存，使用数据库默认值 
     *  
     * @param entity 
     * @return 
     */  
    int insertSelective(T entity);  
    /**
     * 根据主键更新，null值也会更新
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);  
    /**
     * 根据主键更新，null不会更新
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(T entity);  
    /**
     * 根据主键删除
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(Object primaryKey);  
    /**
     * 根据多个主键删除
     * @param primarykeys
     * @return
     */
    int deleteByPrimaryKeys(List<Object> primarykeys);  
  
    /** 
     * 根据指定字段值删除，判断条件为等号 
     *  
     * @param field 
     * @param value 
     * @return 
     */  
    int deleteByField(String field, Object value);  
    /**
     * 根据多个字段段和等于删除
     * @param fields
     * @param values
     * @return
     */
    int deleteByFields(String[] fields, Object[] values);  
  
    /** 
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号 
     *  
     * @param entity 
     * @return 
     */  
    T selectOne(T entity);  
    /**
     * 主键查询
     * @param primaryKey
     * @return
     */
    T selectByPrimaryKey(Object primaryKey);  
  
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
    List<T> selectPage(int pageNum, int pageSize);  
  
    /** 
     * 根据指定字段值模糊分页查询 
     *  
     * @param field 
     * @param value 
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    List<T> selectByField(String field, Object value, int pageNum, int pageSize);  
  
    List<T> selectByFields(String[] fields, Object[] values, int pageNum, int pageSize);  
  
    /** 
     * 根据指定字段值分页查询 
     *  
     * @param field 
     * @param value 
     * @param pageNum 
     * @param pageSize 
     * @return 
     */  
    List<T> selectByEqField(String field, Object value, int pageNum, int pageSize);  
  
    List<T> selectByEqFields(String[] fields, Object[] values, int pageNum, int pageSize);  

}
