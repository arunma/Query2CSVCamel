package com.arunma.dungeon.converters;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Arun
 */
public class HeaderProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        HashSet<String> set= (HashSet<String>) exchange.getIn().getHeader("CamelJdbcColumnNames");

        Map<String, Object> map = new HashMap<String, Object>();
        for (String string : set) {
            map.put(string, string);
        }

        exchange.getOut().setBody(map);

    }
}
