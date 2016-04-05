package codebrother.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author codebrother
 *
 */
public abstract class DBSource {
	public String dbType = null;
	public String dbDriveName = null;
	public String dbIp = null;
	public String dbPort = null;
	public String dbName = null;
	public String username = null;
	public String password = null;
	public String dession = null;
	public String[] args = null;
	public String url = null;
	public Connection dbcn = null;
	public static final short insertPage = 300;
	
	public abstract Connection getConnection();
	public abstract void close(Connection connection);
	public abstract void close(Statement statement);
	public abstract void close(ResultSet rs);
	public abstract int insertSql(String[] sqls);
	public abstract int insertSql(List<String> sqls);
}
