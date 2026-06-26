package br.edu.ifpb.ads.foodjava.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    private static final Gson gson =
            new GsonBuilder().setPrettyPrinting().create();

    public static <T> void salvar(String caminho, T objeto) {

        try (FileWriter writer = new FileWriter(caminho)) {

            gson.toJson(objeto, writer);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static <T> T carregar(String caminho, Class<T> classe) {

        try (FileReader reader = new FileReader(caminho)) {

            return gson.fromJson(reader, classe);

        } catch (IOException e) {

            return null;

        }

    }

    public static <T> T carregarLista(String caminho, Type tipo) {

        try (FileReader reader = new FileReader(caminho)) {

            return gson.fromJson(reader, tipo);

        } catch (IOException e) {

            return null;

        }

    }

}