package mapper;

import java.util.List;

import entity.QA;

public interface QAMapper {
	public List<QA> getAllQA();
	public List<QA> getAllQAByUserID(int UserID);
	public boolean insertQuestion(QA qa);
}
