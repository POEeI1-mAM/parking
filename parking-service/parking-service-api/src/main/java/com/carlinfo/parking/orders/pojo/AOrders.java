package com.carlinfo.parking.orders.pojo;

import java.util.Date;

import com.carlinfo.parking.users.pojo.AAdminsEnum;
import com.carlinfo.parking.users.pojo.AUsers;

/**
 * 订单的POJO
 * 
 * @author 张培基
 *
 */
public class AOrders
{
	private int id;
	private int userId;
	private String userName;
	private int vehId;
	private String ordersn;
	private byte payType;
	private String paySn;
	private String vehName;
	private String parkingName;
	private double price;
	private double time;
	private double charge;
	private String content;
	private Date intTime;
	private Date outTime;
	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date payTime;
	
	/* 字符串描述 */
	private String payTypeStr;
	private String statusStr ; 
	
	/* 关联关系 */
	private AUsers users; 

	public int getId()
	{
		return id;
	}

	public AUsers getUsers()
	{
		return users;
	}

	public void setUsers(AUsers users)
	{
		this.users = users;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getVehId()
	{
		return vehId;
	}

	public void setVehId(int vehId)
	{
		this.vehId = vehId;
	}

	public String getOrdersn()
	{
		return ordersn;
	}

	public void setOrdersn(String ordersn)
	{
		this.ordersn = ordersn;
	}

	public byte getPayType()
	{
		return payType;
	}

	public void setPayType(byte payType)
	{
		this.payType = payType;
	}

	public String getPaySn()
	{
		return paySn;
	}

	public void setPaySn(String paySn)
	{
		this.paySn = paySn;
	}

	public String getVehName()
	{
		return vehName;
	}

	public void setVehName(String vehName)
	{
		this.vehName = vehName;
	}

	public String getParkingName()
	{
		return parkingName;
	}

	public void setParkingName(String parkingName)
	{
		this.parkingName = parkingName;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public double getTime()
	{
		return time;
	}

	public void setTime(double time)
	{
		this.time = time;
	}

	public double getCharge()
	{
		return charge;
	}

	public void setCharge(double charge)
	{
		this.charge = charge;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getIntTime()
	{
		return intTime;
	}

	public void setIntTime(Date intTime)
	{
		this.intTime = intTime;
	}

	public Date getOutTime()
	{
		return outTime;
	}

	public void setOutTime(Date outTime)
	{
		this.outTime = outTime;
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

	public Date getPayTime()
	{
		return payTime;
	}

	public void setPayTime(Date payTime)
	{
		this.payTime = payTime;
	}

	public String getPayTypeStr()
	{
		/*状态:0:禁用;1:启用*/
		AOrdersEnum[] ordersEnums = AOrdersEnum.values() ; 
		for (int i = 0; i < ordersEnums.length; i++)
		{
			AOrdersEnum ordersEnum = ordersEnums[i];
			/*
			 * adminsEnum.toString():枚举项
			 * */
			if(ordersEnum.toString().startsWith("PAY_"))
			{
				if(this.payType == ordersEnum.getStatus())
				{
					this.payTypeStr = ordersEnum.getInfo() ; 
					break ; 
				}
			}
		}
		return payTypeStr;
	}

	public String getStatusStr()
	{
		/*状态:0:禁用;1:启用*/
		AOrdersEnum[] ordersEnums = AOrdersEnum.values() ; 
		for (int i = 0; i < ordersEnums.length; i++)
		{
			AOrdersEnum ordersEnum = ordersEnums[i];
			/*
			 * adminsEnum.toString():枚举项
			 * */
			if(ordersEnum.toString().startsWith("STATUS_"))
			{
				if(this.status == ordersEnum.getStatus())
				{
					this.statusStr = ordersEnum.getInfo() ; 
					break ; 
				}
			}
		}
		return statusStr;
	}
}
