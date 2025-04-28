package br.com.alura.Screenmatch.model;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {

    //Atributos.
    private Integer temporada;
    private String titulo;
    private Integer numeroDoEpisodio;
    private Double avaliacao;
    private LocalDate dataDeLancamento;

    //Construtores.
    public Episodio(Integer numeroDaTemporada, DadosDoEpisodio dadosDoEpisodio) {
        this.temporada = numeroDaTemporada;
        this.titulo = dadosDoEpisodio.titulo();
        this.numeroDoEpisodio = dadosDoEpisodio.numeroDoEpisodio();

        try {
            this.avaliacao = Double.valueOf(dadosDoEpisodio.avaliacao());
        } catch (NumberFormatException exception) {
            this.avaliacao = 0.0;
        }

        try {
            this.dataDeLancamento = LocalDate.parse(dadosDoEpisodio.dataDeLancamento());
        } catch (DateTimeParseException exception) {
            this.dataDeLancamento = null;
        }

    }

    //Getters e Setters.
    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroDoEpisodio() {
        return numeroDoEpisodio;
    }

    public void setNumeroDoEpisodio(Integer numeroDoEpisodio) {
        this.numeroDoEpisodio = numeroDoEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    @Override
    public String toString() {
        return  "temporada = " + temporada +
                ", titulo = '" + titulo + '\'' +
                ", numeroDoEpisodio = " + numeroDoEpisodio +
                ", avaliacao = " + avaliacao +
                ", dataDeLancamento = " + dataDeLancamento;
    }
}