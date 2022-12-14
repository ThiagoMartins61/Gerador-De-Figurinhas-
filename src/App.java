import java.io.InputStream;
import java.net.URL;
import java.util.List;



public class App {
    public static void main(String[] args) throws Exception {
      
        // fazer uma conexão http e buscar os top 250filmes 

        //String url = "https://alura-imdb-api.herokuapp.com/movies";
        //String url ="https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        
        String url ="https://thiago-linguagens-api.herokuapp.com/linguagens";
        var http = new ClienteHttp();
        String json = http.buscaDados(url);


        // exibir e manipilar os dados

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extrairConteudos(json);
        var geradora = new GeradorDeFigurinhas();

        for(int i = 0; i < 3; i++){
            
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = "saida/" +conteudo.getTitulo()+ ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            }
    }
}
        
    