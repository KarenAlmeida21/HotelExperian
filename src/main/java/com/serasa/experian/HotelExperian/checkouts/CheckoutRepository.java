package com.serasa.experian.HotelExperian.checkouts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckoutRepository extends JpaRepository<CheckoutModel, Long> {
    
}
