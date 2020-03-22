package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    public static final long NUMBER = 543254826;
    public static final long NUMBER2 = 657544658;

    Person person;
    String name;
    String idCode;

    @BeforeEach
    void setUp() {
        this.person = new Person("Martin", "5678930472");
        this.name = "Martin";
        this.idCode = "5678930472";
    }

    @Test
    void getName() {
        assertEquals(name, person.getName());
    }

    @Test
    void getIdCode() {
        assertEquals(idCode, person.getIdCode());
    }

    @Test
    void getBorderCrossingId() {
        person.setBorderCrossingId(NUMBER);
        assertEquals(NUMBER, person.getBorderCrossingId());
    }

    @Test
    void setBorderCrossingId() {
        person.setBorderCrossingId(NUMBER2);
        assertEquals(NUMBER2, person.getBorderCrossingId());
    }
}
