package kr.ac.sungkyul.mysite.web.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.GuestBookDao;
import kr.ac.sungkyul.mysite.vo.GuestBookVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class GuestBookListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		GuestBookDao vo = new GuestBookDao();
		List<GuestBookVo> list = vo.getList();
		
		request.setAttribute("list", list);//이름 지정과 객체 
		WebUtil.forward("/WEB-INF/views/guestbook/list.jsp", request, response);
		
		
	}

}
