import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class thanks
 */
 @WebServlet("/thanks")

public class thanks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html;charset=windows-1251");
	      // ��������� ��������� ������
		
		
	      PrintWriter out=response.getWriter();
	      // 1-� ������ ���������
	      String docType="<!DOCTYPE HTML PUBLIC \\"; 
		
	      
	     
	      String message = "";
	      String outString;
	     
	      // ���� ������ �� ��������� ������� ������� "error" � "OK",
	      // ���������� ���������� �� ������� �������� ������
	      message=(String)(request.getAttribute("error"));
	      if (!message.equals("OK")) 
	        (request.getRequestDispatcher("err")).forward(request,response);
	      HttpSession sess = request.getSession(false);
	      String spons_id=(String)(sess.getAttribute("uName"));
	      int sum = new Integer(request.getParameter("one"));
	      String qu, rStr;

	      // ������� ����� �������� �� ��
	      sql1 db = new sql1();
	      qu = "SELECT sum from users where name='" + spons_id +"'" ;
	      Vector vv = new Vector();
	      try  { rStr=db.query(qu,vv); }
	      catch (Exception ex) { }
	      Enumeration e=vv.elements();
	      if (!e.hasMoreElements()) 
	      {
	        // ���� ���� �������� ��� � ��, ���������������
	        // �������� � ���������� ���������� �� ������� �������� ������
	        request.setAttribute("error","����� " + spons_id + " ����������� � ���� ������");
	        request.setAttribute("return","login");
	        (request.getRequestDispatcher("err")).forward(request,response);
	      }
	      String Ssum = (String)(e.nextElement());
	      int i = Integer.parseInt(Ssum);
	      i=i+sum;
	      qu = "UPDATE users SET sum = sum + "+ sum +" WHERE name = '"+spons_id+"'";
	        try 
	        { 
	          rStr=db.query(qu,vv);  
	          db.commit();
	        }
	        catch (Exception ex) {ex.printStackTrace(); }
	        finally {
	      	      db.close();
	        }
	        
		outString=stdhead.mkHead("������ �����������")+
		         "<p align=center>"+
		         "<H1 align=center><font color=red>������ ����������� "+spons_id+
		         "</font></h1>"+
		         "<p>������� ����:"+sum+
		         "<p>������ "+spons_id+":"+i
		         + "</body>" + "</html>";         

		         //		 outString="<h1 align=center><font color=red>������� �� ���������!</font></h1>";
		 out.println(outString);
	      out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
