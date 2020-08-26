package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.IT8Dao;
import com.burro.entity.Entity;

/**
 * T8管理系统 service
 */
@Service
public class T8Service {

	@Resource
	private IT8Dao dao;

	/**
	 * 通过条件查询T8数据集合
	 */
	public List<Entity> list(Entity entity){
		return dao.list(entity);
	}
	
	/**
	 * 通过条件查询T8数据数量
	 */
	public long count(Entity entity) {
		return dao.count(entity);
	}
		
	/**
	 * 新增T8
	 */
	public int insert(Entity entity) {
		return dao.insert(entity);
	}

	/**
	 * 通过id查询T8
	 */
	public Entity getById(String id) {
		return this.dao.getById(id);
	}
	
	/**
	 * 修改T8
	 */
	public long update(Entity entity) {
		return dao.update(entity);
	}

	/**
	 * 批量逻辑删除T8
	 */
	public long delete(String ids, String userId) {
		return dao.deleteByIds( ids.split(","), userId);
	}
	/**
	 * 批量物理删除T8
	 */
	public long drop(String ids, String userId) {
		return this.dao.dropByIds(ids.split(","), userId);
	}
}