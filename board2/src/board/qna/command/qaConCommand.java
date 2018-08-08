package board.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.qna.ex.qaDao;
import board.qna.ex.qaDto;

public class qaConCommand implements qaCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int no = Integer.parseInt(request.getParameter("id"));
		
		qaDao dao = new qaDao();
		qaDto dto = dao.contentQ(no);
		
		request.setAttribute("dto",dto);
		
		
	};

}
