package codebrother.db.factory.oracle;

import java.util.List;

import codebrother.db.factory.interfaces.CRUD;

public class CRUD2Oracle implements CRUD {

	@Override
	public String insertSQL(String[] tables, String[] cols) {
		return null;
	}

	@Override
	public String deleteSQL(String[] tables, String[] cols) {
		return null;
	}

	@Override
	public String updateSQL(String[] tables, String[] cols) {
		return null;
	}

	@Override
	public String selectSQL(String[] tables, String[] cols) {
		return null;
	}

	@Override
	public String insertSQL(String[] tables) {
		return null;
	}

	@Override
	public List<String> insertSQL(String table, short count) {
		return null;
	}

	@Override
	public List<String> truncate(String[] tables) {
		return null;
	}

}
