package com.careerit.iplstats.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "openai")
@Configuration
public class OpenAIConfiguration {
        private String apiKey;
        private String baseUrl;

    @Override
    public String toString() {

    return "OpenAIConfiguration{" +
                "apiKey='" + apiKey + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                '}';
    }
}
