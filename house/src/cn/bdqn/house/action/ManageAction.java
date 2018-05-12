package cn.bdqn.house.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.service.HouseService;
import cn.bdqn.house.util.PageBean;

public class ManageAction extends ActionSupport {
	// 主页面
	private String querycondition;
	private Integer pageIndex = 1;
	// 每页显示数据条数
	private Integer pageSize = 4;
	private PageBean<House> page;
	private List<HouseType> typeList;
	private List<District> disList;
	private Map<Integer, List<Street>> streetMap;
	private House house;// 获取从页面接收的房屋信息数据
	private String price;// 用于接收页面参数信息 (房屋价格)
	private String floorage;// 用于接收页面参数信息 (房屋面积)
	private Integer districtId;// 用于接收页面参数信息 (城区id)
	private District district;
	public List<HouseType> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<HouseType> typeList) {
		this.typeList = typeList;
	}

	public List<District> getDisList() {
		return disList;
	}

	public void setDisList(List<District> disList) {
		this.disList = disList;
	}

	public Map<Integer, List<Street>> getStreetMap() {
		return streetMap;
	}

	public void setStreetMap(Map<Integer, List<Street>> streetMap) {
		this.streetMap = streetMap;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFloorage() {
		return floorage;
	}

	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public PageBean<House> getPage() {
		return page;
	}

	public void setPage(PageBean<House> page) {
		this.page = page;
	}

	public String getQuerycondition() {
		return querycondition;
	}

	public void setQuerycondition(String querycondition) {
		this.querycondition = querycondition;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		if (null == pageIndex) {
			pageIndex = 1;
		}
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	// spring注入业务逻辑对象
	private HouseService houseService;

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public void getSelect() {
		typeList = houseService.findHouseType();// 获取房屋类型集合
		disList = houseService.findDistrict();// 获取房屋所在区域集合

		/*
		  for (int i = 0; i < disList.size(); i++) {// 遍历城区集合
			  District dis =disList.get(i);// 获取城区集合的每一条记录  
				  List<Street> streetlist =
				  houseService.findStreetListByDisId(dis.getId());
				  streetMap.put(dis.getId(), streetlist);
		  }
				 */
	}
	
	public String manage() {
		PageBean<House> pageBean = houseService.findByPage(querycondition, pageIndex, pageSize);
		//List<House> houseList = houseService.getList(querycondition, pageIndex, pageSize);
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		page = pageBean;
		session.put("page", pageBean);
		getSelect();
		session.put("typeList", typeList);
		session.put("disList", disList);
		//session.put("streetMap", streetMap);
		return "manage";
	}
	

}
