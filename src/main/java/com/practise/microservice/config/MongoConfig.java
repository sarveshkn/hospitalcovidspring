package com.practise.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Autowired
	private Environment env;
	
	@Value( "${mongo.host}" )
	private String host;
	
	@Value( "${mongo.port}" )
	private String port;

	public @Bean MongoClient mongoClient() {
		System.out.print("port " + port + " ," + " host + " + this.host + " local host" + host);
		String mongoUri = "mongodb://" + host + ":" + port;
		return MongoClients.create(mongoUri);
	}

	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "covid-hospital-details");
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties(){
	    PropertySourcesPlaceholderConfigurer pspc
	      = new PropertySourcesPlaceholderConfigurer();
	    Resource[] resources = new ClassPathResource[ ]
	      { new ClassPathResource( "mongo.properties" ) };
	    pspc.setLocations( resources );
	    pspc.setIgnoreUnresolvablePlaceholders( true );
	    return pspc;
	}

}
