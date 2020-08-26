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
<title>预约管理</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		//页面加载
		$.widget.init();
		$('.time').dateBox();
		//下拉框样式
// 		$("#searchFlag").comboBox();
		// 初始化功能按钮
		var toolbar = [
			{text : '预约模特',validCount : '0+',handler : function(rows){
				modal.open({title:'预约模特',url:'T8Controller/openEdit'})
			}},
			{text : '评价模特',validCount : '1',handler : function(rows){
				modal.open({title:'评价模特',url:'T8Controller/openEdit?id='+rows[0].id})
			}},
			{text : '删除',validCount : '1+',handler : function(rows){
				alertify.confirm("确认删除吗?", function(e){
					if(e) {
						//取得删除用户列表
						var ids=rows[0].id;
						for(var i=1;i<rows.length;i++){
							ids = ids + "," + rows[i].id;
					}
					$.ajax({
						url: 'T8Controller/delete',
						type: 'post',//提交的方式
						dataType:'json',
						data: {ids:ids},
						success: function(result) {
							if(result>=1){
								loadData();
								alertify.success("删除成功!");
							}
						}
					});
				}});
			}},
			{text : '删除数据',validCount : '1+',handler : function(rows){
				alertify.confirm("确认删除吗?", function(e){
					if(e) {
						//取得删除用户列表
						var ids=rows[0].id;
						for(var i=1;i<rows.length;i++){
							ids = ids + "," + rows[i].id;
					}
					$.ajax({
						url: 'T8Controller/drop',
						type: 'post',//提交的方式
						dataType:'json',
						data: {ids:ids},
						success: function(result) {
							if(result>=1){
								loadData();
								alertify.success("删除成功!");
							}
						}
					});
				}});
			}},
		]
		console.log("${funcPowers}");
		// 根据用户权限确定是否展示按钮
		initToolBarByFuncPower(toolbar,"${funcPowers}");
		//查询按钮权限
		btnPower($("#btnSearch"),"${condPowers}");
		
		//列表方法
		$('#table').datagrid({
			url : 'T8Controller/selectList',//查询数据的地址
			form : 'selectform',//用于筛选的form id
			//字段
			columns : [
				{field : 'aaa',title : '摄影师信息',width : 120},
				{field : 'bbb',title : '模特信息',width : 120},
				{field : 'ttt',title : '预约时间',width : 120},
				{field : 'ddd',title : '评价',width : 120},
// 				{field : 'eee',title : 't05',width : 120},
// 				{field : 'fff',title : 't06',width : 120},
// 				{field : 'ggg',title : 't07',width : 120},
// 				{field : 'hhh',title : 't08',width : 120},
// 				{field : 'iii',title : 't09',width : 120},
// 				{field : 'jjj',title : 't10',width : 120},
// 				{field : 'kkk',title : 't11',width : 120},
// 				{field : 'lll',title : 't12',width : 120},
// 				{field : 'mmm',title : 't13',width : 120},
// 				{field : 'nnn',title : 't14',width : 120},
// 				{field : 'ooo',title : 't15',width : 120},
// 				{field : 'ppp',title : 't16',width : 120},
// 				{field : 'qqq',title : 't17',width : 120},
// 				{field : 'rrr',title : 't18',width : 120},
// 				{field : 'sss',title : 't19',width : 120},
// 				{field : 'ttt',title : 't20',width : 120},
// 				{field : 'uuu',title : 't21',width : 120},
// 				{field : 'vvv',title : 't22',width : 120},
// 				{field : 'www',title : 't23',width : 120},
// 				{field : 'xxx',title : 't24',width : 120},
// 				{field : 'yyy',title : 't25',width : 120},
// 				{field : 'zzz',title : 't26',width : 120},
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
	// 加载 datagrid 填充数据 
	function loadData2(){
		$('#zzz').val("000");
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
	
	//导出Excel
	function  exportExcel(){
		var queryCondition = getQueryCondition();
		$('#queryCondition').val(queryCondition);
		$.ajax({
			type : "POST",
			url : "T8Controller/exportList",
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
			<span class="title">预约管理</span>
		</div>
		<div class="widget-body">
			<div class="widget-control">
				<form id="selectform" class="widget-form" method="post">
				<input id="queryCondition"type="hidden" name="queryCondition" >
				<input id="zzz"type="hidden" name="zzz" >
					<div class="widget-screen">
						<label for="aaa" class="control-label">摄影师编号</label>
						<div class="widget-item">
							<input class="form-control" name="aaa" type="text" placeholder="摄影师编号查询">
						</div>
					</div>
					<div class="widget-screen">
						<label for="bbb" class="control-label">模特编号</label>
						<div class="widget-item">
							<input class="form-control" name="bbb" type="text" placeholder="模特编号查询">
						</div>
					</div>
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="ccc" class="control-label">t03</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="ccc" type="text" placeholder="t03查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="ddd" class="control-label">t04</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="ddd" type="text" placeholder="t04查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="eee" class="control-label">t05</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="eee" type="text" placeholder="t05查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="fff" class="control-label">t06</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="fff" type="text" placeholder="t06查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="ggg" class="control-label">t07</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="ggg" type="text" placeholder="t07查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="hhh" class="control-label">t08</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="hhh" type="text" placeholder="t08查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="iii" class="control-label">t09</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="iii" type="text" placeholder="t09查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="jjj" class="control-label">t10</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="jjj" type="text" placeholder="t10查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="kkk" class="control-label">t11</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="kkk" type="text" placeholder="t11查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="lll" class="control-label">t12</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="lll" type="text" placeholder="t12查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="mmm" class="control-label">t13</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="mmm" type="text" placeholder="t13查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="nnn" class="control-label">t14</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="nnn" type="text" placeholder="t14查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="ooo" class="control-label">t15</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="ooo" type="text" placeholder="t15查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="ppp" class="control-label">t16</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="ppp" type="text" placeholder="t16查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="qqq" class="control-label">t17</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="qqq" type="text" placeholder="t17查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="rrr" class="control-label">t18</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="rrr" type="text" placeholder="t18查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="sss" class="control-label">t19</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="sss" type="text" placeholder="t19查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="ttt" class="control-label">t20</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="ttt" type="text" placeholder="t20查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="uuu" class="control-label">t21</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="uuu" type="text" placeholder="t21模糊查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="vvv" class="control-label">t22</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="vvv" type="text" placeholder="t22模糊查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="www" class="control-label">t23</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control" name="www" type="text" placeholder="t23模糊查询"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="xxx" class="control-label">t24</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<select class="form-control" id="xxx" name="xxx"> -->
<!-- 							<option value="000">请选择</option> -->
<!-- 							<option value="111">111</option> -->
<!-- 							<option value="222">222</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 						<div class="widget-screen"> -->
<!-- 						<label class="control-label">t20时间筛选</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control time" readonly style="background-color: #fff;cursor: default;" name="startTime" type="text" placeholder="筛选起时间"> -->
<!-- 						</div> -->
<!-- 						<label class="control-label" style="margin-left: -15px;">至</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<input class="form-control time" readonly style="background-color: #fff;cursor: default;" name="endTime" type="text" placeholder="筛选止时间"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="yyy" class="control-label">t25</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<select class="form-control" id="yyy" name="yyy"> -->
<!-- 							<option value="000">请选择</option> -->
<!-- 							<option value="111">111</option> -->
<!-- 							<option value="222">222</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="widget-screen"> -->
<!-- 						<label for="zzz" class="control-label">t26</label> -->
<!-- 						<div class="widget-item"> -->
<!-- 							<select class="form-control" id="zzz" name="zzz"> -->
<!-- 							<option value="000">请选择</option> -->
<!-- 							<option value="111">111</option> -->
<!-- 							<option value="222">222</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<button id="btnSearch" class="btn btn-primary btn-sm" onclick="loadData()" type="button">查 询</button>
					<button id="btnSearch" class="btn btn-primary btn-sm" onclick="loadData2()" type="button">推荐模特</button>
<!-- 					<button class="btn btn-primary btn-sm" onclick="exportExcel()" type="button">导 出</button> -->
				</form>
			</div>
			<!-- 数据表格 -->
			<div id="table"></div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>