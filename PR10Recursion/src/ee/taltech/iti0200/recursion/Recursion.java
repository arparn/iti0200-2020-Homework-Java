package ee.taltech.iti0200.recursion;

import ee.taltech.iti0200.recursion.mlp.MyLittlePony;

import java.util.List;

public class Recursion {

    public static List<String> eliminatePonies(List<MyLittlePony> ponies, List<String> ponyNames, Integer listIndex) {
        if (ponies.size() == listIndex - 1) {
            return ponyNames;
        } else {
            MyLittlePony pony = ponies.get(listIndex);
            if (pony.getPonyType() == ponies.get(listIndex + 1).getPonyType()) {
                listIndex++;
                return eliminatePonies(ponies, ponyNames, listIndex);
            } else {
                listIndex++;
                ponyNames.add(pony.getName());
                return eliminatePonies(ponies, ponyNames, listIndex);
            }
        }
    }

    public static int getPonyNamesLengthProduct(List<MyLittlePony> ponies, int product) {
        return 0;
    }

    public static int getPonyNamesLengthProductExceptType(List<MyLittlePony> ponies, int product, MyLittlePony.PonyType type) {
        return 0;
    }
}
