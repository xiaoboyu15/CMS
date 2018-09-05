package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.LoginWater;
import mapper.LoginWaterMapper;

@Service
public class LoginWaterService {
	@Autowired
	private LoginWaterMapper loginWaterMapper;

	public List<LoginWater> getLoginWater() {
		return loginWaterMapper.getLoginWater();
	}
	public LoginWater getLoginWaterByNT(LoginWater loginWater){
		return loginWaterMapper.getLoginWaterByNT(loginWater);
	}
	public boolean insertLogin(LoginWater loginWater) {
		return loginWaterMapper.insertLogin(loginWater);
	}
	public boolean removeWater() {
		return loginWaterMapper.removeWater();
	}
}
