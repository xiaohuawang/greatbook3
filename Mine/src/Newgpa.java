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

@WebServlet("/Newgpa")
public class Newgpa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn;
	
	  public Newgpa() {
	        super();
	        
	    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("doget");
	
	double hw = Double.parseDouble(request.getParameter("homework"));
	double qz = Double.parseDouble(request.getParameter("quiz"));
	double t = Double.parseDouble(request.getParameter("test"));
	double pj = Double.parseDouble(request.getParameter("project"));
	String ID = request.getParameter("studentID");
  
	double qpt = 0, credt = 0, value = 0, GPA = 0;
	
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
	  
	     
      try {
      	String sql = "select ID, assignType, grade from newscore where ID = " + ID;
      
          PreparedStatement preStatement = conn.prepareStatement(sql);
          ResultSet result = preStatement.executeQuery();
          
       //   System.out.println("try");
      	   
          while (result.next())
          {	
        	  System.out.println("LL");
        	   System.out.println(result.getDouble("grade"));
        	  
        	  if ((result.getDouble("grade")) <=100 && (result.getDouble("grade")) >= 93)
          	{
          		value = 4.0;
		            	if (result.getString("assignType").equalsIgnoreCase("homework"))
		            	{
		            		qpt += (value * hw);
		            		credt += hw;
		            	}
		            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
		            	{
		            		qpt += (value * qz);
		            		credt += qz;
		            	}
		            	if (result.getString("assignType").equalsIgnoreCase("test"))
		            	{
		            		qpt += (value * t);
		            		credt += t;
		            	}
		            	if (result.getString("assignType").equalsIgnoreCase("project"))
		            	{
		            		qpt += (value * pj);
		            		credt += pj;
		            	}
          	
           	
      	}
      	else if ((result.getDouble("grade") <=92) && (result.getDouble("grade")) >= 90)
      	{
      		value = 3.7;
	            	if (result.getString("assignType").equalsIgnoreCase("homework"))
	            	{
	            		qpt += (value * hw);
	            		credt += hw;
	            	}
	            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
	            	{
	            		qpt += (value * qz);
	            		credt += qz;
	            	}
	            	if (result.getString("assignType").equalsIgnoreCase("test"))
	            	{
	            		qpt += (value * t);
	            		credt += t;
	            	}
	            	if (result.getString("assignType").equalsIgnoreCase("project"))
	            	{
	            		qpt += (value * pj);
	            		credt += pj;
	            	}
      	}
      	else if (result.getDouble("grade") <=89 && result.getDouble("grade")  >= 87)
    	{
    		value = 3.3;
            	if (result.getString("assignType").equalsIgnoreCase("homework"))
            	{
            		qpt += (value * hw);
            		credt += hw;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
            	{
            		qpt += (value * qz);
            		credt += qz;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("test"))
            	{
            		qpt += (value * t);
            		credt += t;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("project"))
            	{
            		qpt += (value * pj);
            		credt += pj;
            	}
    	}
      	else if (result.getDouble("grade")  <=86 && result.getDouble("grade")  >= 83)
    	{
    		value = 3.0;
            	if (result.getString("assignType").equalsIgnoreCase("homework"))
            	{
            		qpt += (value * hw);
            		credt += hw;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
            	{
            		qpt += (value * qz);
            		credt += qz;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("test"))
            	{
            		qpt += (value * t);
            		credt += t;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("project"))
            	{
            		qpt += (value * pj);
            		credt += pj;
            	}
    	}
      	else if (result.getDouble("grade")  <=82 && result.getDouble("grade")  >= 80)
    	{
    		value = 2.7;
            	if (result.getString("assignType").equalsIgnoreCase("homework"))
            	{
            		qpt += (value * hw);
            		credt += hw;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
            	{
            		qpt += (value * qz);
            		credt += qz;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("test"))
            	{
            		qpt += (value * t);
            		credt += t;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("project"))
            	{
            		qpt += (value * pj);
            		credt += pj;
            	}
    	}
    	else if (result.getDouble("grade")  <=79 && result.getDouble("grade")  >= 77)
    	{
    		value = 2.3;
            	if (result.getString("assignType").equalsIgnoreCase("homework"))
            	{
            		qpt += (value * hw);
            		credt += hw;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
            	{
            		qpt += (value * qz);
            		credt += qz;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("test"))
            	{
            		qpt += (value * t);
            		credt += t;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("project"))
            	{
            		qpt += (value * pj);
            		credt += pj;
            	}
    	}
    	else if (result.getDouble("grade")  <=76 && result.getDouble("grade")  >= 73)
    	{
    		value = 2.0;
            	if (result.getString("assignType").equalsIgnoreCase("homework"))
            	{
            		qpt += (value * hw);
            		credt += hw;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
            	{
            		qpt += (value * qz);
            		credt += qz;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("test"))
            	{
            		qpt += (value * t);
            		credt += t;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("project"))
            	{
            		qpt += (value * pj);
            		credt += pj;
            	}
    	}
    	else if (result.getDouble("grade")  <=72)
    	{
    		value = 1.0;
            	if (result.getString("assignType").equalsIgnoreCase("homework"))
            	{
            		qpt += (value * hw);
            		credt += hw;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("quiz"))
            	{
            		qpt += (value * qz);
            		credt += qz;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("test"))
            	{
            		qpt += (value * t);
            		credt += t;
            	}
            	if (result.getString("assignType").equalsIgnoreCase("project"))
            	{
            		qpt += (value * pj);
            		credt += pj;
            	}
    	}
        	GPA = qpt/credt;
        	System.out.println(GPA);
        	
        }

        System.out.println(value);
   
      } catch (SQLException e) {

          e.printStackTrace();
      }



try {
	conn.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("AAA"+GPA);
System.out.println("AAA"+GPA);
request.setAttribute("GPA", GPA);
getServletContext().getRequestDispatcher("/3.jsp").forward(request, response);

}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
}


}










