package com.wudayu.vcommunity.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wudayu.vcommunity.model.VcUser;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Dec 8, 2014, 2:58:40 PM
 * @Description: DafUserResult是继承于BaseResult的数据对象，其承载了一个DafUser对象
 *
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class VcUserResult extends BaseResult {

	private VcUser objValue;

	public VcUser getObjValue() {
		return objValue;
	}

	public void setObjValue(VcUser user) {
		this.objValue = user;
	}

	@Override
	public String toString() {
		return "XcfcUserResult [" + super.toString() + ", user=" + objValue + "]";
	}
}
