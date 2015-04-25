package com.wudayu.vcommunity.activity;

import android.widget.TextView;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.handler.DataHandler;
import com.wudayu.vcommunity.handler.IDataHandler;
import com.wudayu.vcommunity.handler.IDataHandler.DataCallback;
import com.wudayu.vcommunity.model.VcTestUser;
import com.wudayu.vcommunity.model.VcUser;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.RetrofitNetHandler;
import com.wudayu.vcommunity.net.protocol.VcObjectResult;
import com.wudayu.vcommunity.views.ProcessingDialog;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

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
    INetHandler netHandler = null;

	@Override
	protected void initContainer() {
		setContentView(R.layout.activity_test);
	}

	@Override
	protected void initComponents() {
		tvTest = (TextView) findViewById(R.id.tv_test);
        netHandler = RetrofitNetHandler.getInstance();
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
        /*
		dataHandler.getForUserInfo("9f35c28e869f42aba79d6a64211ce1a2", new DataCallback<VcUser>() {
			@Override
			public void onSuccess(VcUser object) {
				Utils.debug("VcUser = " + object);
				dismissProcessingDialog();
			}

			@Override
			public void onFailure(String errInfo, Exception excep) {
				Utils.debug("errInfo = " + errInfo);
				dismissProcessingDialog();
			}
		});
		*/
        netHandler.getForGetTestUser("19506268550842b6b05bb5e3c0f618ce", new Callback<VcObjectResult<VcTestUser>>() {
            @Override
            public void success(VcObjectResult<VcTestUser> vcTestUserVcObjectResult, Response response) {
                Utils.debug("VcUser = " + vcTestUserVcObjectResult.getObject());
                tvTest.setText(vcTestUserVcObjectResult.getObject().toString());
                dismissProcessingDialog();
            }

            @Override
            public void failure(RetrofitError error) {
                Utils.debug("errInfo = " + error);
                tvTest.setText(error.toString());
                dismissProcessingDialog();
            }
        });
	}

}
