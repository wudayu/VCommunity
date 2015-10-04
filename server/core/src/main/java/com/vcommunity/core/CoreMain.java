package com.vcommunity.core;

import com.vcommunity.core.app.CoreApplication;
import org.springframework.boot.SpringApplication;

/**
 * @author James
 * @since V1.0
 */
public class CoreMain {
    public static void main(String[] args) {
        new SpringApplication(CoreApplication.class).run(args);
    }
}
