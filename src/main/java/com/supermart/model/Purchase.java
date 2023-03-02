package com.supermart.model;

public class Purchase {
	private int productid;
	private String productname;
	private double buyingprice;
	private int supplierid;
	private int quantitybought;
	
	public Purchase() {
	}
	
	public Purchase(int productid, String productname, double buyingprice, int supplierid, int quantitybought) {
		this.productid = productid;
		this.productname = productname;
		this.buyingprice = buyingprice;
		this.supplierid = supplierid;
		this.quantitybought = quantitybought;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getBuyingprice() {
		return buyingprice;
	}

	public void setBuyingprice(double buyingprice) {
		this.buyingprice = buyingprice;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public int getQuantitybought() {
		return quantitybought;
	}

	public void setQuantitybought(int quantitybought) {
		this.quantitybought = quantitybought;
	}

	@Override
	public String toString() {
		return "Purchase [productid=" + productid + ", productname=" + productname + ", buyingprice=" + buyingprice
				+ ", supplierid=" + supplierid + ", quantitybought=" + quantitybought + "]";
	}

		
}
