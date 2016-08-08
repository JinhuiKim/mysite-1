package kr.ac.sungkyul.web.board;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("list".equals(actionName)) {
			action = new BoardListAction();//게시물 리스트
		} else if ("modify".equals(actionName)) {
			action = new BoardModifyAction();//게시물 수정
		} else if ("view".equals(actionName)) {
			action = new BoardViewAction();//게시물보기
		} else if ("write".equals(actionName)) {
			action = new BoardWriteAction();//게시물 입력
		} else if ("delete".equals(actionName)) {
			action = new BoardDeleteAction();//게시물 삭제
		}else if ("modifyform".equals(actionName)) {
			action = new BoardModifyFormAction();//게시물 삭제
		}else if ("writeform".equals(actionName)) {
			action = new BoardWriteFormAction();//게시물 삭제
		} else {
			action = new BoardListAction();
		}
		return action;
	}
}
