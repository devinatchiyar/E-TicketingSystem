/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devi
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class records extends HttpServlet{
    Connection c=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/eticketing","kd","kd");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        String name=request.getParameter("name");
        
        String email=request.getParameter("email");
 
        try{
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
        ResultSet rs = s.executeQuery("select * from travels where travellername='"+name+"' and email='"+email+"'"); 
        out.println("<html><table border='1'><th>"); 
        out.println("<td>NAME</td>"); 
out.println("<td>EMAIL</td>"); 
out.println("<td>SOURCE</td>"); 
out.println("<td>DESTINATION</td>"); 
out.println("<td>DATE</td>"); 
out.println("<td>TIME</td>"); 
out.println("<td>NO OF KIDS</td>"); 
out.println("<td>NO OF ADULTS</td>"); 
out.println("<td>TRAVELS</td>"); 
out.println("<td>SEAT</td></th><tr>"); 
while(rs.next()) 
{
out.println("<td>'"+rs.getString("travellername")+"'</td>"); 
out.println("<td>'"+rs.getString("email")+"'</td>"); 
out.println("<td>'"+rs.getString("source")+"'</td>"); 
out.println("<td>'"+rs.getString("destination")+"'</td>"); 
out.println("<td>'"+rs.getString("dateoftravel")+"'</td>"); 
out.println("<td>'"+rs.getString("timeoftravel")+"'</td>"); 
out.println("<td>'"+rs.getString("kids")+"'</td>"); 
out.println("<td>'"+rs.getString("adults")+"'</td>"); 
out.println("<td>'"+rs.getString("travels")+"'</td>"); 
out.println("<td>'"+rs.getString("seat")+"'</td>"); 
} 
out.println("</tr></table></html>"); 

        s.close();
        c.close();
        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
    finally
     { 
     }
    }
}
    

