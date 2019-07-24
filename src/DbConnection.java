
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18M01ACS031
 */
public class DbConnection {
    
    String host = "jdbc:mysql://localhost:3306/bizeasy";
    String user = "root";
    String pass = "";
    
    Connection conn;
    ResultSet result;
     public Connection getConnection(){
      try{
          conn = DriverManager.getConnection(host, user, pass);
          JOptionPane.showMessageDialog(null,"Connection Successful");
          return conn;
      }
      catch(SQLException ex){
      JOptionPane.showMessageDialog(null,ex.getMessage());
      }
      return null;
    }
      public void insertAccount(String Fname,String Password,String Email){
         
        String q = "INSERT into register(fullname,password,email) VALUES (?,?,?)";
              
        int k = 0;
        try{
        PreparedStatement st = getConnection().prepareStatement(q);
        st.setString(1,Fname);
        st.setString(2,Password);
        st.setString(3,Email);

        if(st.executeUpdate() > k){
         JOptionPane.showMessageDialog(null,Fname + " registered successfully");
         InformationSystem   Account =new InformationSystem();
         Account.UserNameLabel.setText(Fname);
        
         Account.dispose();
        Account.setVisible(true);
        }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
      }
          
      
      
       public void insertSnackReport(String Customername,String Purchase,String Amount,String Discount,String Balance){
        String q = "INSERT into snacksreport(customername, purchase,amount,discount,balance) VALUES (?,?,?,?,?)";
              
        int k = 0;
        try{
        PreparedStatement st = getConnection().prepareStatement(q);
        st.setString(1,Customername);
        st.setString(2,Purchase);
        st.setString(3,Amount);
        st.setString(4,Discount);
        st.setString(5,Balance);
        if(st.executeUpdate() > k){
         JOptionPane.showMessageDialog(null,Customername + " registered successfully");
        }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
      }
        public void insertCuisineReport(String Customername,String Purchase,String Amount,String Discount,String Balance){
        String q = "INSERT into cuisinesreport(customername, purchase,amount,discount,balance) VALUES (?,?,?,?,?)";
              
        int k = 0;
        try{
        PreparedStatement st = getConnection().prepareStatement(q);
        st.setString(1,Customername);
        st.setString(2,Purchase);
        st.setString(3,Amount);
        st.setString(4,Discount);
        st.setString(5,Balance);
        if(st.executeUpdate() > k){
         JOptionPane.showMessageDialog(null,Customername + " registered successfully");
        }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
      }
        public void insertAccountInformation(String Name,String IDNum,String Gender){
        String q = "INSERT into homeaccount(name,accid,gender) VALUES (?,?,?)";
              
        int k = 0;
        try{
        PreparedStatement st = getConnection().prepareStatement(q);
        st.setString(1,Name);
        st.setString(2,IDNum);
        st.setString(3,Gender);

        if(st.executeUpdate() > k){
         JOptionPane.showMessageDialog(null,Name + " registered successfully");
        }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
      }
 public ResultSet getAccount(){    
      //create the select query
         String q = "SELECT * FROM register";
         try{
         //prepare the statement
         Statement statement = getConnection().createStatement();
         //create the resultset collection
         ResultSet results = statement.executeQuery(q);
         //return the resultset object results
                return results;
         }
         catch(SQLException ex){
         //if there is an sql exception, return the error to the user with a null
         JOptionPane.showMessageDialog(null,ex.getMessage());
         return null;
         }
}
   public ResultSet getStudents(){
         String q="SELECT * FROM homeaccount";
         try{
             Statement st=getConnection().createStatement();
             ResultSet rs=st.executeQuery(q);
             return rs;
         }
         catch(SQLException x){
              JOptionPane.showMessageDialog(null, x.getMessage());
              return null;
         }
         }
     

 public ResultSet getSnackReport(){    
      //create the select query
         String q = "SELECT * FROM snacksreport";
         try{
         //prepare the statement
         Statement statement = getConnection().createStatement();
         //create the resultset collection
         ResultSet results = statement.executeQuery(q);
         //return the resultset object results
                return results;
         }
         catch(SQLException ex){
         //if there is an sql exception, return the error to the user with a null
         JOptionPane.showMessageDialog(null,ex.getMessage());
         return null;
         }
 }
   public ResultSet getCuisineReport(){    
      //create the select query
         String q = "SELECT * FROM cuisinesreport";
         try{
         //prepare the statement
         Statement statement = getConnection().createStatement();
         //create the resultset collection
         ResultSet results = statement.executeQuery(q);
         //return the resultset object results
                return results;
         }
         catch(SQLException ex){
         //if there is an sql exception, return the error to the user with a null
         JOptionPane.showMessageDialog(null,ex.getMessage());
         return null;
         }
}
 public void deleteAccount_1( int Phone)
         {
        String q="DELETE FROM account_1 WHERE phone=?";
        int k=0;
        try {
            PreparedStatement st=getConnection().prepareStatement(q);
            
            st.setInt(1,Phone);
         
            if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,Phone+" Deleted successful");
        } 
        }
            
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
              }
    }
  public void deleteHomeAccount(String IDNum){
        String q="DELETE FROM homeaccount WHERE accid=?";
        int k=0;
        try {
            PreparedStatement st=getConnection().prepareStatement(q);
            st.setString(1,IDNum);
            
            if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,IDNum +" Deleted successful");
        } 
        }
            
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
              }
    }
  public void UpdateStudent(String nameF,String emailF,int phoneF,String passwordF){
    String q="UPDATE account_1 SET name=?,email=?,password=? WHERE password=?";
    int k=0;
    try{
       
        
    PreparedStatement Prepst=getConnection().prepareStatement(q);
       Prepst.setString(1,nameF);
       Prepst.setString(2,emailF);
       Prepst.setInt(3,phoneF);
       Prepst.setString(4,passwordF);
      
       if(Prepst.executeUpdate()>k){
           JOptionPane.showMessageDialog(null," account_1 Record Updated successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
    
    
}
   public void UpdateHomeAccount(String Name,String IDNum,String Gender){
    String q="UPDATE homeaccount SET name=?,gender=? WHERE accid=?";
    int k=0;
    try{
       
        
    PreparedStatement st=getConnection().prepareStatement(q);
       st.setString(1,Name);
       st.setString(2,IDNum);
       st.setString(3,Gender);
      
       if(st.executeUpdate()>k){
           JOptionPane.showMessageDialog(null,"Student Record Updated successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
    
    
}
  public void insertAccountInformation(String nameF,String emailF,int phoneF,String passwordF){
    String q="UPDATE account_1 SET name=?,email=?,password=? WHERE password=?";
    int k=0;
    try{
       
        
    PreparedStatement Prepst=getConnection().prepareStatement(q);
       Prepst.setString(1,nameF);
       Prepst.setString(2,emailF);
       Prepst.setInt(3,phoneF);
       Prepst.setString(4,passwordF);
      
       if(Prepst.executeUpdate()>k){
           JOptionPane.showMessageDialog(null," account_1 Record Updated successful");
       }
           
       
   }
catch(SQLException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    
}
    
    
}
  
  
}