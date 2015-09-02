package com.inmobi.bizops;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.ScheduledPollConsumer;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * The CamelSalesForceCSV consumer.
 */
public class CamelSalesForceCSVConsumer extends ScheduledPollConsumer {
    private final CamelSalesForceCSVEndpoint endpoint;

    public CamelSalesForceCSVConsumer(CamelSalesForceCSVEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
        this.endpoint = endpoint;
    }

    @Override
    protected int poll() throws Exception {
        Exchange exchange = endpoint.createExchange();

        InputStream data = new FileInputStream("src/test/test.csv");
        exchange.getIn().setBody(data, InputStream.class);

        try {
            // send message to next processor in the route
            getProcessor().process(exchange);
            return 1; // number of messages polled
        } finally {
            // log exception if an exception occurred and was not handled
            if (exchange.getException() != null) {
                getExceptionHandler().handleException("Error processing exchange", exchange, exchange.getException());
            }
        }
    }
}
