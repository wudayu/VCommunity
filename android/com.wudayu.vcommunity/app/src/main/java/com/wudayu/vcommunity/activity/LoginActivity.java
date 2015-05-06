package com.wudayu.vcommunity.activity;

import com.wudayu.vcommunity.R;

/**
 * Created by David on 5/5/15.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void initContainer() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void afterAllSet() {
        showProcessingDialog(null, true);
    }

}
