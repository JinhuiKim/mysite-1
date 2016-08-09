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

public class ModifyFormAction implements Action { //회원정보수정하는 창의 데이터 가져오기

	@Override                                       
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인증여부 확인
		HttpSession session = request.getSession();
		if(session ==null){
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null){
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}
		
		//인증 되어 있음
		Long no = authUser.getNo();
		UserDao dao = new UserDao();
		
		UserVo vo = dao.get(no);
		request.setAttribute("userVo", vo);
	
		WebUtil.forward("/WEB-INF/views/user/modifyform.jsp", request, response);
		
	}

}
