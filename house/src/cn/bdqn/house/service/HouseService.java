package cn.bdqn.house.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.util.PageBean;

public interface HouseService {
	public void saveHouse(House house);
	public void updateHouse(House house);
	public void deleteHouse(House house);
	public House getHouseById(Serializable id);
	
	public List<House> getList();
	public List<House> getList(String querycondition,int pageIndex,int pageSize);
	public int getCount(String querycondition);
	public PageBean<House> findByPage(String querycondition,int pageIndex,int pageSize);
	public List<HouseType> findHouseType();
	public List<District> findDistrict();
	public List<Street> findStreetListByDisId(int disId);
}
