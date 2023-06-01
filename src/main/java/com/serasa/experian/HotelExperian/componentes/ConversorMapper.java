package com.serasa.experian.HotelExperian.componentes;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConversorMapper {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
