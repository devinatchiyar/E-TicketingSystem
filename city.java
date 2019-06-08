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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class city extends HttpServlet{
    Connection c=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/eticketing","kd","kd");
        String hotel="null";
            String name=request.getParameter("name");
        String kids=request.getParameter("kids");
    
        String adults=request.getParameter("adults");
        String rooms=request.getParameter("rooms");
        String dest=request.getParameter("dest");
    
        String mi=request.getParameter("month-in");
        String di=request.getParameter("day-in");
        String mo=request.getParameter("month-out");
    
        String do1=request.getParameter("day-out");
        String roomtype="null";
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
          (request.getSession()).setAttribute("visitor",name);
        (request.getSession()).setAttribute("rooms",rooms);
        int b=s.executeUpdate("insert into hotels values('"+hotel+"','"+name+"','"+dest+"','"+mi+"','"+di+"','"+mo+"','"+do1+"','"+roomtype+"','"+kids+"','"+adults+"','"+rooms+"')");
       if(dest.equalsIgnoreCase("madurai")){
        RequestDispatcher rd=request.getRequestDispatcher("mduhotels.html");    
rd.include(request, response);
       }
       else if(dest.equalsIgnoreCase("chennai")){
        RequestDispatcher rd=request.getRequestDispatcher("chnaihotels.html");    
rd.include(request, response);
       }
       else{
           out.println("sorry there are no hotels available at this moment");
       }
       
        s.close();
        c.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(city.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        

        
       
      
    }
}
    

