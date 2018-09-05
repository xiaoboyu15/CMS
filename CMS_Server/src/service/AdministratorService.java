package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Administrator;
import mapper.AdministratorMapper;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorMapper adminMapper;

	public List<Administrator> loginInAdmin() {
		return adminMapper.loginInAdmin();
	}
	public boolean insertAdmin(Administrator administrator) {
		return adminMapper.insertAdmin(administrator);
	}
}
