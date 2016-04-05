package codebrother.db.factory.common;

import codebrother.db.factory.interfaces.DataType;
import codebrother.db.factory.mysql.DataTypeMySQL;

public class Column {
	private String name; // 列名称
	private String type; // 列类型
	private short length; // 列长度
	private boolean isNull; // 是否为空
	private boolean isPrimary; // 是否主键
	private boolean isForeign; // 是否外键
	private boolean isAutoCreate; // 是否自增长
	private Object value; // 列值
	private String nochangeValue;
	private String copyColumn;

	public String getNochangeValue() {
		return nochangeValue;
	}

	public void setNochangeValue(String nochangeValue) {
		this.nochangeValue = nochangeValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public short getLength() {
		return length;
	}

	public void setLength(short length) {
		this.length = length;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isForeign() {
		return isForeign;
	}

	public void setForeign(boolean isForeign) {
		this.isForeign = isForeign;
	}

	public boolean isAutoCreate() {
		return isAutoCreate;
	}

	public void setAutoCreate(boolean isAutoCreate) {
		this.isAutoCreate = isAutoCreate;
	}

	public Object getValue() {
		DataType mysql = new DataTypeMySQL();
		switch (this.type) {
		case "varchar":
			if(null != this.getCopyColumn() && !this.getCopyColumn().isEmpty()) {
//				todo
			}
			this.value = mysql.createVarchar((short) 1, this.length);
			break;
		case "datetime":
			if("auto".equals(this.nochangeValue))
				this.value = "now()";
			this.value = null == this.value ? mysql.createDateTime(true) : this.value;	
			break;
		case "char":
			if(null != this.nochangeValue)
				this.value = this.nochangeValue;
			this.value = null == this.value ? mysql.createChar(this.length) : this.value;			
			break;

		default:
			break;
		}
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getCopyColumn() {
		return copyColumn;
	}

	public void setCopyColumn(String copyColumn) {
		this.copyColumn = copyColumn;
	}

}
