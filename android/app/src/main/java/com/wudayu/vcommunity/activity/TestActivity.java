package com.wudayu.vcommunity.activity;

import android.widget.TextView;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.handler.DataHandler;
import com.wudayu.vcommunity.handler.IDataHandler;
import com.wudayu.vcommunity.handler.IDataHandler.DataCallback;
import com.wudayu.vcommunity.model.DafUser;
import com.wudayu.vcommunity.views.ProcessingDialog;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Dec 9, 2014, 10:24:43 AM
 * @Description: TestActivity用来测试某些功能
 *
 **/

public class TestActivity extends BaseActivity {

	TextView tvTest = null;
	IDataHandler dataHandler = null;

	@Override
	protected void initContainer() {
		setContentView(R.layout.activity_test);
	}

	@Override
	protected void initComponents() {
		tvTest = (TextView) findViewById(R.id.tv_test);
	}

	@Override
	protected void initEvents() {
	}

	@Override
	protected void initData() {
		dataHandler = DataHandler.getInstance(this);
	}

	@Override
	protected void afterAllSet() {
		processingDialog = new ProcessingDialog(this);
		processingDialog.show();
		dataHandler.getForUserInfo("9f35c28e869f42aba79d6a64211ce1a2", new DataCallback<DafUser>() {
			@Override
			public void onSuccess(DafUser object) {
				Utils.debug("DafUser = " + object);
				dismissProcessingDialog();
			}

			@Override
			public void onFailure(String errInfo, Exception excep) {
				Utils.debug("errInfo = " + errInfo);
				dismissProcessingDialog();
			}
		});
	}

}
