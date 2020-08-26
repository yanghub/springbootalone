package com.burro.entity;

import com.framework.core.BaseManageEntity;

/**
 * t_city-城市表
 */
public class CityEntity extends BaseManageEntity {
	private String cityId; // 区域ID
	private String cityName; // 区域名称
	private String districtId; // 行政区划ID
	private String parentDistrictId; // 上级行政区划ID
	private String cityLevel; // 区域级别
	private String openFlag; // 开通标识

	/**
	 * 设定【区域ID】
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	/**
	 * 取得【区域ID】
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * 设定【区域名称】
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 取得【区域名称】
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * 设定【行政区划ID】
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	/**
	 * 取得【行政区划ID】
	 */
	public String getDistrictId() {
		return districtId;
	}

	/**
	 * 设定【行政区划ID】
	 */
	public String getParentDistrictId() {
		return parentDistrictId;
	}

	/**
	 * 取得【行政区划ID】
	 */
	public void setParentDistrictId(String parentDistrictId) {
		this.parentDistrictId = parentDistrictId;
	}

	/**
	 * 设定【区域级别】
	 */
	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}

	/**
	 * 取得【区域级别】
	 */
	public String getCityLevel() {
		return cityLevel;
	}

	/**
	 * 设定【开通标识】
	 */
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	/**
	 * 取得【开通标识】
	 */
	public String getOpenFlag() {
		return openFlag;
	}

	/**
	 * 重写tostring方法
	 */
	@Override
	public String toString() {
		return "City [ cityId=" + cityId + ", cityName=" + cityName + ", districtId=" + districtId + ", parentDistrictId="
				+ parentDistrictId + ", cityLevel=" + cityLevel + ", openFlag=" + openFlag + "]";
	}
}
