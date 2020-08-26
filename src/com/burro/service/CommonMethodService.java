package com.burro.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.burro.common.SessionUtil;
import com.framework.core.BaseManageEntity;
import com.framework.core.SessionManageEntity;
import com.framework.util.ManageConstants;
import com.google.gson.Gson;
import com.power.common.CommonUtil;
import com.power.common.ExcelToOssUtils;
import com.power.entity.ExcelHeadInfo;
import com.power.entity.ExportQueueListEntity;
import com.power.service.ExportQueueListService;

/**
 * 共通方法
 */
@Service
public class CommonMethodService {

//	//导出功能
//	@Resource
//	private ExportQueueListService exportQueueListService;
//	
//	@SuppressWarnings("unused")
//	public ModelMap exportList(String excelName,long total,Object entity,Object service,HttpServletRequest request,
//			String methodName,List<ExcelHeadInfo> excelHeadInfos) throws Exception {
//		//获取user对象
//		SessionManageEntity user = SessionUtil.getSession(request);
//		//给对象赋值
//		((BaseManageEntity) entity).setCityIds(user.getCityIds());
//		((BaseManageEntity) entity).setJoinIds(user.getJoinIds());
//		((BaseManageEntity) entity).setRows(-1);
//		ModelMap map = new ModelMap();
//		//判断数量返回结果
//		if (total == 0) {
//			// 当数量=0的时候，没有对应数据--返回
//			map.put("result", "nolist");
//		} else if (total > ManageConstants.EXCEL_OUTPUT_LIMIT) {
//			// 当数量大于sizeExcess的时候，不能导出
//			map.put("result", "sizeExcess");
//		} else {
//			// 生成一个新的记录导出队列 表对象
//			ExportQueueListEntity exportQueueListEntity = new ExportQueueListEntity();
//			try {
//				if (user != null) {
//					// 定义队列exportQueueId 下面导出Excel方法需要传相同的Id
//					String exportQueueId = CommonUtil.getUuid();
//					exportQueueListEntity.setId(exportQueueId);
//					exportQueueListEntity.setCreateBy(user.getUserId());
//					exportQueueListEntity.setUpdateBy(user.getUserId());
//					// 判断传入的查询参数，有值的话用,连接保存到queryParameters查询参数字段中
//					exportQueueListEntity.setQueryParameters(((BaseManageEntity) entity).getQueryCondition());
//					// 文件名
//					exportQueueListEntity.setOutputName(excelName);
//					// 状态
//					exportQueueListEntity.setStatus("0");
//					// POJO转化Gson
//					Gson gson = new Gson();
//					String gsonBuyerOrder = gson.toJson(entity);
//					String excelHeadInfoses = gson.toJson(excelHeadInfos);
//					// 传过的json FieldName--KeyName--FieldWidth
//					exportQueueListEntity.setFieldWidth(excelHeadInfoses);
//					// 参数
//					exportQueueListEntity.setParaValue(gsonBuyerOrder);
//					// service
//					exportQueueListEntity.setServiceType(service.getClass().getName());
//					// 方法
//					exportQueueListEntity.setMethodName(methodName);
//					// para_type
//					exportQueueListEntity.setParaType(entity.getClass().getName());
//					// result_type
//					exportQueueListEntity.setResultType("等待导出");
//					// 结果行数
//					exportQueueListEntity.setResultNum(String.valueOf(total));
//					// 导出人
//					exportQueueListEntity.setExportPerson(user.getUserId());
//					// 插入到m_export_pair_list中
//					this.exportQueueListService.insertExportQueueList(exportQueueListEntity);
//					// 调用导出Excel方法
//					ExcelToOssUtils.uploadToOss(exportQueueListService, exportQueueId, user.getUserId());
//					map.put("result", "success");
//				} else {
//					exportQueueListEntity.setResultType("Session失效，请登录");
//					exportQueueListService.updateExportQueueList(exportQueueListEntity);
//					map.put("result", "failure");
//				}
//			} catch (Exception e) {
//				exportQueueListEntity.setResultType("系统异常!");
//				exportQueueListService.updateExportQueueList(exportQueueListEntity);
//				map.put("result", "failure");
//			}
//		}
//		return map;
//	}
//	
}
