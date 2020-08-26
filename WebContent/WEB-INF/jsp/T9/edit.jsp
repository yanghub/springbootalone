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
<title>编辑</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function() {
	$('#ttt').dateBox();
})
//保存
function save(){
	if($.valid()){
		var urlAddress = "T9Controller/update";
		if($('#hidId').val()==""){//新增
			urlAddress = "T9Controller/insert";
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
			<input type="hidden" id="hidId" name="id" value="${entity.id}">
			<div class="form-group">
				<label for="aaa" class="col-sm-3 col-xs-3 control-label">服饰编号</label>
				<div class="col-sm-8 col-xs-8">
					<input id="aaa" value="${entity.aaa}" name="aaa" class="form-control" type="text"/>
				</div>
			</div>
			<div class="form-group">
				<label for="bbb" class="col-sm-3 col-xs-3 control-label">服饰名称</label>
				<div class="col-sm-8 col-xs-8">
					<input id="bbb" value="${entity.bbb}" name="bbb" class="form-control" type="text"/>
				</div>
			</div>
			<div class="form-group">
				<label for="ccc" class="col-sm-3 col-xs-3 control-label">服装风格</label>
				<div class="col-sm-8 col-xs-8">
					<input id="ccc" value="${entity.ccc}" name="ccc" class="form-control" type="text"/>
				</div>
			</div>
			<div class="form-group">
				<label for="ddd" class="col-sm-3 col-xs-3 control-label">图片链接</label>
				<div class="col-sm-8 col-xs-8">
					<input id="ddd" value="${entity.ddd}" name="ddd" class="form-control" type="text"/>
				</div>
			</div>
			<div class="form-group">
				<label for="eee" class="col-sm-3 col-xs-3 control-label">联系电话</label>
				<div class="col-sm-8 col-xs-8">
					<input id="eee" value="${entity.eee}" name="eee" class="form-control" type="text"/>
				</div>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="fff" class="col-sm-3 col-xs-3 control-label">t06</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="fff" value="${entity.fff}" name="fff" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="ggg" class="col-sm-3 col-xs-3 control-label">t07</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="ggg" value="${entity.ggg}" name="ggg" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="hhh" class="col-sm-3 col-xs-3 control-label">t08</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="hhh" value="${entity.hhh}" name="hhh" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="iii" class="col-sm-3 col-xs-3 control-label">t09</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="iii" value="${entity.iii}" name="iii" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="jjj" class="col-sm-3 col-xs-3 control-label">t10</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="jjj" value="${entity.jjj}" name="jjj" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="kkk" class="col-sm-3 col-xs-3 control-label">t11</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="kkk" value="${entity.kkk}" name="kkk" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="lll" class="col-sm-3 col-xs-3 control-label">t12</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="lll" value="${entity.lll}" name="lll" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="mmm" class="col-sm-3 col-xs-3 control-label">t13</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="mmm" value="${entity.mmm}" name="mmm" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="nnn" class="col-sm-3 col-xs-3 control-label">t14</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="nnn" value="${entity.nnn}" name="nnn" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="ooo" class="col-sm-3 col-xs-3 control-label">t15</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="ooo" value="${entity.ooo}" name="ooo" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="ppp" class="col-sm-3 col-xs-3 control-label">t16</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="ppp" value="${entity.ppp}" name="ppp" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="qqq" class="col-sm-3 col-xs-3 control-label">t17</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="qqq" value="${entity.qqq}" name="qqq" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="rrr" class="col-sm-3 col-xs-3 control-label">t18</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="rrr" value="${entity.rrr}" name="rrr" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="sss" class="col-sm-3 col-xs-3 control-label">t19</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="sss" value="${entity.sss}" name="sss" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="ttt" class="col-sm-3 col-xs-3 control-label">t20</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="ttt" readonly value="${entity.ttt}" name="ttt" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="uuu" class="col-sm-3 col-xs-3 control-label">t21</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="uuu" value="${entity.uuu}" name="uuu" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="vvv" class="col-sm-3 col-xs-3 control-label">t22</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="vvv" value="${entity.vvv}" name="vvv" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="www" class="col-sm-3 col-xs-3 control-label">t23</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<%-- 					<input id="www" value="${entity.www}" name="www" class="form-control" type="text"/> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="xxx" class="col-sm-3 col-xs-3 control-label">t24</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<!-- 					<select class="form-control" id="xxx" name="xxx"> -->
<!-- 						<option selected="selected" value="000">请选择</option> -->
<!-- 						<option value="111">111</option> -->
<!-- 						<option value="222">222</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="yyy" class="col-sm-3 col-xs-3 control-label">t25</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<!-- 					<select class="form-control" id="yyy" name="yyy"> -->
<!-- 						<option selected="selected" value="000">请选择</option> -->
<!-- 						<option value="111">111</option> -->
<!-- 						<option value="222">222</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="zzz" class="col-sm-3 col-xs-3 control-label">t26</label> -->
<!-- 				<div class="col-sm-8 col-xs-8"> -->
<!-- 					<select class="form-control" id="zzz" name="zzz"> -->
<!-- 						<option selected="selected" value="000">请选择</option> -->
<!-- 						<option value="111">111</option> -->
<!-- 						<option value="222">222</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</form>
	</div>
	<div class="modal-footer">
		<button class="btn btn-success" type="button" onclick="save()"><i class="fa fa-check-circle"></i> 保 存</button>
		<button class="btn btn-danger" type="button" onclick="parent.modal.close()"><i class="fa fa-times-circle"></i> 取 消</button>
	</div>
</body>
</html>