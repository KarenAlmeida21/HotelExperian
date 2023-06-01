package com.serasa.experian.HotelExperian.CheckIns;

import com.serasa.experian.HotelExperian.Hospedes.HospedeModel;
import com.serasa.experian.HotelExperian.Hospedes.HospedeRepository;
import com.serasa.experian.HotelExperian.enums.EstadoHospede;
import com.serasa.experian.HotelExperian.exceptions.CheckInNaoEncontradoException;
import com.serasa.experian.HotelExperian.exceptions.HospedeNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        CheckInModel check = checkInRepository.save(checkInModel);

        return check;
    }

    public void marcaHospedeComoPresente(CheckInModel checkInModel) {
        checkInModel.getHospede().setEstadoHospede(EstadoHospede.PRESENTE);
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

    public CheckInModel buscaCheckInPorDocumentoHospede(String documentoHospede) {
        Optional<CheckInModel> checkInModelOptional = checkInRepository.findByHospedeDocumento(
                documentoHospede);
        if (checkInModelOptional.isEmpty()) {
            throw new CheckInNaoEncontradoException("Check-in não encontrado para o documento do hóspede: "
                    + documentoHospede);
        }
        return checkInModelOptional.get();
    }

    public List<CheckInModel> listaCheckInsComHospedesPresentes() {
        List<CheckInModel> checkIns = checkInRepository.findAll();

        return checkIns.stream()
                .filter(checkIn -> checkIn.getHospede().getEstadoHospede() == EstadoHospede.PRESENTE)
                .collect(Collectors.toList());
    }

    public CheckInModel buscaCheckInPorId(Long id) {
        Optional<CheckInModel> checkInModelOptional = checkInRepository.findById(id);
        if (checkInModelOptional.isEmpty()) {
            throw new CheckInNaoEncontradoException("Id não encontrado");
        }
        return checkInModelOptional.get();
    }

    public double calcularPrevisaoCustoHospedagem(CheckInModel checkInModel) {
        LocalDate dataEntrada = checkInModel.getDataDaHospedagem();
        LocalDate dataSaida = checkInModel.getPrevisaoDeSaida();

        long diasHospedagem = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        double valorDiaria = checkInModel.getDiaria().getValor();
        double valorDiariaTotal = valorDiaria * diasHospedagem;
        double valorGaragemDiaria = checkInModel.getVagaDeGaragem().getValor();
        double valorGaragemTotal = valorGaragemDiaria * diasHospedagem;
        double valorTotal = valorDiariaTotal + valorGaragemTotal;

        return valorTotal;
    }
}
