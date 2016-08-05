package kr.ac.sungkyul.web.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao vo = new BoardDao();
		List<BoradVo> list = vo.getList();
		
		request.setAttribute("list", list);//이름 지정과 객체 
		WebUtil.forward("/WEB-INF/views/board/list.jsp", request, response);
		

	}

}
