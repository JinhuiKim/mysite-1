package kr.ac.sungkyul.mysit.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class LoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtil.forward("/WEB-INF/views/user/loginform.jsp", request, response);

	}

}
