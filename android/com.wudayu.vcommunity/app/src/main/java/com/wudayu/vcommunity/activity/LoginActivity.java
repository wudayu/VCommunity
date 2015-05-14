package com.wudayu.vcommunity.activity;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.adapter.ViewPagerAdapter;
import com.wudayu.vcommunity.image.IImageHandler;
import com.wudayu.vcommunity.image.UILImageHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 5/5/15.
 */
public class LoginActivity extends BaseActivity {

    private ViewGroup layoutTitle;
    private ViewPager vpIdentity;
    private TextView tvName;
    private CheckBox cbRemPw;
    private Button btnForgetPassword;
    private Button btnRegisterImmediately;
    private Button btnLogin;

    ViewPagerAdapter pagerAdapter = null;
    IImageHandler imageHandler = null;

    @Override
    protected void initContainer() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initComponents() {
        layoutTitle = (ViewGroup) findViewById(R.id.layout_title);
        vpIdentity = (ViewPager) findViewById(R.id.vp_identity);
        tvName = (TextView) findViewById(R.id.tv_name);
        cbRemPw = (CheckBox) findViewById(R.id.cb_rem_pw);
        btnForgetPassword = (Button) findViewById(R.id.btn_forget_password);
        btnRegisterImmediately = (Button) findViewById(R.id.btn_register_immediately);
        btnLogin = (Button) findViewById(R.id.btn_login);

        pagerAdapter = new ViewPagerAdapter();
        imageHandler = UILImageHandler.getInstance(this);
    }

    @Override
    protected void initEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProcessingDialog(null, true, null);
            }
        });
    }

    @Override
    protected void initData() {
        // 设置layout_title背景
        layoutTitle.setBackgroundResource(R.color.col_app);

        // 设置参与滚动动画的页面个数
        vpIdentity.setOffscreenPageLimit(2);
        // 设置半个多页面显示
        int margin = getResources().getDimensionPixelSize(R.dimen.dp170);
        vpIdentity.setPageMargin(-margin);
        // 设置滚动透明动画
        vpIdentity.setPageTransformer(true, new DepthPageTransformer());
        // 绑定适配器
        vpIdentity.setAdapter(pagerAdapter);
    }

    @Override
    protected void afterAllSet() {
        addPagers();
    }

    /**
     * 添加身份选择ViewPager
     */
    private void addPagers() {
        String[] identities = getResources().getStringArray(R.array.identities);

        List<View> views = new ArrayList<View>();
        for (String data : identities) {
            views.add(addOneView(data));
        }
        pagerAdapter.removeAll();
        pagerAdapter.addAll(views);
    }

    private View addOneView(String data) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_login_identity_panel, null);
        ImageView ivAvatar = (ImageView) view.findViewById(R.id.iv_avatar);
        TextView tvIdentity = (TextView) view.findViewById(R.id.tv_identity);
        // 设置用户图片
        // 设置用户名
        tvIdentity.setText(getString(R.string.tv_identity_prefix) + data);

        return view;
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        public void transformPage(View view, float position) {
            if (position < 0) {
                ViewHelper.setAlpha(view, 1 + position);
            } else if (position == 0) {
                ViewHelper.setAlpha(view, 1);
            } else if (position <= 1) {
                ViewHelper.setAlpha(view, 1 - position);
            }
        }
    }

}
