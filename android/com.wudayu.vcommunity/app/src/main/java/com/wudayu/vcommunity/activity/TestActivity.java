package com.wudayu.vcommunity.activity;

import android.os.AsyncTask;
import android.view.View;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.generic.Utils;
import uk.co.senab.actionbarpulltorefresh.extras.actionbarsherlock.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.Options;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

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

	private PullToRefreshLayout mPullToRefreshLayout;

	@Override
	protected void initContainer() {
		setContentView(R.layout.activity_test);
	}

	@Override
	protected void initComponents() {
		mPullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);
	}

	@Override
	protected void initEvents() {
		// Now setup the PullToRefreshLayout
		ActionBarPullToRefresh.from(this)
				// options
				.options(Options.create()
						// Here we make the refresh scroll distance to 45% of the refreshable view's height
						.scrollDistance(.45f)
						// Here we define a custom header layout which will be inflated and used
						// .headerLayout(R.layout.layout_pull_to_refresh)
						// Here we define a custom header transformer which will alter the header
						// based on the current pull-to-refresh state
						// .headerTransformer(new CustomisedHeaderTransformer())
						.build())
				// Mark All Children as pullable
				.allChildrenArePullable()
				// Set a OnRefreshListener
				.listener(new OnRefreshListener() {
					@Override
					public void onRefreshStarted(View view) {
						Utils.toastMessage(TestActivity.this, "Oh, yeah, u did it!");
						new AsyncTask<Void, Void, Void>() {
							@Override
							protected Void doInBackground(Void... params) {
								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								return null;
							}
							@Override
							protected void onPostExecute(Void result) {
								super.onPostExecute(result);
								mPullToRefreshLayout.setRefreshComplete();
							}
						}.execute();
					}
				})
				// Finally commit the setup to our PullToRefreshLayout
				.setup(mPullToRefreshLayout);
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void afterAllSet() {
	}

}
