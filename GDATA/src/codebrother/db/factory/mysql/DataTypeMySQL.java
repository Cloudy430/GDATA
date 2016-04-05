package codebrother.db.factory.mysql;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import codebrother.db.factory.interfaces.DataType;

public class DataTypeMySQL implements DataType {
	
	@Override
	public String createChar(short len) {
		StringBuilder sb = new StringBuilder("'");
		Random random = new Random();
		for(int i=0; i<len; i++) {
			sb.append(DataType.LOWERCASE[random.nextInt(DataType.LOWERCASE.length)]);
		}
		sb.append("'");
		return sb.toString();
	}

	@Override
	public String createVarchar(short min, short max) {
		StringBuilder sb = new StringBuilder("'");
		Random random = new Random();
		short len = (short)(random.nextInt(max) + min);
		for(int i=min; i<len; i++) {
			sb.append(DataType.LOWERCASE[random.nextInt(DataType.LOWERCASE.length)]);
		}
		sb.append("'");
		return sb.toString();
	}
	
	public String createID(String sysguid) {
		return "uuid()";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date createDateTime(boolean flag) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
//		Date date = flag == true ? new Date() : new Date(); 
		return date;
	}

	@Override
	public String createDate2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
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
