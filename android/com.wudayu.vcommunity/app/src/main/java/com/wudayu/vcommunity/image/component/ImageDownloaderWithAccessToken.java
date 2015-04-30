package com.wudayu.vcommunity.image.component;

import android.content.Context;
import android.net.Uri;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by David on 4/29/15.
 */

public class ImageDownloaderWithAccessToken extends BaseImageDownloader {

    public ImageDownloaderWithAccessToken(Context context) {
        super(context);
    }

    public ImageDownloaderWithAccessToken(Context context, int connectTimeout, int readTimeout) {
        super(context, connectTimeout, readTimeout);
    }

    protected HttpURLConnection createConnection(String url, Object extra) throws IOException {
        String encodedUrl = Uri.encode(url, ALLOWED_URI_CHARS);
        HttpURLConnection conn = (HttpURLConnection) new URL(encodedUrl).openConnection();
        // conn.setRequestProperty("AccessToken", DirectoryConfiguration.getAccessToken(context));
        conn.setConnectTimeout(connectTimeout);
        conn.setReadTimeout(readTimeout);
        return conn;
    }

}