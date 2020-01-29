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
        return null;
    }

    public String getBirthPlace() {
        return null;
    }

    public int getFullYear() {
        return 0;
    }

    private boolean isGenderNumberCorrect() {
        return false;
    }

    private boolean isYearNumberCorrect() {
        return false;
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
        System.out.println(validMaleIdCode.isCorrect());
        System.out.println(validMaleIdCode.getInformation());
        System.out.println(validMaleIdCode.getGender());
        System.out.println(validMaleIdCode.getBirthPlace());
        System.out.println(validMaleIdCode.getFullYear());
        System.out.println(validMaleIdCode.isGenderNumberCorrect());
        System.out.println(validMaleIdCode.isYearNumberCorrect());
        System.out.println(validMaleIdCode.isMonthNumberCorrect());
        System.out.println(validMaleIdCode.isDayNumberCorrect());
        System.out.println(validMaleIdCode.isQueueNumberCorrect());
        System.out.println(validMaleIdCode.isControlNumberCorrect());
        System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
    }

}