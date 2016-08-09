package kr.ac.sungkyul.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String no1 = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long number = Long.parseLong(no1);
		System.out.println(no1 +";"+title + ";"+ content);
		BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDao();
		vo.setNo(number);
		vo.setTitle(title);
		vo.setContent(content);

		dao.modify(vo);

		System.out.println(no1);
		
		WebUtil.redirect("/mysite/bs?a=list", request, response);

	}

}
