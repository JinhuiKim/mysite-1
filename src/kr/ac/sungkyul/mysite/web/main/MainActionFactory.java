package kr.ac.sungkyul.mysite.web.main;

import kr.ac.sungkyul.web.Action;
import kr.ac.sungkyul.web.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = new MainAction();
		
		
		return action;
	}

}
