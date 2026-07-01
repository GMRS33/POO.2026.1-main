package br.edu.ifpb.ads.foodjava.util;

import javafx.scene.control.TextField;

public class MascaraUtil {

    public static void aplicarMascaraCpf(TextField campo) {

        campo.textProperty().addListener((obs, antigo, novo) -> {

            String numeros = novo.replaceAll("\\D", "");

            if (numeros.length() > 11) {
                numeros = numeros.substring(0, 11);
            }

            StringBuilder texto = new StringBuilder();

            for (int i = 0; i < numeros.length(); i++) {

                if (i == 3 || i == 6) {
                    texto.append(".");
                }

                if (i == 9) {
                    texto.append("-");
                }

                texto.append(numeros.charAt(i));

            }

            if (!texto.toString().equals(novo)) {
                campo.setText(texto.toString());
                campo.positionCaret(texto.length());
            }

        });

    }

    public static void aplicarMascaraTelefone(TextField campo) {

        campo.textProperty().addListener((obs, antigo, novo) -> {

            String numeros = novo.replaceAll("\\D", "");

            if (numeros.length() > 11) {
                numeros = numeros.substring(0, 11);
            }

            StringBuilder texto = new StringBuilder();

            for (int i = 0; i < numeros.length(); i++) {

                if (i == 0) {
                    texto.append("(");
                }

                if (i == 2) {
                    texto.append(") ");
                }

                if (i == 7) {
                    texto.append("-");
                }

                texto.append(numeros.charAt(i));

            }

            if (!texto.toString().equals(novo)) {
                campo.setText(texto.toString());
                campo.positionCaret(texto.length());
            }

        });

    }

    public static void aplicarMascaraCnpj(TextField campo) {

        campo.textProperty().addListener((obs, antigo, novo) -> {

            String numeros = novo.replaceAll("\\D", "");

            if (numeros.length() > 14) {
                numeros = numeros.substring(0, 14);
            }

            StringBuilder texto = new StringBuilder();

            for (int i = 0; i < numeros.length(); i++) {

                if (i == 2 || i == 5) {
                    texto.append(".");
                }

                if (i == 8) {
                    texto.append("/");
                }

                if (i == 12) {
                    texto.append("-");
                }

                texto.append(numeros.charAt(i));

            }

            if (!texto.toString().equals(novo)) {
                campo.setText(texto.toString());
                campo.positionCaret(texto.length());
            }

        });

    }

}