package com.inmobi.bizops;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        System.out.println(exchange.getIn().getBody());
        exchange.getOut().setBody("Hello", String.class);
    }

}
