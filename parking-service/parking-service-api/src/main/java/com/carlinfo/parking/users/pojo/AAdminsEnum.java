package com.carlinfo.parking.users.pojo;

/**
 * 管理员的枚举 一张表对应一个枚举
 * 
 * @author 张培基
 */
public enum AAdminsEnum
{
	/* 定义枚举项 */
	STATUS_ENABLE(Byte.valueOf("1"),"启用"),
	STATUS_DISABLE(Byte.valueOf("0"),"禁用");
	
	private byte status;
	private String info ;

	private AAdminsEnum(byte status,String info)
	{
		this.info = info;
		this.status = status;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

}
