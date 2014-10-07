package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.Controller;
import core.mvc.FrontController;

public class SaveController implements Controller {
	private QuestionDao questionDao = new QuestionDao();
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = (String) request.getParameter("writer");
		String title = (String) request.getParameter("title");
		String contents = (String) request.getParameter("contents");
		
		Question question = new Question(writer, title, contents);
		logger.debug(writer);
		
		questionDao.insert(question);
		
		return "index.jsp";
	}

}
