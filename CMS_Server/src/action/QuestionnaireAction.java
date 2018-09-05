package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Answer;
import entity.QA;
import entity.Question;
import entity.Questionnaire;
import service.AnswerService;
import service.QAService;
import service.QuestionService;
import service.QuestionnaireService;

@Controller
public class QuestionnaireAction {
	@Autowired
	private QuestionnaireService questionnaireService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QAService qaService;
	
	@RequestMapping("/getAllQuestionnaire")
	public ModelAndView getAllQuestionnaire() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Questionnaire> questionnaires =questionnaireService.getAllQuestionnaire();
		model.put("questionnaires", questionnaires);
		return new ModelAndView("",model);
	}
	
	@RequestMapping("/getQuestionnaireByID")
	public ModelAndView getQuestionnaireByID(int questionnaireID) {
		Map<String, Object> model = new HashMap<String, Object>();
		Questionnaire questionnaire =questionnaireService.getQuestionnaireByID(questionnaireID);
		model.put("questionnaire", questionnaire);
		return new ModelAndView("",model);
	}
	
//	@RequestMapping("/insertQuestionnaire")
//	public ModelAndView insertQuestionnaire(String questionnaireName,String questionnaireText,String[] questionName,String[] questionType,int[] questionLength,String[] questionText) {
//		Questionnaire questionnaire = new Questionnaire();
//		questionnaire.setQuestionnaireName(questionnaireName);
//		questionnaire.setQuestionnaireText(questionnaireText);
//		List<Questionnaire> questionnaires =questionnaireService.getAllQuestionnaire();
//		for(int i=0;i<questionnaires.size();i++) {
//			if(questionnaires.get(i).getQuestionnaireName().equals(questionnaireName)) {
//				System.out.println("名称重复");
//				return new ModelAndView("neirong");
//			}
//		}
//		questionnaireService.insertQuestionnaire(questionnaire);//插入问卷调查名称以及简述
//		int questionnaireID = questionnaireService.getQuestionnaireByName(questionnaireName).getQuestionnaireID();
//		for(int j=0;j<questionName.length;j++) {
//			Question question =new Question();
//			question.setQuestionnaireID(questionnaireID);
//			question.setQuestionType(questionType[j]);
//			question.setQuestionName(questionName[j]);
//			questionService.insertQuestion(question);
//			int answerNameLength=questionName.length;
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		return new ModelAndView("");
//	}
	
	@RequestMapping("/deleteQuestionnaire")
	public ModelAndView deleteQuestionnaire(int questionnaireID) {
		if(questionnaireService.deleteQuestionnaire(questionnaireID)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}
	@RequestMapping("/updateQuestionnaire")
	public ModelAndView updateQuestionnaire(int questionnaireID,String questionnaireName) {
		Questionnaire questionnaire =new Questionnaire();
		questionnaire.setQuestionnaireID(questionnaireID);
		questionnaire.setQuestionnaireName(questionnaireName);
		if(questionnaireService.updateQuestionnaire(questionnaire)) {
			return new ModelAndView("");
		}
		return new ModelAndView("");
	}
	
	
	@RequestMapping("/insertQuestionnaire")
	public ModelAndView insertQuestionnaire(HttpSession session,String questionnaireName,String[] questionName,String[] answerName,int [] answerNameLength) {
		Questionnaire questionnaire =new Questionnaire();
		questionnaire.setQuestionnaireName(questionnaireName);
		questionnaireService.insertQuestionnaire(questionnaire);
		int questionnaireID= questionnaireService.getQuestionnaireByName(questionnaireName).getQuestionnaireID();
		int begin=0;
		int end=0;
		for(int i=0;i<questionName.length;i++) {
			int questionID=0;
			Question question =new Question();
			question.setQuestionnaireID(questionnaireID);
			question.setQuestionName(questionName[i]);
			questionService.insertQuestion(question);
			List<Question> tempQuestions=questionService.getAllQuestionByNaireID(questionnaireID);
			for(int j=0;j<tempQuestions.size();j++) {
				if(tempQuestions.get(j).getQuestionName().equals(questionName[i])) {
					questionID=tempQuestions.get(j).getQuestionID();				
				}
			}
			end=end+answerNameLength[i];
			for(int k=begin;k<end;k++) {
				Answer answer=new Answer();
				answer.setAnswerName(answerName[k]);
				answer.setQuestionID(questionID);
				answerService.insertAnswer(answer);
			}
			begin=begin+answerNameLength[i];
		}
		return new ModelAndView("questionnaire");
	}
	
	@RequestMapping("/testInsertQuestionnaire")
	public void testInsertQuestionnaire(HttpSession session,String questionnaireName,String[] questionName,String[] answerName,int [] answerNameLength) {
		int begin=0;
		int end=0;
		System.out.println(questionnaireName);
		for(int i=0;i<questionName.length;i++) {
			System.out.println(questionName[i]);
			end=end+answerNameLength[i];
			for(int k=begin;k<end;k++) {
				System.out.println(answerName[k]);
			}
			begin=begin+answerNameLength[i];
		}
		
	}
	@RequestMapping("/testArr")
	public void testArr(String[] questionName) {
		for(int i=0;i<questionName.length;i++) {
			
		System.out.println(questionName[i]);
		}
	}
	
	@RequestMapping("/goToUserQuestionnaire")
	public ModelAndView goToUserQuestionnaire() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Questionnaire> questionnaires =questionnaireService.getAllQuestionnaire();
		model.put("questionnaires", questionnaires);
		return new ModelAndView("userQuestionnaire",model);
	}
	@RequestMapping("/tianXieUserQuestionnaire")
	public ModelAndView tianXieUserQuestionnaire(int questionnaireID) {
		Map<String, Object> model = new HashMap<String, Object>();
		Questionnaire questionnaire=questionnaireService.getQuestionnaireByID(questionnaireID);
		List<Question> questions=questionService.getAllQuestionByNaireID(questionnaireID);
		for(int i=0;i<questions.size();i++) {
			List<Answer> answers = new ArrayList<>();
			List<Answer> answers2 =answerService.getAllAnswerByQuestionID(questions.get(i).getQuestionID());
			for(int j=0;j<answers2.size();j++) {
				answers.add(answers2.get(j));
			}
			questions.get(i).setAnswers(answers);
		}
		model.put("questions", questions);
		model.put("questionnaire", questionnaire);
		return new ModelAndView("tianXieUserQuestionnaire",model);
	}
	@RequestMapping("/finishUserQuestionnaire")
	public String finishUserQuestionnaire(HttpSession session,String []answerID,String questionnaireName) {
		for(int i=0;i<answerID.length;i++) {
			Answer answer=new Answer();
			answer.setAnswerID(Integer.valueOf(answerID[i]));
			answerService.updateAnswer(answer);
		}
		QA qa=new QA();
		qa.setQAName(questionnaireName);
		qa.setQAPersonName((String)session.getAttribute("username"));
		qaService.insertQuestion(qa);
		return "forward:/goToUserIndex.do";
	}

	@RequestMapping("goToQuestionnaire")
	public ModelAndView goToQuestionnaire() {
		return new ModelAndView("questionnaire");
	}
	@RequestMapping("goToQuestionnaireList")
	public ModelAndView goToQuestionnaireList() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Questionnaire> questionnaires =questionnaireService.getAllQuestionnaire();
		for(int i=0;i<questionnaires.size();i++) {
			List<Question> questions=new ArrayList<>();
			List<Question> questions2=questionService.getAllQuestionByNaireID(questionnaires.get(i).getQuestionnaireID());
			for(int j=0;j<questions2.size();j++) {
				questions.add(questions2.get(j));
				List<Answer> answers=new ArrayList<>();
				List<Answer>answers2 =answerService.getAllAnswerByQuestionID(questions2.get(j).getQuestionID());
				for(int k=0;k<answers2.size();k++) {
					answers.add(answers2.get(k));
				}
				questionnaires.get(i).setAnswers(answers);
				questions.get(j).setAnswers(answers);
			}
			questionnaires.get(i).setQuestions(questions);
		}
		model.put("questionnaires", questionnaires);
		return new ModelAndView("questionnaireList",model);
	}
	
	@RequestMapping("goToTongji")
	public ModelAndView goToTongji() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<QA> qas =qaService.getAllQA();
		model.put("qas", qas);
		return new ModelAndView("tongji",model);
	}
	
}
