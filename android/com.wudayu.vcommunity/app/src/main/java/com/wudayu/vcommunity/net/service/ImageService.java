package com.wudayu.vcommunity.net.service;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Query;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedFile;

import com.wudayu.vcommunity.model.TypedImage;
import com.wudayu.vcommunity.net.INetHandler;
import com.wudayu.vcommunity.net.protocol.VcListResult;
import com.wudayu.vcommunity.net.protocol.VcObjectResult;

import java.util.Map;

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

	/** Upload pictures or other files */
    /* Map method
    @Multipart
    @POST("/api/upload/file")
    void uploadMultiplePic(@PartMap Map<String, TypedImage> imageResources, Callback<VcListResult<String>> cb);
    */

    /* MultipartTypedOutput method */
    @POST("/api/upload/file")
    void uploadMultiplePic(@Body MultipartTypedOutput imageResources, Callback<VcListResult<String>> cb);
    /**/

}
