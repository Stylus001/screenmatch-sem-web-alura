package br.com.alura.Screenmatch.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDaTemporada(@JsonAlias("Season") Integer numeroDaTemporada,
                               @JsonAlias("Episodes") List <DadosDoEpisodio> episodios) {
}