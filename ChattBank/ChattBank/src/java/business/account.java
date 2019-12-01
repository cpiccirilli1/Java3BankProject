/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.sql.*;

/**
 *
 * @author Chelsea
 */
public class account {
    public String acctNo;
    public String custId;
    public String type;
    public String balance;
    /**
     * @return the acctNo
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * @param acctNo the acctNo to set
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }
    
    public void account(String acctNo, String type, String balance, String id){
        this.setAcctNo(acctNo);
        this.setBalance(balance);
        this.setCustId(id);
        this.setType(type);
    }
    
    public void account(){
        this.setAcctNo("");
        this.setBalance("");
        this.setCustId("");
        this.setType("");
    }
    
    public void selectDB(String acctNo){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection - accounts.selectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Accounts WHERE acctNo='" +acctNo+"'";
            
            System.out.println("Checking the db now - accounts.selectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                this.setAcctNo(rs.getString(1));
                this.setBalance(rs.getString(4));
                this.setType(rs.getString(3));
                this.setCustId(rs.getString(2));
              
            }
            con.close();
            
        }
        
        catch(SQLException e){
            System.out.println(e);
        }
    }
     
    public void insertDB(String acctNo, String balance, String type, String custId){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO Accounts "+
                "Values('"+acctNo+"', '" +custId+"', '"+type+"', '"+balance+"')";
            System.out.println("Inserting into the db now");
            
            stmt.executeUpdate(sql);
            con.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteDB(){
        /*
        *This requires a selectDB() to be called first.
        */
         try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "delete FROM Accounts WHERE AcctNo='" +this.getAcctNo()+"'";
            
            System.out.println("Deleting entry now");
            
             stmt.executeUpdate(sql);
            
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void updateDB(){
        /*
        *This requires a selectDB() to be called first
        */
         try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "Update Accounts"+ 
                    " set cid='"+this.getCustId()+"', "+
                    "balance='"+this.getBalance()+"', "+
                    "type='"+this.getType()+"', "+
                    "WHERE AcctNo='" +this.getAcctNo()+"'";
            
            System.out.println("Updating db now");
            stmt.executeUpdate(sql);
            
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void display(){
        System.out.println("AcctNo: " + this.getAcctNo());
        System.out.println("Type: "+ this.getType());
        System.out.println("Cust. ID: "+this.getCustId());
        System.out.println("Balance: "+this.getBalance());
    }
    
    public static void main(String[] args){
        account a1 = new account();
        a1.selectDB("998");
        a1.display();
        //a1.updateDB();
    }
}
