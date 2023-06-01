package com.serasa.experian.HotelExperian.funcionarios;

import com.serasa.experian.HotelExperian.enums.Cargo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "funcionarios")

public class FuncionarioModel {
    @Id
    @Column(nullable = false, unique = true)
    private String numeroCracha;
    @Column(nullable = false, unique = true)
    private String cpfFuncionario;
    @Column(nullable = false)
    private String nomeFuncionario;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private Boolean situacao;
}
