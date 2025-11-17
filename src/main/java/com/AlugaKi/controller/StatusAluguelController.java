package com.AlugaKi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugaKi.application.usecases.StatusAluguelInteractor;
import com.AlugaKi.domain.entity.StatusAluguel;

@RestController
@RequestMapping("statusaluguel")
public class StatusAluguelController {
    private StatusAluguelInteractor statusAluguelInteractor;
    private final StatusAluguelDTOMapper statusAluguelDTOMapper;

    public StatusAluguelController(StatusAluguelInteractor statusAluguelInteractor, StatusAluguelDTOMapper statusAluguelDTOMapper) {
        this.statusAluguelInteractor = statusAluguelInteractor;
        this.statusAluguelDTOMapper = statusAluguelDTOMapper;
    }

    @GetMapping("/{id}")
    StatusAluguelResponse findStatusAluguelById(@PathVariable int id) {
        StatusAluguel statusAluguel = statusAluguelInteractor.findStatusAluguelById(id);
        return statusAluguelDTOMapper.toResponse(statusAluguel);
    }

    @GetMapping
    List<StatusAluguelResponse> findAllStatusAlugueis() {
        List<StatusAluguel> statusAlugueis = statusAluguelInteractor.findAllStatusAlugueis();
        return statusAlugueis.stream()
            .map(statusAluguelDTOMapper::toResponse)
            .toList();
    }
}