//=====================================================================
  // ����� �������� code (������������ �������� ��� ���)
  import java.util.*;
  import java.io.*;
  import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  
  @WebServlet("/registration")
  public class registration extends HttpServlet 
  {
    public void doGet(HttpServletRequest rq,
                      HttpServletResponse rs)
                      throws ServletException, IOException
    {

      rq.setCharacterEncoding("Cp1251");
      // ��������� ��������� - ���� ��������
      String s1 = new String(rq.getParameter("spname"));
      if (s1.equals(""))
      {
        // ���� ��� �������� �� �����, ��������������� �������� -
        // ����� ��������� �� ������ � ����� ��������
        rq.setAttribute("error","��� ����� ");
        rq.setAttribute("return","help");
        // �������� ���������� �� ������� ������
        (rq.getRequestDispatcher("err")).forward(rq,rs);
      }       

      s1=decoder.winToDos(s1);

      sql1 db = new sql1();
      String rStr;
      String text="";
      String qu = "SELECT user_id FROM users WHERE name=\'" + s1 +"\'";
      Vector vv = new Vector();
      // ���������� ������� �� ������� �������� �� ��������� �����
      try { rStr=db.query(qu,vv);  }
      catch (Exception ex) { }
      Enumeration e = vv.elements();
      String id;
      if (e.hasMoreElements()) 
      { // ��� ������� � �� - ���������� ID ��������
      id= (String)(e.nextElement());
      text = "�� ��� ����������������";
    }
      else
      {       
        // ��� �� ������� � �� - �������� ������������ ID ��������
        qu = "SELECT MAX(user_id) FROM users";
        vv = new Vector();
        try { rStr=db.query(qu,vv);  }
        catch (Exception ex) { }
        e = vv.elements();
        // ����������� ��� �� 1 � ��������� ����� ������ ��������
        int iid= (new Integer((String)(e.nextElement())).intValue())+1;
        id= new Integer(iid).toString();
        qu = "INSERT INTO users (user_id,name) VALUES(" +
              id+",\'" + s1  +"\' )";
        try 
        { 
          rStr=db.query(qu,vv);  
          db.commit();
        }
        catch (Exception ex) { }
      }
      db.close();

      // ������������ ��������� ����� HTML
      String outStr = stdhead.mkHead("��� �����")+
    	"<p align=center>"+text+"<br>\n"+
        "<p align=center>��� �����:<br>\n" +
        "<table align=center border=3>\n" +
        "  <tr><td><big>&nbsp;&nbsp;" +
        s1 +
        "&nbsp;&nbsp;</big></td></tr>\n" +
        "</table>\n" +
        "<p></p>\n" +
        "<p align=center>\n" +
        "<form align=center action=help>" +
        "<input type=\"SUBMIT\" name=\"next\" value=\"������\">\n" +
        "<INPUT TYPE=\"HIDDEN\" NAME=\"spcode\" VALUE=\"" +
        id + "\">\n</form>\n" +
        "</body>\n" +
        "</html>";

      // ����� HTML � ����� �������
      rs.setContentType("text/html; charset=windows-1251");
      PrintWriter out=rs.getWriter();
      out.println(outStr);
      out.close();
    }
  }