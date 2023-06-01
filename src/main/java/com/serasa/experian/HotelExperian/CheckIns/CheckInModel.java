package com.serasa.experian.HotelExperian.CheckIns;

import com.serasa.experian.HotelExperian.Hospedes.HospedeModel;
import com.serasa.experian.HotelExperian.enums.Diaria;
import com.serasa.experian.HotelExperian.enums.Quarto;
import com.serasa.experian.HotelExperian.enums.VagaDeGaragem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CheckInModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(nullable = false)
    private HospedeModel hospede;
    private LocalDate dataDaHospedagem = LocalDate.now();
    private LocalDate previsaoDeSaida;
    @Enumerated(EnumType.STRING)
    private Diaria diaria;
    @Enumerated(EnumType.STRING)
    private Quarto quarto;
    @Enumerated(EnumType.STRING)
    private VagaDeGaragem vagaDeGaragem;
}
