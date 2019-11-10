package com.pr.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.pr.objetosnulos.JsonNuloDaPalavraTraduzida;

public class TraducaoDaPalavra {
	private String tipo;
	private String definicao;
	private String exemplo;
	private String traducao;
	private String urlImagem;
	
	public TraducaoDaPalavra(String tipo, String definicao, String exemplo, String traducao, String urlImagem) {

		this.tipo = tipo;
		this.definicao = definicao;
		this.exemplo = exemplo;
		this.traducao = traducao;
		this.urlImagem = urlImagem;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tipo: " + tipo + "\nDefinica: " + definicao + "\nExemplo " + exemplo +
				"\n traducao: " + traducao + "\nUrl: " + urlImagem;
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
