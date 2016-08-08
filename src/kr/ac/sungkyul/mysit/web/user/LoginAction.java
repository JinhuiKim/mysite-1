package kr.ac.sungkyul.mysit.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.mysite.dao.UserDao;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		UserDao dao = new UserDao();
		UserVo vo = dao.get(email, password);
		if(vo ==null){
			//로그인 실패
			WebUtil.redirect("/mysite/user?a=loginform&r=fail", request, response);
			return;//redirect 다음에 코드가있다면  무조건 리턴해서 끝내줘야함 
		}
	//로그인 처리 
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", vo);
		WebUtil.redirect("/mysite/main", request, response);

	}

}
