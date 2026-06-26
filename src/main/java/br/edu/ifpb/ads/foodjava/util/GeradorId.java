package br.edu.ifpb.ads.foodjava.util;

import java.util.UUID;

public class GeradorId {

    public static String gerar() {

        return UUID.randomUUID().toString();

    }

}