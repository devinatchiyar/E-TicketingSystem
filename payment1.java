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
public class payment1 extends HttpServlet{
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
        String cn=request.getParameter("cardnumber");
    
        String cvv=request.getParameter("cvv");
         String amount=((request.getSession()).getAttribute("amount11")).toString();
        
 
        try{
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
        
        int b=s.executeUpdate("insert into payment values('"+name+"','"+cn+"','"+cvv+"','"+amount+"')");
        RequestDispatcher rd=request.getRequestDispatcher("successful.html");    
rd.include(request, response);
        
        
        
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
    

