package codebrother.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import codebrother.tools.log.Log;

public class DBConnection extends DBSource {
	
	private Log log = new Log();
	@Override
	public Connection getConnection() {
		dbType = "Mysql";
		dbIp = "localhost";
		username = "root";
		password = "root";
		url = "jdbc:mysql://127.0.0.1/rcs_aml";
		dbDriveName = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(dbDriveName); // 加载mysql驱动
			dbcn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			log.info("The driver is not found.");
//			e.printStackTrace();
		} catch (SQLException e) {
			log.info("the mysql link args error.");
//			e.printStackTrace();
		}
		return dbcn;
	}
	
//	插入数据
	@Override
	public int insertSql(String[] sqls) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// dbcn = this.getMyConection(dbcn, 0);
			dbcn = getConnection();
			dbcn.setAutoCommit(false);
			for(String sql : sqls) {
				String insertSQL = sql;
				pstmt = dbcn.prepareStatement(insertSQL);
				count++;
				pstmt.addBatch();
				if (count % 300 == 0) {
					pstmt.executeBatch();
					dbcn.commit();
				}
			}
			pstmt.executeBatch();
			dbcn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(dbcn);
			sqls = null;
		}
		return count;
	}
	
	@Override
	public void close(Connection connection) {
		if(null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}

	@Override
	public void close(Statement statement) {
		if(null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			statement = null;
		}		
	}

	@Override
	public void close(ResultSet rs) {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}		
	}

	@Override
	public int insertSql(List<String> sqls) {
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// dbcn = this.getMyConection(dbcn, 0);
			dbcn = getConnection();
			dbcn.setAutoCommit(false);
			for(String sql : sqls) {
				String insertSQL = sql;
				pstmt = dbcn.prepareStatement(insertSQL);
				count++;
				pstmt.addBatch();
				if (count % 300 == 0) {
					pstmt.executeBatch();
					dbcn.commit();
				}
			}
			pstmt.executeBatch();
			dbcn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(dbcn);
			sqls = null;
		}
		return count;
	}
	
}
