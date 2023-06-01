package com.serasa.experian.HotelExperian;

import com.serasa.experian.HotelExperian.Hospedes.HospedeModel;
import com.serasa.experian.HotelExperian.Hospedes.HospedeRepository;
import com.serasa.experian.HotelExperian.Hospedes.HospedeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class HospedeServiceTest {

    @InjectMocks
    private HospedeService hospedeService;
    @Mock
    private HospedeRepository hospedeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void cadastraHospedeComSucesso() {
        HospedeModel hospede = new HospedeModel();
        hospede.setDocumento("123456789");
        hospede.setNomeHospede("John Doe");
        hospede.setTelefone("1234567890");

        when(hospedeRepository.existsByDocumento(anyString())).thenReturn(false);
        when(hospedeRepository.existsByTelefone(anyString())).thenReturn(false);
        when(hospedeRepository.save(any(HospedeModel.class))).thenReturn(hospede);

        HospedeModel result = hospedeService.cadastraHospede(hospede);

        assertNotNull(result);
        assertEquals("123456789", result.getDocumento());
        assertEquals("John Doe", result.getNomeHospede());
        assertEquals("1234567890", result.getTelefone());

        verify(hospedeRepository, times(1)).existsByDocumento(anyString());
        verify(hospedeRepository, times(1)).existsByTelefone(anyString());
        verify(hospedeRepository, times(1)).save(any(HospedeModel.class));
    }


    }
