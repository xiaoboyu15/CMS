package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Answer;
import entity.Question;
import entity.Questionnaire;
import service.AnswerService;
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
		return new ModelAndView("");
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
}
