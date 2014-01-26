package org.zezutom.springseries0114.part03.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

@Configuration
public class SeatProvider implements Provider<Seat> {

    @Override
    @Bean
    @Scope(value = "prototype")
    public Seat get() {
        return new Seat();
    }
}
