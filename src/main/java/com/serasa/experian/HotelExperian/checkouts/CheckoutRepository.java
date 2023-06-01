package com.serasa.experian.HotelExperian.checkouts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CheckoutRepository extends JpaRepository<CheckoutModel, Long> {

        List<CheckoutModel> findByCheckInHospedeDocumento(String documento);


}
