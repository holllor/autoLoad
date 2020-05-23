/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.uvdt.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author oleg
 */
public class TestWork {

    public static void main(String[] args) {
        new TestWork().test();
    }

    void test() {
        System.out.println("test");

        OtchetObjJson otch = new OtchetObjJson();
        //row
        List<String> row1 = new ArrayList<>();
        row1.add("1");
        row1.add("2");
        row1.add("3");
        List<String> row2 = new ArrayList<>();
        row2.add("4");
        row2.add("5");
        row2.add("6");
        //graff
        List<List<String>> graf1 = new ArrayList<>();
        graf1.add(row1);
        graf1.add(row2);
        List<List<String>> graf2 = new ArrayList<>();
        graf2.add(row1);
        graf2.add(row2);
        List<List<String>> graf3 = new ArrayList<>();
        graf3.add(row1);
        graf3.add(row2);
// razdels
        List<List<List<String>>> razdels = new ArrayList<>();
        razdels.add(graf1);
        razdels.add(graf2);
        razdels.add(graf3);
        otch.setRazdels(razdels);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("otchet1.json")) {// write json
//          writer.
//gson.           
            gson.toJson(otch, writer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        razdels.stream().map((razdel) -> {
            System.out.println("---------------------------");
            return razdel;
        }).forEachOrdered((razdel) -> {
            razdel.stream().map((list) -> {
                //                System.out.print(" ");
                list.forEach((string) -> {
                    System.out.print(string + " ");
                });
                return list;
            }).forEachOrdered((_item) -> {
                System.out.println("");
            }); //   System.out.println("");
        });
    }

}
