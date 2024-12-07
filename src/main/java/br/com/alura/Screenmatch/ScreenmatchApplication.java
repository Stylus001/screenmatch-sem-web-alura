package br.com.alura.Screenmatch;
import br.com.alura.Screenmatch.model.DadosDaSerie;
import br.com.alura.Screenmatch.service.ConsumoDeAPI;
import br.com.alura.Screenmatch.service.ConversorDeDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		ConsumoDeAPI consumoDeAPI = new ConsumoDeAPI();
		String JSON = consumoDeAPI.obterDados("https://www.omdbapi.com/?t=Breaking+Bad&apikey=21713e87");
		System.out.println(JSON);
		ConversorDeDados conversor = new ConversorDeDados();
		DadosDaSerie dadosDaSerie = conversor.obterDados(JSON, DadosDaSerie.class);
		System.out.println(dadosDaSerie);
	}
}