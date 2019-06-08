import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class amountdisplay1 extends HttpServlet {  
public void service(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
   response.setContentType("text/html;charset=UTF-8");  
    PrintWriter out = response.getWriter();  
String amount=((request.getSession()).getAttribute("amount11")).toString();
out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='payment1.html'>proceed to payment</a>");
            out.println("Rs."+amount);
            out.println("</body>");
            out.println("</html>");

          
    out.close();  
    }  
}  