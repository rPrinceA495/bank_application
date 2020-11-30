/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acer
 */
import java.sql.*; 

public class JDBC {
    
    //Static constants:
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankatm";

    //credentials:
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private String sql;
    private ResultSet rs;



    public JDBC() {

        conn = null;
        pstmt = null;
        stmt = null;
        sql = "";
        rs = null;

        try{

            //Open connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            System.out.println("MySQL Database successfully connected.");

        }catch(SQLException e) {System.out.println(e);}

    }
    
    public int validateUser(String username, String password) {

        try{
            // SQL Statement
            sql = "SELECT * FROM admins where username = ? AND password = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            rs = pstmt.executeQuery();

            // Extract result set (Login success):
            if(rs.next()) {return rs.getInt("admin_id");}

            // (Login failed):
            else {return 0;}


        }catch(SQLException e) {System.out.println(e); return 0;}

    }
    
    
   public int addCustomer(Customer cu) {
        
        int id = 0;
        
        try{
            //Create sql statement to query db:
            sql = "INSERT into customers "
                    + "(f_name, l_name, address, company_name, company_address) "
                    + "VALUES (?, ?, ?, ?, ?)";
            
            //Create preparedstatement object using connecion:
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Assign values to question marks:
            pstmt.setString(1, cu.getfName());
            pstmt.setString(2, cu.getlName());
            pstmt.setString(3, cu.getAddress());
            pstmt.setString(4, cu.getCompanyName());
            pstmt.setString(5, cu.getCompanyAddress());
            
            //Execute the update (No resullt set):
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
                    
            if(rs.next()) {
                id = rs.getInt(1);
            }
            
            return id;

        }catch(SQLException e) {System.out.println(e); return id;}
        
    }
   
   public int addAdmin(Admin ad) {
        
        int id = 0;
        
        try{
            //Create sql statement to query db:
            sql = "INSERT into admins "
                    + "(f_name, l_name, username, password, address) "
                    + "VALUES (?, ?, ?, ?, ?)";
            
            //Create preparedstatement object using connecion:
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Assign values to question marks:
            pstmt.setString(1, ad.getfName());
            pstmt.setString(2, ad.getlName());
            pstmt.setString(3, ad.getUsername());
            pstmt.setString(4, ad.getPassword());
            pstmt.setString(5, ad.getAddress());
            
            //Execute the update (No resullt set):
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
                    
            if(rs.next()) {
                id = rs.getInt(1);
            }
            
            return id;

        }catch(SQLException e) {System.out.println(e); return id;}
        
    }
   
    public int addAccount(Account acc, int customer_id, String accountType) {
        
        int id = 0;
        
        try{
            //Create sql statement to query db:
            sql = "INSERT into accounts "
                    + "(customer_id, branch, acc_type, balance, interest_rate) "
                    + "VALUES (?, ?, ?, ?, ?)";
            
            //Create preparedstatement object using connecion:
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Assign values to question marks:
            pstmt.setInt(1, customer_id);
            pstmt.setString(2, acc.getBranch());
            pstmt.setString(3, accountType);
            pstmt.setDouble(4, acc.getBalance());
            pstmt.setDouble(5, acc.getInterest());
            
            
            //Execute the update (No resullt set):
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
                    
            if(rs.next()) {
                id = rs.getInt(1);
            }
            
            return id;

        }catch(SQLException e) {System.out.println(e); return id;}
        
    }
    
    public ResultSet returnAllCustomers() {
        
        try{
            // SQL Statement
            sql = "SELECT customer_id AS Customer_ID, f_name AS Name, l_name AS Surname, address AS Address, company_name AS Company_Name, company_address AS Company_Address "
                    + "FROM customers";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Execute the query
            rs = pstmt.executeQuery();
            
            return rs;


        }catch(SQLException e) {System.out.println(e); return null;}
        
    }
    
    
    public int getAccountHolderId(int accId) {
		
	int customerId = 0;
		
        try{
            // SQL Statement
            sql = "SELECT customer_id FROM accounts where account_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setInt(1, accId);

            // Execute the query
            rs = pstmt.executeQuery();

            if(rs.next()) {
		customerId = rs.getInt("customer_id");
            }
			
	return customerId;


        }catch(SQLException e) {System.out.println(e); return 0;}
		
    }
    
    public Account fetchAccount(int accountNumber) {
        
        Account acc = null;
        int customerId = 0;

        try{
            // Get Account Details
            sql = "SELECT * FROM accounts where account_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setInt(1, accountNumber);

            // Execute the query
            rs = pstmt.executeQuery();

            // Extract result set (Verification success):
            if(rs.next()) {
                String accType = rs.getString("acc_type");
                customerId = rs.getInt("customer_id");
                
                System.out.println("Acc Type: "+ accType);
                
                if(accType.equals("Cheque")) {
                    acc = new ChequeAccount(rs.getString("branch"), rs.getDouble("balance"));
                    acc.setAccNumber(rs.getInt("account_id"));
                }else if(accType.equals("Savings")) {
                    acc = new SavingsAccount(rs.getString("branch"), rs.getDouble("balance"));
                    acc.setAccNumber(rs.getInt("account_id"));
                }else {
                    acc = new InterestBearingAccount(rs.getString("branch"), rs.getDouble("balance"));
                    acc.setAccNumber(rs.getInt("account_id"));
                }
                
                
                    // Get Account Holder Details
                    sql = "SELECT * FROM customers where customer_id = ?";

                    // Prepared statement object using connection:
                    pstmt = conn.prepareStatement(sql);

                    // Bind values
                    pstmt.setInt(1, customerId);

                    // Execute the query
                    rs = pstmt.executeQuery();

                    // Extract result set (Verification success):
                    if(rs.next()) {
                
                    Customer customer = new Customer(rs.getString("f_name"), rs.getString("l_name"), rs.getString("address"), rs.getString("atm_pin"), rs.getString("company_name"), rs.getString("company_address"));
                    customer.setCustomerId(rs.getInt("customer_id"));
                    acc.setHolder(customer);
                
            }
                
            }else {
            
                return null;
            
            }
            
            

            return acc;

            
        }catch(SQLException e) {System.out.println(e); return null;}

    }
    
    public void updateATMPin(int customerId, String PIN) {
		
		try{
            // SQL Statement
            sql = "UPDATE customers SET atm_pin = ? WHERE customer_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setString(1, PIN);
            pstmt.setInt(2, customerId);

            // Execute the query
            pstmt.executeUpdate();

        }catch(SQLException e) {System.out.println(e);}
		
    }
    
    public int validatePIN(int customerId, String PIN) {

        try{
            // SQL Statement
            sql = "SELECT * FROM customers where customer_id = ? AND atm_pin = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setInt(1, customerId);
            pstmt.setString(2, PIN);

            // Execute the query
            rs = pstmt.executeQuery();

            // Extract result set (Login success):
            if(rs.next()) {return rs.getInt("customer_id");}

            // (Login failed):
            else {return 0;}


        }catch(SQLException e) {System.out.println(e); return 0;}

    }
    
    public void withdrawMoney(double amount, int accNum, double balance) {
        
            double newBalance = balance - amount;
		
		try{
            // SQL Statement
            sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accNum);

            // Execute the query
            pstmt.executeUpdate();

        }catch(SQLException e) {System.out.println(e);}
		
    }
    
    public void depositMoney(double amount, int accNum, double balance) {
        
            double newBalance = balance + amount;
		
		try{
            // SQL Statement
            sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accNum);

            // Execute the query
            pstmt.executeUpdate();

        }catch(SQLException e) {System.out.println(e);}
		
    }
    
    public int addTransaction(Transaction tr) {
        
        int id = 0;
        
        try{
            //Create sql statement to query db:
            sql = "INSERT into transactions "
                    + "(transaction_date, account_id, amount, transaction_type) "
                    + "VALUES (?, ?, ?, ?)";
            
            //Create preparedstatement object using connecion:
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Assign values to question marks:
            pstmt.setTimestamp(1, tr.getTransactionDate());
            pstmt.setInt(2, tr.getAccountId());
            pstmt.setDouble(3, tr.getAmount());
            pstmt.setString(4, tr.getTransactionType());
            
            //Execute the update (No resullt set):
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
                    
            if(rs.next()) {
                id = rs.getInt(1);
            }
            
            return id;

        }catch(SQLException e) {System.out.println(e); return id;}
        
    }
    
    public double getAccountBalance(int accId) {
		
	double balance = 0;
		
        try{
            // SQL Statement
            sql = "SELECT balance FROM accounts where account_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);

            // Bind values
            pstmt.setInt(1, accId);

            // Execute the query
            rs = pstmt.executeQuery();

            if(rs.next()) {
		balance = rs.getInt("balance");
            }
			
	return balance;


        }catch(SQLException e) {System.out.println(e); return balance;}
		
    }
    
    public ResultSet FetchAccountTransactions(int accNum) {
        
        try{
            // SQL Statement
            sql = "SELECT transaction_id AS Transaction_ID, transaction_date AS Date, amount AS Amount, transaction_type AS Transacton_Type "
                    + "FROM transactions WHERE account_id = ?";

            // Prepared statement object using connection:
            pstmt = conn.prepareStatement(sql);
            
            // Bind values
            pstmt.setInt(1, accNum);

            // Execute the query
            rs = pstmt.executeQuery();
            
            return rs;


        }catch(SQLException e) {System.out.println(e); return null;}
        
    }
    
    
}

