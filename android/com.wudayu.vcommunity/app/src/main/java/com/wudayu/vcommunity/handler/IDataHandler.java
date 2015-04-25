package com.wudayu.vcommunity.handler;

import com.wudayu.vcommunity.model.VcUser;


/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Dec 9, 2014, 10:14:43 AM
 * @Description: INetHandler是网络访问接口，其中还包括了网络地址等信息
 *
 **/

public interface IDataHandler {

	/** Get User Info */
	public void getForUserInfo(String userId, DataCallback<VcUser> dcb);

	public interface DataCallback<T> {
		public void onSuccess(T object);
		public void onFailure(String errInfo, Exception excep);
	}

}
