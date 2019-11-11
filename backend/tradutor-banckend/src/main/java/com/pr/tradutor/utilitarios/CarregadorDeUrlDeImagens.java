package com.pr.tradutor.utilitarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class CarregadorDeUrlDeImagens {
	private static final String KEY_GOOGLE_API = "";
    private static final String CX = "";
	private CarregadorDeUrlDeImagens() {};
	
    public static JSONObject obterJsonDa (String traducao) throws MalformedURLException, IOException, JSONException {
    	
    	if (palavraTemEspaçoEmBranco(traducao)) {
    		traducao = formatarEspaçoEmBrancoParaSerEntendivelNaUrl(traducao);
    	}
    	
        String fileType = "png,jpg";
        String searchType = "image";
        URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + KEY_GOOGLE_API + "&cx=" + CX + "&q=" + traducao + "&fileType=" + fileType + "&searchType=" + searchType + "&alt=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String valor = obterStringDoBuffered(br);
        
        conn.disconnect();
        return new JSONObject(valor);
    }
    
    private static String obterStringDoBuffered(BufferedReader br) throws IOException {
        String linha = br.readLine();
        StringBuffer bff = new StringBuffer();
        while (linha != null) {
            bff.append(linha);
            linha = br.readLine();
           
        }
        
        return bff.toString();
    }
    
    public static boolean palavraTemEspaçoEmBranco(String palavra) {
    	return palavra.contains(" ");
    }
    
    public static String formatarEspaçoEmBrancoParaSerEntendivelNaUrl(String palavra) {
    	return palavra.replaceAll(" ", "%20");
    }
}
