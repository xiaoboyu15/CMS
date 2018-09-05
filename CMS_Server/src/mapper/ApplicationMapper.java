package mapper;

import java.util.List;

import entity.Application;

public interface ApplicationMapper {
	public boolean  insertApplication(Application application);
	public List<Application> getAllApplication();
	public boolean changeState(Application application);
	public Application getApplicationByID(int applicationID);
}
