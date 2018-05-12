package cn.bdqn.house.util;

import java.util.List;

public class PageBean<T> {
   private int pageIndex;//当前页
   private int pageSize;//每页显示记录数
   private int totalCount;//总记录数
   private int totalPage;//总页数
   private List<T> list;//每页显示数量
	private int[] numbers;// 要展示的分页序列 (展示的页数集合)
	
public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}


public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}


//获取总分页数
public int getTotalPage() {
	return totalPage;
}
//根据总记录数计算总页数
public void setTotalPage(int totalPage) {
	if(this.totalCount>0 && this.pageSize>0 && this.totalCount%this.pageSize==0){
		this.totalPage = this.totalCount/this.pageSize; 	
	}else if(this.totalCount>0 && this.pageSize>0 && this.totalCount%this.pageSize>0){
		this.totalPage = this.totalCount/this.pageSize+1;
	}else{
		this.totalPage = 0; 	
	}
	setNumbers(totalPage);//获取展示页数集合
}
public List<T> getList() {
	return list;
}
public void setList(List<T> list) {
	this.list = list;
}

//初始化分页展示序列
		public void setNumbers(int totalPage) {
			if(totalPage>0){
				/**totalCount>10?10:totalCount 判断 totalCount 是否大于10
               * 如果totalCount大于10，那么就叫totalCount=10
               * 如果totalCount小于10，那么就叫totalCount=totalCount； 
				 */
				int[]numbers=new int[totalPage>10?10:totalPage];//页面要显示的页数序列 (序列最大长度为10)
				int k=0;
				//使当前页处于展示序列的中间位置
/**比如  当前页为 10 我们希望展示的分页 序列为       6 7 8 9 10 <11> 12 13 14 15
* 比如  当前页为 15 我们希望展示的分页 序列为      10 11 12 13 14 <15> 16 17 18 19
* 从这两个例子可以看出 我们的序列的开始显示的分页数应为 ：   当前页的页数（index）-(序列长度÷2)
* 比如：当前页数位11：  11-（10÷2)=6  当前页数位15：   15-(10÷2)=10
* 另一个情况 如果 我们的总分页数位20页 ，我们的当前分页数为18，这时候再让当前分页在序列的中间就不行了
* 18-（10÷2）=13 如果序列从13 开始 ：13 14 15 16 17 18 19 20 21 22
* 序列 超出了 分页的总页数了 这时候 其实序列中的10个分页 应该为 11 12 13 14 15 16 17 18 19 20
* 那开始序列显示的分页数应为：总页数-显示的总序列数+1 
* 而这两个条件不用同时成立 只要成立一个 并保证 添加的元素不超过10个 页数就可以了
* 所以我们可以这么写 判断语句  
* if(i>=(index-(number.length/2+1)||i>=totalCount-number.length)&& k<number.length)
* number[k]=i+1;为什么是i+1呢？ 因为从前面的推论我们看出  我们这个判断语句都在刚才的推论中减去了1，所以要在这里加上1
*/
				for(int i=0;i<totalPage;i++){
					if((i>=pageIndex-(numbers.length/2+1) || i>=totalPage-numbers.length)&& k<numbers.length){
						numbers[k]=i+1;
						k++;
					}else if(k>=numbers.length){
						break;
					}
			   }
				this.numbers = numbers;
			}
		}
   
}
