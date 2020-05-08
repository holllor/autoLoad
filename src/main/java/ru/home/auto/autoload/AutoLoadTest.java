/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.auto.autoload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author oleg
 */
public class AutoLoadTest {

    public static void main(String[] args) {
        AutoLoadTest alt = new AutoLoadTest();
//        alt.testLoad();
        alt.test2();
    }

    void testLoad() {
        //пример из Описания библиотеки
        try {

            Document doc = Jsoup.connect("http://forums.kuban.ru/").get();
            File testF = new File("test");
            String uri = "";

            Document docFile = Jsoup.parse(testF, null, uri);
//            docFile.System.out.println(doc.title());

            Elements newsHeadlines = doc.select(".page a");

            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));

            }
        } catch (IOException ex) {
            Logger.getLogger(AutoLoadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * скачивает файл по ссылке
     */
    void test2() {
        try {
            //определение логгера
            Logger log = Logger.getLogger(AutoLoadTest.class.getName());// подключаем ЛОГГЕР
            FileHandler fh = new FileHandler("MyLogFile.log", 5000, 1, true);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            log.addHandler(fh);
//----------------------------
            //подключение к сайту по прямой ссылке
            Connection con = Jsoup.connect("https://dogovor-kupli-prodazhi.com/wp-content/uploads/2018/03/dkp_avto.pdf");
            log.info("прошли коннект");
            Response resp = con.ignoreContentType(true).execute();
            log.log(Level.INFO, "прошел запрос");
            String contentType = resp.contentType();
            String charset = resp.charset();
            int statusCode = resp.statusCode();
            String nameFile = resp.header("Content-Disposition");
            System.out.println(nameFile);
            log.log(Level.INFO, "test: {0}    {1} {2}", new Object[]{contentType, charset, statusCode});

            //запись в файл полученной информации
            BufferedInputStream bis = resp.bodyStream();
            File localFile = new File("test");
            try (FileOutputStream out = new FileOutputStream(localFile)) {
                out.write(bis.readAllBytes());
            }
            log.info("запись в файл прошла нормально");
        } catch (IOException ex) {
            Logger.getLogger(AutoLoadTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
