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
		
		// action
		String action = request.getParameter("action");
		if (action == null) action = "";
		
		// key
		String keyString = request.getParameter("key");
		if (keyString == null) keyString="0";
		Long key = Long.parseLong(keyString);

		String urlList = "/list.jsp";
		String urlForm = "/form.jsp";
		
		ServletContext sc = getServletContext();
	
		
		switch (action) {
		case "new":
			
			RequestDispatcher rdNew = sc.getRequestDispatcher(urlForm);
			
			request.setAttribute("entryKey", null);
			request.setAttribute("entryValue", "");
			request.setAttribute("nextAction", "create");
			rdNew.forward(request, response);
			
			break;
			
		case "edit":
			
			RequestDispatcher rdEdit = sc.getRequestDispatcher(urlForm);
			
			request.setAttribute("entryKey", testBean.getByKey(key).getKey());
			request.setAttribute("entryValue", testBean.getByKey(key).getValue());
			request.setAttribute("nextAction", "update");
			rdEdit.forward(request, response);
			
			break;
			
		case "delete":
			
			System.out.println("delete " + key);
			
			break;

		default:
			
			Collection<TestTable> ejbResult = testBean.getList();
			
			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlList);
			
			request.setAttribute("resultList", ejbResult);
			rdDefault.forward(request, response);
			
			break;
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
