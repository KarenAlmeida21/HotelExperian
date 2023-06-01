package com.serasa.experian.HotelExperian.Hospedes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<HospedeModel, Long> {
    boolean existsByNomeHospede(String nome);
    boolean existsByDocumento(String documento);
}
