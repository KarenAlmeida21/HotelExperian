package com.serasa.experian.HotelExperian.CheckIns;

import com.serasa.experian.HotelExperian.Hospedes.HospedeModel;
import com.serasa.experian.HotelExperian.enums.Diaria;
import com.serasa.experian.HotelExperian.enums.Quarto;
import com.serasa.experian.HotelExperian.enums.VagaDeGaragem;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class CheckInDTO {
    @NotBlank
    private HospedeModel hospede;
    @NotBlank
    private LocalDate dataDaHospedagem = LocalDate.now();
    @NotBlank
    private LocalDate previsaoDeSaida;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Diaria diaria;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private Quarto quarto;
    @Enumerated(EnumType.STRING)
    @NotBlank
    private VagaDeGaragem vagaDeGaragem;
}
