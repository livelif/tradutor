package com.pr.tradutor.objetosnulos;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonNuloDaPalavraTraduzida {
	
	public static JSONObject criarObjetoComEsta (String mensagemDeErro) {
		try {
			return new JSONObject(mensagemDeErro);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JSONObject();
	}
}
