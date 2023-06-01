package com.serasa.experian.HotelExperian.Hospedes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<HospedeModel, String> {
    boolean existsByNomeHospede(String nome);

    boolean existsByDocumento(String documento);
}
