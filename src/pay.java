import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class thanks
 */
 @WebServlet("/pay")

public class pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pay() {
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
		
	      String id = new String(request.getParameter("spname"));
	      if (id.equals(""))
	      {
	        // ���� ��� �������� �����������, ���������������
	        // �������� � ���������� ���������� �� ������� �������� ������
	        request.setAttribute("error","���� ������");
	        request.setAttribute("return","login");
	        (request.getRequestDispatcher("err")).forward(request,response);
	      }       

	      Vector vv;
	      Enumeration e;
	      String rStr, qu, outStr;

	      // ������� ����� �������� �� ��
	      sql1 db = new sql1();
	      
	      qu = "SELECT user_id from users where name='" + id +"'";
	      vv = new Vector();
	      try  { rStr=db.query(qu,vv); }
	      catch (Exception ex) { }
	      e=vv.elements();
	      if (!e.hasMoreElements()) 
	      {
	        // ���� ���� �������� ��� � ��, ���������������
	        // �������� � ���������� ���������� �� ������� �������� ������
	        request.setAttribute("error","����� " + id + " �������� � ��� �����");
	        request.setAttribute("return","login");
	        (request.getRequestDispatcher("err")).forward(request,response);
	      }
	      String spName = (String)(e.nextElement());

	      // ���������� ����� (��� ���������, ���� ��� ��� ���)
	      HttpSession sess = request.getSession(true);
	      // ��� � ��� �������� ��������������� ���������� ������
	      sess.setAttribute("uCode",spName);
	      sess.setAttribute("uName",id);
		
		
		
		
	      PrintWriter out=response.getWriter();
	      // 1-� ������ ���������
	      String docType="<!DOCTYPE HTML PUBLIC \\"; 
		
		String outString;
		outString=stdhead.mkHead("������")+
		         "<p align=center>"+
		         "<H1 align=center><font color=black>��� ������</font></h1>"
		         ;         


		      
		   // ������������ ����������� �������������� ����� ��������
		      outString=outString + 
		    " <table align=center>"+
		    "<tr><td>"+
		    "<form action='thanks'>"+
		     " <input type='text' name='one' value='' class='filterInput'>"+
		      "<input type='SUBMIT' name='send' value='ϳ���������'><br>"+
		         "</form>"+
		        " </td></tr>"+
		         "</table>"+  
		        "</body>\n" +
		        "</html>";
		   // ��������� ��������� ������ � ����� � ���� HTML-���������  
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
