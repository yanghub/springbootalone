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
<title>功能管理编辑</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
//保存
function save(){
	$('#funcId').valid({notNull : true,len : 10});
	$('#funcName').valid({notNull : true,len : 10});	
	if($.valid()){
		var urlAddress = "baseFuncController/updateBaseFunc";
		if($('#hidId').val()==""){//新增
			urlAddress = "baseFuncController/insertBaseFunc";
		}
		//提交保存
		$("#editForm").ajaxSubmit({
			url:urlAddress,
			dataType:"json",
			success: function(data){
				if(data=='1'){
					parent.loadData();
					parent.modal.close()
					parent.alertify.success('操作成功!');
				}else{
					parent.alertify.error('操作失败!');
				}
				
			}
		})
	}
}
</script>
</head>
<body>
	<div class="modal-body">
		<form id="editForm" class="form-horizontal no-margin">
			<input type="hidden" id="hidId" name="id" value="${baseFunc.id}">
			<div class="form-group">
				<label for="funcId" class="col-sm-3 col-xs-3 control-label">功能代码</label>
				<div class="col-sm-8 col-xs-8">
					<input id="funcId" value="${baseFunc.funcId}" name="funcId" class="form-control" type="text" maxlength="10" placeholder="请输入建议长度为3的功能代码"/>
				</div>
			</div>
			<div class="form-group">
				<label for="funcName" class="col-sm-3 col-xs-3 control-label">功能名称</label>
				<div class="col-sm-8 col-xs-8">
					<input id="funcName" value="${baseFunc.funcName}" name="funcName" class="form-control" type="text" maxlength="10" placeholder="请输入功能名称"/>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button class="btn btn-success" type="button" onclick="save()"><i class="fa fa-check-circle"></i> 保 存</button>
		<button class="btn btn-danger" type="button" onclick="parent.modal.close()"><i class="fa fa-times-circle"></i> 取 消</button>
	</div>
</body>
</html>