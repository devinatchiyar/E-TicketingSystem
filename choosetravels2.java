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
public class choosetravels2 extends HttpServlet{
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
      
        String travels=request.getParameter("travels");
        String seat=request.getParameter("no");
        (request.getSession()).setAttribute("no",seat);
                (request.getSession()).setAttribute("travels",travels);
     
 
        try{
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        int no=Integer.parseInt(((request.getSession()).getAttribute("no")).toString());
        String name=((request.getSession()).getAttribute("name")).toString();
        ResultSet rs=s.executeQuery("select ticket from bus2 where busname='"+travels+"'");
        rs.beforeFirst();
        while(rs.next()){
        int tickets=rs.getInt("ticket");
        
        
        int tickets1=tickets-no;
        if(tickets1<=0){
         out.println("no tickets available");
        }
         else{
                 rs.updateInt("ticket",tickets1);
                 rs.updateRow();
           
        int b=s.executeUpdate("update travels set travels='"+travels+"' where travellername='"+name+"'");
        int d=s.executeUpdate("update travels set tickets='"+seat+"' where travellername='"+name+"'");
     
        RequestDispatcher rd=request.getRequestDispatcher("amountdisplay");  
//servlet2 is the url-pattern of the second servlet  
  
rd.forward(request, response);
        
            
        }
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
    

