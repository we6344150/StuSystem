package cn.bdqn.house.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bdqn.house.entity.HouseUser;
import cn.bdqn.house.service.HouseUserService;
import cn.bdqn.house.util.MD5Utils;

public class HouseUserAction extends ActionSupport {
	
	private HouseUserService userService;
    private HouseUser user;
    private String username;
    private String name;
    private String pw;
    
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	private String resultPage="";

	public String getResultPage() {
		return resultPage;
	}


	public void setResultPage(String resultPage) {
		this.resultPage = resultPage;
	}


	


	public HouseUserService getUserService() {
		return userService;
	}


	public void setUserService(HouseUserService userService) {
		this.userService = userService;
	}


	public HouseUser getUser() {
		return user;
	}


	public void setUser(HouseUser user) {
		this.user = user;
	}


	public String login() {
		HouseUser houseUser=userService.getHouseUserByUserName(user.getUsername());
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session=(Map<String, Object>)ac.getSession();
        if(null==houseUser) {
        	  session.put("msg", "用户名或密码错误");
        	  return INPUT;
        }else{
        	 String pwd=user.getPassword();
             user.setPassword(MD5Utils.md5(pwd));
			if(pwd.equals(houseUser.getPassword())){
				// Map<String, Object> request=(Map<String, Object>)ac.get("request");
				user=houseUser;
				session.put("user", houseUser);
				session.put("msg", "登录成功");
				return SUCCESS;
			}else{
				session.put("msg", "用户名或密码错误");
				  return INPUT;
			}
		}
      
	}
	public String loginAjax() {
		  HouseUser houseUser=userService.getHouseUserByUserName(name);
			 HttpServletResponse response= ServletActionContext.getResponse();
			 response.setContentType("text/html;charset=UTF-8");
			 try {
				PrintWriter writer=response.getWriter();
				if(houseUser==null) {
					writer.print("error");
				  }else {
					 
					if((MD5Utils.md5(pw)).equals(houseUser.getPassword())) {
						writer.print("pass");
					}else {
						writer.print("error");
					}
				  }
				writer.close();//这句话牛逼了值俩小时
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			   return INPUT;
		
		
	}
   public String register() {
	   HouseUser houseUser=userService.getHouseUserByUserName(user.getUsername());
	   ActionContext ac=ActionContext.getContext();
	   Map<String, Object> session=(Map<String, Object>)ac.getSession();
       if(null!=houseUser) {
    	  session.put("msg", "用户名重复");
     	  return INPUT;
		}else {
			userService.saveMd5(user);
			//userService.saveHouseUser(user);
			session.put("msg", "注册成功");
			return SUCCESS;
		}
   }
   //登录名判断登录名是否存在
   public String checkUserName() {
	  HouseUser houseUser=userService.getHouseUserByUserName(username);
	 HttpServletResponse response= ServletActionContext.getResponse();
	 response.setContentType("text/html;charset=UTF-8");
	 try {
		PrintWriter writer=response.getWriter();
		if(houseUser!=null) {
			writer.print("no");
		  }else {
			writer.print("yes");
		  }
		writer.close();//这句话牛逼了值俩小时
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   return INPUT;
   }
}
