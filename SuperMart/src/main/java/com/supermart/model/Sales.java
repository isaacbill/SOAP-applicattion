package com.supermart.model;

public class Sales {
	private int orderid;
	private int productid;
	private int quantitysold;
	private String customername;
	private String servedby;
	
	public Sales() {
	}

	public Sales(int orderid, int productid, int quantitysold, String customername, String servedby) {
		super();
		this.orderid = orderid;
		this.productid = productid;
		this.quantitysold = quantitysold;
		this.customername = customername;
		this.servedby = servedby;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantitysold() {
		return quantitysold;
	}

	public void setQuantitysold(int quantitysold) {
		this.quantitysold = quantitysold;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getServedby() {
		return servedby;
	}

	public void setServedby(String servedby) {
		this.servedby = servedby;
	}

	@Override
	public String toString() {
		return "Sales [orderid=" + orderid + ", productid=" + productid + ", quantitysold=" + quantitysold
				+ ", customername=" + customername + ", servedby=" + servedby + "]";
	}
	
	
}
