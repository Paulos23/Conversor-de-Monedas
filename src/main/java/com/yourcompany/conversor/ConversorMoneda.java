package com.yourcompany.conversor;

public class ConversorMoneda {
    public static double convertir(double monto, String monedaOrigen, String monedaDestino) {
        try {
            double tasa = com.yourcompany.conversor.ClienteAPI.getTasaConversion(monedaOrigen, monedaDestino);
            return monto * tasa;
        } catch (Exception e) {
            System.err.println("Error al convertir: " + e.getMessage());
            return -1; // Valor de error
        }
    }
}