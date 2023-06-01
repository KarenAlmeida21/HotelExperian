package com.serasa.experian.HotelExperian.CheckIns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInModel, Long> {
}
