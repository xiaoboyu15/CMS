package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Admin;
import mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;

	public List<Admin> loginInAdmin() {
		return adminMapper.loginInAdmin();
	}
}
