package com.careerit.cbook.config;

import com.careerit.lutil.ConvertorUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ConvertorUtil convertorUtil() {
        return new ConvertorUtil();
    }
}
