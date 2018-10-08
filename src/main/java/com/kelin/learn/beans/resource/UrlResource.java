// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author kelin on 2018/10/8.
 */
public class UrlResource implements Resource {


    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return url.openStream();
    }
}
