/*
Chelsea Piccirilli
Java 3 Fall 2019
 */
package business;
import java.sql.*;

public class customer {
    private String custId;
    private String custPassword; 
    private String custFirstName; 
    private String custLastName; 
    private String custAddress;
    private String custEmail;
    public AccountList alist = new AccountList();
    
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
     * @return the custPassword
     */
    public String getCustPassword() {
        return custPassword;
    }

    /**
     * @param custPassword the custPassword to set
     */
    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    /**
     * @return the custFirstName
     */
    public String getCustFirstName() {
        return custFirstName;
    }

    /**
     * @param custFirstName the custFirstName to set
     */
    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    /**
     * @return the custLastName
     */
    public String getCustLastName() {
        return custLastName;
    }

    /**
     * @param custLastName the custLastName to set
     */
    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    /**
     * @return the custAddress
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * @param custAddress the custAddress to set
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    /**
     * @return the custEmail
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * @param custEmail the custEmail to set
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public void customer(){
        this.setCustId("");
        this.setCustPassword("");
        this.setCustFirstName("");
        this.setCustLastName("");
        this.setCustAddress("");
        this.setCustEmail("");
        
    }
    
    public void customer(String id, String pass, String fn, String ln, String add, 
            String email){
        this.setCustId(id);
        this.setCustPassword(pass);
        this.setCustFirstName(fn);
        this.setCustLastName(ln);
        this.setCustAddress(add);
        this.setCustEmail(email);
    }
    public void getAccts(String id){
        account a1;
        String an;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection - customer.getAccts");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "SELECT AcctNo FROM Accounts WHERE cid='" +id+"'";
            
            System.out.println("Checking the db now - customer.getAccts");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                a1 = new account();
                an = rs.getString(1);
                a1.selectDB(an);
                alist.add(a1);
              
            }
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    public void selectDB(String id){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection - customer.SelectDB");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Customers WHERE CustID='" +id+"'";
            
            System.out.println("Checking the db now - customer.SelectDB");
            
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                this.setCustId(rs.getString(1));
                this.setCustFirstName(rs.getString(3));
                this.setCustLastName(rs.getString(4));
                this.setCustAddress(rs.getString(5));
                this.setCustEmail(rs.getString(6));
                this.setCustPassword(rs.getString(2));
              
            }
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        getAccts(id);
    }
    
    public void insertDB(String id, String pass, String fn, String ln, String add,
    String email){
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
            String sql = "INSERT INTO Customers "+
                "Values('"+id+"', '" +pass+"', '"+fn+"', '"+ln+"', '"+add+"', '"+email+"')";
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
            String sql = "Update Customers "+ 
                    "set CustPassword='"+ this.getCustPassword()+"', "+
                    "CustFirstName='"+this.getCustFirstName()+"', "+
                    "CustLastName='"+this.getCustLastName()+"', "+
                    "CustAddress='"+this.getCustAddress()+"', "+
                    "CustEmail='"+this.getCustEmail()+"', "+
                    "WHERE CustID='" +this.getCustId()+"'";
            
            System.out.println("Checking the db now");
            stmt.executeUpdate(sql);
            
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
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
            String sql = "delete FROM Customers WHERE CustID='" +this.getCustId()+"'";
            
            System.out.println("Deleting entry now");
            
             stmt.executeUpdate(sql);
            
            con.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void display(){
       System.out.println("Customer ID: "+ this.getCustId());
       System.out.println("Customer pass: "+ this.getCustPassword());
       System.out.println("Customer Name:"+this.getCustFirstName()+
               " "+this.getCustLastName());
       System.out.println("Customer city: " +this.getCustAddress());
       System.out.println("Customer email: "+ this.getCustEmail());
       alist.display();
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){       
        customer c1 = new customer();
        c1.selectDB("3001");
        c1.display();
    
    }
}
