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
public class signup extends HttpServlet{
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
        String uname=request.getParameter("username");
        String pw=request.getParameter("password");
        String phoneno=request.getParameter("phoneno");
        String email=request.getParameter("email");
 
        try{
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
        Statement t=c.createStatement();
        boolean p=false;
        ResultSet rs=t.executeQuery("select * from users where usname='"+uname+"'");
        p=rs.next();
        if(p==false){
        int b=s.executeUpdate("insert into users values('"+uname+"','"+pw+"','"+email+"','"+phoneno+"')");
        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
//servlet2 is the url-pattern of the second servlet  
  
rd.forward(request, response);
        }
        else{
            RequestDispatcher rd=request.getRequestDispatcher("invalid.html");  
//servlet2 is the url-pattern of the second servlet  
  
rd.forward(request, response);

            
        }
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
    

