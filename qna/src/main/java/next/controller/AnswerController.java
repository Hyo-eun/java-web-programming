package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.security.krb5.Asn1Exception;
import core.mvc.Controller;
import core.mvc.FrontController;

public class AnswerController implements Controller {
	private AnswerDao answerDao = new AnswerDao();
	private QuestionDao questionDao = new QuestionDao();
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String questionIdStr = request.getParameter("questionId");
		long questionId = Integer.parseInt(questionIdStr);
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		Answer answer = new Answer(writer, contents, questionId);
		answerDao.insert(answer);
		questionDao.increaseCountOfComment(questionId);
		
		logger.debug(writer);
		
		return "api";
	}

}
