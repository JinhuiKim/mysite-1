package kr.ac.sungkyul.web.board;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("list".equals(actionName)) {
			action = new BoardListAction();
		} else if ("modify".equals(actionName)) {
			action = new BoardModifyAction();
		} else if ("view".equals(actionName)) {
			action = new BoardViewAction();
		} else if ("write".equals(actionName)) {
			action = new BoardWriteAction();
		} else {
			action = new BoardListAction();
		}
		return action;
	}
}
