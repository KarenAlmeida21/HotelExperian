package com.serasa.experian.HotelExperian;

import com.serasa.experian.HotelExperian.Hospedes.HospedeModel;
import com.serasa.experian.HotelExperian.Hospedes.HospedeRepository;
import com.serasa.experian.HotelExperian.Hospedes.HospedeService;
import com.serasa.experian.HotelExperian.exceptions.HospedeJaCadastradoException;
import com.serasa.experian.HotelExperian.exceptions.HospedeNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;
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


    @Test
    public void cadastraHospedeNomeJaCadastradoException() {
        HospedeModel hospede = new HospedeModel();
        hospede.setDocumento("123456789");
        hospede.setNomeHospede("John Doe");
        hospede.setTelefone("1234567890");

        when(hospedeRepository.existsByDocumento(anyString())).thenReturn(true);

        assertThrows(HospedeJaCadastradoException.class, () -> hospedeService.cadastraHospede(hospede));

        verify(hospedeRepository, times(1)).existsByDocumento(anyString());
        verify(hospedeRepository, never()).existsByTelefone(anyString());
        verify(hospedeRepository, never()).save(any(HospedeModel.class));
    }


    @Test
    public void exibirTodosHospedeException() {
        when(hospedeRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(HospedeNaoEncontradoException.class, () -> hospedeService.exibirTodosHospede());

        verify(hospedeRepository, times(1)).findAll();
    }

    @Test
    void exibirTodosHospedeComSucesso() {
        List<HospedeModel> hospedeList = new ArrayList<>();
        hospedeList.add(new HospedeModel());

        hospedeList.add(new HospedeModel());
        hospedeList.add(new HospedeModel());

        when(hospedeRepository.findAll()).thenReturn(hospedeList);

        List<HospedeModel> result = hospedeService.exibirTodosHospede();

        assertNotNull(result);
        assertEquals(2, result.size());

        verify(hospedeRepository, times(1)).findAll();
    }




}
