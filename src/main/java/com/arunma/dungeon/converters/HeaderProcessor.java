package com.arunma.dungeon.converters;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arun
 */
public class HeaderProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        //HashSet<String> set= (HashSet<String>) exchange.getIn().getHeader("CamelJdbcColumnNames");

        List<LinkedHashMap<String, Object>> allData = (List<LinkedHashMap<String, Object>>)exchange.getIn().getBody();

        if (allData.size()==0) return;

        LinkedHashMap<String,String> headerMap=new LinkedHashMap<String, String>();

        for (Map.Entry<String, Object> eachEntry : allData.get(0).entrySet()) {
            String headerKey=eachEntry.getKey();
            headerMap.put(headerKey,headerKey);
            System.out.println(headerKey);
        }

        exchange.getOut().setBody(headerMap);

    }
}
