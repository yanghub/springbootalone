package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.IBaseFuncDao;
import com.burro.entity.BaseFuncEntity;


/**
 * 基本功能Service实现
 */
@Service
public class BaseFuncService {

	@Resource
	private IBaseFuncDao baseFuncDao;

	/**
	 * 查询基本功能信息列表
	 */
	public List<BaseFuncEntity> listBaseFunc(BaseFuncEntity baseFuncEntity) {
		return this.baseFuncDao.list(baseFuncEntity);
	}

	/**
	 * 查询基本功能信息条数
	 */
	public long countBaseFunc(BaseFuncEntity baseFuncEntity) {
		return this.baseFuncDao.count(baseFuncEntity);
	}

	/**
	 * 修改基本功能信息
	 */
	public int insertBaseFunc(BaseFuncEntity baseFuncEntity) {
		return this.baseFuncDao.insert(baseFuncEntity);
	}

	/**
	 * 新增基本功能信息
	 */
	public long updateBaseFunc(BaseFuncEntity baseFuncEntity) {
		return this.baseFuncDao.update(baseFuncEntity);
	}

	/**
	 * 批量删除基本功能信息
	 */
	public long deleteBaseFuncByIds(String ids, String updateBy) {
		String[] idsArr = ids.split(",");
		return baseFuncDao.deleteByIds(idsArr, updateBy);
	}

	/**
	 * 通过id查询基本功能信息
	 */
	public BaseFuncEntity getBaseFuncById(String id) {
		return this.baseFuncDao.getById(id);
	}

}
