package ee.taltech.iti0200.idcode;
import java.util.Map;
import java.util.HashMap;
public class IdCode {

    private final String idCodeValue;
    static public int ID_CODE_LENGTH = 11;

    enum Gender {
        MALE, FEMALE
    }

    public String getIdCodeValue() {
        return idCodeValue;
    }

    public IdCode(String idCodeValue) {
        this.idCodeValue = idCodeValue;
    }

    public boolean isCorrect() {
        String idCode = getIdCodeValue();
        for (int index = 0; index < idCode.length(); index++) {
            char letter = idCode.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        return idCode.length() == ID_CODE_LENGTH && isGenderNumberCorrect() && isYearNumberCorrect()
                && isMonthNumberCorrect() && isDayNumberCorrect() && isQueueNumberCorrect()
                && isControlNumberCorrect();
    }

    public String getInformation() {
        if (isCorrect()) {
            String idCode = getIdCodeValue();
            Gender gender = getGender();
            int yearInt = getFullYear();
            String year = Integer.toString(yearInt);
            String month = idCode.substring(3, 5);
            String day = idCode.substring(5, 7);
            String dateOfBirth = day + "." + month + "." + year;
            String city = getBirthPlace();
            return "This is a " + gender + " born on " + dateOfBirth + " in " + city;
        } else {
            return "Given invalid ID code!";
        }
    }

    public Gender getGender() {
        if (!isGenderNumberCorrect()) {
            return null;
        }
        String idCode = getIdCodeValue();
        char genderChar = idCode.charAt(0);
        int genderNumber = Character.getNumericValue(genderChar);
        if (genderNumber % 2 == 0) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    public String getBirthPlace() {
        if (!isQueueNumberCorrect()) {
            return "Wrong input!";
        }
        int identificator = 999;
        String answer = null;
        String idCode = getIdCodeValue();
        String queue = idCode.substring(7, 10);
        int queueNumber = Integer.parseInt(queue);
        if (0 > queueNumber || queueNumber > 999) {
            return "Wrong input!";
        } else if (queueNumber == 0) {
            return null;
        } else {
            Map<Integer, String> cityMap = new HashMap<Integer, String>();
            cityMap.put(10, "Kuressaare");
            cityMap.put(20, "Tartu");
            cityMap.put(220, "Tallinn");
            cityMap.put(270, "Kohtla-Järve");
            cityMap.put(370, "Tartu");
            cityMap.put(420, "Narva");
            cityMap.put(470, "Pärnu");
            cityMap.put(490, "Tallinn");
            cityMap.put(520, "Paide");
            cityMap.put(570, "Rakvere");
            cityMap.put(600, "Valga");
            cityMap.put(650, "Viljandi");
            cityMap.put(710, "Võru");
            cityMap.put(999, null);
            for (Integer cityNumber : cityMap.keySet()) {
                if (queueNumber <= cityNumber && identificator >= cityNumber) {
                    identificator = cityNumber;
                    answer = cityMap.get(cityNumber);
                }
            }
            return answer;
        }
    }

    public int getFullYear() {
        if (!isYearNumberCorrect()) {
            return -1;
        }
        String idCode = getIdCodeValue();
        char genderChar = idCode.charAt(0);
        int genderNumber = Character.getNumericValue(genderChar);
        int fullYear;
        if (genderNumber == 1 || genderNumber == 2) {
            fullYear = 1800;
        } else if ( genderNumber == 3 || genderNumber == 4) {
            fullYear = 1900;
        } else if (genderNumber == 5 || genderNumber == 6) {
            fullYear = 2000;
        } else {
            return -1;
        }
        String year = idCode.substring(1, 3);
        int yearOfBirth = Integer.parseInt(year);
        return fullYear += yearOfBirth;
    }

    private boolean isGenderNumberCorrect() {
        String idCode = getIdCodeValue();
        char genderChar = idCode.charAt(0);
        if (!Character.isDigit(genderChar)) {
            return false;
        }
        int genderNumber = Character.getNumericValue(genderChar);
        return 1 <= genderNumber && genderNumber <= 6;
    }

    private boolean isYearNumberCorrect() {
        String idCode = getIdCodeValue();
        String year = idCode.substring(1, 3);
        for (int index = 0; index < year.length(); index ++) {
            char letter = year.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int yearOfBirth = Integer.parseInt(year);
        return 0 <= yearOfBirth && yearOfBirth <= 99;
    }

    private boolean isMonthNumberCorrect() {
        String idCode = getIdCodeValue();
        String monthNumber = idCode.substring(3, 5);
        for (int index = 0; index < monthNumber.length(); index ++) {
            char letter = monthNumber.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int month = Integer.parseInt(monthNumber);
        return 1 <= month && month <= 12;
    }

    private boolean isDayNumberCorrect() {
        String idCode = getIdCodeValue();
        String month = idCode.substring(3, 5);
        int monthNumber = Integer.parseInt(month);
        String day = idCode.substring(5, 7);
        for (int index = 0; index < day.length(); index ++) {
            char letter = day.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int dayNumber = Integer.parseInt(day);
        int year = getFullYear();
        return (monthNumber == 2 && isLeapYear(year) && (1 <= dayNumber && dayNumber <= 29))
                || (monthNumber == 2 && !isLeapYear(year) && (1 <= dayNumber && dayNumber <= 28))
                || ((1 <= monthNumber && monthNumber <= 7) && monthNumber != 2 && monthNumber % 2 == 0 && (1 <= dayNumber
                && dayNumber <= 30))
                || ((1 <= monthNumber && monthNumber <= 7) && monthNumber % 2 != 0 && (1 <= dayNumber && dayNumber <= 31))
                || ((8 <= monthNumber && monthNumber <= 12) && monthNumber % 2 == 0 && (1 <= dayNumber && dayNumber <= 31))
                || ((8 <= monthNumber && monthNumber <= 12) && monthNumber % 2 != 0 && (1 <= dayNumber && dayNumber <= 30));
    }

    private boolean isQueueNumberCorrect() {
        String idCode = getIdCodeValue();
        String queue = idCode.substring(7, 10);
        for (int index = 0; index < queue.length(); index ++) {
            char letter = queue.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int queueNumber = Integer.parseInt(queue);
        return 0 <= queueNumber && queueNumber <= 999;
    }

    private boolean isControlNumberCorrect() {
        String idCode = getIdCodeValue();
        char lastChar = idCode.charAt(idCode.length() - 1);
        if (!Character.isDigit(lastChar)) {
            return false;
        }
        int lastNumber = Character.getNumericValue(lastChar);
        int integer = 1;
        int integer2 = 3;
        int sum1 = 0;
        int sum2 = 0;
        for (int index = 0; index < 10; index++) {
            char character = idCode.charAt(index);
            int number = Character.getNumericValue(character);
            sum1 += number * integer;
            if (integer == 9) {
                integer = 0;
            }
            integer += 1;
        }
        int controlNumber = sum1 % 11;
        if (controlNumber == 10) {
            for (int index = 0; index < 11; index++) {
                char character = idCode.charAt(index);
                int number = Character.getNumericValue(character);
                sum2 += number * integer2;
                if (integer2 == 9) {
                    integer2 = 1;
                }
                integer2 += 1;
            }
            controlNumber = sum2 % 11;
        }
        if (controlNumber == 10) {
            controlNumber = 0;
        }
        return controlNumber == lastNumber;
    }

    private boolean isLeapYear(int fullYear) {
        if (fullYear % 400 == 0) {
            return true;
        } else if (fullYear % 100 == 0) {
            return false;
        } else if (fullYear % 4 == 0) {
            return true;
        } else {
           return false;
        }
    }

    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("50003103736");
        //System.out.println(validMaleIdCode.isCorrect());
        System.out.println(validMaleIdCode.getInformation());
        //System.out.println(validMaleIdCode.getGender());
        //System.out.println(validMaleIdCode.getBirthPlace());
        //System.out.println(validMaleIdCode.getFullYear());
        //System.out.println(validMaleIdCode.isGenderNumberCorrect());
        //System.out.println(validMaleIdCode.isYearNumberCorrect());
        //System.out.println(validMaleIdCode.isMonthNumberCorrect());
        //System.out.println(validMaleIdCode.isDayNumberCorrect());
        //System.out.println(validMaleIdCode.isQueueNumberCorrect());
        //System.out.println(validMaleIdCode.isControlNumberCorrect());
        //System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}
