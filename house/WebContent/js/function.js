var isIE = !!document.all;
//Selector
/*function bindSelector()
{
	for(var i=0; i<arguments.length; i++) {
		document.getElementById(arguments[i]).onmouseover = function(){
			this.getElementsByTagName("ul")[0].style.display = "block";
		};
		document.getElementById(arguments[i]).onmouseout = function(){
			this.getElementsByTagName("ul")[0].style.display = "none";
		};
	}
}*/

function getStyle(el, name)
{
	return isIE ? el.currentStyle[name] : window.getComputedStyle(el, null)[name];
}

/**
 *	分页
 */
var curPage = $('#index').attr('value');
var totalPageCount = $(":input[name='page.totalPage']").val();
function firstPage(){
    document.searchForm.index.value="0";//将当前页设定成首页
  //提交manage.jsp的form表单 也就是提交house_list.jsp和search_list.jsp中的请求数据 (分页和组合查询的参数信息)	
    document.searchForm.submit();
}
function lastPage(){
	document.searchForm.index.value=totalPage;
	document.searchForm.submit();
}		
function previousPage(){
	if(curPage > 0){
		document.searchForm.index.value=parseInt(curPage)-1;
	}
	document.searchForm.submit();
}
function nextPage(){
	if(parseInt(curPage) < parseInt(totalPage)){
		document.searchForm.index.value=parseInt(curPage)+1;
	}
	document.searchForm.submit();
	
}
function clickPage(pageIndex){
	if(parseInt(pageIndex)>0 && parseInt(pageIndex) <= parseInt(totalPage)){
		$('#index').attr('value',index);
		document.searchForm.submit();
	}
}
document.searchForm.onsubmit=function goPage(){
	if(parseInt(totalPage)>0){
	    var p = parseInt(document.searchForm.index.value);
	    if(isNaN(p) || p<1 || p>totalPage){
	        alert("请输入正确的页码 ！");
	        return false;
	    }else{
            document.searchForm.index.value=p;
    	}
    }else{
    	return false;
    }
};
