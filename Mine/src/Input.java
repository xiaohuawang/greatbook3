import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Input")
public class Input extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
   static Connection conn;
    
  public Input() {
      super();
      
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  
	    try {
           
	    	
	    	String url = "jdbc:oracle:thin:testuser/password@localhost";
             Class.forName("oracle.jdbc.driver.OracleDriver");
            //properties for creating connection to Oracle database
            Properties props = new Properties();
            props.setProperty("user", "testdb");
            props.setProperty("password", "password");
           
            //creating connection to Oracle database using JDBC
            
                conn = DriverManager.getConnection(url,props);
            } catch (Exception e) {

                e.printStackTrace();
            }
	    
		String Id = request.getParameter("Id");
    	String Classtype=request.getParameter("Classtype");
    	String Classname=request.getParameter("Classname");
    	String Assigntype=request.getParameter("Assigntype");
        String Thedate =request.getParameter("Thedate");
        String Grade=request.getParameter("Grade");
        
        
      try{
        String sql = "Insert into newscore(Id, Classtype, Classname, Assigntype, Thedate, Grade) values (" + Id + ", '" + Classtype + "', '" + Classname + "', '"+ Assigntype +"', to_date('" + Thedate +"','MM/DD/YYYY'), "  + Grade + ")";
         PreparedStatement preStatement = conn.prepareStatement(sql);
         ResultSet result = preStatement.executeQuery();
         result.next();
        }catch (SQLException e) {

            e.printStackTrace();
        }
      
      try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
      
      RequestDispatcher rd = request.getRequestDispatcher("Form");
      rd.forward(request, response);
      
      //System.out.println("doGet");
      
       }
        
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
      
  }

        
  
 
	
	
	
}
























