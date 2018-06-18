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
	      // получение выходного потока
		
		
	      PrintWriter out=response.getWriter();
	      // 1-я строка документа
	      String docType="<!DOCTYPE HTML PUBLIC \\"; 
		
	      
	     
	      String message = "";
	      String outString;
	     
	      // Если фильтр не установил атрибут запроса "error" в "OK",
	      // управление передается на сервлет страницы ошибки
	      message=(String)(request.getAttribute("error"));
	      if (!message.equals("OK")) 
	        (request.getRequestDispatcher("err")).forward(request,response);
	      HttpSession sess = request.getSession(false);
	      String spons_id=(String)(sess.getAttribute("uName"));
	      int sum = new Integer(request.getParameter("one"));
	      String qu, rStr;

	      // Выборка имени спонсора из БД
	      sql1 db = new sql1();
	      qu = "SELECT sum from users where name='" + spons_id +"'" ;
	      Vector vv = new Vector();
	      try  { rStr=db.query(qu,vv); }
	      catch (Exception ex) { }
	      Enumeration e=vv.elements();
	      if (!e.hasMoreElements()) 
	      {
	        // Если кода спонсора нет в БД, устанавливаются
	        // атрибуты и управление передается на сервлет страницы ошибки
	        request.setAttribute("error","Логин " + spons_id + " отсутствует в базе данных");
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
	        
		outString=stdhead.mkHead("Кабінет користувача")+
		         "<p align=center>"+
		         "<H1 align=center><font color=red>Кабінет користувача "+spons_id+
		         "</font></h1>"+
		         "<p>Внесена сума:"+sum+
		         "<p>Баланс "+spons_id+":"+i
		         + "</body>" + "</html>";         

		         //		 outString="<h1 align=center><font color=red>Спасибо за поддержку!</font></h1>";
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
