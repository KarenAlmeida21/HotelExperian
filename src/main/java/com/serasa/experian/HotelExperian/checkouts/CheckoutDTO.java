package com.serasa.experian.HotelExperian.checkouts;

import com.serasa.experian.HotelExperian.CheckIns.CheckInModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class CheckoutDTO {
    @NotBlank
    private CheckInModel checkIn;
    @NotBlank
    private LocalDate dataDaSaida = LocalDate.now();
}
