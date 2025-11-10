package com.AlugaKi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugaKi.application.usecases.PeriodoInteractor;
import com.AlugaKi.domain.entity.Periodo;

@RestController
@RequestMapping("periodo")
public class PeriodoController {
    private PeriodoInteractor periodoInteractor;
    private final PeriodoDTOMapper periodoDTOMapper;

    public PeriodoController(PeriodoInteractor periodoInteractor, PeriodoDTOMapper periodoDTOMapper){
        this.periodoInteractor = periodoInteractor;
        this.periodoDTOMapper = periodoDTOMapper;
    }

    @GetMapping("/{id}")
    CreatePeriodoResponse findPeriodoById(@PathVariable int id){
        Periodo periodo = periodoInteractor.findPeriodoById(id);
        return periodoDTOMapper.toResponse(periodo);
    }

    @GetMapping
    List<CreatePeriodoResponse> findAllPeriodos(){
        List<Periodo> periodos = periodoInteractor.findAllPeriodos();
        return periodos.stream()
            .map(periodoDTOMapper::toResponse)
            .toList();
    }
    
}

