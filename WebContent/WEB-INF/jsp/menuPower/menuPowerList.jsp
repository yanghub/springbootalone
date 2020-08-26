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
<title>权限查询</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		$.widget.init();	
		$('#powerType').comboBox();
		
		// 根据用户权限确定是否展示按钮
		initToolBarByFuncPower(toolbar,"${funcPowers}");
		//查询按钮权限
		btnPower($("#btnSearch"),"${condPowers}");
		
		$('#table').datagrid({
			url : 'menuPowerController/selectMenuPowerList',//查询数据的地址
			form : 'selectform',//用于筛选的form id
			//字段
			columns : [
				{field : 'menuId',title : '菜单代码',width : 90,sortable : true},
				{field : 'menuName',title : '菜单名称',width : 140,sortable : true},
				{field : 'powerType',title : '权限类型',width : 140,sortable : true,formatter:function(val,row,index){
					if(val == '01'){
						return '用户';
					}else if(val == '00'){
						return '角色';
					}else{
						return val
					}
				}},
				{field : 'powerId',title : '权限名称',width : 140,sortable : true},
				{field : 'createBy',title : '创建人',width : 90,sortable : true},
				{field : 'createDate',title : '创建时间',width : 90,sortable : true},
				{field : 'updateBy',title : '修改人',width : 90,sortable : true},
				{field : 'updateDate',title : '修改时间',width : 90,sortable : true}
			],
			singleSelect : false,//是否单行选中-默认false
			//pageSize : 10//分页，每页查询数量-默认10
		});
		
		loadComboBox($('#menuPid'), 'SEARCH_ALL_MENU');
		
		// 级联操作二级菜单
		$("#menuPid").comboBox({
			onChange: function (n,o) {
				// 第一次加载一级菜单时 二级菜单不加载   
				if(o!=''){
					// 以后每次一级菜单改变时 二级菜单级联更新
					loadComboBoxByPara($('#menuId'),'SEARCH_ALL_MENU',n);
				}else{
					loadComboBoxByPara($('#menuId'),'SEARCH_ALL_MENU','000');
				}
			}
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
			<span class="title">权限查询</span>
		</div>
		<div class="widget-body">
			<div class="widget-control">
				<form id="selectform" class="widget-form" method="post">
					<div class="widget-screen">
						<label for="menuKeyword" class="control-label">菜单名称</label>
						<div class="widget-item">
							<input class="form-control" id="menuKeyword" name="menuKeyword" type="text" placeholder="可按菜单名称模糊查询">
						</div>
					</div>
					<div class="widget-screen">
						<label for="menuPid" class="control-label">一级菜单</label>
						<div class="widget-item">
							<input class="form-control" id="menuPid" name="menuPid" type="text">
						</div>
					</div>
					<div class="widget-screen">
						<label for="menuId" class="control-label">二级菜单</label>
						<div class="widget-item">
							<input class="form-control" id="menuId" name="menuId" type="text">
						</div>
					</div>
					<div class="widget-screen">
						<label for="powerId" class="control-label">权限名称</label>
						<div class="widget-item">
							<input class="form-control" id="powerId" name="powerId" type="text" placeholder="可按权限名称模糊查询">
						</div>
					</div>					
					<div class="widget-screen">
						<label for="powerType" class="control-label">权限类型</label>
						<div class="widget-item">
							<select class="form-control" id="powerType" name="powerType" >
								<option selected="selected" value="000">所有</option>
								<option value="00">角色</option>
								<option value="01">用户</option>
							</select>
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