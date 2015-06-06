package com.vcommunity.android;

import com.vcommunity.android.config.BootApplication;
import com.vcommunity.android.config.CoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author James Chow
 * @createdate 2015/5/10
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
public class AndroidApplication {
    public static void main(String[] args) {
        new BootApplication(CoreApplication.class).run(args);
    }

}
