package com.burro.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.burro.dao.ICityDao;
import com.burro.entity.CityEntity;

/**
 * 城市信息Service
 */
@Service
public class CityService {

	@Resource
	private ICityDao cityDao;

	/**
	 * 通过条件获取城市信息
	 */
	
	public List<CityEntity> list(CityEntity cityEntity) {
		return cityDao.list(cityEntity);
	}

	/**
	 * 通过条件统计城市信息条数
	 */
	
	public long count(CityEntity cityEntity) {
		return this.cityDao.count(cityEntity);
	}

	/**
	 * 更新城市信息
	 */
	
	public long updateCity(CityEntity cityEntity) {
		return this.cityDao.update(cityEntity);
	}

	/**
	 * 通过id获取城市信息
	 */
	
	public CityEntity getCityById(String cityId) {
		return cityDao.getById(cityId);
	}

	/**
	 * 通过客户ID获取客户所属城市信息
	 */
	
	public CityEntity getCityByUserId(String userId) {
		return this.cityDao.getByUserId(userId);
	}

	
	/**
	 * 查询所有1.6级城市
	 */
	
	public List<CityEntity> listLeveCity() {
		return cityDao.listLevel1And6();
	}

}
