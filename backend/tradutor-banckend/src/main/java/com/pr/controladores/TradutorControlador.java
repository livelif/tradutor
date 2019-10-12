package com.pr.controladores;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pr.modelo.TraducaoDaPalavra;
import com.pr.utilitarios.Tradutor;

@RestController
public class TradutorControlador {
	

    @RequestMapping("/traduzir")
    public String greeting(@RequestParam(value="palavra", defaultValue="fly") String palavra) throws JSONException {
    	JSONArray traducaoJson = new JSONArray();
    	try {
			List<TraducaoDaPalavra> traduzir = Tradutor.traduzir(palavra);
			traduzir.stream().forEach(tradutor -> traducaoJson.put(tradutor.gerarJsonDaPalavra()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return traducaoJson.toString();
    }
}
