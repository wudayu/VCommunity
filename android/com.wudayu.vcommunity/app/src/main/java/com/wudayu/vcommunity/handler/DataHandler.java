package com.wudayu.vcommunity.handler;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;

import com.wudayu.vcommunity.db.IDbHandler;
import com.wudayu.vcommunity.db.OrmliteDbHandler;
import com.wudayu.vcommunity.model.VcUser;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.RetrofitNetHandler;
import com.wudayu.vcommunity.net.protocol.VcUserResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Mar 3, 2015, 10:26:49 AM
 * @Description: David Wu created this file
 *
 **/
public class DataHandler implements IDataHandler {

	private static Activity sContext = null;
	private static INetHandler sNetHandler = null;
	private static IDbHandler sDbHandler = null;

	/** Generate the Singleton */
	private static final IDataHandler instance = new DataHandler();

	private DataHandler() {};

	public static IDataHandler getInstance(Activity context) {
		sContext = context;
		sNetHandler = RetrofitNetHandler.getInstance();
		sDbHandler = OrmliteDbHandler.getInstance(context);
		
		return instance;
	}

	@Override
	public void getForUserInfo(final String userId, final DataCallback<VcUser> dcb) {
		Callback<VcUserResult> cbRetrofit = new Callback<VcUserResult>() {
			@Override
			public void failure(RetrofitError error) {
				RetrofitNetHandler.toastNetworkError(sContext, error);
				// 网络无法连接，连接本地数据库
				sDbHandler.getForUserInfo(userId, dcb);
			}
			@Override
			public void success(VcUserResult result, Response response) {
				// 获取到数据，首先写入数据库
				VcUser user = result.getObjValue();
				sDbHandler.setForUserInfo(user);
				dcb.onSuccess(user);
			}
		};
//		sNetHandler.getForUserInfo(userId, cbRetrofit);
	}

}
