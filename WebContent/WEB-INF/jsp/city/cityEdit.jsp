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
$(document).ready(function() {
	// 默认初始化
// 	$("#openFlag").comboBox();
// 	var openFlag = "${city.openFlag}";
// 	// 修改页面 填充状态指定项   
// 	if(openFlag){
// 		$("#openFlag").comboBox('select',openFlag);
// 	}
})
//保存
function save(){
	$('#remark').valid({len : 50});
	if($.valid()){
		var urlAddress = "cityController/updateCity";
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
 			<input type="hidden" id="hidId" name="id" value="${city.id}">
 			<div class="form-group">
 				<label for="cityId" class="col-sm-3 col-xs-3 control-label">城市区号</label>
				<div class="col-sm-8 col-xs-8">
					<input id="cityId" value="${city.cityId}" class="form-control" type="text" disabled="disabled"/>
				</div>
			</div>
			<div class="form-group">
				<label for="cityName" class="col-sm-3 col-xs-3 control-label">城市名称</label>
				<div class="col-sm-8 col-xs-8">
					<input id="cityName" value="${city.cityName}" class="form-control" type="text" disabled="disabled"/>
				</div>
			</div>
			<div class="form-group">
				<label for="districtId" class="col-sm-3 col-xs-3 control-label">城市编码</label>
				<div class="col-sm-8 col-xs-8">
					<input id="districtId" value="${city.districtId}" class="form-control" type="text" disabled="disabled"/>
				</div>
			</div>
			<div class="form-group">
				<label for="parentDistrictId" class="col-sm-3 col-xs-3 control-label">上级城市编码</label>
				<div class="col-sm-8 col-xs-8">
					<input id="parentDistrictId" value="${city.parentDistrictId}" class="form-control" type="text" disabled="disabled"/>
				</div>
			</div>
			<div class="form-group">
				<label for="cityLevel" class="col-sm-3 col-xs-3 control-label">城市级别</label>
				<div class="col-sm-8 col-xs-8">
					<input id="cityLevel" value="${city.cityLevel}" class="form-control" type="text" disabled="disabled"/>
				</div>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="openFlag" class="col-sm-3 col-xs-3 control-label">开通标识</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<!-- 					<select class="form-control" id="openFlag" name="openFlag"> -->
<!-- 						<option value="" selected="selected"></option> -->
<!-- 						<option value="0">未开通</option> -->
<!-- 						<option value="1">已开通</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="form-group">
				<label for="remark" class="col-sm-3 col-xs-3 control-label">备注</label>
				<div class="col-sm-8 col-xs-8">
					<input id="remark" value="${city.remark}" name="remark" class="form-control" type="text" />
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