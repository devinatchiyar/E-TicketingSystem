
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Enterdetails extends HttpServlet{
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
            String source=request.getParameter("source");
            String destination=request.getParameter("destination");
           
            String dateoftravel=request.getParameter("date");
            
            String travels="null";
            String x="null";
 
        try{
        PrintWriter out=response.getWriter();    
        Statement s=c.createStatement();
      int b=s.executeUpdate("insert into travels values('"+name+"','"+email+"','"+source+"','"+destination+"','"+dateoftravel+"','"+travels+"','"+x+"')");
      if(b==1){ 
          out.println("hello");
          (request.getSession()).setAttribute("name",name);
          (request.getSession()).setAttribute("date",dateoftravel);
          (request.getSession()).setAttribute("email",email);
          if((source.equalsIgnoreCase("madurai"))&&(destination.equalsIgnoreCase("chennai"))&&(dateoftravel.equalsIgnoreCase("today"))){
      RequestDispatcher rd=request.getRequestDispatcher("choosetravels.html");
       rd.forward(request,response);
      }
          else if((source.equalsIgnoreCase("chennai"))&&(destination.equalsIgnoreCase("madurai"))&&(dateoftravel.equalsIgnoreCase("today"))){
      RequestDispatcher rd=request.getRequestDispatcher("choosetravels1.html");
       rd.forward(request,response);
      }
          else if((source.equalsIgnoreCase("madurai"))&&(destination.equalsIgnoreCase("chennai"))&&(dateoftravel.equalsIgnoreCase("tomorrow"))){
      RequestDispatcher rd=request.getRequestDispatcher("choosetravels2.html");
       rd.forward(request,response);
      }
          else if((source.equalsIgnoreCase("chennai"))&&(destination.equalsIgnoreCase("madurai"))&&(dateoftravel.equalsIgnoreCase("tomorrow"))){
      RequestDispatcher rd=request.getRequestDispatcher("choosetravels3.html");
       rd.forward(request,response);
      }
          else{
              out.println("sorry no buses available");
          }
      }
      else
      {
          out.println("invalid details");
      }
        s.close();
        c.close();
        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
    finally
     { 
         PrintWriter out=response.getWriter();    
         out.println("hi");
     }
    }
}
    

