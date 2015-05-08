package com.wudayu.vcommunity.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.adapter.MainActivityPageAdapter;
import com.wudayu.vcommunity.constant.Constant;
import com.wudayu.vcommunity.fragment.TestFirstFragment;
import com.wudayu.vcommunity.fragment.TestSecondFragment;
import com.wudayu.vcommunity.fragment.TestThirdFragment;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.service.PushService;
import com.wudayu.vcommunity.views.PageSelectBar;
import com.wudayu.vcommunity.views.SwitchViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 20, 2014, 10:02:04 PM
 * @Description: MainActivity是项目的真正主界面当所有数据加载完成后，用户看到的就是这个页面。他包括了一个ViewPager和一个PageSelectBar
 *
 **/

public class MainActivity extends BaseActivity {

	private static final int PAGE_COUNT = 3;

	SwitchViewPager vpMain = null;
	PageSelectBar psbMain = null;
	ImageView ivBack = null;
	TextView tvTitle = null;

	TestFirstFragment testFirstFragment = null;
	TestSecondFragment testSecondFragment = null;
	TestThirdFragment testThirdFragment = null;
	TestThirdFragment testForthFragment = null;


	@Override
	protected void initContainer() {
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void initComponents() {
		vpMain = (SwitchViewPager) findViewById(R.id.vp_main);
		psbMain = (PageSelectBar) findViewById(R.id.psb_main);
		ivBack = (ImageView) findViewById(R.id.iv_back);
		tvTitle = (TextView) findViewById(R.id.tv_title);

		MainActivityPageAdapter adapter = new MainActivityPageAdapter(getSupportFragmentManager());

		List<Fragment> fragments = new ArrayList<Fragment>();
		testFirstFragment = new TestFirstFragment();
		testSecondFragment = new TestSecondFragment();
		testThirdFragment = new TestThirdFragment();
		testForthFragment = new TestThirdFragment();

		fragments.add(testFirstFragment);
		fragments.add(testSecondFragment);
		fragments.add(testThirdFragment);
		fragments.add(testForthFragment);

		adapter.addAll(fragments);
		vpMain.setAdapter(adapter);
		vpMain.setOffscreenPageLimit(PAGE_COUNT - 1);
	}

	@Override
	protected void initEvents() {
		vpMain.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int pos) {
				psbMain.selectItemUI(pos);
				// TODO make this test code right
				if (pos == 3)
					startActivity(new Intent(MainActivity.this, LoginActivity.class));
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {}
			@Override
			public void onPageScrollStateChanged(int arg0) {}
		});
		psbMain.setPageSelectBarOnPageSelectedListener(new PageSelectBar.PageSelectBarOnPageSelectedListener() {
			@Override
			public void onPageSelected(int position) {
				vpMain.setCurrentItem(position);
			}
		});
	}

	@Override
	protected void initData() {
		ivBack.setVisibility(View.INVISIBLE);
	}

	@Override
	protected void afterAllSet() {
		if (Constant.needPush) {
			Intent pushServiceIntent = new Intent(this, PushService.class);
			startService(pushServiceIntent);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		testFirstFragment.onActivityResult(requestCode, resultCode, data);
		testSecondFragment.onActivityResult(requestCode, resultCode, data);
		testThirdFragment.onActivityResult(requestCode, resultCode, data);
		testForthFragment.onActivityResult(requestCode, resultCode, data);

		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * 双击后退键退出
	 */
	private static long back_pressed = 0;
	@Override
	public void onBackPressed() {
		if (back_pressed + 2000 > System.currentTimeMillis()) {
			super.closeAllActivity();
			super.onBackPressed();
		} else {
			Utils.toastMessage(this, getString(R.string.str_double_close));
		}

		back_pressed = System.currentTimeMillis();
	}

	public void setTitle(String titleString) {
		tvTitle.setText(titleString);
	}

}
