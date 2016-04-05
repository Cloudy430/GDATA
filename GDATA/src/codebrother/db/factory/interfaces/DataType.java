package codebrother.db.factory.interfaces;

import java.util.Date;

public interface DataType {
	
	public static final byte[] NUMBER = {0,1,2,3,4,5,6,7,8,9};
	public static final char[] LOWERCASE = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public static final char[] UPPERCASE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	public static final char[] OPER = {'-', '_'};

	public String createChar(short len);

	public String createVarchar(short min, short max);

	public float createNumber(byte main, byte nomain);

	public int createIntNumber(byte main, byte nomain);
	
	public float createFloatNumber(byte main, byte nomain);
	
	public double createDoubleNumber(byte main, byte nomain);
	
	public String createTime(byte main, byte nomain);
	
	public String createDate(byte main, byte nomain);
	
	public Date createDateTime(boolean flag);
	
	public String createDate2String(Date date, String format);
	
	public String createDateTime2String(Date date, String format);
	
	public String createTime2String(Date date, String format);
}
