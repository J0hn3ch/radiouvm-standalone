/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.universome.radio.RadioUVM;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.ssl.TLS;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author gianluca
 */
public class Grabber {
    
    private final HttpClientConnectionManager cm;
    private final HttpClientContext clientContext;
    private CloseableHttpClient httpclient;
    
    // Grabber Constructor
    public Grabber() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException{
        // SSL Configuration
        // Trust standard CA and those trusted by our custom strategy
        final SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(new TrustStrategy() {
                    @Override
                    public boolean isTrusted(
                            final X509Certificate[] chain,
                            final String authType) throws CertificateException {
                        final X509Certificate cert = chain[0];
                        return "CN=spreaker.com".equalsIgnoreCase(cert.getSubjectDN().getName());
                    }
                })
                .build();
        
        // Allow TLSv1.2 protocol only
        final SSLConnectionSocketFactory sslSocketFactory = SSLConnectionSocketFactoryBuilder.create()
                .setSslContext(sslcontext)
                .setTlsVersions(TLS.V_1_2)
                .build();
        this.cm = PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslSocketFactory)
                .build();
        
        this.httpclient = HttpClients.custom()
                .setConnectionManager(this.cm)
                .build();
        
        this.clientContext = HttpClientContext.create();
        
    }
    
    public JSONObject getUserInfo() throws URISyntaxException{
        try {
            // User Info URI Request
            final HttpGet httpget = new HttpGet("https://api.spreaker.com/v2/users/8497168");
            System.out.println("Request User Info" + httpget.getMethod() + " " + httpget.getUri());
            
            // commentare
            try (CloseableHttpResponse response = httpclient.execute(httpget, clientContext)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
                JSONObject jsonResponse = json.getJSONObject("response");
                System.out.println(json);
                this.endRequest();
                return jsonResponse;
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
            return null;
        }
    }
    
    public JSONArray getUserShows() throws URISyntaxException{
        try {
            // User Info URI Request
            final HttpGet httpget = new HttpGet("https://api.spreaker.com/v2/users/8497168/shows?limit=3");
            System.out.println("Request User Shows" + httpget.getMethod() + " " + httpget.getUri());
            String show_id = "";
            try (CloseableHttpResponse response = httpclient.execute(httpget, clientContext)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                
                // JSON Parsing to grab Shows Info
                JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
                JSONObject jsonResponse = json.getJSONObject("response");
                JSONArray shows = jsonResponse.getJSONArray("items");
                
                this.endRequest();
                return shows;
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
            return null;
        }
    }
    
    public JSONArray getShowEpisodes(String show_id) throws URISyntaxException{
        try {
            // User Info URI Request
            final HttpGet httpget = new HttpGet("https://api.spreaker.com/v2/shows/"+ show_id + "/episodes?limit=3");
            System.out.println("Request Show Episodes" + httpget.getMethod() + " " + httpget.getUri());
            String playback_url = "";
            try (CloseableHttpResponse response = httpclient.execute(httpget, clientContext)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                
                // JSON Parsing to grab Episode Info
                JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
                JSONObject jsonResponse = json.getJSONObject("response");
                JSONArray episodes = jsonResponse.getJSONArray("items");
                
                this.endRequest();
                
                return episodes;
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
            return null;
        }
    }
    
    public JSONObject getEpisodeInfo(String episode_id) throws URISyntaxException{
        try {
            // User Info URI Request
            final HttpGet httpget = new HttpGet("https://api.spreaker.com/v2/episodes/"+ episode_id);
            System.out.println("Request Episode Info" + httpget.getMethod() + " " + httpget.getUri());
            String playback_url = "";
            try (CloseableHttpResponse response = httpclient.execute(httpget, clientContext)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                
                // JSON Parsing to grab Episode Info
                JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
                JSONObject jsonResponse = json.getJSONObject("response");
                JSONObject episode = jsonResponse.getJSONObject("episode");
                
                this.endRequest();
                
                return episode;
            }
            
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
            return null;
        }
    }
    
    public void endRequest(){
        final SSLSession sslSession = clientContext.getSSLSession();
                if (sslSession != null) {
                    System.out.println("SSL protocol " + sslSession.getProtocol());
                    System.out.println("SSL cipher suite " + sslSession.getCipherSuite());
                }
    }
}
