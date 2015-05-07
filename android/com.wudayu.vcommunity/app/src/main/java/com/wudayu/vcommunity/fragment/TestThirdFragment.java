package com.wudayu.vcommunity.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.constant.ImageLoaderHelper;
import com.wudayu.vcommunity.constant.ReqCode;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.image.IImageHandler;
import com.wudayu.vcommunity.image.UILImageHandler;
import com.wudayu.vcommunity.model.VcUser;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.RetrofitNetHandler;
import com.wudayu.vcommunity.net.protocol.VcListResult;
import com.wudayu.vcommunity.net.protocol.VcObjectResult;
import com.wudayu.vcommunity.views.ProcessingDialog;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:55:48 PM
 * @Description: Test Fragment No.3
 *
 **/

public class TestThirdFragment extends BaseFragment {

	public static final String CURR_USER_ID = "4fef1bb5822e47ca9453443f7fa4820c";

	ImageView ivHeader = null;

	IImageHandler imageHandler = null;
	INetHandler netHandler = null;

	String takePicturePath = null;
	String cuttedImagePath = null;
	List<String> filePathes = new ArrayList<String>();
	String uploadedUUid = null;
	int currPicIndex = -1;

	VcUser currUser = null;

	@Override
	protected View initContainer(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_test_third, null);
	}

	@Override
	protected void initComponents(View fragView) {
		ivHeader = (ImageView) fragView.findViewById(R.id.iv_header);

		imageHandler = UILImageHandler.getInstance(getActivity());
		netHandler = RetrofitNetHandler.getInstance();
	}

	@Override
	protected void initEvents() {
		ivHeader.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				takePicturePath = imageHandler.getNewTmpImagePath();
				imageHandler.selectGetImageWay(TestThirdFragment.this.getActivity(), ivHeader, takePicturePath);
			}
		});
	}

	@Override
	protected void initData() {
	}

	@Override
	protected void afterAllSet() {
        /*
		processingDialog = new ProcessingDialog(this.getActivity(), true, null);
		processingDialog.show();

		netHandler.getForUserInfo(CURR_USER_ID, new Callback<VcObjectResult<VcUser>>() {
			@Override
			public void success(VcObjectResult<VcUser> result, Response response) {
				Utils.debug("result = " + result);
				imageHandler.loadHeaderImage(result.isSuccess() ? result.getObject().getPhotosrc() : "", ivHeader);
				dismissProcessingDialog();
			}
			@Override
			public void failure(RetrofitError error) {
				RetrofitNetHandler.toastNetworkError(TestThirdFragment.this.getActivity(), error);
				dismissProcessingDialog();
			}
		});
		*/
	}

	public void cutTheImage(Uri uri) {
		cuttedImagePath = imageHandler.getNewTmpImagePath();
		imageHandler.cutTheImageHead(this.getActivity(), uri, cuttedImagePath);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			if (resultCode == Activity.RESULT_OK) {
				switch (requestCode) {
				// 如果是直接从相册获取
				case ReqCode.ALBUM:
					cutTheImage(data.getData());
					break;
				// 如果是调用相机拍照时
				case ReqCode.CAMERA:
					cutTheImage(Uri.fromFile(new File(takePicturePath)));
					break;
				// 取得裁剪后的图片
				case ReqCode.CUTTED:
					setPicToView(cuttedImagePath);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setPicToView(String cuttedImagePath) {
		String compressedPath = imageHandler.compressImage(cuttedImagePath);
		imageHandler.loadHeaderImage(ImageLoaderHelper.URI_PREFIX_FILE + compressedPath, ivHeader);
		++currPicIndex;
		filePathes.add(compressedPath);

		uploadPic(compressedPath);
	}

	void uploadPic(String filePath) {
		processingDialog = new ProcessingDialog(this.getActivity(), "Uploading ...", false, null);
		processingDialog.show();
        /*
		netHandler.postForUploadPic(CURR_USER_ID, filePath, new Callback<VcObjectResult<String>>() {
			@Override
			public void success(VcObjectResult<String> result, Response response) {
				uploadedUUid = result.getObject();
				dismissProcessingDialog();
			}
			@Override
			public void failure(RetrofitError error) {
				RetrofitNetHandler.toastNetworkError(TestThirdFragment.this.getActivity(), error);
                Utils.debug("error = " + error);
				dismissProcessingDialog();
			}
		});
		*/
        /*
        netHandler.postForUploadTestPic(filePath, new Callback<VcListResult<String>>() {
            @Override
            public void success(VcListResult<String> result, Response response) {
                // uploadedUUid = result.getObject();
                Utils.debug("uploadedUUids = " + result.getList());
                Utils.debug("UUids.size = " + result.getList().size());
                dismissProcessingDialog();
            }

            @Override
            public void failure(RetrofitError error) {
                RetrofitNetHandler.toastNetworkError(TestThirdFragment.this.getActivity(), error);
                Utils.debug("error = " + error);
                dismissProcessingDialog();
            }
        });
        */
        netHandler.postForUploadSinglePic(filePath, new Callback<VcListResult<String>>() {
            @Override
            public void success(VcListResult<String> result, Response response) {
                // uploadedUUid = result.getObject();
                Utils.debug("uploadedUUids = " + result.getList());
                Utils.debug("UUids.size = " + result.getList().size());
                dismissProcessingDialog();
            }

            @Override
            public void failure(RetrofitError error) {
                RetrofitNetHandler.toastNetworkError(TestThirdFragment.this.getActivity(), error);
                Utils.debug("error = " + error);
                dismissProcessingDialog();
            }
        });
	}

}
