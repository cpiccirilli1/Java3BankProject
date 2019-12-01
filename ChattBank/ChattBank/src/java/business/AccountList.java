/********************
 Chelsea Piccirilli
 Lab 4
 *******************/
package business;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Chelsea
 */
public class AccountList 
{
    public int count = 0;
    public ArrayList<account> arr = new ArrayList<account>();
    
    
    public void AccountList(){

    }
    
    public void add(account a1){
        arr.add(a1);
        count++;
    }
    
    public void display()
    {
        for (int i = 0; i < count; i++)
        {
            arr.get(i).display();
        }
    }
    
}
