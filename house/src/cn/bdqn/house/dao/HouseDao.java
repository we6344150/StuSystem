package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.Street;

public interface HouseDao {
	   public void save(House house);
	   public void update(House house);
	   public void delete(House house);
	   // 通过 id查询 持久化类中的对应 实例
	   public House getById(Serializable id);
	  
	  //查询所有用户列表
	   public List<House> getList();
	   public List<House> getList(String querycondition,int pageIndex,int pageSize);
	   public int getCount(String querycondition);
	   public List<HouseType> findHouseType();
	   public List<District> findDistrict();
	   public List<Street> findStreetListByDisId(int disId);
	   
}
