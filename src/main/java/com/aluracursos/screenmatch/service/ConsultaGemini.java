package com.aluracursos.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
    public static String obtenerTraduccion(String texto){
        String modelo = "gemini-2.0-flash-lite";  //puedes cambiar la versión si lo deseas
        String prompt = "Traduce el siguiente texto al español: " + texto;

        Client cliente = new com.google.genai.Client.Builder().apiKey("AIzaSyBW60ihawi6JrkIfsGefJoLJkapGt6AX2s").build();

        try {
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null // Parámetro para configuraciones adicionales
            );

            if (!respuesta.text().isEmpty()) {
                return respuesta.text();
            }
        } catch (Exception e) {
            System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
        }

        return null;

    }

}
