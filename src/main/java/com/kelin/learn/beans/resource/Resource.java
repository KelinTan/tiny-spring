// Copyright 2018 Alo7 Inc. All rights reserved.
package com.kelin.learn.beans.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kelin on 2018/10/8.
 */
public interface Resource {


    InputStream getInputStream() throws IOException;

}
