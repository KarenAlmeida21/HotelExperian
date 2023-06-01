package com.serasa.experian.HotelExperian.Hospedes;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeModel cadastrarHospede(@RequestBody HospedeDTO hospedeDTO) {
        HospedeModel novoHospede = modelMapper.map(hospedeDTO, HospedeModel.class);
        return hospedeService.cadastraHospede(novoHospede);
    }

    @Transactional
    @GetMapping("/listar-hospedes")
    public List<HospedeDTO> exibirHospedeList() {
        List<HospedeDTO> hospedesList = new ArrayList<>();
        for (HospedeModel hospedeReferencia : hospedeService.exibirTodosHospede()) {
            HospedeDTO hospedeDTO = modelMapper.map(hospedeReferencia, HospedeDTO.class);
            hospedesList.add(hospedeDTO);
        }
        return hospedesList;
    }

    @DeleteMapping("/{documento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaHospede(@PathVariable String documento) {
        hospedeService.deletaHospede(documento);

    }




}
