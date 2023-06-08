package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class BaikeCrawler {
    public static void main(String[] args) throws IOException {
        String url = "https://baike.baidu.com/item/Python/407313?fromtitle=python&fromid=1122762";

        // 发送http请求，获取响应
        Document doc = Jsoup.parse(new URL(url), 5000);

        // 解析响应，提取简介信息
        Elements summary = doc.select(".lemma-summary");
        System.out.println(summary.text());


    }
}
