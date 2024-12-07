package br.com.alura.Screenmatch.service;

public interface IConversorDeDados {
    <T> T obterDados(String JSON, Class<T> classe);
}