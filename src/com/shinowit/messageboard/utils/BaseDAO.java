package com.shinowit.messageboard.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class BaseDAO {

	private static String jdbcSQLServerUri=null;
	private static String jdbcSQLServerUsername=null;
	private static String jdbcSQLServerUserpass=null;
	
	/**
	 * 负责读取jdbc.properties配置参数文件中的配置项值
	 * @param propertyName 配置项名称
	 * @return 配置项对应的配置参数值
	 */
	public String getProperty(String propertyName){
		String result=null;
		try {
			Properties prop=new Properties();
			InputStream is=getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			prop.load(is);
			result=prop.getProperty(propertyName);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 静态初始化块,唯一的执行一次读取jdbc.propeties属性文件内容及注册数据库驱动类的工作
	 */
	static{
		BaseDAO obj=new BaseDAO();
		String jdbcSQLServerDriverClassName=obj.getProperty("jdbcSQLServerDriverClassName");
		jdbcSQLServerUri=obj.getProperty("jdbcSQLServerUri");
		jdbcSQLServerUsername=obj.getProperty("jdbcSQLServerUsername");
		jdbcSQLServerUserpass=obj.getProperty("jdbcSQLServerUserpass");
		try {
			Class.forName(jdbcSQLServerDriverClassName);//注册jdbc驱动类
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得一个数据库连接connection对象
	 * @return 成功获取的话返回数据库连接对象,失败返回null
	 */
	public static Connection getConn(){
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(jdbcSQLServerUri,jdbcSQLServerUsername, jdbcSQLServerUserpass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
		}
	}

	public static void close(PreparedStatement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
		}
	}

	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * insert,update,delete类的对数据库的内容造成更改的sql语句执行的方法
	 * @param sql sql语句
	 * @param params ?占位符对应的参数值
	 * @param types ?占位符对应的数据库字段类型
	 * @return sql语句执行后影响的数据库记录行数
	 */
	public static int update(String sql,Object params[],int types[]){
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConn();
			pstmt=conn.prepareStatement(sql);
			for (int index=0;index<params.length;index++){
				pstmt.setObject(index+1, params[index], types[index]);
			}
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}

	/**
	 * 查询数据库单行记录并映射为java实体类
	 * @param sql sql语句
	 * @param params ?占位符对应的参数值
	 * @param types ?占位符对应的字段类型
	 * @param mapObject 完成ResultSet查询结果集向Java实体类映射的你们自己写的匿名内部类
	 * @return null或者填充了查询结果数据的实体类实例
	 */
	public static <E> E queryForObject(String sql,Object params[],int types[],IMapObject<E> mapObject){
		E result=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = getConn();
			pstmt=conn.prepareStatement(sql);
			for (int index=0;index<params.length;index++){
				pstmt.setObject(index+1, params[index], types[index]);
			}
			rs=pstmt.executeQuery();
			result=mapObject.mapping(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public static List queryForList(String sql,Object params[],int types[],IMapListObject mapObject){
		List result=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = getConn();
			pstmt=conn.prepareStatement(sql);
			for (int index=0;index<params.length;index++){
				pstmt.setObject(index+1, params[index], types[index]);
			}
			rs=pstmt.executeQuery();
			result=mapObject.mappingToList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public static int queryForInt(String sql,Object params[],int types[]){
		int result=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				return result=rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	}
