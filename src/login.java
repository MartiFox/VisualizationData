import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class help
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=windows-1251");
		

		
	      // ��������� ��������� ������
	      PrintWriter out=response.getWriter();

	      // 1-� ������ ���������
		 String outString=stdhead.mkHead("����������") +	
				 "<h2 align=center>����������</h2>"+

				"<p><table align=center>"+
				 " <tr>"+
				   "<td width=50% align=center>������ ��� ����"+
				    "<p><form action='pay'>"+
				   " <input type='text' name='spname', value=''>"+
				    " <input type='SUBMIT' name='sendcode' value='OK'>"+
				   " </form>"+
				  " </td>"+
				   "<td width=50% align=center>���� �� ������ �� ����, ������ ���� ��� ���������"+
				    "<p><form action='registration'>"+
				    "<input type='text' name='spname', value=''>"+
				     "<input type='SUBMIT' name='sendname' value='OK'>"+
				    "</form>"+
				   "</td>"+
				 "</tr>"+
				 "</table>"+
		 "</body>"+
			"</html>";	 
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
