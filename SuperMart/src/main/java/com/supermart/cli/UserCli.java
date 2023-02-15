package com.supermart.cli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.supermart.dbcon.DbConnection;
import com.supermart.dbcon.DbUtil;
import com.supermart.model.Purchase;
import com.supermart.model.Sales;
import com.supermart.model.Stock;
import com.supermart.model.Supplier;
import com.supermart.model.User;
import com.supermart.service.SupermartService;

public class UserCli {
	public static void loopInput() {
		String input;
		while(true) {
			System.out.println("Do you have an account?");
			System.out.println("Enter 'y' for yes or 'n' for no: ");
	    	Scanner scanner = new Scanner(System.in);
	    	input = (scanner.nextLine()).toLowerCase();
	    	//kb.close();
	    	if(input.equals("y")) {
	    		login();
	    		break;
	    	}else if(input.equals("n")) {
	    		register();
	    		break;
	    	}else {
	    		System.out.println("Invalid input. Please try again!");
	    		System.out.println("");
	    	}
		}
	}
	public static void register(){
		String username,password,confirmpwd;
		User user = new User();
		SupermartService supermartService = new SupermartService();
		
		System.out.println("Register account");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter Username: ");
    	username = scan.nextLine();
        
        System.out.println("Enter Password: ");
        password = scan.nextLine();
        
        System.out.println("Confirm Password: ");
        confirmpwd = scan.nextLine();
        //scanner.close();
        System.out.println("");
        
        if(username.isEmpty() || password.isEmpty() || confirmpwd.isEmpty()) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else if(!password.equals(confirmpwd)){
        	System.out.println("Password should be same as confirm password!");
        	exitSystem();
        }else if(password.equals(confirmpwd)) {
        	user.setUsername(username);
        	user.setPassword(password);
        	user.setConfirmpwd(confirmpwd);
        	
        	
        	try {
        		SupermartService.registerUser(user);
				System.out.println("Account created. Please login.");
				System.out.println("");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }else {
        	System.out.println("Account not created.");
        }
	}
	public static void login(){
		String username,password;
		User user = new User();
		SupermartService supermartService = new SupermartService();
		
    	System.out.println("Login");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter Username: ");
    	username = scan.nextLine();
        
        System.out.println("Enter Password: ");
        password = scan.nextLine();
    	
		System.out.println("");
		
		if(username.isEmpty() || password.isEmpty()) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	user.setUsername(username);
        	user.setPassword(password);
        	try {
				supermartService.loginUser(user);
				
				String entry;
				while(true) {
					System.out.println("Please select one:"+
							"\n\t1. Add supplier"+
			                "\n\t2. Edit supplier"+
			                "\n\t3. List suppliers"+
			                "\n\t4. Delete supplier"+
							"\n\t5. Add Stock"+
							"\n\t6. Edit Stock"+
							"\n\t7. List Stock"+
							"\n\t8. Delete Stock"+
							"\n\t9. Add Purchase"+
							"\n\t10. Edit Purchase"+
							"\n\t11. List Purchase"+
							"\n\t12. Delete Purchase"+
							"\n\t13. Add Sales"+
							"\n\t14. Edit Sales"+
							"\n\t15. List Sales"+
							"\n\t16. Delete Sales"+
							"\n\t17. Exit");
					System.out.println("");
					System.out.println("Enter your selection: ");
					entry = (scan.nextLine());
					if(entry.equals("1")) {
						addSupplier();
						break;
					}else if(entry.equals("2")) {
						editSupplier();
						break;
					}else if(entry.equals("3")) {
						getAllSuppliers();
						break;
					}
					else if(entry.equals("4")) {
						deleteSupplier();
						break;
					}else if(entry.equals("5")) {
						addStock();
						break;
					}else if(entry.equals("6")) {
						editStock();
						break;
					}else if(entry.equals("7")) {
						getAllStock();
						break;
					}else if(entry.equals("8")) {
						deleteStock();
						break;
					}else if(entry.equals("9")) {
						addPurchase();
						//break;
					}else if(entry.equals("10")) {
						editPurchase();
						break;
						//break;
					}else if(entry.equals("11")) {
						//listing all purchases
						getAllPurchases();
						break;
					}else if(entry.equals("12")) {
						deletePurchase();
						break;
					}else if(entry.equals("13")) {
						addSales();
						break;
					}else if(entry.equals("14")) {
						editSales();
						break;
					}else if(entry.equals("15")) {
						getAllSales();
						break;
					}else if(entry.equals("16")) {
						deleteSale();
						break;
					}else if(entry.equals("17")){
						exitSystem();
					}else {
						System.out.println("Invalid input. Please try again!");
						System.out.println("");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		//scanner.close();
	}
	private static void addSupplier(){
		String suppliername,suppliercontact;
		Supplier supplier = new Supplier();
		
    	System.out.println("Add a new supplier");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter supplier name: ");
    	suppliername = scan.nextLine();
        
        System.out.println("Enter supplier contact: ");
        suppliercontact = scan.nextLine();
        //scan.close();
        System.out.println("");
        
        if(suppliername.isEmpty() || suppliercontact.isEmpty()) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        	
        }else {
        	supplier.setSuppliername(suppliername);
        	supplier.setSuppliercontact(suppliercontact);
        	try {
				SupermartService.insertSupplier(supplier);
				System.out.println("supplier inserted");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	private static void editSupplier() {
		String suppliername,suppliercontact;
		int supplierid = 0;
		Supplier supplier = new Supplier();
		
    	System.out.println("Edit a supplier");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter supplier id: ");
    	supplierid = Integer.parseInt(scan.nextLine());
    	
    	System.out.println("supplier name: ");
    	suppliername = scan.nextLine();
        
        System.out.println("Enter supplier contact: ");
        suppliercontact = scan.nextLine();
        //scan.close();
        System.out.println("");
        
        if(suppliername.isEmpty() || suppliercontact.isEmpty() || supplierid==0) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	supplier.setSupplierid(supplierid);
        	supplier.setSuppliername(suppliername);
        	supplier.setSuppliercontact(suppliercontact);
        	try {
				SupermartService.updateSupplier(supplier);
				System.out.println("update successful");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	public static void getAllSuppliers(){
		Connection connection=null;
		PreparedStatement p=null;
		ResultSet rs=null;
		connection = DbConnection.connectDB();
		try {
		String sql="select * from supplier";
		p=connection.prepareStatement(sql);
		rs=p.executeQuery();
		System.out.println("supplierid\tsuppliername\tsuppliercontact");
		while(rs.next()) {
			int supplierid=rs.getInt("supplierid");
			String suppliername=rs.getString("suppliername");
			String suppliercontact=rs.getString("suppliercontact");
			System.out.println(supplierid + "\t\t"+ suppliername+"\t\t"+suppliercontact);
		}
		}
		catch(SQLException e) {
			System.out.println(e);			
		}
	}
	private static void deleteSupplier() {
		System.out.println("Delete a supplier");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter supplierid: ");
    	int supplierid = Integer.parseInt(scan.nextLine());
    	//scan.close();
    	
    	try {
			SupermartService.deleteSupplier(supplierid);
			System.out.println("supplier deleted !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void addStock(){
		int productid,quantityavailable = 0;
		double sellingprice = 0;
		Stock stock = new Stock();
		
    	System.out.println("Add a new stock");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter product_id: ");
    	productid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter quantity available: ");
        quantityavailable = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter selling price: ");
        sellingprice = Double.parseDouble(scan.nextLine());
        //scan.close();
        System.out.println("");
        
        if(productid==0 || quantityavailable==0 || sellingprice==0) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	stock.setProductid(productid);
        	stock.setQuantityavailable(quantityavailable);
        	stock.setSellingprice(sellingprice);
        	try {
				SupermartService.insertStock(stock);
				System.out.println("stock inserted");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	private static void editStock() {
		double sellingprice = 0;
		int productid,stockid,quantityavailable = 0;
		Stock stock = new Stock();
		
    	System.out.println("Edit stock");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter stockid: ");
    	stockid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter selling price: ");
        sellingprice = Double.parseDouble(scan.nextLine());
        
        System.out.println("Enter productid: ");
        productid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter quantityavailable: ");
        quantityavailable = Integer.parseInt(scan.nextLine());
        //scan.close();
        System.out.println("");
        
        if(productid==0 || stockid==0 || sellingprice==0 || quantityavailable==0) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	stock.setSellingprice(sellingprice);
        	stock.setProductid(productid);
        	stock.setStockid(stockid);
        	stock.setQuantityavailable(quantityavailable);
        	try {
				SupermartService.updateStock(stock);
				System.out.println(" stock update successful");	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	public static void getAllStock() {
		Connection connection=null;
		PreparedStatement p=null;
		ResultSet rs=null;
		connection = DbConnection.connectDB();
		try {
		String sql="select * from stock";
		p=connection.prepareStatement(sql);
		rs=p.executeQuery();
		System.out.println("stockid\tproductid\tquantityavailable\tsellingprice");
		while(rs.next()) {
			int stockid=rs.getInt("stockid");
			int productid=rs.getInt("productid");
			int quantityavailable=rs.getInt("quantityavailable");
			double sellingprice=rs.getDouble("sellingprice");
			System.out.println(stockid + "\t\t"+ productid+"\t\t"+quantityavailable+"\t\t"+ sellingprice);
		}
		}
		catch(SQLException e) {
			System.out.println(e);			
		}
	}
	private static void deleteStock() {
		System.out.println("Delete stock");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter stockid: ");
    	int stockid = Integer.parseInt(scan.nextLine());
    	//scan.close();
    	
    	try {
			SupermartService.deleteStock(stockid);
			System.out.println("stock deleted !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void addPurchase(){
		String productname;
		double buyingprice = 0;
		int supplierid,quantitybought = 0;
		Purchase purchase = new Purchase();
		
    	System.out.println("Add a new purchase");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter product name: ");
    	productname = scan.nextLine();
        
        System.out.println("Enter buying price: ");
        buyingprice = Double.parseDouble(scan.nextLine());
        
        System.out.println("Enter supplier id: ");
        supplierid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter quantity bought: ");
        quantitybought = Integer.parseInt(scan.nextLine());
        //scan.close();
        System.out.println("");
        
        if(productname.isEmpty() || buyingprice==0 || supplierid==0 || quantitybought==0) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	purchase.setProductname(productname);
        	purchase.setBuyingprice(buyingprice);
        	purchase.setSupplierid(supplierid);
        	purchase.setQuantitybought(quantitybought);
        	try {
				SupermartService.insertPurchase(purchase);
				System.out.println("new purchase inserted");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	public static void editPurchase(){
		String productname;
		double buyingprice = 0;
		int productid,supplierid,quantitybought = 0;
		Purchase purchase = new Purchase();
		
    	System.out.println("Edit a purchase");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter product id: ");
    	productid = Integer.parseInt(scan.nextLine());
    	
    	System.out.println("Enter product name: ");
    	productname = scan.nextLine();
        
        System.out.println("Enter buying price: ");
        buyingprice = Double.parseDouble(scan.nextLine());
        
        System.out.println("Enter supplier id: ");
        supplierid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter quantity bought: ");
        quantitybought = Integer.parseInt(scan.nextLine());
        //scan.close();
        System.out.println("");
        
        if(productid==0 || productname.isEmpty() || buyingprice==0 || supplierid==0 || quantitybought==0) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	purchase.setProductid(productid);
        	purchase.setProductname(productname);
        	purchase.setBuyingprice(buyingprice);
        	purchase.setSupplierid(supplierid);
        	purchase.setQuantitybought(quantitybought);
        	try {
				SupermartService.updatePurchase(purchase);
				 System.out.println("purchase updated");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	private static void getAllPurchases() {
		Connection connection=null;
		PreparedStatement p=null;
		ResultSet rs=null;
		connection = DbConnection.connectDB();
		try {
		String sql="select * from purchase";
		p=connection.prepareStatement(sql);
		rs=p.executeQuery();
		System.out.println("productid\tproductname\tbuyingprice\tsupplierid\tquantitybought");
		while(rs.next()) {
			int productid=rs.getInt("productid");
			String productname=rs.getString("productname");
			double buyingprice=rs.getDouble("buyingprice");
			int supplierid=rs.getInt("supplierid");
			int quantitybought=rs.getInt("quantitybought");
			System.out.println(productid + "\t\t"+ productname+"\t\t"+ buyingprice+"\t\t"+ supplierid+"\t\t"+quantitybought);
		}
		}
		catch(SQLException e) {
			System.out.println(e);			
		}
	}
	private static void deletePurchase() {
		System.out.println("Delete a purchase");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter productid: ");
    	int productid = Integer.parseInt(scan.nextLine());
    	//scan.close();
    	
    	try {
			SupermartService.deletePurchase(productid);
			System.out.println("purchase deleted !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void addSales(){
		int productid,quantitysold = 0;
		String customername,servedby;
		Sales sales = new Sales();
		
    	System.out.println("Add a new sale");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter product id: ");
    	productid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter quantity sold: ");
        quantitysold = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter customer name: ");
        customername = scan.nextLine();
        
        System.out.println("Enter served by: ");
        servedby = scan.nextLine();
        //scan.close();
        System.out.println("");
        
        if(productid==0 || quantitysold==0 || customername.isEmpty() || servedby.isEmpty()) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	sales.setProductid(productid);
        	sales.setQuantitysold(quantitysold);
        	sales.setCustomername(customername);
        	sales.setServedby(servedby);
        	try {
				SupermartService.insertSales(sales);
				System.out.println("sale inserted");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	private static void editSales() {
		String customername,servedby;
		int productid,orderid,quantitysold = 0;
		Sales sales = new Sales();
		
    	System.out.println("Edit a sale");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter order id: ");
    	orderid = Integer.parseInt(scan.nextLine());
    	
    	System.out.println("Enter customer name: ");
    	customername = scan.nextLine();
        
        System.out.println("Enter served by: ");
        servedby = scan.nextLine();
        
        System.out.println("Enter product id: ");
        productid = Integer.parseInt(scan.nextLine());
        
        System.out.println("Enter quantity sold: ");
        quantitysold = Integer.parseInt(scan.nextLine());
        //scan.close();
        System.out.println("");
        
        if(productid==0 || customername.isEmpty() || orderid==0 || servedby.isEmpty() || quantitysold==0) {
        	System.out.println("Fields cannot be empty");
        	exitSystem();
        }else {
        	sales.setCustomername(customername);
        	sales.setServedby(servedby);
        	sales.setProductid(productid);
        	sales.setOrderid(orderid);
        	sales.setQuantitysold(quantitysold);
        	try {
				SupermartService.updateSales(sales);
				System.out.println("sale updated");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
	}
	private static void getAllSales() {
		Connection connection=null;
		PreparedStatement p=null;
		ResultSet rs=null;
		connection = DbConnection.connectDB();
		try {
		String sql="select * from sales";
		p=connection.prepareStatement(sql);
		rs=p.executeQuery();
		System.out.println("orderid\tproductid\tquantitysold\tservedby\tcustomername");
		while(rs.next()) {
			int orderid=rs.getInt("orderid");
			int productid=rs.getInt("productid");
			int quantitysold=rs.getInt("quantitysold");
			String servedby=rs.getString("servedby");
			String customername=rs.getString("customername");
			System.out.println(orderid + "\t\t"+ productid+"\t\t"+ quantitysold+"\t\t"+ servedby +"\t\t"+ customername);
		}
		}
		catch(SQLException e) {
			System.out.println(e);			
		}
	}
	
	private static void deleteSale() {
		System.out.println("Delete a sale");
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter orderid: ");
    	int orderid = Integer.parseInt(scan.nextLine());
    	//scan.close();
    	
    	try {
			SupermartService.deleteSale(orderid);
			System.out.println("sale deleted !!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
		public static void exitSystem(){
		System.out.println("//////////////////////////////////////////");
	    System.out.println("You have exited the system");
	    System.exit(0);
	}
}

	           