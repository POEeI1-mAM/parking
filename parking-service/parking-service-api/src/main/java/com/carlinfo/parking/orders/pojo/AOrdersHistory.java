package com.carlinfo.parking.orders.pojo;

import java.util.Date;

/**
 * 订单历史的POJO
 * 
 * @author 张培基
 *
 */
public class AOrdersHistory
{
	private int id;
	private int orderId;
	private String thirdsn;
	private String content;
	private byte status;
	private Date createTime;
	private Date updateTime;

	/* 字符串描述 */
	private String statusStr;
	/* 订单表 */
	private AOrders orders ; 

	public AOrders getOrders()
	{
		return orders;
	}

	public void setOrders(AOrders orders)
	{
		this.orders = orders;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public String getThirdsn()
	{
		return thirdsn;
	}

	public void setThirdsn(String thirdsn)
	{
		this.thirdsn = thirdsn;
	}

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getStatusStr()
	{
		/* 状态:0:禁用;1:启用 */
		AOrdersHistoryEnum[] ordersEnums = AOrdersHistoryEnum.values();
		for (int i = 0; i < ordersEnums.length; i++)
		{
			AOrdersHistoryEnum ordersEnum = ordersEnums[i];
			/*
			 * adminsEnum.toString():枚举项
			 */
			if (ordersEnum.toString().startsWith("STATUS_"))
			{
				if (this.status == ordersEnum.getStatus())
				{
					this.statusStr = ordersEnum.getInfo();
					break;
				}
			}
		}
		return statusStr;
	}
}
