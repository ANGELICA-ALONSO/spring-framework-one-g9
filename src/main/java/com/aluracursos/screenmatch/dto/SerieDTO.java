package com.aluracursos.screenmatch.dto;

import com.aluracursos.screenmatch.model.Categoria;
import jakarta.persistence.Enumerated;


public record SerieDTO(
        String titulo,
        Integer totalDeTemporadas,
        Double evaluacion,
        String poster,
        Categoria genero,
        String actores,
        String sinopsis) {
}
