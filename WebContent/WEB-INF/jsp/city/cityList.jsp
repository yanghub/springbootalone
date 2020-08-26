<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.framework.util.ManageConstants"%>
<%
String basePath = (String)request.getServletContext().getAttribute(ManageConstants.BASE_PATH);
String staticPath = (String)request.getServletContext().getAttribute(ManageConstants.STATIC_PATH);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>城市管理</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		//页面加载
		$.widget.init();	
		loadComboBox($('#parentDistrictId'), "SEARCH_ALL_PROVINCE");  
		$('#cityLevel').comboBox();

		var toolbar = [
			{text : '修改',validCount : '1',handler : function(rows){
				modal.open({title:'修改城市信息',url:'cityController/openEditPage?cityKey='+rows[0].id})
			}},
		]
		
		// 根据用户权限确定是否展示按钮
		initToolBarByFuncPower(toolbar,"${funcPowers}");
		//查询按钮权限
		btnPower($("#btnSearch"),"${condPowers}");
		
		$('#table').datagrid({
			url : 'cityController/selectCityList',//查询数据的地址
			form : 'selectform',//用于筛选的form id
			//字段
			columns : [
				{field : 'id',title : '编号',width : 80,hidden:true},
				{field : 'cityId',title : '城市区号',width : 90},
				{field : 'cityName',title : '城市名称',width : 90},
				{field : 'districtId',title : '城市编码',width : 90},
				{field : 'parentDistrictId',title : '上级城市编码',width : 80},
				{field : 'cityLevel',title : '城市级别',width : 90},
// 				{field : 'openFlag',title : '开通标识',width : 90},
				{field : 'remark',title : '备注',width : 80},
				{field : 'updateBy',title : '修改人',width : 80},
				{field : 'updateDate',title : '修改时间',width : 90}
			],
			//按钮功能栏
			toolbar : toolbar,
			singleSelect : false//是否单行选中-默认false
		});
	});
	// 加载 datagrid 填充数据 
	function loadData(){
		$('#table').datagrid('load');
	}
	
	function searchData(){
		//点击查询会有倒计时三秒之内不让再查询
 		var status = setButttonDisable3Secound();
		if(status == "false"){
			return;
		}
		loadData();
	}
	function  exportExcel(){
		var queryCondition = getQueryCondition();
		$('#queryCondition').val(queryCondition);
		$.ajax({
			type : "POST",
			url : "cityController/exportList",
			data : $('#selectform').serialize(),
			datatype : "json",
			success : function(data) {
				var obj = eval("(" + data + ")");
				if (obj.result == "nolist") {					
					alertify.error("没有符合条件的数据!");
				} else if(obj.result == "sizeExcess") {						
					alertify.error("导出数量超出，请重新选择!");
				} else if(obj.result == "success"){ 
					alertify.success("导出已成功，请到右上角【导出一览表】查询");
				} else if(obj.result == "failure"){ 
					alertify.success("导出失败，请重试！");
				}
			}
		}); 
	}	
</script>

</head>
<body>
	<div class="widget">
		<div class="widget-header">
			<span class="title">城市管理</span>
		</div>
		<div class="widget-body">
			<div class="widget-control">
				<form id="selectform" class="widget-form" method="post">
					<div class="widget-screen">
						<label for="parentDistrictId" class="control-label">省份</label>
						<div class="widget-item">
							<input class="form-control" id="parentDistrictId" name="parentDistrictId" type="text" >
						</div>
					</div>
					<div class="widget-screen">
						<label for="cityLevel" class="control-label">城市级别</label>
						<div class="widget-item">
							<select class="form-control" id="cityLevel" name="cityLevel">
								<option value="000" selected>所有</option>
								<option value="0">省</option>
								<option value="1">市</option>
								<option value="2">区</option>
								<option value="6">直辖市</option>
							</select>
						</div>
					</div>
					<div class="widget-screen">
						<label for="cityName" class="control-label">城市名称</label>
						<div class="widget-item">
							<input class="form-control" id="cityName" name="cityName" type="text" placeholder="可按城市名称模糊查询">
						</div>
					</div>
					<div class="widget-screen">
						<label for="cityId" class="control-label">城市区号</label>
						<div class="widget-item">
							<input class="form-control" id="textbox" name="cityId" type="text" placeholder="可按城市区号模糊查询">
						</div>
					</div>					
					<div class="widget-screen">
						<label for="districtId" class="control-label">城市编码</label>
						<div class="widget-item">
							<input class="form-control" id="textbox" name="districtId" type="text" placeholder="可按城市编码模糊查询">
						</div>
					</div>
					<button id="btnSearch" class="btn btn-primary btn-sm" onclick="searchData()" type="button">查 询</button>
					<button class="btn btn-primary btn-sm" onclick="exportExcel()" type="button">导出</button>					
				</form>
			</div>
			<!-- 数据表格 -->
			<div id="table"></div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>