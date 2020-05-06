package ee.taltech.iti0200.kt1.chocolatefactory;

public class ChocolateFactory {
    private int chocolateBoxesMade;
    private int costSoFar;

    public enum BoxType {

        SQUARE1(4,4),
        SQUARE2(5, 5),
        RECTANGLE1(3, 6),
        RECTANGLE2(4, 8);

        private int width;
        private int length;

        BoxType(int width, int length) {
            this.width = width;
            this.length = length;
        }
    }

    public ChocolateType[][] makeChocolateBox(ChocolateType chocolate1, ChocolateType chocolate2, Integer preferedChocolate1Count, BoxType boxType) {
        int width = boxType.width;
        int length = boxType.length;
        int choc1 = 0;
        int choc2 = 0;
        ChocolateType[][] chocolateBox = new ChocolateType[length][width];
        if (preferedChocolate1Count == 0) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    chocolateBox[i][j] = chocolate2;
                    choc2++;
                }
            }
        } else if (preferedChocolate1Count == 4) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if ((i == 0 && j == 0) || (i == length - 1 && j == width - 1)
                            || (i == 0 && j == width - 1) || (i == length - 1 && j == 0)) {
                        chocolateBox[i][j] = chocolate1;
                        choc1++;
                    } else {
                        chocolateBox[i][j] = chocolate2;
                        choc2++;
                    }
                }
            }
        } else if (preferedChocolate1Count == (length - 1 + width) * 2) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    if ((i == 0) || (i == length - 1) || (j == 0) || (j == width - 1)) {
                        chocolateBox[i][j] = chocolate1;
                        choc1++;
                    } else {
                        chocolateBox[i][j] = chocolate2;
                        choc2++;
                    }
                }
            }
        } else {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < length; j++) {
                    if (i % 2 == 1 && j % 2 == 1) {
                        chocolateBox[i][j] = chocolate1;
                        choc1++;
                    } else {
                        chocolateBox[i][j] = chocolate2;
                        choc2++;
                    }
                    if (i % 2 == 0 && j % 2 == 0) {
                        chocolateBox[i][j] = chocolate1;
                        choc1++;
                    } else {
                        chocolateBox[i][j] = chocolate2;
                        choc2++;
                    }
                }
            }
        }
        int cost = (choc1 * chocolate1.getPricePerPiece()) + (choc2 * chocolate2.getPricePerPiece());
        costSoFar += cost;
        chocolateBoxesMade++;
        return chocolateBox;
    }

    public int getChocolateBoxesMade() {
        return chocolateBoxesMade;
    }

    public int getCostSoFar() {
        return costSoFar;
    }

    public static void main(String[] args) {
        ChocolateFactory factory = new ChocolateFactory();
        ChocolateType[][] a = factory.makeChocolateBox(new ChocolateType(7, "0"),
                new ChocolateType(9, "o"), 4, BoxType.SQUARE1);
        System.out.println(factory.getCostSoFar());
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j].getStringForm());
            }
            System.out.println();
        }
    }
}
