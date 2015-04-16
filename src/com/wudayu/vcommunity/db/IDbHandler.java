package com.wudayu.vcommunity.db;

import com.wudayu.vcommunity.handler.IDataHandler;
import com.wudayu.vcommunity.model.DafUser;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Mar 4, 2015, 5:53:40 PM
 * @Description: David Wu created this file
 *
 **/
public interface IDbHandler extends IDataHandler {

	public void setForUserInfo(DafUser user);

}
