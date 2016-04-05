package codebrother.db.factory.mysql;

import java.util.ArrayList;
import java.util.List;

import codebrother.db.dao.DBConnection;
import codebrother.db.dao.DBSource;
import codebrother.db.factory.common.Column;
import codebrother.db.factory.interfaces.CRUD;
import codebrother.tools.log.Log;

public class CRUD2MySQL implements CRUD {

	@Override
	public String insertSQL(String[] tables, String[] cols) {
		return null;
	}

	@Override
	public String deleteSQL(String[] tables, String[] cols) {
		for(String table : tables) {
			String deleteSql = "delete from " + table;
			Log.print(deleteSql);
		}
		return null;
	}

	@Override
	public String updateSQL(String[] tables, String[] cols) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectSQL(String[] tables, String[] cols) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertSQL(String[] tables) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> insertSQL(String table, short count) {
		List<String> sqllist = new ArrayList<String>();
		List<String> cols = colName(table);
		List<Object> values = null;
		for(int i=0; i<count; i++) {
			StringBuilder sbcol = new StringBuilder();
			for(String col : cols) {
				sbcol.append(col).append(", ");
			}
			String colResult = sbcol.substring(0, sbcol.length()-2);
			sbcol = null;
			
			StringBuilder sbvalue = new StringBuilder();
			values = colvalue(table);
			for(Object value : values) {
				sbvalue.append(value).append(", ");
			}
			String valueResult = sbvalue.substring(0, sbvalue.length()-2);
			sbvalue = null;
//			sqllist.add("insert into " + table +" (" + colResult + ") values (" + valueResult + ");");
			sqllist.add("insert into " + table +" (" + colResult + ") values (" + valueResult + ")");
			DBSource db = new DBConnection();
			db.insertSql(sqllist);
		}
		return sqllist;
	}
	
	private List<Object> colvalue(String table) {
		List<Column> colList = getColInfo(table);
		List<Object> values = new ArrayList<Object>();
		values.clear();
		for(Column c : colList) {
			values.add(c.getValue());
		}
		return values;
	}

	private List<String> colName(String table) {
		List<Column> colList = getColInfo(table);
		List<String> cols = new ArrayList<String>();
		for(Column c : colList) {
			cols.add(c.getName());
		}
		
		return cols;
	}
	
	private List<Column> getColInfo(String table) {
		List<Column> colList = new ArrayList<Column>();
		
		Column id = new Column();
		id.setName("id");
		id.setType("char");
		id.setLength((short)32);
		id.setPrimary(true);
		id.setForeign(false);
		id.setAutoCreate(true);
		id.setNull(true);
		colList.add(id);
		
		Column ctif_tp = new Column();
		ctif_tp.setName("ctif_tp");
		ctif_tp.setType("char");
		ctif_tp.setLength((short)1);
		ctif_tp.setPrimary(false);
		ctif_tp.setForeign(false);
		ctif_tp.setAutoCreate(false);
		ctif_tp.setNull(false);
		ctif_tp.setNochangeValue("1");
		colList.add(ctif_tp);
		
		Column client_tp = new Column();
		client_tp.setName("client_tp");
		client_tp.setType("char");
		client_tp.setLength((short)1);
		client_tp.setPrimary(false);
		client_tp.setForeign(false);
		client_tp.setAutoCreate(false);
		client_tp.setNull(false);
		client_tp.setNochangeValue("1");
		colList.add(client_tp);
		
		Column ctnm = new Column();
		ctnm.setName("ctnm");
		ctnm.setType("varchar");
		ctnm.setLength((short)32);
		ctnm.setPrimary(false);
		ctnm.setForeign(false);
		ctnm.setAutoCreate(false);
		ctnm.setNull(true);
		colList.add(ctnm);
		
		Column smid = new Column();
		smid.setName("client_tp");
		smid.setType("varchar");
		smid.setLength((short)32);
		smid.setPrimary(false);
		smid.setForeign(false);
		smid.setAutoCreate(false);
		smid.setNull(false);
		smid.setCopyColumn("id");
		colList.add(smid);
		
		Column citp = new Column();
		
		
		Column citp_nt = new Column();
		
		
		Column ctid = new Column();
		
		
		Column ctar = new Column();
		
		
		Column cctl = new Column();
		
		
		Column ceml = new Column();
		
		
		Column ctvc = new Column();
		
		
		Column crnm = new Column();
		
		
		Column crit = new Column();
		
		
		Column crit_nt = new Column();
		
		
		Column crid = new Column();
		
		
		Column busi_reg_no = new Column();
		
		
		Column redt = new Column();
		redt.setName("redt");
		redt.setType("datetime");
//		redt.setLength((short)32);
		redt.setPrimary(false);
		redt.setForeign(false);
		redt.setAutoCreate(false);
		redt.setNull(false);
		redt.setNochangeValue("auto");
		colList.add(redt);
		
		Column updt = new Column();
		
		Column rgdt = new Column();
		rgdt.setName("rgdt");
		rgdt.setType("datetime");
//		client_tp.setLength((short)32);
		rgdt.setPrimary(false);
		rgdt.setForeign(false);
		rgdt.setAutoCreate(false);
		rgdt.setNull(false);
//		  `citp` varchar(32) DEFAULT NULL COMMENT '主体身份证件/证明文件类型',
//		  `citp_nt` varchar(30) DEFAULT NULL COMMENT '主体证件类型说明',
//		  `ctid` varchar(20) DEFAULT NULL COMMENT '主体身份证件/证明文件号码',
//		  `ctar` varchar(128) DEFAULT NULL COMMENT '详细地址',
//		  `cctl` varchar(32) DEFAULT NULL COMMENT '联系电话',
//		  `ceml` varchar(100) DEFAULT NULL COMMENT '电子邮件',
//		  `ctvc` varchar(32) DEFAULT NULL COMMENT '主体的职业/行业类别',
//		  `crnm` varchar(32) DEFAULT NULL COMMENT '主体的法定代表人姓名',
//		  `crit` varchar(32) DEFAULT NULL COMMENT '主体的法定代表人身份证件类型',
//		  `crit_nt` varchar(30) DEFAULT NULL COMMENT '法人证件类型说明',
//		  `crid` varchar(20) DEFAULT NULL COMMENT '主体的法定代表人身份证件号码',
//		  `busi_reg_no`
//		  redt` datetime DEFAULT NULL COMMENT '落地时间',
//		  `updt` date DEFAULT NULL,
//		  `rgdt` date DEFAULT NULL COMMENT '开户日期',
		return colList;
	}

	@Override
	public List<String> truncate(String[] tables) {
		List<String> list  = new ArrayList<String>();
		for(String table : tables) {
			list.add("truncate table " + table + ";");
		}
		return list;
	}

}
