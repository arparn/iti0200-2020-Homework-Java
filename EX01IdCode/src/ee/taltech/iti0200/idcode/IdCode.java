package ee.taltech.iti0200.idcode;
public class IdCode {

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
        return false;
    }

    public String getInformation() {
        return null;
    }

    public Gender getGender() {
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
        return null;
    }

    public int getFullYear() {
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
        int genderNumber = Character.getNumericValue(genderChar);
        return 1 <= genderNumber || genderNumber <= 6;
    }

    private boolean isYearNumberCorrect() {
        String idCode = getIdCodeValue();
        String year = idCode.substring(1, 3);
        int yearOfBirth = Integer.parseInt(year);
        return 0 <= yearOfBirth || yearOfBirth <= 99;
    }

    private boolean isMonthNumberCorrect() {
        return false;
    }

    private boolean isDayNumberCorrect() {
        return false;
    }

    private boolean isQueueNumberCorrect() {
        return false;
    }

    private boolean isControlNumberCorrect() {
        return false;
    }

    private boolean isLeapYear(int fullYear) {
        return false;
    }

    public static void main(String[] args) {
        IdCode validMaleIdCode = new IdCode("37605030299");
        //System.out.println(validMaleIdCode.isCorrect());
        //System.out.println(validMaleIdCode.getInformation());
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