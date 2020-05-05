package ee.taltech.iti0200.webscraping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WebScrape {

    public WebScrape(){}

    public void getData() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String url = "https://www.osta.ee/kategooria/arvutid/page-";
        List<Data> dataList = new LinkedList<>();
        int pageNum = 1;
        while (true) {
            int size = dataList.size();
            String urlNum = url;
            urlNum += pageNum;
            try {
                Document document = Jsoup.connect(urlNum).get();

                for (Element object : document.select(
                        "ul.row.offers-list.js-main-offers-list.thumbs li")) {
                    if (object.select(".offer-thumb__title").text().equals("")) {
                        continue;
                    } else {
                        String title = object.select(".offer-thumb__title").text();
                        String price = object.select(".price-cp").text();
                        String findHref = object.select("figure.offer-thumb__image").html();
                        String href = "";
                        for (String str : findHref.split(" ")) {
                            if (str.contains("href")) {
                                href = str.substring(6, str.length() - 1);
                                break;
                            }
                        }
                        Data data = new Data(title, price, href);
                        dataList.add(data);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (pageNum == 7) { //size == dataList.size()
                break;
            }
            System.out.println(pageNum);
            pageNum++;
        }
        File file = new File("C://Users//arthu//Desktop//WebScrapeData.json");
        try (FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.write(gson.toJson(dataList));
            fileWriter.close();
            System.out.println(gson.toJson(dataList));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebScrape scrape = new WebScrape();
        scrape.getData();
    }
}
