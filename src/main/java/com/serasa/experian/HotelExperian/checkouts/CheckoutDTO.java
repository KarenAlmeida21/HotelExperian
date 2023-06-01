package com.serasa.experian.HotelExperian.checkouts;

import com.serasa.experian.HotelExperian.CheckIns.CheckInModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CheckoutDTO {
    @NotNull
    private CheckInModel checkIn;
    @NotNull
    private LocalDate dataDaSaida;
}
