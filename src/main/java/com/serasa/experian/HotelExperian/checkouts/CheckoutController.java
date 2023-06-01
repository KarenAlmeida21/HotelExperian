package com.serasa.experian.HotelExperian.checkouts;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {
    private CheckoutService checkoutService;
    private ModelMapper modelMapper;

    public CheckoutController(CheckoutService checkoutService, ModelMapper modelMapper) {
        this.checkoutService = checkoutService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/realiza-checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckoutModel realizaChecout(@RequestBody CheckoutDTO checkoutDTO) {
        CheckoutModel checkout = modelMapper.map(checkoutDTO, CheckoutModel.class);

        return checkoutService.createCheckout(checkout);

    }

    @DeleteMapping("/deleta-checkout/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaCheckout(@PathVariable Long id) {
        checkoutService.deletaCheckout(id);
    }

    @GetMapping("/listar-checkouts")
    public List<CheckoutDTO> checkoutsList() {
        List<CheckoutDTO> checkoutDTOList = new ArrayList<>();
        for (CheckoutModel checkReferencia : checkoutService.listarCheckouts()) {
            CheckoutDTO checkoutDTO = modelMapper.map(checkReferencia, CheckoutDTO.class);
            checkoutDTOList.add(checkoutDTO);
        }
        return checkoutDTOList;
    }

    @GetMapping("/documento-hospede/{documento}")
    public List<CheckoutModel> listarCheckoutsPorDocumentoHospede(@PathVariable String documento) {
        return checkoutService.listarCheckoutsPorDocumentoHospede(documento);
    }
}
