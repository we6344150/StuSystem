package cn.bdqn.house.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.bdqn.house.entity.HouseUser;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*String actionName=invocation.getProxy().getActionName();//通过代理获得拦截名
		if("loginXxx".equals(actionName)){
			return invocation.invoke();
		}else{
			//1.判断用户是否登录，查找session中是否有user对象
			Map<String, Object> session=invocation.getInvocationContext().getSession();
			HouseUser user=(HouseUser)session.get("user");
			
			if(null!=user){
				//2.如果存在，拦截器放开请求让其通过，
			//	invocation.invoke();//相当于放过请求
				return invocation.invoke();
			}else{
				//3.否则拦截使之回到登录页面
				return "manage";
			}
			
		}*/
		return invocation.invoke();
	}

}
