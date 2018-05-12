package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import cn.bdqn.house.dao.HouseUserDao;
import cn.bdqn.house.entity.HouseUser;
import cn.bdqn.house.service.HouseUserService;
import cn.bdqn.house.util.MD5Utils;
@Transactional(readOnly = false)
public class HouseUserServiceImpl implements HouseUserService {
	
	   private HouseUserDao userDao;
	 private HouseUser user;
	 
	

	public HouseUser getUser() {
		return user;
	}

	public void setUser(HouseUser user) {
		this.user = user;
	}

	public HouseUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(HouseUserDao userDao) {
		this.userDao = userDao;
	}

	

	public void saveHouseUser(HouseUser user) {
		
			userDao.save(user);
	
	}
     
	@Override
	public void updateHouseUser(HouseUser user) {
		
			userDao.update(user);
	
	}

	@Override
	public void deleteHouseUser(HouseUser user) {
		
			userDao.delete(user);
	
	}
  
	@Override
	public HouseUser getHouseUserById(Serializable id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}

	@Override
	public HouseUser getHouseUserByUserName(String userName) {
		return userDao.getByName(userName);
	}

	@Override
	public HouseUser getHouseUserFromListByUserName(String userName) {
		List<HouseUser> users=userDao.getList();
		for (HouseUser houseUser : users) {
			if(userName.equals(houseUser.getUsername())){
				return houseUser;
			}
		}
		return null;
	}

	@Override
	public List<HouseUser> getList() {
		// TODO Auto-generated method stub
		return userDao.getList();
	}

	@Override
	public void saveMd5(HouseUser user) {
         String pwd=user.getPassword();
         user.setPassword(MD5Utils.md5(pwd));
         user.setIsadmin("n");
         userDao.save(user);
	}

	
   
}
