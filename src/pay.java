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
	      // получение выходного потока
		
	      String id = new String(request.getParameter("spname"));
	      if (id.equals(""))
	      {
	        // Если код спонсора отсутствует, устанавливаются
	        // атрибуты и управление передается на сервлет страницы ошибки
	        request.setAttribute("error","Немає логину");
	        request.setAttribute("return","login");
	        (request.getRequestDispatcher("err")).forward(request,response);
	      }       

	      Vector vv;
	      Enumeration e;
	      String rStr, qu, outStr;

	      // Выборка имени спонсора из БД
	      sql1 db = new sql1();
	      
	      qu = "SELECT user_id from users where name='" + id +"'";
	      vv = new Vector();
	      try  { rStr=db.query(qu,vv); }
	      catch (Exception ex) { }
	      e=vv.elements();
	      if (!e.hasMoreElements()) 
	      {
	        // Если кода спонсора нет в БД, устанавливаются
	        // атрибуты и управление передается на сервлет страницы ошибки
	        request.setAttribute("error","Логин " + id + " відсутний в базі даних");
	        request.setAttribute("return","login");
	        (request.getRequestDispatcher("err")).forward(request,response);
	      }
	      String spName = (String)(e.nextElement());

	      // Выбирается сеанс (или создается, если его еще нет)
	      HttpSession sess = request.getSession(true);
	      // Код и имя спонсора устанавливаются атрибутами сеанса
	      sess.setAttribute("uCode",spName);
	      sess.setAttribute("uName",id);
		
		
		
		
	      PrintWriter out=response.getWriter();
	      // 1-я строка документа
	      String docType="<!DOCTYPE HTML PUBLIC \\"; 
		
		String outString;
		outString=stdhead.mkHead("Оплата")+
		         "<p align=center>"+
		         "<H1 align=center><font color=black>Ваш внесок</font></h1>"
		         ;         


		      
		   // Формирование статической заключительной части страницы
		      outString=outString + 
		    " <table align=center>"+
		    "<tr><td>"+
		    "<form action='thanks'>"+
		     " <input type='text' name='one' value='' class='filterInput'>"+
		      "<input type='SUBMIT' name='send' value='Підтвердити'><br>"+
		         "</form>"+
		        " </td></tr>"+
		         "</table>"+  
		        "</body>\n" +
		        "</html>";
		   // Получение выходного потока и вывод в него HTML-документа  
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
