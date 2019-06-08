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
public class viewhotel extends HttpServlet{
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
 
        try{
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
        ResultSet rs = s.executeQuery("select * from hotels"); 
        out.println("<html><table border='1'><th>"); 
        out.println("<td>HOTELNAME</td>"); 
out.println("<td><VISITORNAME/td>"); 

out.println("<td>DESTINATION</td>"); 
out.println("<td>MONTHIN</td>"); 
out.println("<td>DAYIN</td>"); 
out.println("<td>MONTHOUT</td>"); 
out.println("<td>DAYOUT</td>"); 
out.println("<td>ROOMTYPE</td>"); 
out.println("<td>KIDS</td>"); 
out.println("<td>ADULTS</td>"); 
out.println("<td>ROOMS</td></th>"); 
while(rs.next()) 
{
    out.println("<tr>");
out.println("<td>'"+rs.getString("hotelname")+"'</td>"); 
out.println("<td>'"+rs.getString("visitorname")+"'</td>"); 
out.println("<td>'"+rs.getString("destination")+"'</td>"); 
out.println("<td>'"+rs.getString("monthin")+"'</td>"); 
out.println("<td>'"+rs.getString("dayin")+"'</td>"); 
out.println("<td>'"+rs.getString("monthout")+"'</td>"); 
out.println("<td>'"+rs.getString("dayout")+"'</td>"); 
out.println("<td>'"+rs.getString("roomtype")+"'</td>"); 
out.println("<td>'"+rs.getString("kids")+"'</td>"); 
out.println("<td>'"+rs.getString("adults")+"'</td>"); 
out.println("<td>'"+rs.getString("rooms")+"'</td>"); 
out.println("</tr>");
} 
out.println("</table></html>"); 

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
    

