package com.serasa.experian.HotelExperian.checkouts;

import com.serasa.experian.HotelExperian.CheckIns.CheckInModel;
import com.serasa.experian.HotelExperian.CheckIns.CheckInRepository;
import com.serasa.experian.HotelExperian.exceptions.CheckoutNãoEncontrado;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    private CheckoutRepository checkoutRepository;

    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public CheckoutModel createCheckout(CheckoutModel checkoutModel, @RequestParam("dataSaida") LocalDateTime dataSaida) {
        checkoutModel.setDataDaSaida(dataSaida);
        return checkoutRepository.save(checkoutModel);
    }


    public void deletaCheckout(Long id) {
        CheckoutModel checkoutModel = buscaCheckoutPorId(id);
        checkoutRepository.deleteById(id);
    }

    public List<CheckoutModel> listarCheckouts() {
        List<CheckoutModel> checkoutModelList = (List<CheckoutModel>) checkoutRepository.findAll();
        if (checkoutModelList.isEmpty()) {
            throw new CheckoutNãoEncontrado("Não há checkouts cadastrados");
        }
        return checkoutModelList;
    }

    public CheckoutModel buscaCheckoutPorId(Long id) {

        Optional<CheckoutModel> checkoutModelOptional = checkoutRepository.findById(id);
        if (checkoutModelOptional.isEmpty()) {
            throw new CheckoutNãoEncontrado("Id não encontrado");
        }
        return checkoutModelOptional.get();
    }

    public List<CheckoutModel> listarCheckoutsPorDocumentoHospede(String documento) {
        List<CheckoutModel> checkouts = checkoutRepository.findByCheckInHospedeDocumento(documento);

        if (checkouts.isEmpty()) {
            throw new CheckoutNãoEncontrado("Nenhum checkout encontrado para o documento do hóspede: " + documento);
        }

        return checkouts;
    }


    public Double calcularPrevisaoCustoHospedagem(CheckoutModel checkoutModel) {
        CheckInModel checkIn = checkoutModel.getCheckIn();
        LocalDate dataEntrada = checkIn.getDataDaHospedagem();

        long diasHospedagem = ChronoUnit.DAYS.between(dataEntrada, checkoutModel.getDataDaSaida());
        double valorDiaria = checkIn.getDiaria().getValor();
        double valorDiariaTotal = valorDiaria * diasHospedagem;
        double valorGaragemDiaria = checkIn.getVagaDeGaragem().getValor();
        double valorGaragemTotal = valorGaragemDiaria * diasHospedagem;
        Double valorDaHospedagem = valorDiariaTotal + valorGaragemTotal;

        return valorDaHospedagem;
    }



}
