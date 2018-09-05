package mapper;

import java.util.List;

import entity.LoginWater;

public interface LoginWaterMapper {

	public List<LoginWater> getLoginWater();
	public LoginWater getLoginWaterByNT(LoginWater loginWater);
	public boolean insertLogin(LoginWater loginWater);
	public boolean removeWater();
}
