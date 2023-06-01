package com.serasa.experian.HotelExperian.Hospedes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class HospedeDTO {
    @NotBlank
    private String documento;
    @NotBlank
    private String nomeHospede;
    @NotBlank
    private int idade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String enderecoHospede;
}
