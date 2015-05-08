package com.wudayu.vcommunity.activity;

import com.wudayu.vcommunity.R;

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

	@Override
	protected void initContainer() {
		setContentView(R.layout.activity_test);
	}

	@Override
	protected void initComponents() {
	}

	@Override
	protected void initEvents() {
		/*
		// Now setup the PullToRefreshLayout
		ActionBarPullToRefresh.from(this)
				// options
				.options(Options.create()
						// Here we make the refresh scroll distance to 45% of the refreshable view's height
						.scrollDistance(.4f)
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
		*/
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void afterAllSet() {
	}

}
