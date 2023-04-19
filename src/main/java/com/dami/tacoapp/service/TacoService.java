package com.dami.tacoapp.service;

import com.dami.tacoapp.mapper.TacoMapper;
import com.dami.tacoapp.model.dto.TacoDto;
import com.dami.tacoapp.repository.TacoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TacoService {
    private final TacoRepository tacoRepository;

    public TacoDto getTacoById(@NotNull @NonNull Long tacoId) {
        return tacoRepository.findById(tacoId)
                .map(TacoMapper::map)
                .orElseThrow(EntityNotFoundException::new); // TODO add exception handler
    }
}
