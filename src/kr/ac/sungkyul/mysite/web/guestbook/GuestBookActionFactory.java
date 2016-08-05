package kr.ac.sungkyul.mysite.web.guestbook;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class GuestBookActionFactory extends ActionFactory{

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("delete".equals(actionName)){
			action = new GuestBookDeleteAction();
		}else if("list".equals(actionName)){
			action = new GuestBookListAction();
		}else if("insert".equals(actionName)){
			action = new GuestBookInsertAction();
		}else if("deleteform".equals(actionName)){
			action = new GuestBookDeleteFormAction();
		}else{
			action = new GuestBookListAction();
		}
		return action;
	}

}
