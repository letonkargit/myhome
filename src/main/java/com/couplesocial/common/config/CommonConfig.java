package com.couplesocial.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonConfig {
    @Value("${cs.images.path.profilepic}") public String profileImagesPath;
    @Value("${cs.images.path.location}") public String locationImage;

    public String getProfileImagesPath() {
        return profileImagesPath;
    }

    public String getLocationImage() {
        return locationImage;
    }
}
