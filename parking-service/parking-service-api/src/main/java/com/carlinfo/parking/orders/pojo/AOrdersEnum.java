package com.carlinfo.parking.orders.pojo;

/**
 * 订单的枚举
 * @author 张培基
 *
 */
public enum AOrdersEnum
{
	/*0:微信,1:支付宝,2财富通*/
	PAY_WEIXIN(Byte.valueOf("0"),"微信"),
	PAY_ALIPAY(Byte.valueOf("1"),"支付宝"),
	PAY_TENPAY(Byte.valueOf("2"),"财富通"),
	
	/* 0:下单,1:已入库,2:已出库,3:已支付,4:完成;5:取消 */
	STATUS_SUBMIT(Byte.valueOf("0"),"下单"),
	STATUS_LIB_IN(Byte.valueOf("1"),"已入库"),
	STATUS_LIB_OUT(Byte.valueOf("2"),"已出库"),
	STATUS_PAYED(Byte.valueOf("3"),"已支付"),
	STATUS_FINISH(Byte.valueOf("4"),"完成"),
	STATUS_CANCEL(Byte.valueOf("5"),"取消");
	
	private byte status;
	private String info;

	private AOrdersEnum(byte status,String info)
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
