package com.carlinfo.common.util;

/**
 * 分页的工具类 要想分页:得提供每页多少条和总条数,才可以完成分页,否则分不了页
 * 
 * @author wangshMac
 */
public class PageInfoUtil
{
	/**
	 * 总记录数
	 */
	private int totalRecord;
	/**
	 * 每页多少条
	 */
	private int pageSize = 10;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 上一页
	 */
	private int prePage;
	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 当前记录数
	 * 每页10条
	 * 1	1
	 * 2	11
	 * 3	21(当前记录数)
	 */
	private int currentRecord;

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getCurrentPage()
	{
		/* 容错判断
		 * 设置当前页为-1;或者大于总页数:都不合理
		 *  */
		/* 当前页小于1 */
		if(this.currentPage < 1)
		{
			this.currentPage = 1 ; 
		}
		/* 当前页大于总页数
		 * 必须是总条数>0,如果总条数为0,总页数也为0,当前页就赋值永远失败
		 *  */
		if(this.totalRecord > 0 && this.currentPage > this.getTotalPage())
		{
			this.currentPage = this.getTotalPage() ; 
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getTotalPage()
	{
		/* 总页数如何计算
		 * 总条数为:31,每页10条;共几页?4
		 * 总条数为:30,每页10条;共几页?3
		 *  */
		/* 余数:% */
		if(this.getTotalRecord() % this.getPageSize() == 0 )
		{
			/* 除尽 */
			this.totalPage = this.getTotalRecord() / this.getPageSize() ; 
		}else
		{
			/* 除不尽 */
			this.totalPage = this.getTotalRecord() / this.getPageSize() + 1; 
		}
		
		// TODO 培基说不能加此判断
		/* 总页数不能为0, 这是一个坑 */
		if(this.totalPage == 0 )
		{
			this.totalPage = 1 ; 
		}
		return totalPage;
	}

	public int getPrePage()
	{
		/* 上一页 */
		this.prePage = this.getCurrentPage() - 1 ; 
		/* 容错判断
		 * 小于1,
		 * 大于总页数
		 *  */
		if(this.prePage < 1)
		{
			this.prePage = 1 ; 
		}
		return prePage;
	}

	public int getNextPage()
	{
		/* 下一页 */
		this.nextPage = this.getCurrentPage() + 1 ; 
		/* 容错判断
		 * 小于1,
		 * 大于总页数
		 *  */
		if(this.nextPage > this.getTotalPage())
		{
			this.nextPage = this.getTotalPage() ; 
		}
		return nextPage;
	}

	public int getCurrentRecord()
	{
		/* 当前页的条数
		 * 每页10条;
		 * 页数		当前页的条数
		 * 1		1
		 * 2		11
		 * 3		21
		 * 4		31
		 * 5		41
		 * (页数-1)*每页多少条 + 1
		 *  */
		this.currentRecord = (this.getCurrentPage() - 1) * this.getPageSize(); 
		return currentRecord;
	}
	
	@Override
	public String toString()
	{
		return "PageInfoUtil [totalRecord=" + this.getTotalRecord() + ", pageSize=" + this.getPageSize() + ", totalPage=" + this.getTotalPage()
				+ ", currentPage=" + this.getCurrentPage() + ", prePage=" + this.getPrePage() + ", nextPage=" + this.getNextPage()
				+ ", currentRecord=" + this.getCurrentRecord() + "]";
	}
	
	public static void main(String[] args)
	{
		/* 测试 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		/* 总条数 */
		//pageInfoUtil.setTotalRecord(31);
		pageInfoUtil.setPageSize(5);
		pageInfoUtil.setCurrentPage(11111);
		System.out.println("--->" + pageInfoUtil);
	}
}
