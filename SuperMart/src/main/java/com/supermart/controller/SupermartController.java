package com.supermart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supermart.model.Purchase;
import com.supermart.model.Sales;
import com.supermart.model.Stock;
import com.supermart.model.Supplier;
import com.supermart.service.SupermartService;

public class SupermartController extends HttpServlet {
	
		private static final long serialVersionUID = 319867896525879301L;
		
		public SupermartController()
		{
			super();
		}
		
		protected void doSetPurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String productname = request.getParameter("productname");
			double buyingprice = Double.parseDouble(request.getParameter("buyingprice"));
			int supplierid = Integer.parseInt(request.getParameter("supplierid"));
			int quantitybought = Integer.parseInt(request.getParameter("quantitybought"));
			
			Purchase purchase = new  Purchase();
			purchase.setProductname(productname);
			purchase.setBuyingprice(buyingprice);
			purchase.setSupplierid(supplierid);
			purchase.setQuantitybought(quantitybought);
			
		try {
			int res = SupermartService.insertPurchase(purchase);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "Purchase Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "Purchase Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void doSetSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int productid = Integer.parseInt(request.getParameter("productid"));
			int quantitysold = Integer.parseInt(request.getParameter("quantitysold"));
			String customername = request.getParameter("customername");
			String servedby = request.getParameter("servedby");
			
			Sales sale = new  Sales();
			sale.setProductid(productid);
			sale.setQuantitysold(quantitysold);
			sale.setCustomername(customername);
			sale.setServedby(servedby);
			
		try {
			int res = SupermartService.insertSales(sale);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "Sale Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "Sale Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void doSetStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int productid = Integer.parseInt(request.getParameter("productid"));
			int quantityavailable = Integer.parseInt(request.getParameter("quantityavailable"));
			double sellingprice = Double.parseDouble(request.getParameter("sellingprice"));
			
			Stock stock =  new Stock();
			stock.setProductid(productid);
			stock.setQuantityavailable(quantityavailable);
			stock.setSellingprice(sellingprice);
			
		try {
			int res = SupermartService.insertStock(stock);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "Stock Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "Stock Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void doSetSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String suppliername = request.getParameter("suppliername");
			String suppliercontact = request.getParameter("suppliercontact");
			
			Supplier supplier = new Supplier();
			supplier.setSuppliername(suppliername);
			supplier.setSuppliercontact(suppliercontact);
			
		try {
			int res = SupermartService.insertSupplier(supplier);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "supplier Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "supplier Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		protected void doUpdatePurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int productid = Integer.parseInt(request.getParameter("productid"));
			String productname = request.getParameter("productname");
			double buyingprice = Double.parseDouble(request.getParameter("buyingprice"));
			int supplierid = Integer.parseInt(request.getParameter("supplierid"));
			int quantitybought = Integer.parseInt(request.getParameter("quantitybought"));
			
			Purchase purchase = new Purchase();
			purchase.setProductid(productid);
			purchase.setProductname(productname);
			purchase.setBuyingprice(buyingprice);
			purchase.setSupplierid(supplierid);
			purchase.setQuantitybought(quantitybought);
			
		try {
			int res = SupermartService.updatePurchase(purchase);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "Unable to update purchase");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "Purchase updated");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void doUpdateSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			int productid = Integer.parseInt(request.getParameter("productid"));
			int quantitysold = Integer.parseInt(request.getParameter("quantitysold"));
			String customername = request.getParameter("customername");
			String servedby = request.getParameter("servedby");
			
			Sales sale = new  Sales();
			sale.setOrderid(orderid);
			sale.setProductid(productid);
			sale.setQuantitysold(quantitysold);
			sale.setCustomername(customername);
			sale.setServedby(servedby);
			
		try {
			int res = SupermartService.insertSales(sale);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "Sale Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "Sale Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void doUpdateStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int stockid = Integer.parseInt(request.getParameter("stockid"));
			int productid = Integer.parseInt(request.getParameter("productid"));
			int quantityavailable = Integer.parseInt(request.getParameter("quantityavailable"));
			double sellingprice = Double.parseDouble(request.getParameter("sellingprice"));
			
			Stock stock =  new Stock();
			stock.setStockid(stockid);
			stock.setProductid(productid);
			stock.setQuantityavailable(quantityavailable);
			stock.setSellingprice(sellingprice);
			
		try {
			int res = SupermartService.insertStock(stock);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "Stock Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "Stock Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void doUpdateSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int supplierid = Integer.parseInt(request.getParameter("supplierid"));
			String suppliername = request.getParameter("suppliername");
			String suppliercontact = request.getParameter("suppliercontact");
			
			Supplier supplier = new Supplier();
			supplier.setSupplierid(supplierid);
			supplier.setSuppliername(suppliername);
			supplier.setSuppliercontact(suppliercontact);
			
		try {
			int res = SupermartService.insertSupplier(supplier);
			if (res==0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Error", "supplier Exist");
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("Valid", "supplier Entered");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		protected void doDeletePurchase(HttpServletRequest request, HttpServletResponse response) {
			int productid = Integer.parseInt(request.getParameter("productid"));
			
			try {
				 SupermartService.deletePurchase(productid);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		protected void doDeleteSale(HttpServletRequest request, HttpServletResponse response) {
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			
			try {
				 SupermartService.deleteSale(orderid);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		protected void doDeleteStock(HttpServletRequest request, HttpServletResponse response) {
			int stockid = Integer.parseInt(request.getParameter("stockid"));
			
			try {
				 SupermartService.deleteSale(stockid);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		protected void doDeleteSupplier(HttpServletRequest request, HttpServletResponse response) {
			int supplierid = Integer.parseInt(request.getParameter("supplierid"));
			
			try {
				 SupermartService.deleteSale(supplierid);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

}
