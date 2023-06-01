package com.serasa.experian.HotelExperian.CheckIns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInModel, Long> {
    Optional<CheckInModel> findByHospedeDocumento(String documentoHospede);
}
