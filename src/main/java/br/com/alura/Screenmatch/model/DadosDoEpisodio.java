package br.com.alura.Screenmatch.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDoEpisodio(@JsonAlias("Title")String titulo,
                              @JsonAlias("Episode")Integer numeroDoEpisodio,
                              @JsonAlias("imdbRating")String avaliacao,
                              @JsonAlias("Released")String dataDeLancamento) {
}
