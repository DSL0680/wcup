package org.zerock.wcup.config;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class RootConfig {

    @Bean
    public ModelMapper modelMapper(){
        log.info("modelMapper...............");
        return new ModelMapper();
    }

}
