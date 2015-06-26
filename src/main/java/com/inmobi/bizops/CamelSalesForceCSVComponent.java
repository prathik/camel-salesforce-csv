package com.inmobi.bizops;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;

import org.apache.camel.impl.UriEndpointComponent;

/**
 * Represents the component that manages {@link CamelSalesForceCSVEndpoint}.
 */
public class CamelSalesForceCSVComponent extends UriEndpointComponent {
    
    public CamelSalesForceCSVComponent() {
        super(CamelSalesForceCSVEndpoint.class);
    }

    public CamelSalesForceCSVComponent(CamelContext context) {
        super(context, CamelSalesForceCSVEndpoint.class);
    }

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new CamelSalesForceCSVEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
