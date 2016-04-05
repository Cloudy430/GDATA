package codebrother.db.factory.mysql.bin;

import java.sql.Connection;

public class DBOper {
	private String sql;
	private Connection dbcn = null;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Connection getDbcn() {
		return dbcn;
	}

	public void setDbcn(Connection dbcn) {
		this.dbcn = dbcn;
	}
	

}
