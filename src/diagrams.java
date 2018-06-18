import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class diagrams
 */
@WebServlet("/diagrams")
public class diagrams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=windows-1251");
	      // получение выходного потока

	      // 1-я строка документа
		 String outString=stdhead.mkHead("Побудова діаграми")  +
				 
				 "<div id='fh5co-services'>"+
				 "<div class='container'>"+
				 	"<div class='row'>"+
				 		"<div class='col-md-10 col-md-offset-1'>"+
				 			"<div class='row'>"+
				 				
				 					"<div class='fh5co-desc'>"+
				 					"<h5><a href=charting.html><img src=images/diagram.png width=\"50\"\r\n" + 
				 					"height=\"50\" border=0>Перейти на побудову діаграм онлайн</a></h5>"+
				 					"</div>"+	
				 				"</div>"+
				 			"</div>"+
				 		"</div>"+
				 	"</div>"+
				 "</div>"+
				 "</div>"+
				 "</div>"+	
		         "<table align=center "
		         + "border='1'>"		 
				 ;
		

/*		 String qu = "SELECT x, y  FROM datatable";
	      Vector vv = new Vector();
	      String rStr;
	      // Соединение с БД
	      sql1 db = new sql1();
	      try { rStr=db.query(qu,vv); }
	      catch (Exception ex) { }
	      db.commit(); db.close();
  
	      // Формирование HTML-таблицы координат 
	      List dataList = new ArrayList();
	      Enumeration e = vv.elements();
	      
	      while (e.hasMoreElements())
	      {
		        outString=outString + "<tr><td>" +
	                  (String)(e.nextElement()) + 
	                  "</td><td> " +
	                  (String)(e.nextElement()) + 
	                  "</td></tr>\n"
	                 ;
	      }
	      
	      String qu2 = "SELECT x  FROM datatable";
	      Vector vv2 = new Vector();
	      String rStr2;
	      // Соединение с БД
	      sql1 db2 = new sql1();
	      try { rStr=db.query(qu,vv); }
	      catch (Exception ex) { }
	      db.commit(); db.close();
	      Enumeration e2 = vv.elements();
	      
	      while (e.hasMoreElements())
	      {
	    	  dataList.add(e2.nextElement());
   
	      } 
		  
	      String diagramtypes2="WebContent/diagramtypes2.jsp";
	      request.setAttribute("data",dataList);
	      RequestDispatcher dispatcher = request.getRequestDispatcher(diagramtypes2);
	      if (dispatcher != null){
	        dispatcher.forward(request, response);
	      }
*/	      
		 outString=outString + 
				 "</table>"+
		"<table align=center>"+
		 "<tr>"+
		 "  <td>"+
		    "<h3 align=center>Оберіть тип діаграми</h3>"+
		    "<form  action=diagramtypes.jsp>"+
		     "<p align=center>"+
		     "<select name='choice' >"+
		      "<option value='1'>Стовбчата діаграма "+
		      
		      "<option value='3'>Кільцева діаграма "+
		      "<option value='4'>Точкова діаграма"+
		      "<option value='5'>Стовбчата діаграма зі значеннями"+
/*		      "<option value='6'>Test"+
		      "<option value='7'>DB"+ */
		      "<option value='8'>Графік"+
		     "</select>"+
		     "<input type='SUBMIT' name='select' value='Вибрати' > "+
		    "</form>"+
		   "</td>"+
		  "</tr>"+
		  "</table>"  

		  ;
		 
		
		 
	      outString=outString + 
	  		        "</body>\n" +
	  		        "</html>";
	      
	      
		response.setContentType("text/html;charset=windows-1251");

	   // получение выходного потока
	      PrintWriter out=response.getWriter();
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
