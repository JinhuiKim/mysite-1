package kr.ac.sungkyul.mysit.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// logout 처리
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("authUser");
			session.invalidate();// 새 세션아이디를 발급하라 !! 브라우저에게 알림

		}
		WebUtil.redirect("/mysite/main", request, response);

	}

}
