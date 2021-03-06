<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${rootPath}/common/resource/H-ui.admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}/common/resource/H-ui.admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" 	href="${rootPath}/common/resource/H-ui.admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}/common/resource/H-ui.admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${rootPath}/common/resource/H-ui.admin/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${rootPath }/common/resource/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${rootPath }/common/resource/util.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${rootPath }/common/resource/H-ui.admin/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
	$(function() {
		/*$("#min_title_list li").contextMenu('Huiadminmenu', {
			bindings: {
				'closethis': function(t) {
					console.log(t);
					if(t.find("i")){
						t.find("i").trigger("click");
					}		
				},
				'closeall': function(t) {
					alert('Trigger was '+t.id+'\nAction was Email');
				},
			}
		});*/
	});
	/*个人信息*/
	function myselfinfo() {
		layer.open({
			type : 1,
			area : [ '300px', '200px' ],
			fix : false, //不固定
			maxmin : true,
			shade : 0.4,
			title : '查看信息',
			content : '<div>管理员信息</div>'
		});
	}

	/*资讯-添加*/
	function article_add(title, url) {
		var index = layer.open({
			type : 2,
			title : title,
			content : url
		});
		layer.full(index);
	}
	/*图片-添加*/
	function picture_add(title, url) {
		var index = layer.open({
			type : 2,
			title : title,
			content : url
		});
		layer.full(index);
	}
	/*产品-添加*/
	function product_add(title, url) {
		var index = layer.open({
			type : 2,
			title : title,
			content : url
		});
		layer.full(index);
	}
	/*用户-添加*/
	function member_add(title, url, w, h) {
		layer_show(title, url, w, h);
	}
</script>

<!--此乃百度统计代码，请自行删除-->
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
<!--/此乃百度统计代码，请自行删除-->