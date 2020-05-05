package ee.taltech.iti0200.webscraping;

public class Data {

    private String title;
    private String price;
    private String pictureHref;

    public Data(String title, String price, String href) {
        this.title = title;
        this.price = price;
        this.pictureHref = href;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
