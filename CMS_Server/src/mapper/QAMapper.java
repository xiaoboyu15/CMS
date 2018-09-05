package mapper;

import java.util.List;

import entity.QA;

public interface QAMapper {
	public List<QA> getAllQA();
	public boolean insertQuestion(QA qa);
}
