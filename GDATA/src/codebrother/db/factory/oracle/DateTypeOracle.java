package codebrother.db.factory.oracle;

import java.util.Date;

import codebrother.db.factory.interfaces.DataType;

public class DateTypeOracle implements DataType {

	@Override
	public String createChar(short len) {
		return null;
	}

	@Override
	public String createVarchar(short min, short max) {
		return null;
	}

	@Override
	public float createNumber(byte main, byte nomain) {
		return 0;
	}

	@Override
	public int createIntNumber(byte main, byte nomain) {
		return 0;
	}

	@Override
	public float createFloatNumber(byte main, byte nomain) {
		return 0;
	}

	@Override
	public double createDoubleNumber(byte main, byte nomain) {
		return 0;
	}

	@Override
	public String createTime(byte main, byte nomain) {
		return null;
	}

	@Override
	public String createDate(byte main, byte nomain) {
		return null;
	}

	@Override
	public Date createDateTime(boolean flag) {
		return null;
	}

	@Override
	public String createDate2String(Date date, String format) {
		return null;
	}

	@Override
	public String createDateTime2String(Date date, String format) {
		return null;
	}

	@Override
	public String createTime2String(Date date, String format) {
		return null;
	}

}
