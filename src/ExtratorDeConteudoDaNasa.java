import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    
    public List <Conteudo> extrairConteudos(String json){

        var parser = new JsonParser();
        List<Map<String, String >> ListaDeAtributos = parser.parse(json);

        List <Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteudos
        for (Map<String, String > atributos: ListaDeAtributos) {

            String urlImagem = atributos.get("url");
            String titulo = atributos.get("title");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos;

    }
}
