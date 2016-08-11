package kr.ac.sungkyul.web.board;

import static java.lang.Math.toIntExact;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;
import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.WebUtil;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no1 = request.getParameter("no");
		String kwd =request.getParameter("kwd");
		Long pageNo = Long.parseLong(no1);
		BoardDao vo = new BoardDao();
		List<BoardVo> pageList = vo.getAll(kwd);
		List<BoardVo> list = vo.getList(pageNo, kwd);
	System.out.println("list size"+ list.size());
		int totalPage;
		int sPage;
		int ePage;
	
		if(pageList.size()% 10 == 0){
			totalPage = pageList.size() / 10 ;//
		
		}else{
			totalPage = (pageList.size() / 10)+ 1;
		}
		int pPage = totalPage / 5 ;
		int countPage = (toIntExact(pageNo)-1)/5;
		boolean prePage = true;
		boolean nextPage = true;
		
		//시작페이지 구하기
		if(countPage == 0){
			sPage = 1;
			prePage=false;
		}else {
			sPage = (countPage*5)+1;
		}
		
		//마지막페이지 구하기
		if(countPage==pPage){
			ePage = totalPage;
			nextPage=false;
		}else{
			ePage = sPage+4;
		}

		request.setAttribute("list", list);// 이름 지정과 객체
		request.setAttribute("pageList", pageList);// 이름 지정과 객체
		request.setAttribute("sPage", sPage);
		request.setAttribute("ePage", ePage);
		request.setAttribute("prePage", prePage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("kwd", kwd);
		WebUtil.forward("/WEB-INF/views/board/list.jsp", request, response);

	}

}
