package kr.ac.sungkyul.mysit.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.UserDao;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class JoinAction implements Action  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String agreeProv = request.getParameter("agreeProv");
		

		UserDao dao = new UserDao();
		UserVo vo = new UserVo();

		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		System.out.println(vo);
		dao.insert(vo);
		if("y".equals(agreeProv)){
		WebUtil.redirect("/mysite/user?a=success", request, response); //포워딩 아니라 리다이렉션으로 a값 보내기 
		}else { 
			// 화면에 동의구하기 출력
		}
		
		
	}
}
