package com.example.demo.controller;

import com.example.demo.model.Carro;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/fipe")
public class FipeController {

    @PostMapping("/valor")
    public Map<String, Object> getValorFipe(@RequestBody Carro carro) {
        Map<String, Object> responseMap = new HashMap<>();

        try {
            String marca = carro.getMarca();
            String modelo = carro.getModelo();
            Integer ano = carro.getAno();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            // Passo 1: Obter ID da marca
            String marcaUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
            ResponseEntity<String> marcaResponse = restTemplate.exchange(marcaUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            JSONArray marcasJson = new JSONArray(marcaResponse.getBody());
            String marcaId = null;

            for (int i = 0; i < marcasJson.length(); i++) {
                JSONObject marcaObj = marcasJson.getJSONObject(i);
                if (marcaObj.getString("nome").equalsIgnoreCase(marca)) {
                    marcaId = marcaObj.getString("codigo");
                    break;
                }
            }

            if (marcaId == null) {
                responseMap.put("erro", "Marca não encontrada.");
                return responseMap;
            }

            // Passo 2: Obter ID do modelo
            String modeloUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marcaId + "/modelos";
            ResponseEntity<String> modeloResponse = restTemplate.exchange(modeloUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            JSONObject modelosJson = new JSONObject(modeloResponse.getBody());
            JSONArray modelosArray = modelosJson.getJSONArray("modelos");
            String modeloId = null;

            for (int i = 0; i < modelosArray.length(); i++) {
                JSONObject modeloObj = modelosArray.getJSONObject(i);
                if (modeloObj.getString("nome").equalsIgnoreCase(modelo)) {
                    modeloId = modeloObj.getString("codigo");
                    break;
                }
            }

            if (modeloId == null) {
                responseMap.put("erro", "Modelo não encontrado.");
                return responseMap;
            }

            // Passo 3: Obter valor para o ano e modelo específico
            String anoUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marcaId + "/modelos/" + modeloId + "/anos";
            ResponseEntity<String> anoResponse = restTemplate.exchange(anoUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            JSONArray anosArray = new JSONArray(anoResponse.getBody());
            String anoId = null;

            for (int i = 0; i < anosArray.length(); i++) {
                JSONObject anoObj = anosArray.getJSONObject(i);
                if (anoObj.getString("nome").contains(ano.toString())) {
                    anoId = anoObj.getString("codigo");
                    break;
                }
            }

            if (anoId == null) {
                responseMap.put("erro", "Ano não encontrado.");
                return responseMap;
            }

            // Passo 4: Obter o valor FIPE do carro
            String valorUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + anoId;
            ResponseEntity<String> valorResponse = restTemplate.exchange(valorUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            JSONObject valorJson = new JSONObject(valorResponse.getBody());

            if (valorJson.has("Valor")) {
                String valor = valorJson.getString("Valor");
                responseMap.put("valor", valor);
                responseMap.put("mes", "Setembro de 2024");  // Simulando o mês de referência
            } else {
                responseMap.put("erro", "Valor não encontrado para o carro especificado.");
            }

        } catch (RestClientException e) {
            responseMap.put("erro", "Erro ao se conectar à API FIPE: " + e.getMessage());
        } catch (Exception e) {
            responseMap.put("erro", "Erro ao processar a requisição: " + e.getMessage());
        }

        return responseMap;
    }
}
