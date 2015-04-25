package com.wudayu.vcommunity.db;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.model.VcUser;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Mar 3, 2015, 10:24:54 AM
 * @Description: David Wu created this file
 *
 **/
public class OrmliteDbHandler implements IDbHandler {

	private static Context sContext = null;

	/** Generate the Singleton */
	private final static IDbHandler instance = new OrmliteDbHandler();

	private OrmliteDbHandler() {};

	public static IDbHandler getInstance(Context context) {
		sContext = context;

		return instance;
	}

	DatabaseHelper mDatabaseHelper = null;

	private DatabaseHelper getHelper() {
	    if (mDatabaseHelper == null) {
	    	mDatabaseHelper = OpenHelperManager.getHelper(sContext, DatabaseHelper.class);
	    }

	    return mDatabaseHelper;
	}

	@Override
	public void getForUserInfo(String userId, DataCallback<VcUser> dcb) {
		DatabaseHelper dbHelper = getHelper();
		try {
			RuntimeExceptionDao<VcUser, Integer> userDao = RuntimeExceptionDao.createDao(dbHelper.getConnectionSource(), VcUser.class);
			List<VcUser> users = userDao.queryForEq(VcUser.USER_ID, userId);
			if (users != null && users.size() > 0) {
				dcb.onSuccess(users.get(0));
			} else {
				dcb.onFailure(sContext.getString(R.string.error_local_database_has_no_data), null);
			}
		} catch (SQLException e) {
			dcb.onFailure(sContext.getString(R.string.error_local_database_connot_be_connected), null);
			e.printStackTrace();
		};
	}

	@Override
	public void setForUserInfo(VcUser user) {
		DatabaseHelper dbHelper = getHelper();
		try {
			RuntimeExceptionDao<VcUser, Integer> userDao = RuntimeExceptionDao.createDao(dbHelper.getConnectionSource(), VcUser.class);
			if (user != null) {
				// 有数据则添加或更新
				userDao.createOrUpdate(user);
			} else {
				// 没数据则清空表，保持与服务器统一
				userDao.deleteBuilder().delete();
			}
		} catch (SQLException e) {
			Utils.debug("--:(------can not connect database---");
			e.printStackTrace();
		};
	}

}
