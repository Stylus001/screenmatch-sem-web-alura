package br.com.alura.Screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDaSerie(@JsonAlias("Title") String titulo,
                           @JsonAlias("totalSeasons") Integer totalDeTemporadas,
                           @JsonAlias("imdbRating") String avaliacao) {
}
