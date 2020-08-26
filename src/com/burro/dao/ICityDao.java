package com.burro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.burro.entity.CityEntity;
import com.framework.core.IBaseManageDao;

/**
 * 城市管理DAO
 */
public interface ICityDao extends IBaseManageDao<CityEntity>{

	
	/**
	 * 通过userId查询客户所属城市信息
	 */
	public CityEntity getByUserId(@Param("userId") String userId);
	
	/**
	 * 通过cityId查询客户所属城市信息
	 */
	public CityEntity getByCityId(@Param("cityId") String cityId);
	
	/**
	 * 查询所有1.6级城市
	 */
	public List<CityEntity> listLevel1And6();
	


}
