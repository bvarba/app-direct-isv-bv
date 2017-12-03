package com.bvarba.appdirect.web.client;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {
    private RestTemplate restTemplate;

    public RestTemplateFactory() {
        super();
    }

    // API

    @Override
    public RestTemplate getObject() {
        return restTemplate;
    }

    @Override
    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        restTemplate = new RestTemplate();
        final BasicOAuthInterceptor interceptor =  new BasicOAuthInterceptor(
                "Dummy",
        	     "secret");
        restTemplate.getInterceptors()
        .add(interceptor);
    }
}
