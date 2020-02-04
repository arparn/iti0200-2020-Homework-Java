package ee.taltech.iti0200.idcode;
import java.util.Map;
import java.util.HashMap;
public class IdCode {
    public static final int ID_CODE_LENGTH = 11;
    public static final int IDENTIFICATION_NUMBER = 999;
    public static final int CITY_MAP_TARTU = 20;
    public static final int CITY_MAP_TALLINN = 220;
    public static final int CITY_MAP_KOHTLA_JARVE = 270;
    public static final int CITY_MAP_TARTU2 = 370;
    public static final int CITY_MAP_NARVA = 420;
    public static final int CITY_MAP_PARNU = 470;
    public static final int CITY_MAP_TALLINN2 = 490;
    public static final int CITY_MAP_PAIDE = 520;
    public static final int CITY_MAP_RAKVERE = 570;
    public static final int CITY_MAP_VALGA = 600;
    public static final int CITY_MAP_VILJANDI = 650;
    public static final int CITY_MAP_VORU = 710;
    public static final int CENTURY1 = 1800;
    public static final int CENTURY2 = 1900;
    public static final int CENTURY3 = 2000;
    public static final int DAY_INDEX7 = 7;
    public static final int DAY_INDEX6 = 6;
    public static final int MAX_MONTH = 12;
    public static final int MONTH_INDEX8 = 8;
    public static final int AMOUNT_OF_DAYS1 = 29;
    public static final int AMOUNT_OF_DAYS2 = 28;
    public static final int AMOUNT_OF_DAYS3 = 30;
    public static final int AMOUNT_OF_DAYS4 = 31;
    public static final int MONTH_INDEX9 = 9;
    public static final int CONTROL_NUMBER11 = 11;
    public static final int LEAP_YEAR_CONTROL = 400;


    private final String idCodeValue;

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
            String day = idCode.substring(5, DAY_INDEX7);
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
        int identificator = IDENTIFICATION_NUMBER;
        String answer = null;
        String idCode = getIdCodeValue();
        String queue = idCode.substring(DAY_INDEX7, 10);
        int queueNumber = Integer.parseInt(queue);
        if (queueNumber == 0) {
            return null;
        } else {
            Map<Integer, String> cityMap = new HashMap<Integer, String>();
            cityMap.put(10, "Kuressaare");
            cityMap.put(CITY_MAP_TARTU, "Tartu");
            cityMap.put(CITY_MAP_TALLINN, "Tallinn");
            cityMap.put(CITY_MAP_KOHTLA_JARVE, "Kohtla-Järve");
            cityMap.put(CITY_MAP_TARTU2, "Tartu");
            cityMap.put(CITY_MAP_NARVA, "Narva");
            cityMap.put(CITY_MAP_PARNU, "Pärnu");
            cityMap.put(CITY_MAP_TALLINN2, "Tallinn");
            cityMap.put(CITY_MAP_PAIDE, "Paide");
            cityMap.put(CITY_MAP_RAKVERE, "Rakvere");
            cityMap.put(CITY_MAP_VALGA, "Valga");
            cityMap.put(CITY_MAP_VILJANDI, "Viljandi");
            cityMap.put(CITY_MAP_VORU, "Võru");
            cityMap.put(IDENTIFICATION_NUMBER, null);
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
            fullYear = CENTURY1;
        } else if (genderNumber == 3 || genderNumber == 4) {
            fullYear = CENTURY2;
        } else if (genderNumber == 5 || genderNumber == DAY_INDEX6) {
            fullYear = CENTURY3;
        } else {
            return -1;
        }
        String year = idCode.substring(1, 3);
        int yearOfBirth = Integer.parseInt(year);
        fullYear += yearOfBirth;
        return fullYear;
    }

    private boolean isGenderNumberCorrect() {
        String idCode = getIdCodeValue();
        char genderChar = idCode.charAt(0);
        if (!Character.isDigit(genderChar)) {
            return false;
        }
        int genderNumber = Character.getNumericValue(genderChar);
        return 1 <= genderNumber && genderNumber <= DAY_INDEX6;
    }

    private boolean isYearNumberCorrect() {
        String idCode = getIdCodeValue();
        String year = idCode.substring(1, 3);
        for (int index = 0; index < year.length(); index++) {
            char letter = year.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMonthNumberCorrect() {
        String idCode = getIdCodeValue();
        String monthNumber = idCode.substring(3, 5);
        for (int index = 0; index < monthNumber.length(); index++) {
            char letter = monthNumber.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int month = Integer.parseInt(monthNumber);
        return 1 <= month && month <= MAX_MONTH;
    }

    private boolean isDayNumberCorrect() {
        String idCode = getIdCodeValue();
        String month = idCode.substring(3, 5);
        int monthNumber = Integer.parseInt(month);
        String day = idCode.substring(5, DAY_INDEX7);
        for (int index = 0; index < day.length(); index++) {
            char letter = day.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int dayNumber = Integer.parseInt(day);
        int year = getFullYear();
        return (monthNumber == 2 && isLeapYear(year) && (1 <= dayNumber && dayNumber <= AMOUNT_OF_DAYS1))
                || (monthNumber == 2 && !isLeapYear(year) && (1 <= dayNumber && dayNumber <= AMOUNT_OF_DAYS2))
                || ((1 <= monthNumber && monthNumber <= DAY_INDEX7) && monthNumber != 2 && monthNumber % 2 == 0
                && (1 <= dayNumber && dayNumber <= AMOUNT_OF_DAYS3)) || ((1 <= monthNumber && monthNumber <= DAY_INDEX7)
                && monthNumber % 2 != 0 && (1 <= dayNumber && dayNumber <= AMOUNT_OF_DAYS4))
                || ((MONTH_INDEX8 <= monthNumber && monthNumber <= MAX_MONTH) && monthNumber % 2 == 0
                && (1 <= dayNumber && dayNumber <= AMOUNT_OF_DAYS4)) || ((MONTH_INDEX8 <= monthNumber
                && monthNumber <= MAX_MONTH) && monthNumber % 2 != 0 && (1 <= dayNumber
                && dayNumber <= AMOUNT_OF_DAYS3));
    }

    private boolean isQueueNumberCorrect() {
        String idCode = getIdCodeValue();
        String queue = idCode.substring(DAY_INDEX7, 10);
        for (int index = 0; index < queue.length(); index++) {
            char letter = queue.charAt(index);
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        int queueNumber = Integer.parseInt(queue);
        return 0 <= queueNumber && queueNumber <= IDENTIFICATION_NUMBER;
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
            if (integer == MONTH_INDEX9) {
                integer = 0;
            }
            integer += 1;
        }
        int controlNumber = sum1 % CONTROL_NUMBER11;
        if (controlNumber == 10) {
            for (int index = 0; index < CONTROL_NUMBER11; index++) {
                char character = idCode.charAt(index);
                int number = Character.getNumericValue(character);
                sum2 += number * integer2;
                if (integer2 == MONTH_INDEX9) {
                    integer2 = 1;
                }
                integer2 += 1;
            }
            controlNumber = sum2 % CONTROL_NUMBER11;
        }
        if (controlNumber == 10) {
            controlNumber = 0;
        }
        return controlNumber == lastNumber;
    }

    private boolean isLeapYear(int fullYear) {
        if (fullYear % LEAP_YEAR_CONTROL == 0) {
            return true;
        } else if (fullYear % 100 == 0) {
            return false;
        } else return fullYear % 4 == 0;
    }

    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("49812115320");
        //System.out.println(validMaleIdCode.isCorrect());
        //System.out.println(validMaleIdCode.getInformation());
        //System.out.println(validMaleIdCode.getGender());
        //System.out.println(validMaleIdCode.getBirthPlace());
        //System.out.println(validMaleIdCode.getFullYear());
        System.out.println(validMaleIdCode.isGenderNumberCorrect());
        System.out.println(validMaleIdCode.isYearNumberCorrect());
        System.out.println(validMaleIdCode.isMonthNumberCorrect());
        System.out.println(validMaleIdCode.isDayNumberCorrect());
        System.out.println(validMaleIdCode.isQueueNumberCorrect());
        System.out.println(validMaleIdCode.isControlNumberCorrect());
        //System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}
