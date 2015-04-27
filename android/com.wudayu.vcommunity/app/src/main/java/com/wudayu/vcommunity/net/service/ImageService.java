package com.wudayu.vcommunity.net.service;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Query;

import com.wudayu.vcommunity.model.TypedImage;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.protocol.VcListResult;
import com.wudayu.vcommunity.net.protocol.VcObjectResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Dec 10, 2014, 3:47:03 PM
 * @Description: ImageService是用来向上传图片的Retrofit的Service
 *
 **/

public interface ImageService {
	/** Upload Picture */
	@Multipart
	@POST("/rest/broker/updateBrokerPic")
	void uploadPic(@Query("id") String relationId, @Part(INetHandler.UPLOAD_PIC_FILE_KEY) TypedImage imageResource, Callback<VcObjectResult<String>> cb);

    // TODO remove this
    @Multipart
    @POST("/api/upload/file")
    void uploadTestPic(@Part(INetHandler.UPLOAD_PIC_FILE_KEY) TypedImage imageResource, Callback<VcObjectResult<String>> cb);

    @Multipart
    @POST("/api/upload/file")
//    void uploadTestMultiPic(@Part(INetHandler.UPLOAD_PIC_FILE_KEY) TypedImage imageResource, @Part(INetHandler.UPLOAD_PIC_FILE_KEY) TypedImage imageResource2, Callback<VcListResult<String>> cb);
    void uploadTestMultiPic(@Part(INetHandler.UPLOAD_PIC_FILE_KEY) TypedImage[] imageResources, Callback<VcListResult<String>> cb);
}
