package com.hejie.springbootpractice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>工具类:ConnDbUtil </p>
 * <p>Description:数据库连接工具类 </p>
 * @author 何杰
 * @date 2019年8月28日
 * @version 1.0
 * @since JDK 1.8
 */
public class ConnDbUtil {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/mydatabase?characterEncoding=UTF-8";
	public static final String USERNAME = "test";
	public static final String PASSWORD = "test";
	private static Logger logger = LoggerFactory.getLogger(ConnDbUtil.class);
	
	/*
	 * 得到连接
	 */
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			logger.error("加载驱动失败，错误信息 < " + e.getMessage() + " > ");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			logger.error("获取连接失败，错误信息 < " + e.getMessage() + " > ");
		}
		
		logger.debug("获取连接成功");
		return con;
	}
	
	/*
	 * 关闭连接
	 */
	public static void closeConnection(Connection connection) {
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("关闭连接失败，错误信息 < " + e.getMessage() + " > ");
			}
		}
		
		logger.debug("关闭连接成功");
	}
	
	/*
	 * 关闭PreparedStatement
	 */
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("关闭预编译处理对象失败，错误信息 < " + e.getMessage() + " > ");
			}
		}
		
		logger.debug("关闭预编译处理对象成功");
	}
	
	/*
	 * 关闭Statement
	 */
	public static void closeStatement(Statement statement) {
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("关闭Statement对象失败，错误信息 < " + e.getMessage() + " > ");
			}
		}
		
		logger.debug("关闭Statement对象成功");
	}
	
	/*
	 * 关闭结果集
	 */
	public static void closeResultSet(ResultSet resultSet) {
		
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("关闭ResultSet对象失败，错误信息 < " + e.getMessage() + " > ");
			}
		}
		
		logger.debug("关闭ResultSet对象成功");
	}
	
	/*
	 * 依次关闭
	 */
	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection conn) {
		closeResultSet(resultSet);
		closePreparedStatement(preparedStatement);
		closeConnection(conn);
	}
	
}
