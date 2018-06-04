import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

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
		 String outString=stdhead.mkHead("Построение диаграммы")  +
				 
				 "<div id='fh5co-services'>"+
				 "<div class='container'>"+
				 	"<div class='row'>"+
				 		"<div class='col-md-10 col-md-offset-1'>"+
				 			"<div class='row'>"+
				 				
				 					"<div class='fh5co-desc'>"+
				 					"<h5><a href=charting.html><img src=images/diagram.png width=\"50\"\r\n" + 
				 					"height=\"50\" border=0>Перейти на постороение диаграмм онлайн</a></h5>"+
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
		

  
		 
		 outString=outString + 
				 "</table>"+
		"<table align=center>"+
		 "<tr>"+
		 "  <td>"+
		    "<h3 align=center>Выберите тип диаграммы</h3>"+
		    "<form  action=diagramtypes.jsp>"+
		     "<p align=center>"+
		     "<select name='choice' >"+
		      "<option value='1'>Столбчатая диаграмма "+
		      
		      "<option value='3'>Кольцевая диаграмма "+

		      "<option value='8'>График"+
		     "</select>"+
		     "<input type='SUBMIT' name='select' value='Выбрать' > "+
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
