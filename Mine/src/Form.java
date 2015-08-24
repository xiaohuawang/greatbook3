
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Form")

public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static Connection conn;
	
    public Form() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String allBook = "";
		Double average = 0.0;
		

    	System.out.println("doget");
    	
    	
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
		
		/*  
		  <tr>
		    <td>Jill</td>
		    <td>Smith</td>		
		    <td>50</td>
		  </tr>
		  <tr>
		    <td>Eve</td>
		    <td>Jackson</td>		
		    <td>94</td>
		  </tr>
		  <tr>
		    <td>John</td>
		    <td>Doe</td>		
		    <td>80</td>
		  </tr>
		*/
		
		try {
		    	PreparedStatement preStatement = conn.prepareStatement("select * from NEWSCORE");
				ResultSet result = preStatement.executeQuery();
				while (result.next())
				{
		    		allBook += "<tr>";
		    		allBook += "<td>";
		    		allBook += result.getInt("ID");
		    		allBook+= "</td>";
		    		allBook += "<td>";
		    		allBook += result.getString("classtype");
		    		allBook+= "</td>";
		    		allBook += "<td>";
		    		allBook += result.getString("classname");
		    		allBook+= "</td>";
		    	    allBook += "<td>";
		    		allBook += result.getString("assigntype");
		    		allBook+= "</td>";
		    		allBook += "<td>";
		    		allBook += result.getString("theDate");
	    		    allBook+= "</td>";
		    		allBook += "<td>";
		    		allBook+= result.getDouble("GRADE");
		    		allBook+= "</td>";
		    		allBook += "</tr>";
				}
				
				
				
				
	  } catch (SQLException e) {
         e.printStackTrace();
	     }

		 request.setAttribute("allBook", allBook);
		 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			getServletContext().getRequestDispatcher("/2.jsp").forward(request, response);	
    }
   
		
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        
    }
    
    
    
    
}















