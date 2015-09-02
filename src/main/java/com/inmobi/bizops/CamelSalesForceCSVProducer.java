package com.inmobi.bizops;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * The CamelSalesForceCSV producer.
 */
public class CamelSalesForceCSVProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(CamelSalesForceCSVProducer.class);
    private CamelSalesForceCSVEndpoint endpoint;

    public CamelSalesForceCSVProducer(CamelSalesForceCSVEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        LOG.info("Begin Salesforce Upload");
        Uploader csvUploader = new BulkUploader();
        csvUploader.setBatchSize(endpoint.getBatchSize());
        csvUploader.upload(endpoint.getObject(), (InputStream) exchange.getIn().getBody());
        exchange.getOut().setBody(endpoint.getObject() + " " + endpoint.getBatchSize(), String.class);
    }

}
