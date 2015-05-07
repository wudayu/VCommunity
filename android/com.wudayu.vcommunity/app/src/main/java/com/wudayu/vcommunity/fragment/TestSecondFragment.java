package com.wudayu.vcommunity.fragment;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.constant.WeatherCityCode;
import com.wudayu.vcommunity.image.IImageHandler;
import com.wudayu.vcommunity.image.UILImageHandler;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.RetrofitNetHandler;
import com.wudayu.vcommunity.net.protocol.WeatherResult;
import com.wudayu.vcommunity.views.ProcessingDialog;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:55:16 PM
 * @Description: Test Fragment No.2
 *
 **/

public class TestSecondFragment extends BaseFragment {

	INetHandler netHandler = null;
    IImageHandler imageHandler = null;
	TextView tvWeather = null;

	@Override
	protected View initContainer(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_test_second, null);
	}

	@Override
	protected void initComponents(View fragView) {
		tvWeather = (TextView) fragView.findViewById(R.id.tv_weather);

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
