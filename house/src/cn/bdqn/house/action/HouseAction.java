package cn.bdqn.house.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HousePicture;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.service.HouseService;
import cn.bdqn.house.util.PageBean;

public class HouseAction extends ActionSupport {
	// 属性驱动
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
	private File pic;
	private String picContentType;
	private String picFileName;
	// private uploadFile uploadFile;
	private HousePicture picture;
	public List<HouseType> getTypeList() {
		return typeList;
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


	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public HousePicture getPicture() {
		return picture;
	}

	public void setPicture(HousePicture picture) {
		this.picture = picture;
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

	// 分页查询方法
	public String findByPage() {

		PageBean<House> pageBean = houseService.findByPage(querycondition, pageIndex, pageSize);
		// List<House> houseList=houseService.getList(querycondition, pageIndex,
		// pageSize);
		// 压栈
		// ValueStack vs=ActionContext.getContext().getValueStack();
		// 栈顶是map<"page",pageBean>对象
		// vs.set("page", pageBean);
		// vs.set("houseList", houseList);
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		page = pageBean;
		session.put("page", pageBean);
		// session.put("houseList", houseList);
		return "manage";
	}

	// 发布房屋信息，获得各种下拉列表
	public void getSelect() {
		typeList = houseService.findHouseType();// 获取房屋类型集合
		disList = houseService.findDistrict();// 获取房屋所在区域集合

		
		 /* for (int i = 0; i < disList.size(); i++) {// 遍历城区集合
			  District dis =disList.get(i);// 获取城区集合的每一条记录  
		  if (dis.getStreets()!= null && dis.getStreets().size() > 0) { // 获取该城区所定义的街道，并将这些对应的街道放入list集合
				  List<Street> streetlist =
				  houseService.findStreetListByDisId(dis.getId());
				  streetMap.put(dis.getId(), streetlist);
				 
				   } 
		  }*/
				 
	}

	public String addHouse() {
		getSelect();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("typeList", typeList);
		session.put("disList", disList);
		// session.put("streetMap", streetMap);

		return "add";
	}

	public String doAddHouse() throws IOException {
		String destPath = ServletActionContext.getServletContext().getRealPath("/");
		destPath = destPath + "upload" + File.separatorChar + picFileName;// 路径+添加的upload文件夹+文件正反分隔符+文件名为全路径
		// System.out.println(destPath);
		File destFile = new File(destPath);
		FileUtils.copyFile(pic, destFile);// 源文件+拷到哪去
		
		getSelect();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("typeList", typeList);
		session.put("disList", disList);
		houseService.saveHouse(house);
		return "doAdd";
	}
	public String delete() {
		//serilizeble id 和传进的int id参数类型不匹配
		House gethouse=houseService.getHouseById(house.getId());
		//String filepath=gethouse.getPicture().getUrl();
		houseService.deleteHouse(gethouse);
		/*File file=new File(filepath);
		if(file.exists()) {
			file.delete();
		}*/
		return "delete";
	}
	public String initUpdate() {
		//模型默认压栈
		house=houseService.getHouseById(house.getId());
		String filepath=house.getPicture().getUrl();
		getSelect();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("typeList", typeList);
		session.put("disList", disList);
		return "initUpdate";
	}
	public String updateHouse() {
		if(picFileName!=null) {
			
		}
		return "updateHouse";
	}
}
