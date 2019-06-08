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
public class payment extends HttpServlet{
    Connection c=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/eticketing","kd","kd");
        String name=request.getParameter("name");
        String cn=request.getParameter("cardnumber");
        String amount=((request.getSession()).getAttribute("amount")).toString();
        int am=Integer.parseInt("amount");
        String cvv=request.getParameter("cvv");
        int balance=Integer.parseInt(request.getParameter("balance"));
        
        int newbalance=balance-am;
 
      
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
        out.println(amount);
        out.println(am);
        out.println(balance);
        out.println(newbalance);
        if(newbalance<0)
            out.println("insuffiecient funds");
        else
        {
        
                

        int b=s.executeUpdate("insert into payment values('"+name+"','"+cn+"','"+cvv+"','"+amount+"')");
        if(b==1){
        RequestDispatcher rd=request.getRequestDispatcher("successful.html");    
        rd.include(request, response);
        }
        else{
            out.println("invalid");
        }
        }
        
        
        s.close();
        c.close();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        }
}

    

