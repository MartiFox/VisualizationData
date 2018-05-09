import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contacts
 */
@WebServlet("/contacts")
public class contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=windows-1251");
	      // получение выходного потока
	      PrintWriter out=response.getWriter();
	      // 1-я строка документа

		
		String outString=stdhead.mkHead("Контакты")  +
"<div id='fh5co-services'>"+
	"<div class='container'>"+
		"<div class='row'>"+
			"<div class='col-md-10 col-md-offset-1'>"+
				"<div class='row'>"+
					"<h2 class='section-lead text-center'>Контакты</h2>"+
					"<div class='col-md-4 col-sm-6 col-xs-6 col-xxs-12 fh5co-service'>"+
						"<div class='fh5co-icon to-animate'><i class='icon-present'></i></div>"+
						"<div class='fh5co-desc'>"+
							"<h3>Mail</h3>"+
							"<p>gmail</p>"+
						"</div>"+	
					"</div>"+
				"</div>"+
			"</div>"+
		"</div>"+
	"</div>"+
"</div>"+
"</div>"+

	"</body>" + "</html>";   
	
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
