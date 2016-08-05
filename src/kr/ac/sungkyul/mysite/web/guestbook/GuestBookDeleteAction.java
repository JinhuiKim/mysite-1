package kr.ac.sungkyul.mysite.web.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.GuestBookDao;
import kr.ac.sungkyul.mysite.vo.GuestBookVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class GuestBookDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String number = request.getParameter("no");
		    String password = request.getParameter("password");
			
		    
		    Long rno = Long.parseLong(number);
		 
		    
		    GuestBookDao dao = new GuestBookDao();
		    GuestBookVo vo  = new GuestBookVo();

		    vo.setNo(rno);
		    vo.setPassword(password);
		   
		    dao.delete(vo);
		

		    WebUtil.redirect("/mysite/gb?a=list", request, response);
		    

	}

}
