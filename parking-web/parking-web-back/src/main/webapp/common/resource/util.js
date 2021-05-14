/* js的全局变量,和el表达式木有关系到
 * el表达式是给tomcat看的,
 * js是给浏览器的看的
 *  /就像空格一样,可以多加,不能不加
 *  */
var rootPath = "/usercenter_20180108_model2/"; 

/*
	目的:是为了每点击一次,让验证码包含的img标签中的src刷新一次(让src不一样)
	img:它是html中的一部分,dom;
	
	js里面的dom;Jquery操作Dom;
	
	标签(节点,元素)三要素是:
		标签名
		属性
		开始标签和结束标签中间的内容
	src:是img的属性
	jquery:操作dom元素有三步走:
		通过合适的选择器找到元素
		获取三要素
		修改三要素
*/
function refreshCode(imgCode)
{
	/*
		${aaa}:El表达式,是给tomcat看的,只能写在JSP中
		$():Jquery代码;是给HTML浏览器看的
		
		如何让url不一样,本身的内容还不变
		
		new Date():是js里面的代码,和java不一样
	*/
	var codeUrl = rootPath + "/CommonServlet?method=code&now=" + new Date() ; 
	/* id:选择器 */
	console.info(imgCode + "====" + $("#" + imgCode).attr("src"));
	/* 把不一样的地址给了img标签 */
	$("#" + imgCode).attr("src",codeUrl)
	return false ; 
}


/**
	返回值:如果为false,事件阻止;
	~获取当前页的dom元素,为当前页的dom元素赋值;
	~获取每页多少条的dom元素,为每页多少条的dom元素赋值;
	~表单提交;
*/
function pageFormSubmit(formId,currentPageId,currentPageVal,pageSizeId,pageSizeVal)
{
	console.log("=====>" + $("#" + currentPageId).length);
	/* 获取当前页的dom元素,为当前页的dom元素赋值; */
	$("#" + currentPageId).prop("value",currentPageVal);
	$("#" + pageSizeId).prop("value",pageSizeVal);
	/* 通过js让表单提交
		通过Jquery里面的id选择器来做
	*/
	$("#" + formId).submit();
	return false ; 
}