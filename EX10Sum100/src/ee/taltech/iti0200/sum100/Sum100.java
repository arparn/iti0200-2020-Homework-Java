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
            num.append("0");
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
            System.out.println("Final variants: " + variants);
            return removeVariants(variants);
        }
        System.out.println(input.get(0).getNumber());
        short number = input.get(0).getNumber();
        List<String> answerList = new LinkedList<>();

        boolean subtract = input.get(0).canBeSubtracted();
        boolean placeNext = input.get(0).canBePlacedNextToOther();

        if (!subtract && placeNext) {
            if (variants.size() >= 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    StringBuilder variant2 = new StringBuilder();
                    System.out.println("All Variants: " + variants);
                    System.out.println("var: " + variant);
                    System.out.println("num: " + number);
                    if (!variant.contains(Integer.toString(number))) {
                        answerList.add((variant1.append(variant).append("+").append(number)).toString());
                        if (input.size() > 1 && input.get(1).canBePlacedNextToOther()) {
                            answerList.add((variant2.append(variant).append("+").append(number).append(input.get(1).getNumber())).toString());
                        }
                    }
                    if (!answerList.contains(variant)) {
                        answerList.add(variant);
                    }
                    System.out.println("Answer: " + answerList);
                }
            } else {
                if (input.get(1).canBePlacedNextToOther()) {
                    answerList.add(Integer.toString(number) + input.get(1).getNumber());
                }
                answerList.add(Integer.toString(number));
                System.out.println("1st AnswerList = " + answerList);
            }
            input.remove(0);
            return calcSums(input, answerList);
        } else if (subtract && !placeNext) {
            if (variants.size() >= 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    StringBuilder variant2 = new StringBuilder();
                    variant1.append(variant);
                    variant2.append(variant);
                    answerList.add((variant1.append("+").append(number)).toString());
                    answerList.add((variant2.append("-").append(number)).toString());
                }
            } else {
                answerList.add(Integer.toString(number));
                answerList.add("-" + Integer.toString(number));
            }
            input.remove(0);
            return calcSums(input, answerList);
        } else if (subtract) {
            if (variants.size() >= 1) {
                for (String variant : variants) {
                    StringBuilder variant1 = new StringBuilder();
                    StringBuilder variant2 = new StringBuilder();
                    StringBuilder variant3 = new StringBuilder();
                    System.out.println("All Variants: " + variants);
                    System.out.println("var: " + variant);
                    System.out.println("num: " + number);
                    if (!variant.contains(Integer.toString(number))) {
                        answerList.add((variant1.append(variant).append("+").append(number)).toString());
                        answerList.add((variant2.append(variant).append("-").append(number)).toString());
                        if (input.size() > 1 && input.get(1).canBePlacedNextToOther()) {
                            answerList.add((variant3.append(variant).append("+").append(number).append(input.get(1).getNumber())).toString());
                            answerList.add((variant3.append(variant).append("-").append(number).append(input.get(1).getNumber())).toString());
                        }
                    }
                    if (!answerList.contains(variant)) {
                        answerList.add(variant);
                    }
                    System.out.println("Answer: " + answerList);
                }
            } else {
                if (input.get(1).canBePlacedNextToOther()) {
                    answerList.add(Integer.toString(number) + input.get(1).getNumber());
                }
                answerList.add(Integer.toString(number));
                answerList.add("-" + Integer.toString(number));
                System.out.println("1st AnswerList = " + answerList);
            }
            input.remove(0);
            return calcSums(input, answerList);
        } else {
            if (variants.size() >= 1) {
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