package eu.universome.radio.RadioUVM;

import static ch.qos.logback.classic.Level.WARN;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
//https://stackoverflow.com/questions/22955621/error-type-list-does-not-take-parameters


//import org.springframework.http.HttpEntity;



public class RadioUvmClientApplication {
    /*
    public static void main(String[] args) throws URISyntaxException {    
        
           
            
            
            JSONObject show = shows.getJSONObject(0);
            String show_id = String.valueOf(show.get("show_id"));
            System.out.println("The Show: " + show.toString(4)); 
            System.out.println("Show ID: " + show_id);
            
            JSONArray episodes = grabber.getUserEpisodes(show_id);
            JSONObject episode = episodes.getJSONObject(0);
            String playback_url = String.valueOf(episode.get("playback_url"));
            System.out.println("Episode: " + episode.toString(4));
            System.out.println("Episode URL: " + playback_url);
        
    }*/
}
/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RadioUvmApplication {
    
        private static final Logger log = LoggerFactory.getLogger(RadioUvmApplication.class);
        
	public static void main(String[] args) {
		SpringApplication.run(RadioUvmApplication.class, args);
	}
        
        @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
        
        @Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://quoters.apps.pcfone.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}

}
*/

