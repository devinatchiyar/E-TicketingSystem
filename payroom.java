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
public class payroom extends HttpServlet{
    Connection c=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/eticketing","kd","kd");
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
        int rooms=Integer.parseInt(((request.getSession()).getAttribute("rooms")).toString());
        int days=Integer.parseInt(request.getParameter("days"));
        String hotel=request.getParameter("hotel");
        String roomtype=request.getParameter("roomtype");
        String visitor=((request.getSession()).getAttribute("visitor")).toString();
        int b=s.executeUpdate("update hotels set hotelname='"+hotel+"' where visitorname='"+visitor+"'");
       
        int amount1=0;
        
        if(rooms<=10){
        
        if(roomtype.equalsIgnoreCase("ac")){
             amount1=(rooms*2000)*days;
        }
        else if(roomtype.equalsIgnoreCase("superdeluxe")){
             amount1=(rooms*5000)*days;
        }
        else if(roomtype.equalsIgnoreCase("deluxe")){
             amount1=(rooms*3000)*days;
        }
        else if(roomtype.equalsIgnoreCase("nonac")){
            amount1=(rooms*1000)*days;
        }
        else{
            out.println("invalid details");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");    
rd.include(request, response);


        }
        String amount11=Integer.toString(amount1);
        (request.getSession()).setAttribute("amount11",amount11);

        
        RequestDispatcher rd=request.getRequestDispatcher("amountdisplay1");    
rd.include(request, response);
        }
        else{
            out.println("no of rooms is  "+rooms);
 

        }

        
        s.close();
        c.close();
        
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        
        
    }
}
    

