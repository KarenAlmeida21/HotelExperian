package com.serasa.experian.HotelExperian.CheckIns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInModel, Long> {
    boolean existsByHospedeDocumento(String documentoHospede);

    Optional<CheckInModel> findByHospedeDocumento(String documento);

    Optional<CheckInModel> findByHospedeTelefone(String telefone);

    Optional<CheckInModel> findByHospedeNomeHospede(String nomeHospede);

   //
}


