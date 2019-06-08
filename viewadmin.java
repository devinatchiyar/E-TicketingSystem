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
public class viewadmin extends HttpServlet{
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
        ResultSet rs = s.executeQuery("select * from admins"); 
        out.println("<html><table border='1'><tr>"); 
        out.println("<td>NAME</td>"); 

out.println("<td>PASSWORD</td></tr>"); 
while(rs.next()) 
{
out.println("<tr><td>'"+rs.getString("username")+"'</td>"); 
out.println("<td>'"+rs.getString("password")+"'</td></tr>"); 

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
    

