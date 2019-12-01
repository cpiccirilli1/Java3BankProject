/*
Chelsea Piccirilli
Java 3 Fall 2019
 */
package customer;

import java.sql.*;


public class Customer {
    private String custId = "3001";
    private String custPassword; 
    private String custFirstName; 
    private String custLastName; 
    private String custAddress;
    private String custEmail;
    
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

    public void Customer(){
        this.setCustId("");
        this.setCustPassword("");
        this.setCustFirstName("");
        this.setCustLastName("");
        this.setCustAddress("");
        this.setCustEmail("");
        
    }
    
    public void Customer(String id, String pass, String fn, String ln, String add, 
            String email){
        this.setCustId(id);
        this.setCustPassword(pass);
        this.setCustFirstName(fn);
        this.setCustLastName(ln);
        this.setCustAddress(add);
        this.setCustEmail(email);
    }
    
    public void selectDB(String id){
         try{
            String dbPath = "C:/Users/Chelsea/Documents/CTC/Fall 2019/Fall 2019/Java3/ChattBank/ChattBank/web/ChattBankMDB.mdb";
            System.out.println("Starting DB Connection");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+dbPath);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Customers WHERE CustID='" +id+"'";
            
            System.out.println("Checking the db now");
            
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
    }
    
    public void display(){
       System.out.println("Customer ID: "+ this.getCustId());
       System.out.println("Customer pass: "+ this.getCustPassword());
       System.out.println("Customer Name:"+this.getCustFirstName()+
               " "+this.getCustLastName());
       System.out.println("Customer city: " +this.getCustAddress());
       System.out.println("Customer email: "+ this.getCustEmail());
       
    }
    
    /**
     *
     * @param args
     */
    
    public void main(String[] args){       
        Customer c1;
        c1 = new Customer();
        c1.selectDB(this.custId);
        c1.display();
    
    }
}

