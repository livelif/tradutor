package com.pr.tradutor.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.pr.tradutor.objetosnulos.JsonNuloDaPalavraTraduzida;

public class TraducaoDaPalavra {
	private String tipo;
	private String definicao;
	private String exemplo;
	private String traducao;
	private String urlImagem;
	private String descricaoDaImagem;
	
	public TraducaoDaPalavra(String tipo, String definicao, String exemplo, String traducao, String urlImagem, 
			String descricaoDaImamge) {

		this.tipo = tipo;
		this.definicao = definicao;
		this.exemplo = exemplo;
		this.traducao = traducao;
		this.urlImagem = urlImagem;
		this.descricaoDaImagem = descricaoDaImamge;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ \n\"Tipo\": \"" + tipo + "\",\n\"Definicao\": \"" + definicao + "\",\n\"Exemplo\": \"" + exemplo +
				"\",\n\"traducao\": \"" + traducao + "\",\n\"Url\": \"" + urlImagem + "\",\n\"descricaoImagem\": \"" + descricaoDaImagem + "\"\n}";
	}
	
	public JSONObject gerarJsonDaPalavra() {
		try {
			return new JSONObject(this.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mensagemDeErro = "Nao foi possivel criar json desta palavra: " + traducao;
		return JsonNuloDaPalavraTraduzida.criarObjetoComEsta(mensagemDeErro);
	}
	
	
}
