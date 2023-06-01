package com.serasa.experian.HotelExperian.checkouts;

import com.serasa.experian.HotelExperian.CheckIns.CheckInModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "check_in_id")
    private CheckInModel checkIn;
    private LocalDate dataDaSaida = LocalDate.now();


}
