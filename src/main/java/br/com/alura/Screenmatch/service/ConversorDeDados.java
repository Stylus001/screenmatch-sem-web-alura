package br.com.alura.Screenmatch.service;
import br.com.alura.Screenmatch.model.DadosDaSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDeDados implements IConversorDeDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String JSON, Class<T> classe) {
        try {
            return mapper.readValue(JSON, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
