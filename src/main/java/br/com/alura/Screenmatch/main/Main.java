package br.com.alura.Screenmatch.main;
import br.com.alura.Screenmatch.model.DadosDaSerie;
import br.com.alura.Screenmatch.model.DadosDaTemporada;
import br.com.alura.Screenmatch.service.ConsumoDeAPI;
import br.com.alura.Screenmatch.service.ConversorDeDados;
import java.util.*;

public class Main {

    private ConsumoDeAPI consumoDeAPI = new ConsumoDeAPI();
    private ConversorDeDados conversor = new ConversorDeDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=21713e87";

        List <DadosDaSerie> dadosDasSeries = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

            public void exibeMenu() {
                int opcao = -1;
                while (opcao != 0) {
                var menu = """
                        +--------------------------+
                        |    Screenmatch Opções    |
                        +--------------------------+
                        |1| Buscar séries.         |
                        |2| Buscar episódios.      |
                        |3| Listar séries buscadas.|
                        |0| Sair.                  |
                        +--------------------------+""";

                System.out.println(menu);
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> buscarSerieWeb();
                    case 2 -> buscarEpisodioPorSerie();
                    case 3 -> listarSeriesBuscadas();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida");
                }
            }
        }

        private void buscarSerieWeb() {
            DadosDaSerie dadosDaSerie = getDadosDaSerie();
            dadosDasSeries.add(dadosDaSerie);
            System.out.println(dadosDaSerie);
        }

        private DadosDaSerie getDadosDaSerie() {
            System.out.println("Digite o nome da série para busca");
            var nomeSerie = scanner.nextLine();
            var json = consumoDeAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
            DadosDaSerie dadosDaSerie = conversor.obterDados(json, DadosDaSerie.class);
            return dadosDaSerie;
        }

        private void buscarEpisodioPorSerie(){
            DadosDaSerie dadosDaSerie = getDadosDaSerie();
            List<DadosDaTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= dadosDaSerie.totalDeTemporadas(); i++) {
                var json = consumoDeAPI.obterDados(ENDERECO + dadosDaSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosDaTemporada dadosDaTemporada = conversor.obterDados(json, DadosDaTemporada.class);
                temporadas.add(dadosDaTemporada);
            }
            temporadas.forEach(System.out::println);
        }
    }