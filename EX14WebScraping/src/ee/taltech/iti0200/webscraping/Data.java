package ee.taltech.iti0200.webscraping;

public class Data {

    private String Title;
    private String Price;
    private String Picture_href;

    public Data(String title, String price, String href) {
        this.Title = title;
        this.Price = price;
        this.Picture_href = href;
    }

    public String getPicture_href() {
        return Picture_href;
    }

    public String getTitle() {
        return Title;
    }

    public String getPrice() {
        return Price;
    }
}
