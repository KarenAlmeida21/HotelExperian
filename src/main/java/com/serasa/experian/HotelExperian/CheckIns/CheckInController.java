package com.serasa.experian.HotelExperian.CheckIns;

import com.serasa.experian.HotelExperian.Hospedes.HospedeRepository;
import com.serasa.experian.HotelExperian.exceptions.CheckInNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/check-ins")
public class CheckInController {
    private CheckInService checkInService;
    private ModelMapper modelMapper;
    private HospedeRepository hospedeRepository;

    public CheckInController(CheckInService checkInService, ModelMapper modelMapper, HospedeRepository hospedeRepository) {
        this.checkInService = checkInService;
        this.modelMapper = modelMapper;
        this.hospedeRepository = hospedeRepository;
    }

    @PostMapping("/realiza-check-in")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckInModel realizaCheckIn(@RequestBody CheckInDTO check) {
        ModelMapper modelMapper = new ModelMapper();
        CheckInModel checkInModel = modelMapper.map(check, CheckInModel.class);
        checkInModel.setDataDaHospedagem(LocalDate.now());

        CheckInModel checkIn = modelMapper.map(check, CheckInModel.class);
        checkInModel.setDataDaHospedagem(LocalDate.now());

        return checkInService.createCheckIn(checkIn, checkIn.getHospede());

    }

    @GetMapping("/listar-check-ins")
    public List<CheckInDTO> exibircheckInsList() {
        List<CheckInDTO> checKInDTOList = new ArrayList<>();
        for (CheckInModel checkReferencia : checkInService.listarCheckIns()) {
            CheckInDTO checKInDTO = modelMapper.map(checkReferencia, CheckInDTO.class);
            checKInDTOList.add(checKInDTO);
        }
        return checKInDTOList;
    }

    @GetMapping("/busca-hospede-documento/{documento}")
    public CheckInModel buscaCheckInPorDocumentoTelefone(@PathVariable String documento) {
        return checkInService.buscaCheckInPorDocumentoHospede(documento);
    }

    @GetMapping("/buscar-por-telefone/{telefone}")
    public CheckInDTO buscarPorTelefone(@PathVariable String telefone) {
            CheckInModel checkIn = checkInService.buscaCheckInPorTelefoneHospede(telefone);
            CheckInDTO checkInDTO = modelMapper.map(checkIn, CheckInDTO.class);
            return checkInDTO;
    }

    @GetMapping("/buscar-hospede-nome/{nomeHospede}")
    public CheckInModel buscarCheckInPorNomeHospede(@PathVariable String nomeHospede) {
            CheckInModel checkIn = checkInService.buscaCheckInPorNomeHospede(nomeHospede);
            return checkIn;

    }

    @GetMapping("/hospedes-presentes")
    public List<CheckInModel> listarCheckInsComHospedesPresentes() {
        return checkInService.listaCheckInsComHospedesPresentes();
    }

    @GetMapping("/calcular-previsao-custo/{id}")
    public double calcularPrevisaoCustoHospedagem(@PathVariable Long id) {
        CheckInModel checkInModel = checkInService.buscaCheckInPorId(id);
        return checkInService.calcularPrevisaoCustoHospedagem(checkInModel);
    }

    @DeleteMapping("/deleta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaCheckIn(@PathVariable Long id) {
        checkInService.deletaCheckIn(id);
    }



}
