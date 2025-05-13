package com.yourcompany.conversor;

import java.util.Scanner;

public class MenuConsola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("Bienvenid@ al conversor de Monedas =");
        System.out.println("*******************************************");

        while (true) {
            System.out.println("\n1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasilero");
            System.out.println("4) Real Brasilero =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();
            if (opcion == 7) {
                System.out.println("¡Gracias por usar el conversor! 👋");
                break;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            String monedaOrigen, monedaDestino;
            switch (opcion) {
                case 1 -> { monedaOrigen = "USD"; monedaDestino = "ARS"; }
                case 2 -> { monedaOrigen = "ARS"; monedaDestino = "USD"; }
                case 3 -> { monedaOrigen = "USD"; monedaDestino = "BRL"; }
                case 4 -> { monedaOrigen = "BRL"; monedaDestino = "USD"; }
                case 5 -> { monedaOrigen = "USD"; monedaDestino = "COP"; }
                case 6 -> { monedaOrigen = "COP"; monedaDestino = "USD"; }
                default -> {
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
                    continue;
                }
            }

            double resultado = ConversorMoneda.convertir(monto, monedaOrigen, monedaDestino);
            if (resultado != -1) {
                System.out.printf("\n✅ Resultado: %.2f %s = %.2f %s%n", monto, monedaOrigen, resultado, monedaDestino);
                System.out.println("*******************************************");
            }
        }
    }
}