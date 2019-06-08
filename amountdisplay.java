import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class amountdisplay extends HttpServlet {  
public void service(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
   response.setContentType("text/html;charset=UTF-8");  
    PrintWriter out = response.getWriter();  
    int amount=1;
int no=Integer.parseInt(((request.getSession()).getAttribute("no")).toString());
 String travels=((request.getSession()).getAttribute("travels")).toString();   
 if(travels.equalsIgnoreCase("radha")){
      amount=amount*500*no;
 }
 if(travels.equalsIgnoreCase("srs")){
      amount=amount*500*no;
 }

if(travels.equalsIgnoreCase("kpn")){
      amount=amount*500*no;
 }
String amount1=Integer.toString(amount);
(request.getSession()).setAttribute("amount",amount1);
out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='payment.html'>proceed to payment</a>");
            out.println("Rs."+amount1);
            out.println("</body>");
            out.println("</html>");



          
    out.close();  
    }  
}  