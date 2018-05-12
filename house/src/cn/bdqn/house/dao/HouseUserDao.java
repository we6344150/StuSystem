package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.HouseUser;

public interface HouseUserDao {
   public void save(HouseUser user);
   public void update(HouseUser user);
   public void delete(HouseUser user);
   // 通过 id查询 持久化类中的对应 实例
   public HouseUser getById(Serializable id);
   public HouseUser getByName(String userName);
  //查询所有用户列表
   public List<HouseUser> getList();
}
