package com.myhome.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonConfig {
    @Value("${cs.images.path}") public String imagesPath;

    public String getImagesPath() {
        return imagesPath;
    }
}
