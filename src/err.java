 //========================================================
  // Формирование сообщения об ошибке
  import java.util.*;
  import java.io.*;
  import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  
  @WebServlet("/err")

  public class err extends HttpServlet 
  {
    public void doGet(HttpServletRequest rq,
                      HttpServletResponse rs)
                      throws ServletException, IOException
    {

      // Формирование HTML-документа
      String outStr=stdhead.mkHead("Ошибка") +
               "<h2 align=center>==Ошибка!==<br>" + 
      // Текст сообщения подставляется из атрибута "error"
                (String)(rq.getAttribute("error")) +
                "</h2>\n<p align=center>\n" +
                "<form action=\"" +
      // Адрес, на который передается управление,
      // подставляется из атрибута "return"
                (String)(rq.getAttribute("return")) +
                "\">" +
                "<input type=\"submit\" name=\"ok\" value=\"OK!\">" +
                "<input type=\"hidden\" name=\"spcode\" value=\"" +
                (String)(rq.getParameter("spcode"))+"\">" +
                "</body></html>";
      // Вывод в поток отклика
      rs.setContentType("text/html; charset=windows-1251");
      PrintWriter out=rs.getWriter();
      out.println(outStr);
      out.close();
    }
  }
