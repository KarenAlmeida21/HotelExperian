package com.serasa.experian.HotelExperian.Hospedes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HospedeModel {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    private String documento;
    @Column(nullable = false, unique = true)
    private String nomeHospede;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false, unique = true)
    private String telefone;
    @Column(nullable = false)
    private String enderecoHospede;
    @Enumerated(EnumType.STRING)
    private EstadoHospede estadoHospede;
}
