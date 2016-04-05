package codebrother.db.factory.interfaces;

import java.util.List;

public interface CRUD {
	/**
	 * @author codebrother
	 * @param tables
	 * @param cols
	 * @return
	 */
	public String insertSQL(String[] tables);
	public List<String> insertSQL(String table, short count);
	public String insertSQL(String[] tables, String[] cols);
	public String deleteSQL(String[] tables, String[] cols);
	public String updateSQL(String[] tables, String[] cols);
	public String selectSQL(String[] tables, String[] cols);
	public List<String> truncate(String[] tables);
	
}
