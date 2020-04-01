package ee.taltech.iti0200.recursion;

import ee.taltech.iti0200.recursion.mlp.MyLittlePony;

import java.util.List;

public class Recursion {

    public static List<String> eliminatePonies(List<MyLittlePony> ponies, List<String> ponyNames, Integer listIndex) {
        if (ponies.size() == 0) {
            return ponyNames;
        }
        if (ponies.size() - 1 == listIndex) {
            ponyNames.add(ponies.get(listIndex).getName());
            return ponyNames;
        } else {
            MyLittlePony pony = ponies.get(listIndex);
            if (pony.getPonyType() != ponies.get(listIndex + 1).getPonyType()) {
                ponyNames.add(pony.getName());
            }
            listIndex++;
            return eliminatePonies(ponies, ponyNames, listIndex);
        }
    }

    public static int getPonyNamesLengthProduct(List<MyLittlePony> ponies, int product) {
        if (ponies.size() == 0) {
            return product;
        } else {
            product += ponies.get(0).getName().length();
            ponies.remove(0);
            return getPonyNamesLengthProduct(ponies, product);
        }
    }

    public static int getPonyNamesLengthProductExceptType(List<MyLittlePony> ponies, int product,
                                                          MyLittlePony.PonyType type) {
        if (ponies.size() == 0) {
            return product;
        } else {
            MyLittlePony pony = ponies.get(0);
            if (pony.getPonyType() != type) {
                product += pony.getName().length();
            }
            ponies.remove(0);
            return getPonyNamesLengthProductExceptType(ponies, product, type);
        }
    }
}
