package com.vcommunity.android.config;

import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ResourceLoader;

public class BootApplication extends SpringApplication {

    public BootApplication(Object... sources) {
        super(sources);
        this.addListeners(new ConfigInitListener());
    }

    public BootApplication(ResourceLoader resourceLoader, Object... sources) {
        super(resourceLoader, sources);
        this.addListeners(new ConfigInitListener());
    }

}