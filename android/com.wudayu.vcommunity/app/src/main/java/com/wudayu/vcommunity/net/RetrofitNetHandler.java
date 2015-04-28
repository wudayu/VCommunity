package com.wudayu.vcommunity.net;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.mime.MultipartTypedOutput;

import android.app.Activity;
import android.util.Base64;

import com.wudayu.vcommunity.R;
import com.wudayu.vcommunity.generic.Utils;
import com.wudayu.vcommunity.model.TypedImage;
import com.wudayu.vcommunity.model.VcTestUser;
import com.wudayu.vcommunity.model.VcUser;
import com.wudayu.vcommunity.net.converter.JacksonConverter;
import com.wudayu.vcommunity.net.protocol.VcListResult;
import com.wudayu.vcommunity.net.protocol.VcObjectResult;
import com.wudayu.vcommunity.net.protocol.WeatherResult;
import com.wudayu.vcommunity.net.service.ImageService;
import com.wudayu.vcommunity.net.service.UserService;
import com.wudayu.vcommunity.net.service.WeatherService;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Dec 9, 2014, 10:51:45 AM
 * @Description: RetrofitNetHandler是INetHandler的Retrofit实现，目前本项目仅打算使用Retrofit作为其网络访问框架
 *
 **/

public class RetrofitNetHandler implements INetHandler {

	RestAdapter weatherAdapter = null;
	RestAdapter generalAdapter = null;

	/** Generate the Singleton */
	private final static RetrofitNetHandler mNetHandler = new RetrofitNetHandler();

	private RetrofitNetHandler() {
		weatherAdapter = new RestAdapter.Builder().setEndpoint(SERVER_URL_WEATHER).setConverter(new JacksonConverter(JacksonConverter.TEXT_HTML_VALUE)).build();
		generalAdapter = new RestAdapter.Builder().setEndpoint(SERVER_URL_FOR_RETROFIT).setConverter(new JacksonConverter()).build();
	};

	public static INetHandler getInstance() {
		return mNetHandler;
	}

	public static void toastNetworkError(Activity activity, RetrofitError error) {
		if (error.getKind() == RetrofitError.Kind.NETWORK) {
			Utils.toastMessage(activity, activity.getString(R.string.error_cannot_connect_server));
		} else if (error.getKind() == RetrofitError.Kind.CONVERSION) {
			Utils.toastMessage(activity, activity.getString(R.string.error_data_format_wrong));
		} else if (error.getKind() == RetrofitError.Kind.HTTP) {
			Utils.toastMessage(activity, activity.getString(R.string.error_server_got_problems));
		} else {
			Utils.toastMessage(activity, activity.getString(R.string.error_unexpected_error));
		}
	}

	@Override
	public void getForWeather(String code, Callback<WeatherResult> cb) {
		weatherAdapter.create(WeatherService.class).getWeather(code, cb);
	}

	@Override
	public void getForUserInfo(String userId, Callback<VcObjectResult<VcUser>> cb) {
		generalAdapter.create(UserService.class).getUser(userId, "0", cb);
	}

    @Override
    public void getForGetTestUser(String userId, Callback<VcObjectResult<VcTestUser>> cb) {
        generalAdapter.create(UserService.class).getTestUser(userId, cb);
    }

    @Override
    public void postForUploadSinglePic(String imagePath, Callback<VcListResult<String>> cb) {
        postForUploadMultiplePic(new String[]{imagePath}, cb);
    }

    /**
     * postForUploadMultiplePic
     * It can use Map method and MultipartTypedOutput method
     * the different between these two methods is that
     * in Map method, the FILE_KEY of each file must be different
     *
     * @param imagePaths
     * @param cb
     */
    @Override
    public void postForUploadMultiplePic(String[] imagePaths, Callback<VcListResult<String>> cb) {
        /* Map method
        Map<String, TypedImage> typedImages = new HashMap<String, TypedImage>();
        for (String imagePath : imagePaths) {
            typedImages.put(INetHandler.UPLOAD_PIC_FILE_KEY + System.currentTimeMillis(), new TypedImage(imagePath));
        }

        // new TypedImage(imagePath) ==also=can=be==> new TypedFile("image/jpg", new File(imagePath)) and the "image/jpg"can also be "audio/mp3" and so on
        */
        /* MultipartTypedOutput method */
        MultipartTypedOutput typedImages = new MultipartTypedOutput();
        for (String imagePath : imagePaths) {
            typedImages.addPart(INetHandler.UPLOAD_PIC_FILE_KEY, new TypedImage(imagePath));
        }
        /**/

        generalAdapter.create(ImageService.class).uploadMultiplePic(typedImages, cb);
    }


	/**
	 * Interceptor used to authorize requests.
	 */
	public class AuthRequestInterceptor implements RequestInterceptor {

	    @Override
	    public void intercept(RequestFacade requestFacade) {

	        // if (user != null) {
	            final String authorizationValue = encodeCredentialsForBasicAuthorization();
	            requestFacade.addHeader("Authorization", authorizationValue);
	        //}
	    }

	    private String encodeCredentialsForBasicAuthorization() {
	    	final String username = "deadmin";
	    	final String password = "deadmin";
	        final String userAndPassword = username + ":" + password;
	        return "Basic " + Base64.encodeToString(userAndPassword.getBytes(), Base64.NO_WRAP);
	    }

	    /*
	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
	    */
	}
}
