package com.supermart.model;

public class Supplier {
	private int supplierid;
	private String suppliername;
	private String suppliercontact;
	
	public Supplier() {
	}

	public Supplier(int supplierid, String suppliername, String suppliercontact) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
		this.suppliercontact = suppliercontact;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getSuppliercontact() {
		return suppliercontact;
	}

	public void setSuppliercontact(String suppliercontact) {
		this.suppliercontact = suppliercontact;
	}

	@Override
	public String toString() {
		return "Supplier [supplierid=" + supplierid + ", suppliername=" + suppliername + ", suppliercontact="
				+ suppliercontact + "]";
	}

	public void getDetails() {
		// TODO Auto-generated method stub
		
	}
	
		
}
