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
    @UriPath @Metadata(required = "true")
    private String name;
    @UriParam(defaultValue = "10")
    private int option = 10;

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

    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
