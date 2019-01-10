

$(function(){
	var loginId = $("#loginId").val();
	if(loginId==1){
		return false;
	}
	var opertionIds1 = $("#opertionIds1").val();//财务权限
	var op1_array = "";
	if(opertionIds1!=undefined && opertionIds1!=null && opertionIds1!=""){
		op1_array = opertionIds1.split(",");
	}
	
	var opertionIds2 = $("#opertionIds2").val();//普通权限
	var op2_array = "";
	if(opertionIds2!=undefined && opertionIds2!=null && opertionIds2!=""){
		op2_array = opertionIds2.split(",");
	}
	
	var ifYanFinance = $("#ifYanFinance").val();//是否首次使用财务
	var ifYanHr = $("#ifYanHr").val();//是否首次使用人力
	
	//普通权限
	var map = {};
	if(op2_array!=""){
		
		for (var mt = 0; mt < op2_array.length; mt++) {
			var op2 = op2_array[mt];
			map[op2] = op2;
		}
	}
	
	$(":lang(onememu)").each(function(){
		
		var id = $(this).attr("id");
		if(id!=undefined){
			if(id==0 && loginId==1){//这个权限只有管理员才能看
				$(this).show();
			}
			var dir = $(this).attr("dir");
			
			if(dir==undefined){//dir属性为undfined是为普通权限
				var vv = map[id];
				if(vv==undefined){
					$(this).hide();
				}else{
					$(this).show();
				}
			}
		}
	});
	
	//特殊权限
	var mapspecail = {};
	if(op1_array!=""){
		
		for (var mt = 0; mt < op1_array.length; mt++) {
			var op = op1_array[mt];
			mapspecail[op] = op;
		}
	}
	
	$(":lang(onememu)").each(function(){
		
		var id = $(this).attr("id");
		if(id!=undefined){
			var dir = $(this).attr("dir");
			
			if(dir!=undefined){//dir属性不为undfined是为特殊权限
				var vv = mapspecail[id];
				
				if(vv==undefined){
					$(this).hide();
				}else{
					$(this).show();
				}
			}
		}
	});});


function showContent(url){
	$("#laContent").attr("src",url);
}

function showLefts(title){
	$(".layui-side-scroll").hide();
	$("#"+title).show();
}

function showLeft(title,ptype){
	var loginId = $("#loginId").val();
	if(loginId==1){//管理员直接显示，无需验证
		$(".layui-side-scroll").hide();
		$("#"+title).show();
	}else{
		
		if(ptype!=0){//是需要验证的功能  1:人事功能
			$(".layui-side-scroll").hide();
			$("#pub").show();
			layui.use(['table','layer'], function () {
				var layer=layui.layer;
				layer.open({
					type: 2,
					area: ['40%', '40%'],
					content: '/login/showYanz.do?type='+ptype+"&title="+title
				});
			});
		}else{
			$(".layui-side-scroll").hide();
			$("#"+title).show();
		}
	}
}

 