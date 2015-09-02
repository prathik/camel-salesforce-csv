package com.inmobi.bizops;

import com.sforce.async.AsyncApiException;
import com.sforce.ws.ConnectionException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by prathik.raj on 15/12/14.
 */
public interface Uploader {
    void upload(String sobjectType, String fileName)
            throws AsyncApiException, ConnectionException, IOException;
    void upload(String sobjectType, InputStream in)
            throws AsyncApiException, ConnectionException, IOException;
    void setBatchSize(int batchSize);
}
