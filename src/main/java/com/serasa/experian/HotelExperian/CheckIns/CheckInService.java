package com.serasa.experian.HotelExperian.CheckIns;

import com.serasa.experian.HotelExperian.Hospedes.HospedeModel;
import com.serasa.experian.HotelExperian.Hospedes.HospedeRepository;
import com.serasa.experian.HotelExperian.enums.EstadoHospede;
import com.serasa.experian.HotelExperian.exceptions.CheckInNaoEncontradoException;
import com.serasa.experian.HotelExperian.exceptions.HospedeNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;
    @Autowired
    private HospedeRepository hospedeRepository;

    public CheckInModel createCheckIn(CheckInModel checkInModel, HospedeModel hospedeModel) {
        HospedeModel hospede = hospedeRepository.findById(hospedeModel.getId())
                .orElseThrow(() -> new HospedeNaoEncontradoException("Hóspede não encontrado"));

        checkInModel.setHospede(hospede);
        marcaHospedeComoPresente(checkInModel);
        return checkInRepository.save(checkInModel);
    }

    public void marcaHospedeComoPresente(CheckInModel checkInModel) {
        checkInModel.getHospede().setEstadoHospede(EstadoHospede.AUSENTE);
    }

    public void marcaHospedeComoAusente(CheckInModel checkInModel) {
        checkInModel.getHospede().setEstadoHospede(EstadoHospede.AUSENTE);
    }

    public List<CheckInModel> listarCheckIns() {
        List<CheckInModel> checkInModelList = (List<CheckInModel>) checkInRepository.findAll();
        if (checkInModelList.isEmpty()) {
            throw new CheckInNaoEncontradoException("Não há check-ins cadastrados");
        }
        return checkInModelList;
    }
}
