package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Questionnaire;
import service.QuestionnaireService;

@Controller
public class QuestionnaireAction {
	@Autowired
	private QuestionnaireService questionnaireService;
	
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
	
	@RequestMapping("/deleteQuestionnaire")
	public ModelAndView deleteQuestionnaire(int questionnaireID) {
		if(questionnaireService.deleteQuestionnaire(questionnaireID)) {
			System.out.println("主表数据删除成功");
			return new ModelAndView("");
		}
		System.out.println("主表数据删除失败");
		return new ModelAndView("");
	}
	
	@RequestMapping("/deleteQuestionnaireChild")
	public void deleteQuestionnaireChild(String questionnaireName) {
		Questionnaire questionnaire=new Questionnaire();
		questionnaire.setQuestionnaireName(questionnaireName);
		if(questionnaireService.deleteQuestionnaireChild(questionnaire)) {
			System.out.println("删除子表成功");
		}
		System.out.println("删除子表失败");
	}
	
	
	//动态建表，测试完成
	@RequestMapping("/updateQuestionnaire")
	public void updateQuestionnaire(String questionnaireName,String question[],String answer[],int num[]) {
		ArrayList<String>  strArray = new ArrayList<String> ();
		Questionnaire questionnaire=new Questionnaire();
		int index=0;
		for(int i=0;i<question.length;i++) {
			strArray.add(question[i]);
			for(int j=0;j<num[i];j++) {
				System.out.println(answer[index]);
				strArray.add(answer[index]);
				index++;
			}
		}
		questionnaire.setQuestionnaireName(questionnaireName);
		questionnaire.setQA(strArray);
		questionnaireService.updateQuestionnaire(questionnaire);
		questionnaireService.insertChild(questionnaire);
		questionnaireService.insertQuestionnaire(questionnaire);
	}
}
