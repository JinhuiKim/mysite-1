package kr.ac.sungkyul.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		if(no ==null || no.matches("-?\\d+(//.//d+)?")==false){//이상한일  방지
			WebUtil.redirect("/mysite/bs", request, response);
			return;
		}
		
		
		Long number = Long.parseLong(no);
		
		BoardDao dao = new BoardDao();
		
		BoardVo vo = dao.get(number);
		
		if(vo==null){//이상한일  방지
			WebUtil.redirect("/mysite/bs", request, response);
			return;
		}
		
		dao.viewcount(vo);
		request.setAttribute("boardVo", vo);

				
		WebUtil.forward("/WEB-INF/views/board/view.jsp", request, response);
		

	}

}
