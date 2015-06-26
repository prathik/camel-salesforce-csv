package com.inmobi.bizops;

import com.sforce.async.AsyncApiException;
import com.sforce.ws.ConnectionException;

import java.io.IOException;

/**
 * Created by prathik.raj on 15/12/14.
 */
public interface Uploader {
    void upload(String sobjectType, String fileName)
            throws AsyncApiException, ConnectionException, IOException;
    void setBatchSize(int batchSize);
}
