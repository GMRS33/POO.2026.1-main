package br.edu.ifpb.ads.foodjava.util;

public class Validacao {

    public static boolean campoVazio(String texto) {

        return texto == null || texto.trim().isEmpty();

    }

    public static boolean emailValido(String email) {

        if (campoVazio(email)) {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    }

    public static boolean telefoneValido(String telefone) {

        if (campoVazio(telefone)) {
            return false;
        }

        String numero = telefone.replaceAll("[^0-9]", "");

        return numero.length() >= 10 && numero.length() <= 11;

    }

    public static boolean cpfValido(String cpf) {

        if (campoVazio(cpf)) {
            return false;
        }

        String numero = cpf.replaceAll("[^0-9]", "");

        return numero.length() == 11;

    }

    public static boolean cnpjValido(String cnpj) {

        if (campoVazio(cnpj)) {
            return false;
        }

        String numero = cnpj.replaceAll("[^0-9]", "");

        return numero.length() == 14;

    }

    public static boolean precoValido(double preco) {

        return preco > 0;

    }

}