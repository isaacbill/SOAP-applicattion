
package com.supermart.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.supermart.dbcon.DbConnection;
import com.supermart.dbcon.DbUtil;
import com.supermart.model.Purchase;
import com.supermart.model.Sales;
import com.supermart.model.Stock;
import com.supermart.model.Supplier;
import com.supermart.model.User;

public class SupermartService {
	private Connection connection;
	private PreparedStatement statement;
	
	public SupermartService() {
	}
	public static int registerUser(User user) throws ClassNotFoundException {
		String query = "INSERT INTO users (username,password,confirmpwd) VALUES (?, ?, ?);";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getConfirmpwd());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public void loginUser(User user) throws SQLException {
		String query = "SELECT * FROM users WHERE username=? AND password=?";
		ResultSet resultSet = null;
		//boolean userExist = false;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				//userExist = true;
				System.out.println("Welcome "+user.getUsername());
				System.out.println("");
			}else {
				System.out.println("Incorrect username/password");
				System.exit(0);
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		//return userExists;
	}
	
	public static int insertPurchase(Purchase purchase) throws ClassNotFoundException {
		String query = "INSERT INTO purchase (productname,buyingprice,supplierid,quantitybought) VALUES (?, ?, ?, ?);";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, purchase.getProductname());
			statement.setDouble(2, purchase.getBuyingprice());
			statement.setInt(3, purchase.getSupplierid());
			statement.setInt(4, purchase.getQuantitybought());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int insertSales(Sales sales) throws ClassNotFoundException {
		String query = "INSERT INTO sales (productid,quantitysold,customername,servedby) VALUES (?, ?, ?, ?);";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, sales.getProductid());
			statement.setInt(2, sales.getQuantitysold());
			statement.setString(3, sales.getCustomername());
			statement.setString(4, sales.getServedby());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int insertStock(Stock stock) throws ClassNotFoundException {
		String query = "INSERT INTO stock (productid,quantityavailable,sellingprice) VALUES (?, ?, ?);";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, stock.getProductid());
			statement.setInt(2, stock.getQuantityavailable());
			statement.setDouble(3, stock.getSellingprice());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int insertSupplier(Supplier supplier) throws ClassNotFoundException {
		String query = "INSERT INTO supplier (suppliername,suppliercontact) VALUES (?, ?);";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, supplier.getSuppliername());
			statement.setString(2, supplier.getSuppliercontact());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}

	
	public static int updatePurchase(Purchase purchase) throws ClassNotFoundException {
		String query = "UPDATE purchase SET productname=?,buyingprice=?,supplierid=?,quantitybought=? WHERE productid=?;";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, purchase.getProductname());
			statement.setDouble(2, purchase.getBuyingprice());
			statement.setInt(3, purchase.getSupplierid());
			statement.setInt(4, purchase.getQuantitybought());
			statement.setInt(5,purchase.getProductid());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int updateSales(Sales sales) throws ClassNotFoundException {
		String query = "UPDATE sales SET productid=?,quantitysold=?,customername=?,servedby=? WHERE orderid=?;";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, sales.getProductid());
			statement.setInt(2, sales.getQuantitysold());
			statement.setString(3, sales.getCustomername());
			statement.setString(4, sales.getServedby());
			statement.setInt(5, sales.getOrderid());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int updateStock(Stock stock) throws ClassNotFoundException {
		String query = "UPDATE stock SET productid=?,quantityavailable=?,sellingprice=? WHERE stockid=?;";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, stock.getProductid());
			statement.setInt(2, stock.getQuantityavailable());
			statement.setDouble(3, stock.getSellingprice());
			statement.setInt(4, stock.getStockid());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int updateSupplier(Supplier supplier) throws ClassNotFoundException {
		String query = "UPDATE supplier SET suppliername=?,suppliercontact=? WHERE supplierid=?;";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
	
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, supplier.getSuppliername());
			statement.setString(2, supplier.getSuppliercontact());
			statement.setInt(3, supplier.getSupplierid());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}

	
	public List<Purchase> getAllPurchases() throws SQLException {
		String query = "SELECT * FROM purchase";
		List<Purchase> list = new ArrayList<Purchase>();
		Purchase purchase = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				purchase = new Purchase();
				/*Retrieve purchase details 
                and store it in purchase object*/
				purchase.setProductid(resultSet.getInt("productid"));
				purchase.setProductname(resultSet.getString("productname"));
				purchase.setBuyingprice(resultSet.getDouble("buyingprice"));
				purchase.setSupplierid(resultSet.getInt("supplierid"));
				purchase.setQuantitybought(resultSet.getInt("quantitybought"));
				
				list.add(purchase);
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return list;
	}
	
	public List<Sales> getAllSales() throws SQLException {
		String query = "SELECT * FROM sales";
		List<Sales> list = new ArrayList<Sales>();
		Sales sales = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				sales = new Sales();
				sales.setProductid(resultSet.getInt("productid"));
				sales.setQuantitysold(resultSet.getInt("quantitysold"));
				sales.setCustomername(resultSet.getString("customername"));
				sales.setServedby(resultSet.getString("servedby"));
				
				list.add(sales);
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return list;
	}
	
	public List<Stock> getAllStock() throws SQLException {
		String query = "SELECT * FROM stock";
		List<Stock> list = new ArrayList<Stock>();
		Stock stock = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				stock = new Stock();
				stock.setProductid(resultSet.getInt("productid"));
				stock.setQuantityavailable(resultSet.getInt("quantityavailable"));
				stock.setSellingprice(resultSet.getDouble("sellingprice"));
				
				list.add(stock);
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return list;
	}
	
	public List<Supplier> getAllSuppliers() throws SQLException {
		String query = "SELECT * FROM supplier";
		List<Supplier> list = new ArrayList<Supplier>();
		Supplier supplier = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				supplier = new Supplier();
				supplier.setSuppliername(resultSet.getString("suppliername"));
				supplier.setSuppliercontact(resultSet.getString("suppliercontact"));
				
				list.add(supplier);
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return list;
	}
	
	
	public Supplier getSupplier(int supplierid) throws SQLException {
		String query = "SELECT * FROM supplier WHERE supplierid="+supplierid;
		Supplier supplier = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				supplier = new Supplier();
				supplier.setSupplierid(resultSet.getInt("supplierid"));
				supplier.setSuppliername(resultSet.getString("suppliername"));
				supplier.setSuppliercontact(resultSet.getString("suppliercontact"));
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return supplier;
	}
	
	public Sales getSale(int orderid) throws SQLException {
		String query = "SELECT * FROM sales WHERE orderid="+orderid;
		Sales sale = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				sale = new Sales();
				sale.setOrderid(resultSet.getInt("orderid"));
				sale.setProductid(resultSet.getInt("productid"));
				sale.setQuantitysold(resultSet.getInt("quantitysold"));
				sale.setCustomername(resultSet.getString("customername"));
				sale.setServedby(resultSet.getString("servedby"));
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return sale;
	}
	
	public Stock getStock(int stockid) throws SQLException {
		String query = "SELECT * FROM stock WHERE stockid="+stockid;
		Stock stock = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				stock = new Stock();
				stock.setStockid(resultSet.getInt("stockid"));
				stock.setProductid(resultSet.getInt("productid"));
				stock.setQuantityavailable(resultSet.getInt("quantityavailable"));
				stock.setSellingprice(resultSet.getDouble("sellingprice"));
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return stock;
	}
	
	public Purchase getPurchase(int purchaseid) throws SQLException {
		String query = "SELECT * FROM purchase WHERE productid="+purchaseid;
		Purchase purchase = null;
		ResultSet resultSet = null;
		try {
			connection = DbConnection.connectDB();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				purchase = new Purchase();
				purchase.setProductid(resultSet.getInt("productid"));
				purchase.setProductname(resultSet.getString("productname"));
				purchase.setBuyingprice(resultSet.getDouble("buyingprice"));
				purchase.setSupplierid(resultSet.getInt("supplierid"));
				purchase.setQuantitybought(resultSet.getInt("quantitybought"));
			}
		}finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return purchase;
	}
	
	
	public static int deletePurchase(int productid) throws ClassNotFoundException {
		String query = "DELETE FROM purchase WHERE productid="+productid+";";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
			PreparedStatement statement = con.prepareStatement(query);
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int deleteSale(int orderid) throws ClassNotFoundException {
		String query = "DELETE FROM sales WHERE orderid="+orderid+";";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
			PreparedStatement statement = con.prepareStatement(query);
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int deleteStock(int stockid) throws ClassNotFoundException {
		String query = "DELETE FROM stock WHERE stockid="+stockid+";";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
			PreparedStatement statement = con.prepareStatement(query);
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
	
	public static int deleteSupplier(int supplierid) throws ClassNotFoundException {
		String query = "DELETE FROM supplier WHERE supplierid="+supplierid+";";
		int insertResult = 0;
		
		try{
			Connection con = DbConnection.connectDB();
			PreparedStatement statement = con.prepareStatement(query);
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}
}
