package com.bvarba.appdirect.web.client;

import java.io.IOException;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.http.HttpRequest;  
import org.springframework.http.client.ClientHttpRequestExecution;  
import org.springframework.http.client.ClientHttpRequestInterceptor;  
import org.springframework.http.client.ClientHttpResponse;

import com.sun.jersey.oauth.signature.HMAC_SHA1;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthRequest;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;

public class BasicOAuthInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger( BasicOAuthInterceptor.class );

    private final String consumerKey;
    private final String consumerSecret;

    public BasicOAuthInterceptor( String consumerKey, String consummerSecret ) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consummerSecret;
    }

    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {
    	try {
	        OAuthRequest oauthReq = new HttpOAuthRequestImpl(request);	        
	        OAuthParameters oauthParams = new OAuthParameters();
	        oauthParams.consumerKey(consumerKey);
	        oauthParams.setSignatureMethod(new HMAC_SHA1().name());
	        oauthParams.setNonce();
	        oauthParams.setTimestamp();
	        oauthParams.setVersion();
	        OAuthSecrets oauthSecrets = new OAuthSecrets();
	        oauthSecrets.consumerSecret(consumerSecret);
	        OAuthSignature.sign(oauthReq, oauthParams, oauthSecrets);
        } catch (OAuthSignatureException e) {
        	logger.error("Error signing request...", e);
        	throw new IOException("Error signing request...");
        }
        logger.debug("Successfully signed request!");

        return execution.execute(request, body);
    }

    private String mask( String toMask ) {
        return toMask.replaceAll( ".", "*" );
    }
}
