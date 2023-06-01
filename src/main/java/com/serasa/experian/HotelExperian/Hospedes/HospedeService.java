package com.serasa.experian.HotelExperian.Hospedes;

import org.springframework.stereotype.Service;

@Service
public class HospedeService {

    private HospedeRepository hospedeRepository;

    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }



    
}
