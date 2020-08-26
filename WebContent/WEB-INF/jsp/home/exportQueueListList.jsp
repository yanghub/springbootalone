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
<title>导出队列列表</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){

		$.widget.init();	
		
		selectErrorExport();
		
		$('#table').datagrid({
			url : 'exportQueueListController/selectExportQueueListList?exportPerson=${LoginId}',//查询数据的地址
			//字段
			columns : [
				{field : 'createDate',title : '导出申请时间',width : 170,sortable : false,},		
				{field : 'queryParameters',title : '导出条件',width : 330,sortable : false,
					formatter: function(value,row,index){
					// console.log('<span title='+value+'>'+value+'</span>')
						return '<span title=\"'+value+'\">'+value+'</span>';
					}
				},

				{field:'outputName',title:'文件名',width:280, 
					formatter: function(value,row,index){
						if(row.status == 1)return '<a style="color:blue" href="' + row.fullPath + '">'+ row.outputName +'</a>';
						else return ''+ row.outputName + '';
					} 
				},
				{field : 'status',title : '状态',width : 100,sortable : false,
					formatter:function(value){
						if(value == 0 )return '等待';
						else if(value == 1 )return '成功';	
						else if(value == 2 )return '失败';
					}, 
				},
				{field : 'resultType',title : '状态信息',width : 100,sortable : false,}
			]
		});
		
		// 进入页面直接初始化列表--显示
		$('#table').datagrid('load');
		
	});
		
	function selectErrorExport(){
		$.ajax({
				type : "POST",
					url : "exportQueueListController/updateErrorExport",
					datatype : "json"
		});
	}	
</script>

</head>
<body>
	<div class="widget">
		<div class="widget-body">
			<!-- 数据表格 -->
			<div id="table"></div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>