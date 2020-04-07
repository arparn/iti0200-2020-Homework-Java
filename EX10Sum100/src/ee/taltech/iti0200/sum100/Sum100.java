package ee.taltech.iti0200.sum100;
import java.util.LinkedList;
import java.util.List;

public class Sum100 {

    public static List<String> removeVariants(List<String> variants) {
        List<String> answer = new LinkedList<>();
        for (String var : variants) {
            int sum = 0;
            String sign = "+";
            StringBuilder num = new StringBuilder();
            for (int i = 0; i < var.length(); i++) {
                String symbol = Character.toString(var.charAt(i));
                if (!symbol.equals("-") && !symbol.equals("+")) {
                    num.append(symbol);
                } else if (symbol.equals("-")) {
                    if (sign.equals("+")) {
                        sum += Integer.parseInt(num.toString());
                    } else {
                        sum -= Integer.parseInt(num.toString());
                    }
                    num = new StringBuilder();
                    sign = "-";
                } else {
                    if (sign.equals("+")) {
                        sum += Integer.parseInt(num.toString());
                    } else {
                        sum -= Integer.parseInt(num.toString());
                    }
                    num = new StringBuilder();
                    sign = "+";
                }
            }
            if (sign.equals("+")) {
                sum += Integer.parseInt(num.toString());
            } else {
                sum -= Integer.parseInt(num.toString());
            }
            if (sum == 100) {
                answer.add(var);
            }
        }
        return answer;
    }

    public static List<String> calcSums(List<MagicNumber> input, List<String> variants)  {

        if (input.size() == 0) {
            return removeVariants(variants);
        }

        short number = input.get(0).getNumber();
        List<String> answerList = new LinkedList<>();

        boolean subtract = input.get(0).canBeSubtracted();
        boolean placeNext = input.get(0).canBePlacedNextToOther();

         if (!subtract && placeNext) {
            if (variants.size() > 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    StringBuilder variant2 = new StringBuilder();
                    answerList.add((variant2.append(variant).append(number)).toString());
                    answerList.add((variant1.append(variant).append("+").append(number)).toString());
                }
            } else {
                answerList.add(Integer.toString(number));
            }
            input.remove(0);
            return calcSums(input, answerList);
        } else if (subtract && !placeNext) {
            if (variants.size() > 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    StringBuilder variant2 = new StringBuilder();
                    answerList.add((variant1.append(variant).append("+").append(number)).toString());
                    answerList.add((variant2.append(variant).append("-").append(number)).toString());
                }
            } else {
                answerList.add(Integer.toString(number));
                answerList.add("-" + Integer.toString(number));
            }
            input.remove(0);
            return calcSums(input, answerList);
        } else if (subtract) {
            if (variants.size() > 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    StringBuilder variant2 = new StringBuilder();
                    StringBuilder variant3 = new StringBuilder();
                    answerList.add((variant3.append(variant).append(number)).toString());
                    answerList.add((variant1.append(variant).append("+").append(number)).toString());
                    answerList.add((variant2.append(variant).append("-").append(number)).toString());
                }
            } else {
                answerList.add(Integer.toString(number));
                answerList.add("-" + Integer.toString(number));
            }
            input.remove(0);
            return calcSums(input, answerList);
        } else {
            if (variants.size() > 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    answerList.add((variant1.append(variant).append("+").append(number)).toString());
                }
            } else {
                answerList.add(Integer.toString(number));
            }
            input.remove(0);
            return calcSums(input, answerList);
        }
    }

    public static List<String> calcSums(List<MagicNumber> input) {
        return calcSums(input, new LinkedList<>());
    }
}
