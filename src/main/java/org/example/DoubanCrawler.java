package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DoubanCrawler {
    public static void main(String[] args) throws IOException {
        String url = "https://movie.douban.com/top250";
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        InputStream is = conn.getInputStream();
        Scanner sc = new Scanner(is);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        String html = sb.toString();
        Document doc = Jsoup.parse(html);
        Elements items = doc.select(".item");
        for (Element item : items) {
            String title = item.select(".title").text();
            String rating = item.select(".rating_num").text();
            System.out.println(title + " " + rating);
        }
    }
}
