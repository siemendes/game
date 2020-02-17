package com.sm.serenity.game.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {
    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigurer() {

        PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
        propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);

        return propertyConfigurer;
    }
}