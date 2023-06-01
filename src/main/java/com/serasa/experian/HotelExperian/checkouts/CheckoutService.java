package com.serasa.experian.HotelExperian.checkouts;

import com.serasa.experian.HotelExperian.CheckIns.CheckInRepository;
import com.serasa.experian.HotelExperian.exceptions.CheckoutNãoEncontrado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    private CheckoutRepository checkoutRepository;

    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public CheckoutModel createCheckout(CheckoutModel checkoutModel) {
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





}
