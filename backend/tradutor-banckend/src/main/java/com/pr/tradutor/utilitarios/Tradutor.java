package com.pr.tradutor.utilitarios;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.pr.tradutor.modelo.TraducaoDaPalavra;

public class Tradutor {
	
	private Tradutor() {}
	
    public static List<TraducaoDaPalavra> traduzir(String palavra) throws MalformedURLException, IOException, JSONException {
        String urlDicionario = "https://dictionary.cambridge.org/pt/dicionario/ingles-portugues/" + palavra;
        Document doc = Jsoup.connect(urlDicionario).get();
        
        Elements tipos = pegarElementoUsandoClass("pos dpos", doc);
        Elements definicoes = pegarElementoUsandoClass("def ddef_d db", doc);
        Elements exemplos = pegarElementoUsandoClass("eg deg", doc);
        Elements traducoes = pegarElementoUsandoClass("trans dtrans dtrans-se ", doc);

        
        return obterTraducoesDaPalavra(tipos, definicoes, exemplos, traducoes);
    }

	private static List<TraducaoDaPalavra> obterTraducoesDaPalavra(Elements tipos, Elements definicoes, Elements exemplos,
			Elements traducoes) throws MalformedURLException, IOException, JSONException {
		List<TraducaoDaPalavra> traducoesDaPalavra = new ArrayList<TraducaoDaPalavra>();
        String lastTraducao = "-----------";
        int i = 0;
        for (int index = 0; index < traducoes.size(); index++) {
            System.out.println("com.paulo.ingles.utils.Tradutor.traduzir()"+traducoes.get(index).ownText());
            if (!traducoes.get(index).ownText().contains(lastTraducao) && i < tipos.size()) {
                String tipo = tipos.get(i).text();
                String definicao = definicoes.get(index).text();
                String exemplo = exemplos.get(index).text();
                String traducao = traducoes.get(index).ownText();
                lastTraducao = traducoes.get(index).ownText();
                String urlDaImagem = CarregadorDeUrlDeImagens.obterUrlDaImagemUsando(traducao);
                traducoesDaPalavra.add(new TraducaoDaPalavra(tipo, definicao, exemplo, traducao, urlDaImagem));
                i++;
            }           
            
        }
        return traducoesDaPalavra;
	}
    
    private static Elements pegarElementoUsandoClass(String classe, Document doc) {
        
        return doc.body().getElementsByClass(classe);
    }
	
}
