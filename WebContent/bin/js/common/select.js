/** 
 * @Function_Name: loadComboBox 
 * @Description: 设定下拉列表 
 * @param $obj 下拉列表jQuery对象
 * @param type 取得下拉列表类别
 * @param code 级联查询时使用的一级列表code值
 * @param hidden 是否隐藏下拉列表
 * @returns boolean 加载列表是否成功
 */
function loadComboBox($obj,type,code,hidden){
	
	// 加载是否成功标识
	var loadFlag = false;
	
	// 加载url地址
	var urlAddr ="";
	// 列出用户角色查询列表
	if(type == "SEARCH_ROLE_BY_POWERTYPE"){
		urlAddr = "commonController/getSearchRoleByPowerType";
	}else
	// 列出用户角色编辑列表
	if(type == "EDIT_ROLE_BY_POWERTYPE"){
		urlAddr = "commonController/getEditRoleByPowerType";
	}else
	// 根据当前用户权限，列出相应的区域查询列表
	if(type == "SEARCH_CITY_BY_USER"){
		urlAddr = "commonController/getSearchCityByUser";
	}else
	// 根据当前用户权限，列出相应的区域编辑列表
	if(type == "EDIT_CITY_BY_USER"){
		urlAddr = "commonController/getEditCityByUser";
	}else 
	// 获取所有的省份 查询页
	if(type == "SEARCH_ALL_PROVINCE"){
		urlAddr = "commonController/getSearchAllProvince";
	}else
	// 获取所有的省份 编辑页
	if(type == "EDIT_ALL_PROVINCE"){
		urlAddr = "commonController/getEditAllProvince";
	}else 
	// 获取所有的城市 查询页
	if(type == "SEARCH_ALL_CITY"){
		urlAddr = "commonController/getSearchAllCity";
	}else
	// 获取所有的城市 编辑页
	if(type == "EDIT_ALL_CITY"){
		urlAddr = "commonController/getEditAllCity";
	}else 
	// 获取所有已开通城市 查询页
	if(type == "SEARCH_ALL_OPEN_CITY"){
		urlAddr = "commonController/getSearchAllOpenCity";
	}else
	// 获取所有已开通的城市 编辑页
	if(type == "EDIT_ALL_OPEN_CITY"){
		urlAddr = "commonController/getEditAllOpenCity";
	}else
	// 列出加盟类型查询列表
	if(type == "SEARCH_ALL_JOINTYPE"){
		urlAddr = "commonController/getSearchAllJoinType";
	}else 
	// 列出加盟类型编辑列表
	if(type == "EDIT_ALL_JOINTYPE"){
		urlAddr = "commonController/getEditAllJoinType";
	}else 
	// 根据区域显示 加盟商(类型)查询下拉列表
	if(type == "SEARCH_JOINANDTYPE_BY_USER"){
		urlAddr = "commonController/getSearchJoinAndTypeByUser";
	}else
	// 根据区域显示加盟商(类型)编辑下拉列表	
	if(type == "EDIT_JOINANDTYPE_BY_USER"){
		urlAddr = "commonController/getEditJoinAndTypeByUser";	
	}else
	// 一级菜单下拉查询列表
	if(type == "SEARCH_ALL_MENU"){
		urlAddr = "commonController/getSearchAllMenu";
	}else 
	// 一级菜单下拉编辑列表
	if(type == "EDIT_ALL_MENU"){
		urlAddr = "commonController/getEditAllMenu";
	}else
	// 获取字典表中的角色类型下拉查询列表
	if(type == "SEARCH_ROLETYPE"){
		urlAddr = "commonController/getSearchDictByTypeCode?Para=USER_TYPE";
	}else 
	// 获取字典表中的角色类型下拉编辑列表
	if(type == "EDIT_ROLETYPE"){
		urlAddr = "commonController/getEditDictByTypeCode?Para=USER_TYPE";
	}else
	// 获取字典表中的角色类型下拉查询列表
	if(type == "SEARCH_RULETYPE"){
		urlAddr = "commonController/getSearchDictByTypeCode?Para=RULE_TYPE";
	}else 
	// 获取字典表中的角色类型下拉编辑列表
	if(type == "EDIT_RULETYPE"){
		urlAddr = "commonController/getEditDictByTypeCode?Para=RULE_TYPE";
	}
	else
	// 获取月卡信息下拉查询列表
	if(type == "SEARCH_CARD_ID"){
		urlAddr = "commonController/getSearchCardID";
	}else 
	// 获取月卡信息下拉查询列表
	if(type == "EDIT_CARD_ID"){
		urlAddr = "commonController/getEditCardID";
	}
	else
	// 获取电池类型下拉查询列表
	if(type == "SEARCH_POWER_TYPE_ID"){
		urlAddr = "commonController/getSearchPowerTypeID";
	}else 
	// 获取电池类型下拉查询列表
	if(type == "EDIT_POWER_TYPE_ID"){
		urlAddr = "commonController/getEditPowerTypeID";
	}		
	else
	// 获取电池型号下拉查询列表
	if(type == "SEARCH_POWER_ID"){
		urlAddr = "commonController/getSearchPowerID";
	}else 
	// 获取电池型号下拉查询列表
	if(type == "EDIT_POWER_ID"){
		urlAddr = "commonController/getEditPowerTID";
	}
	$obj.comboBox({
		editable:false,
		url : urlAddr,
		onLoadSuccess:function(data){
			if(data.length == 2 && (type == "SEARCH_CITY_BY_USER" || type == "EDIT_CITY_BY_USER")){
				// 默认 选择
				$obj.comboBox('select',data[1].code);
				
				if (hidden!=false) {
					// console.log("默认不显示！");
					$obj.parent().parent().hide();	
				}
			}else if(type == "SEARCH_ALL_PROVINCE"){
				if(code){
					$obj.comboBox('select',code);
				}else{
					$obj.comboBox('select','100000');
				}
			}else{
				if(code){
					$obj.comboBox('select',code);
				}else{
					$obj.comboBox('select','000');
				}
			}
			loadFlag = true;		
		}
		
	})
	return loadFlag;
}

/** 
 * @Function_Name: LoadDict
 * @Description: 设定字典下拉列表-用于查询与编辑回显 
 * @param obj-下拉列表对象
 * @param dictType-字典类别
 * @param code-字典加载后的设定值
 * @returns {Boolean-是否成功} 返回值说明
 * @author fanyunpeng
 * @date 2018年10月16日 
 */
function LoadDict($obj,dictType,code){
	var loadFlag = false;
	var arr = dictType.split("_");
	if (arr[0] == "SEARCH" || arr[0] == "EDIT") {
		$obj.comboBox({
			editable:false,
			url : "commonController/getDictList?ParaFlag="+arr[0]+"&ParaType="+dictType.replace(arr[0]+"_",""),
			onLoadSuccess:function(data){
				if(code){
					$obj.comboBox('select',code);
				}else{
					$obj.comboBox('select','000');
				}
				loadFlag = true;		
			}
		});
	}
	return loadFlag;
}

/** 
 * @Function_Name: loadComboBox 
 * @Description: 取得带参设定下拉列表 
 * @param $obj 下拉列表jQuery对象
 * @param type 取得下拉列表类别
 * @param code 级联查询时使用的一级列表code值
 * @param hidden 是否隐藏下拉列表
 * @returns boolean 加载列表是否成功
 */
function loadComboBoxByPara($obj,type,Para,code,level){
	if (level == null || level == '') {
		level = 0;
	}else{
		level = level;
	}
	// 加载是否成功标识
	var loadFlag = false;
	var urlAddr = "";
	//指定一级菜单下的所有二级菜单下拉列表 查询页
	if(type == "SEARCH_ALL_MENU"){
		urlAddr = "commonController/getSearchMenuByPid?Para="+Para;
	}else 
	//指定一级菜单下的所有二级菜单下拉列表 编辑页
	if(type == "EDIT_ALL_MENU"){
		urlAddr = "commonController/getEditMenuByPid?Para="+Para;
	}else if(type == "SEARCH_STOREINFO"){// 获取字典表中的角色类型下拉查询列表
		urlAddr = "commonController/getSearchStoreList?Para="+Para+"&level="+level;
	}else if(type == "EDIT_STOREINFO"){// 获取字典表中的角色类型下拉编辑列表
		urlAddr = "commonController/getEditStoreList?Para="+Para+"&level="+level;
	}else if(type == "SEARCH_ALL_COUPON"){
		urlAddr = "commonController/getSearchCouponType?Para="+Para;
	}else if(type == "EDIT_ALL_COUPON"){
		urlAddr = "commonController/getEditCouponType?Para="+Para;
	}
	var orgCount = 0;
	$obj.comboBox({
		url : urlAddr,//返回json数据的url
		editable:false,
		onLoadSuccess:function(data){
			if(code){
				$obj.comboBox('select',code);
			}else{
				$obj.comboBox('select','000');
			}
			loadFlag = true;
		}
	})
	return loadFlag;
}

//通过省份控件和城市控件，取得区域代码
function getCityId(objProv,objCity){
	var blnRet = "";
	var provVal = objProv.comboBox('getValue');
    var provText = objProv.comboBox('getText');

	if(provVal != provText && provVal!="" && provVal !="000"){//非手动输入省份代码，非默认值
		blnRet = provVal;
		var cityVal = objCity.comboBox('getValue');
        var cityText = objCity.comboBox('getText');	
    	if(cityVal != cityText && cityVal!="" && cityVal !="000"){//非手动输入城市代码，非默认值
        	blnRet = cityVal;
        }
    }
    return blnRet;
}

//通过区域代码,设定省份控件和城市控件
function setObjByCityId(strCity,objProv,objCity,cityFlag){
	var blnRet = false;
	if(strCity.length !=6) return blnRet;
	if(strCity.substring(1)=="00000"){//全国100000
		//设定省份为全国
		objProv.comboBox({
        	onLoadSuccess:function(){
        		objProv.comboBox('select',strCity);
    			blnRet = true;
    		}
        });
	}else if(strCity.substring(2)=="0000"){//省XX0000
		//设定省份为指定省
		objProv.comboBox({
        	onLoadSuccess:function(){
        		objProv.comboBox('select',strCity);
    			blnRet = true;
    		}
        });
	}else if(strCity.substring(4)=="00"){//市XXXX00
		var strProv = strCity.substr(0,2)+"0000";
		
		//设定省份为指定省
		objProv.comboBox({
        	onLoadSuccess:function(){
        		objProv.comboBox('select',strProv);
    			blnRet = true;
    		}
        });

		//根据指定省份初始化城市
		loadComboBoxByPara(objCity, cityFlag,strProv);
		
		//设定城市为指定城市
		objCity.comboBox({
        	onLoadSuccess:function(){
        		objCity.comboBox('select',strCity);
    			blnRet = true;
    		}
        });
	}

    return blnRet;
}

/*取得10条年月下拉列表，当前日期小于5日，则不取当前月*/
function loadMonthComboxBox(obj){
	var blnRet = false;
	var orgCount = 0;
	obj.comboBox({
		url : "commonController/getYearMonth",//返回json数据的url
		valueField : "code",//这个id和你返回json里面的id对应
		textField : "name", //这个text和你返回json里面的text对应
		editable:false,
		panelHeight:'auto',
		onLoadSuccess:function(data){//选中某第一项
			orgCount = data.length;
			obj.comboBox('select',data[0].code);//菜单项可以text或者id
			blnRet = true;
		},
		onShowPanel: function() {  
            // 动态调整高度  
            if (orgCount > 8) {  
                $(this).comboBox('panel').height(200);  
            }
        }
	})
	return blnRet;
}

//判断页面是否有编辑功能
function editPower(strOptPower){
	var blnRet = false;
    if(strOptPower.length >=2){
    	if(strOptPower.substring(0, 1)=="1"){
    		blnRet = true;
    	}
    }
    return blnRet;
}

//判断页面是否有报表功能
function reportPower(strOptPower){
	var blnRet = false;
    if(strOptPower.length >=2){
    	if(strOptPower.substring(1, 2)=="1"){
    		blnRet = true;
    	}
    }
    return blnRet;
}

// 判断页面是否有客户密码安全权限
function customerPasswordPower(strOptPower){
	var blnRet = false;
	
    if (strOptPower.length >= 5) {
    	if (strOptPower.substring(4, 5) == "1") {
    		blnRet = true;
    	}
    }
    
    return blnRet;
}

// 判断页面是否有配送员密码安全权限
function employeePasswordPower(strOptPower){
	var blnRet = false;
	
    if (strOptPower.length >= 6) {
    	if (strOptPower.substring(5, 6) == "1") {
    		blnRet = true;
    	}
    }
    
    return blnRet;
}


function loadRoleList($obj,type,code,hidden){
	
	// 加载是否成功标识
	var loadFlag = false;
	
	// 加载url地址
	var urlAddr ="";
	// 列出用户角色查询列表
	if(type == "SEARCH_ROLE"){
		urlAddr = "commonController/getSearchRoleByPowerType";
	}else
	// 列出用户角色编辑列表
	if(type == "EDIT_ROLE"){
		urlAddr = "commonController/getEditRoleByPowerType";
	}	
	$obj.comboBox({
		editable:false,
		url : urlAddr,
		onLoadSuccess:function(data){
			if(data.length == 2 && (type == "SEARCH_CITY_BY_USER" || type == "EDIT_CITY_BY_USER")){
				// 默认 选择
				$obj.comboBox('select',data[1].code);
				
				if (hidden!=false) {
					// console.log("默认不显示！");
					$obj.parent().parent().hide();	
				}
			}else if(type == "SEARCH_ALL_PROVINCE"){
				if(code){
					$obj.comboBox('select',code);
				}else{
					$obj.comboBox('select','100000');
				}
			}else{
				if(code){
					$obj.comboBox('select',code);
				}else{
					$obj.comboBox('select','000');
				}
			}
			loadFlag = true;		
		}
		
	})
	return loadFlag;
}