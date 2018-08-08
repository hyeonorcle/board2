package board.qna.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.qna.command.qaCommand;
import board.qna.command.qaConCommand;
import board.qna.command.qaListCommand;

/**
 * Servlet implementation class qaController
 */
@WebServlet("*.khy")
public class qaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public qaController() {
        super();
    
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("doGet");
		actionDo(req,res);
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		System.out.println("doPost");
		actionDo(req,res);
	}

	protected void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String viewPage = null;
		qaCommand qac = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/qaList.khy")) {
			qac = new qaListCommand();
			qac.execute(req, res);
			viewPage = "listQnA.jsp";
		}else if(com.equals("/qaContent.khy")) {
			qac = new qaConCommand();
			qac.execute(req, res);
			viewPage = "contentQnA.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/qaboard/" + viewPage);
		dispatcher.forward(req, res);
		
		
	}
}
