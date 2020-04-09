package ee.taltech.iti0200.cakeorder;

import static ee.taltech.iti0200.cakeorder.CakeOrderProcessor.CakeOrderProcessorType.COUNT_TOTAL_SUM;
import static ee.taltech.iti0200.cakeorder.CakeOrderProcessor.CakeOrderProcessorType.MAKE_DAIRY_FREE;

public class Main {

    public static void main(String[] args) {
        String jsonInput = "{\n" +
                "  \"cakes\": [\n" +
                "    {\n" +
                "      \"name\": \"Sacher\",\n" +
                "      \"BBD\": \"2020-04-29\",\n" +
                "      \"price\": 14.00,\n" +
                "      \"kg\": 2.00,\n" +
                "      \"ingredients\": [\"flour\", \"chocolate\", \"milk\", \"sugar\", \"eggs\"]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"New York Cheesecake\",\n" +
                "      \"BBD\": \"2020-04-09\",\n" +
                "      \"price\": 10.00,\n" +
                "      \"kg\": 1.50,\n" +
                "      \"ingredients\": [\"flour\", \"cream-cheese\", \"milk\", \"sugar\", \"eggs\"]\n" +
                "\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        CakeOrderProcessor processor = new CakeOrderProcessor(COUNT_TOTAL_SUM);
        System.out.println(processor.process(jsonInput));

    }
}
