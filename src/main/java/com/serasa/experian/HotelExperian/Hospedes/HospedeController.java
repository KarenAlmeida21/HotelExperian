package com.serasa.experian.HotelExperian.Hospedes;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    private HospedeService hospedeService;
    private ModelMapper modelMapper;

    public HospedeController(HospedeService hospedeService, ModelMapper modelMapper) {
        this.hospedeService = hospedeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/cadastrar-hospede")
    public HospedeModel cadastrarHospede(HospedeDTO hospedeDTO) {
        HospedeModel novoHospede = modelMapper.map(hospedeDTO, HospedeModel.class);
        return hospedeService.cadastraHospede(novoHospede);
    }


}
