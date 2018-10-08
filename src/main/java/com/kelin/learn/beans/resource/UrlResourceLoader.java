// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.resource;

import java.net.URL;

/**
 * @author kelin on 2018/10/8.
 */
public class UrlResourceLoader implements ResourceLoader {


    @Override
    public Resource loadResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
