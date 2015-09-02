package com.inmobi.bizops;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

/**
 * Represents a CamelSalesForceCSV endpoint.
 */
@UriEndpoint(scheme = "sfcsv", title = "CamelSalesForceCSV", syntax="sfcsv:name",
        consumerClass = CamelSalesForceCSVConsumer.class, label = "CamelSalesForceCSV")
public class CamelSalesForceCSVEndpoint extends DefaultEndpoint {
    @UriPath(enums = "start,upload") @Metadata(required = "true")
    private String name;

    @UriParam(defaultValue = "1000")
    private int batchSize = 1000;

    @UriParam @Metadata(required = "true")
    private String object;

    public CamelSalesForceCSVEndpoint() {
    }

    public CamelSalesForceCSVEndpoint(String uri, CamelSalesForceCSVComponent component) {
        super(uri, component);
    }

    public CamelSalesForceCSVEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new CamelSalesForceCSVProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new CamelSalesForceCSVConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
