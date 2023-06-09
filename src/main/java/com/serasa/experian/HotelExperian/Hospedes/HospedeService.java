package com.serasa.experian.HotelExperian.Hospedes;

import com.serasa.experian.HotelExperian.CheckIns.CheckInRepository;
import com.serasa.experian.HotelExperian.exceptions.HospedeErrorException;
import com.serasa.experian.HotelExperian.exceptions.HospedeJaCadastradoException;
import com.serasa.experian.HotelExperian.exceptions.HospedeNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    private HospedeRepository hospedeRepository;
    private CheckInRepository checkInRepository;

    public HospedeService(HospedeRepository hospedeRepository, CheckInRepository checkInRepository) {
        this.hospedeRepository = hospedeRepository;
        this.checkInRepository = checkInRepository;
    }


    public HospedeModel cadastraHospede(HospedeModel hospede) {
        verificaHospedePorNome(hospede.getNomeHospede());
        verificaDocumentoHospede(hospede.getDocumento());
        verificaHospedePorTelefone(hospede.getTelefone());

        return hospedeRepository.save(hospede);
    }

    public void verificaHospedePorNome(String nome) {
        if (hospedeRepository.existsByNomeHospede(nome)) {
            throw new HospedeJaCadastradoException("Hospede com o mesmo nome já cadastrado.");
        }
    }

    public void verificaHospedePorTelefone(String telefone) {
        if (hospedeRepository.existsByTelefone(telefone)) {
            throw new HospedeJaCadastradoException("Hóspede com o mesmo telefone já cadastrado.");
        }
    }


    public void verificaDocumentoHospede(String documento) {
        if (hospedeRepository.existsByDocumento(documento)) {
            throw new HospedeJaCadastradoException("Hóspede com o mesmo documento já cadastrado.");
        }
    }


    public List<HospedeModel> exibirTodosHospede() {
        List<HospedeModel> hospedeList = hospedeRepository.findAll();
        if (hospedeList.isEmpty()) {
            throw new HospedeNaoEncontradoException("Não Há hospede cadastrados");
        }
        return hospedeList;
    }

    public void deletaHospede(String documento) {
        Optional<HospedeModel> hospedeOptional = hospedeRepository.findByDocumento(documento);
        if (hospedeOptional.isEmpty()) {
            throw new HospedeNaoEncontradoException("Documento não encontrado");
        }
        if (checkInRepository.existsByHospedeDocumento(documento)) {
            throw new HospedeErrorException("Este hospede está vinculado a um check-in. Verifique");

        }
        HospedeModel hospede = hospedeOptional.get();
        hospedeRepository.delete(hospede);
    }


    public HospedeModel buscaHospedePorDocumento(String documento) {
        return hospedeRepository.findByDocumento(documento)
                .orElseThrow(() -> new HospedeNaoEncontradoException("Documento não encontrado"));
    }


    public HospedeModel atualizaHospede(String documento, HospedeDTO hospedeDTO) {
        HospedeModel hospede = buscaHospedePorDocumento(documento);
        hospede.setEnderecoHospede(hospedeDTO.getEnderecoHospede());
        hospede.setNomeHospede(hospedeDTO.getNomeHospede());
        hospede.setIdade(hospedeDTO.getIdade());
        hospede.setDocumento(hospedeDTO.getDocumento());
        hospede.setTelefone(hospedeDTO.getTelefone());

        return hospedeRepository.save(hospede);
    }


}
