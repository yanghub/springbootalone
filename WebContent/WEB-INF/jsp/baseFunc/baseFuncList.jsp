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
<title>功能管理</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		//初始化帮助信息
		$.widget.init();
		setHelpInfo($('#helpIcon'),"${helpInfoId}");//初始化帮助信息
		// 初始化功能按钮
		var toolbar= [
 			{text : '新增',validCount : '0+',handler : function(rows){
				modal.open({title:'新增功能管理',url:'baseFuncController/openEditPage'})
			}},
			{text : '修改',validCount : '1',handler : function(rows){
				modal.open({title:'修改功能管理',url:'baseFuncController/openEditPage?id='+rows[0].id})
			}},
			{text : '删除',validCount : '1+',handler : function(rows){
				alertify.confirm("确认删除吗?", function(e){if(e) {
					//取得删除菜单列表
					var deleteMenuList=rows[0].id;
					for(var i=1;i<rows.length;i++){
						deleteMenuList = deleteMenuList + "," + rows[i].id;
					}
					
					$.ajax({
						url: 'baseFuncController/deleteBaseFunc',
						type: 'post',//提交的方式
						dataType:'json',
						data: {ids:deleteMenuList},
						success: function(result) {
							if(result>=1){
								alertify.success("删除成功!");
								loadData();
							}
						}
					});
				}});
			}},
		]
		
		// 根据用户权限确定是否展示按钮
		initToolBarByFuncPower(toolbar,"${funcPowers}");
		//查询按钮权限
		btnPower($("#btnSearch"),"${condPowers}");
		
		$('#table').datagrid({
			url : 'baseFuncController/selectBaseFuncList',//查询数据的地址
			form : 'selectform',//用于筛选的form id
			//字段
			columns : [
				{field : 'funcId',title : '功能代码',width : 150,sortable : true,}, 
				{field : 'funcName',title : '功能名称',width : 150,sortable : true,},
				{field : 'createBy',title : '创建人',width : 150,sortable : true,},
				{field : 'createDate',title : '创建时间',width : 170,sortable : true,},
				{field : 'updateBy',title : '修改人',width : 150,sortable : true,},
				{field : 'updateDate',title : '修改时间',width : 170,sortable : true,}
			],
			//按钮功能栏
			toolbar : toolbar,
			singleSelect : false,//是否单行选中-默认false
			//pageSize : 10//分页，每页查询数量-默认10
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
</script>

</head>
<body>
 	<div class="widget">
		<div class="widget-header">
			<span class="title">功能管理</span>
			<img class="help-icon" id="helpIcon"/>
		</div>
		<div class="widget-body">
			<div class="widget-control">
				<form id="selectform" class="widget-form" method="post">
					<div class="widget-screen">
						<label for="funcId" class="control-label">功能代码</label>
						<div class="widget-item">
							<input class="form-control" id="funcId" name="funcId" type="text" placeholder="可按功能代码模糊查询">
						</div>
					</div>
					<div class="widget-screen">
						<label for="funcName" class="control-label">功能名称</label>
						<div class="widget-item">
							<input class="form-control" id="funcName" name="funcName" type="text" placeholder="可按功能名称模糊查询">
						</div>
					</div>					
					<button id="btnSearch" class="btn btn-primary btn-sm" onclick="searchData()" type="button">查 询</button>					
				</form>
			</div>
			<!-- 数据表格 -->
			<div id="table"></div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>