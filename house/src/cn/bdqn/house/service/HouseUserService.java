package cn.bdqn.house.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.bdqn.house.entity.HouseUser;

public interface HouseUserService {
public void saveHouseUser(HouseUser user);
public void updateHouseUser(HouseUser user);
public void deleteHouseUser(HouseUser user);
public HouseUser getHouseUserById(Serializable id);
public HouseUser getHouseUserByUserName(String userName);
public HouseUser getHouseUserFromListByUserName(String userName);
public List<HouseUser> getList();
public void saveMd5(HouseUser user);
}
