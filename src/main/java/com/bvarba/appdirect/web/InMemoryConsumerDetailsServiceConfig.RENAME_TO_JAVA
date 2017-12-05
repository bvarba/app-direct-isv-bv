package com.bvarba.appdirect.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.provider.BaseConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetailsService;
import org.springframework.security.oauth.provider.InMemoryConsumerDetailsService;
import org.springframework.stereotype.Component;

import com.bvarba.appdirect.AppDirectConfig;

@Component
public class InMemoryConsumerDetailsServiceConfig {

  @Autowired
  private AppDirectConfig appDirectConfig;

  @Bean
  public ConsumerDetailsService createInMemoryConsumerDetailsService() {
    Map<String, ConsumerDetails> consumerDetailsStore = new HashMap<>();
    ConsumerDetails consumerDetails = createConsumerDetails();
    consumerDetailsStore.put(consumerDetails.getConsumerKey(), consumerDetails);

    InMemoryConsumerDetailsService consumerDetailsService = new InMemoryConsumerDetailsService();
    consumerDetailsService.setConsumerDetailsStore(consumerDetailsStore);

    return consumerDetailsService;
  }

  private ConsumerDetails createConsumerDetails() {
    BaseConsumerDetails consumerDetails = new BaseConsumerDetails();
    consumerDetails.setConsumerKey(appDirectConfig.getAppKey());
    consumerDetails.setSignatureSecret(new SharedConsumerSecretImpl(appDirectConfig.getAppSecret()));
    consumerDetails.setRequiredToObtainAuthenticatedToken(false);
    return consumerDetails;
  }

}
