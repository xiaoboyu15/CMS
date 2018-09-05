package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Application;
import mapper.ApplicationMapper;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationMapper applicationMapper;
	
	public boolean  insertApplication(Application application) {
		return applicationMapper.insertApplication(application);
	}
	public List<Application> getAllApplication(){
		return applicationMapper.getAllApplication();
	}
	public boolean changeState(Application application) {
		return applicationMapper.changeState(application);
	}
	public Application getApplicationByID(int applicationID) {
		return applicationMapper.getApplicationByID(applicationID);
	}
}
