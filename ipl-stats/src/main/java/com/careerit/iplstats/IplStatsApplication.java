package com.careerit.iplstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class IplStatsApplication {

    @Autowired
    private ConfigurableEnvironment env;

    public static void main(String[] args) {
		SpringApplication.run(IplStatsApplication.class, args);
	}

}
