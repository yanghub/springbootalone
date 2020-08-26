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
<title>用户权限编辑</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<%=staticPath%>bin/plugin/ztree/bootstrapStyle.css" />
<script type="text/javascript" src="<%=staticPath%>bin/plugin/ztree/jquery.ztree.core.js" ></script>
<script type="text/javascript" src="<%=staticPath%>bin/plugin/ztree/jquery.ztree.excheck.js" ></script>
<script type="text/javascript" src="<%=staticPath%>bin/plugin/ztree/jquery.ztree.exedit.js" ></script>
<style>
	div.content_wrap {width: 600px;height:180px;}
	div.content_wrap div.left{float: left;width: 250px;}
	div.content_wrap div.right{float: right;width: 340px;}
	div.zTreeDemoBackground {width:200px;height:100%;text-align:left;}
	ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:370px;height:300px;overflow-y:scroll;overflow-x:auto;}
	ul.log {border: 1px solid #617775;background: #f0f6e4;width:300px;height:170px;overflow: hidden;}
	ul.log.small {height:45px;}
	ul.log li {color: #666666;list-style: none;padding-left: 10px;}
	ul.log li.dark {background-color: #E3E3E3;}
</style>
<script type="text/javascript">
	var treeObj = "";
	var editUserId = "${editUserId}";
	var editUserRoleId = "${editUserRoleId}";
	$(document).ready(function(){
		 // 初始化树形菜单
		treeObj = $.fn.zTree.init($("#userPowerTreeChange"), {
			view: {
				selectedMulti: false, 
				fontCss : setFontCss
			},
			check: {
				enable: true
			},
			async: {
				enable: true,
				url:'userController/listUserPowerByUserIdChange',
				// 初始化树形菜单 携带参数
				otherParam: ["editUserId", editUserId,"editUserRoleId",editUserRoleId]
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			edit: {
				enable: false
			}
		});
	});
	function setFontCss(treeId, treeNode) {
		return treeNode.roleFlag == 'true' ? {color:"red"} : {};
	};
	
	// 点击保存按钮 执行保存
	function save(){
		var nodes = treeObj.getCheckedNodes(true);
		var menuIds ='';
		var funcIds ='';
		if (nodes.length==0) { 
			parent.alertify.error('请选择一个权限',false);	
			return false;	
		}
		//增加去掉角色权限 拼接选中的一级菜单 二级菜单 和  功能存入个人权限
		for(var i = 0;i < nodes.length;i++){
			if((nodes[i].level=='0'||nodes[i].level=='1')&& nodes[i].roleFlag == 'false'){
				menuIds +=nodes[i].id+',';
			}else if(nodes[i].level=='2'&& nodes[i].roleFlag == 'false'){
				funcIds+=nodes[i].id+'-'+nodes[i].pId+',';
			}
		} 
		// 获取未选中的用户的角色功能权限
		var rolenodes = treeObj.getCheckedNodes(false);
		var roleMenuIds ='';
		var roleFuncIds ='';
		// 拼接未选中角色的一级菜单 二级菜单 和  功能存入typer_type=02
		for(var i = 0;i < rolenodes.length;i++){
			if((rolenodes[i].level=='0'||rolenodes[i].level=='1')&& rolenodes[i].roleFlag == 'true'){
				roleMenuIds +=rolenodes[i].id+',';
				//console.log(nodes[i].id+":0 and 1");
			}else if(rolenodes[i].level=='2'&& rolenodes[i].roleFlag == 'true'){
				roleFuncIds+=rolenodes[i].id+'-'+rolenodes[i].pId+',';
			}
		}
		
		// 修改用户角色权限
		$.ajax({
			type : "POST",
			url : "userController/updateUserPowerChange",
			data : {
				userId:editUserId,
				menuIds:menuIds,
				funcIds:funcIds,
				roleMenuIds:roleMenuIds,
				roleFuncIds:roleFuncIds
			},
			datatype : "json",
			success : function(data) {
				if(data>=0){
					parent.modal.close();
					parent.alertify.success('修改用户权限成功!');
				}else{
					parent.alertify.error('修改用户权限失败!');
				}
			} 
		}); 
	}
</script>
</head>
<body>
	<div class="modal-body">
		<form id="editForm" class="form-horizontal no-margin">
			<ul id="userPowerTreeChange" class="ztree"></ul>
		</form>
	</div>
	<div class="modal-footer">
		<button class="btn btn-success" type="button" onclick="save()"><i class="fa fa-check-circle"></i> 保 存</button>
		<button class="btn btn-danger" type="button" onclick="parent.modal.close()"><i class="fa fa-times-circle"></i> 取 消</button>
	</div>
</body>
</html>