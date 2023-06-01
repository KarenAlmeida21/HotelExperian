package com.serasa.experian.HotelExperian.Hospedes;

import org.springframework.stereotype.Service;

@Service
public class HospedeService {

    private HospedeRepository hospedeRepository;

    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }

    public HospedeModel cadastraHospede(HospedeModel hospede) {
        verificaHospedePorNome(hospede.getNomeHospede());
        verificaDocumentoHospede(hospede.getDocumento());

        return hospedeRepository.save(hospede);
    }

    public void verificaHospedePorNome(String nome) {
        if (hospedeRepository.existsByNomeHospede(nome)) {
            throw new HospedeException("Hospede com o mesmo nome já cadastrado.");
        }
    }

    public void verificaDocumentoHospede(String documento) {
        if (hospedeRepository.existsByDocumento(documento)) {
            throw new HospedeException("Hóspede com o mesmo documento já cadastrado.");
        }
    }



}
