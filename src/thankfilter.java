import java.util.*;
  import java.io.*;
  import javax.servlet.*;
  import javax.servlet.http.*;
  public class thankfilter implements Filter
  {

    public void doFilter(ServletRequest rq,
                      ServletResponse rs,
                      FilterChain fc)
                      throws ServletException, IOException
    {
      int i;
      boolean erFlag=false;
      String message = "";
      String outStr;
      // выборка параметров - суммы  
      Float sum = new Float(0);
      String Strsum = new String(rq.getParameter("one"));
      

      if (!Strsum.equals(""))
      {
        try { sum = new Float(Strsum); }
        catch (NumberFormatException nfe) 
        {  
          erFlag=true;
          message=message.concat("Неверный формат. Введите числовое значение <br>");  
        }
      }
      if ((sum.floatValue()<1))
      {  
        erFlag=true;
        message=message.concat("Введите значение больше нуля<br>");  
      }
      
      
      if (erFlag) 
      {
      // Если были ошибки, устанавливаются атрибуты запроса
        rq.setAttribute("error",message);
        rq.setAttribute("return","help");
      }
      else     
          rq.setAttribute("error","OK");
        // Передача управления на следующий фильтр/сервлет
        fc.doFilter(rq,rs);
      }
    
    
      
    // Пустые методы, но они должны быть определены
    public void init(FilterConfig filterConfig) throws ServletException  { }
    public void destroy() { }
  }