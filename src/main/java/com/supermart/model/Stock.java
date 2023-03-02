package com.supermart.model;

public class Stock {
	private int stockid;
	private int productid;
	private int quantityavailable;
	private double sellingprice;
	
	public Stock() {
	}
	

	public Stock(int stockid, int productid, int quantityavailable, double sellingprice) {
		super();
		this.stockid = stockid;
		this.productid = productid;
		this.quantityavailable = quantityavailable;
		this.sellingprice = sellingprice;
	}


	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantityavailable() {
		return quantityavailable;
	}

	public void setQuantityavailable(int quantityavailable) {
		this.quantityavailable = quantityavailable;
	}

	public double getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}


	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", productid=" + productid + ", quantityavailable=" + quantityavailable
				+ ", sellingprice=" + sellingprice + "]";
	}
	
	
	
	}
