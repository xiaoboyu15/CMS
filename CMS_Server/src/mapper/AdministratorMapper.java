package mapper;

import java.util.List;

import entity.Administrator;

public interface AdministratorMapper {
	public List<Administrator> loginInAdmin();
	public boolean insertAdmin(Administrator administrator);
}
