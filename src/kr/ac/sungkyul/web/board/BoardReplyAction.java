package kr.ac.sungkyul.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.mysite.vo.UserVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session ==null){
			WebUtil.redirect("/mysite/main", request, response);
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser ==null){
			WebUtil.redirect("mysite/main", request, response);
			return;
		}
		
		String no = request.getParameter("no");
		String  title = request.getParameter("title");
		String  content = request.getParameter("content");
		Long boardNo = Long.parseLong(no);
		
		System.out.println("qweqweqweqwe"+boardNo);
		
		if(title ==null && content ==null){
			WebUtil.redirect("mysite/bs?a=writeform", request, response);
		
			return;
		}
		
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		System.out.println("boardNo"+boardNo);
		BoardVo	parentVo = dao.get(boardNo);
		
		
	System.out.println("parentVo.getGroupNo()"+parentVo.getGroupNo());

	System.out.println("parentVo.getOrderNo()"+parentVo.getOrderNo());

	System.out.println("parentVo.getDepth()"+parentVo.getDepth());
	
		vo.setGroupNo(parentVo.getGroupNo());
		vo.setOrderNo(parentVo.getOrderNo());
		vo.setDepth(parentVo.getDepth());
	
		vo.setUserNo(authUser.getNo());
		vo.setTitle(title);
		vo.setContent(content);
		dao.write(vo);

		WebUtil.redirect("/mysite/bs?a=list&no=1", request, response);
	}

}
