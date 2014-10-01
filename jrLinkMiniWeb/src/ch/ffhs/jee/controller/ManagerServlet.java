package ch.ffhs.jee.controller;

import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.ffhs.jee.model.TestTable;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/manage")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@EJB
	private TestBeanLocal testBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) action = "";
		
		String keyString = request.getParameter("key");
		if (keyString == null) keyString="0";
		Long key = Long.parseLong(keyString);

		Collection<TestTable> ejbResult = testBean.getList();
		
		//for (TestTable elm : ejbResult) {
		//	System.out.println(elm.getKey() + " - " + elm.getValue());
		//}

		switch (action) {
		case "new":
			System.out.println("new");
			break;
		case "edit":
			System.out.println("edit " + key);
			break;
		case "delete":
			System.out.println("delete " + key);
			break;

		default:
		
			String url = "/list.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			
			request.setAttribute("resultList", ejbResult);
			rd.forward(request, response);
			
			break;
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
