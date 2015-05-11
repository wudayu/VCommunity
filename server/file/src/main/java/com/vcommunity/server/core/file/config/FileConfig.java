package com.vcommunity.server.core.file.config;

import com.vcommunity.server.core.file.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author James Chow
 * @createdate 2015/5/11
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Configuration
public class FileConfig {
    @Value("${file.path}")
    private String filePath;

    @Bean
    public UploadUtils uploadUtil() {
        UploadUtils uploadUtils = new UploadUtils();
        uploadUtils.setFilePath(filePath);

        return uploadUtils;
    }

}
