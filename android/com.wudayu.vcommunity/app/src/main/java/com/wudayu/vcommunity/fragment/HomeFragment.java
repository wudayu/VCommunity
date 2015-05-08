package com.wudayu.vcommunity.fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.activity.TestActivity;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.image.IImageHandler;
import com.wudayu.vcommunity.image.UILImageHandler;
import com.wudayu.vcommunity.listener.BannerViewOnItemClickListener;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.views.BannerView;
import com.wudayu.vcommunity.views.CountDownView;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:52:32 PM
 * @Description: 首页Fragment
 *
 **/

public class HomeFragment extends BaseFragment {

	BannerView bvBanner = null;

	IImageHandler imageHandler = null;

	@Override
	protected View initContainer(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_home, null);
	}

	@Override
	protected void initComponents(View fragView) {
		bvBanner = (BannerView) fragView.findViewById(R.id.bv_banner);

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
		testData();
	}

	private void testData() {
		// HomePageBanner
		List<View> views = new ArrayList<View>();
		ImageView view1 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://pic1.win4000.com/wallpaper/d/53e85d4307c60.jpg", view1);
		view1.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_FIRST));
		ImageView view2 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://d.hiphotos.baidu.com/image/pic/item/72f082025aafa40fc8e997d5a964034f78f0198e.jpg", view2);
		view2.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_SECOND));
		ImageView view3 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://pic1.win4000.com/wallpaper/f/538eb7e2ee428.jpg", view3);
		view3.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_THIRD));
		views.add(view1);
		views.add(view2);
		views.add(view3);
		bvBanner.setViews(views);
		bvBanner.setRolling(3000);
	}

}
