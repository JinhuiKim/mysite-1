package kr.ac.sungkyul.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("no");
	    
	    Long rno = Long.parseLong(number);

		BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDao ();
	    vo.setNo(rno);
		
		dao.delete(vo);
		WebUtil.redirect("/mysite/bs?a=list", request, response);
	
	}

}
