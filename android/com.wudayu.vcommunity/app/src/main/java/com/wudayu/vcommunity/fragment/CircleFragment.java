package com.wudayu.vcommunity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.image.IImageHandler;
import com.wudayu.vcommunity.image.UILImageHandler;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.RetrofitNetHandler;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:55:16 PM
 * @Description: 邻里圈Fragment
 *
 **/

public class CircleFragment extends BaseFragment {

	INetHandler netHandler = null;
    IImageHandler imageHandler = null;

	@Override
	protected View initContainer(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_circle, null);
	}

	@Override
	protected void initComponents(View fragView) {

		netHandler = RetrofitNetHandler.getInstance();
        imageHandler = UILImageHandler.getInstance(this.getActivity());
	}

	@Override
	protected void initEvents() {
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void afterAllSet() {
	}
	
}
