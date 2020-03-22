package ee.taltech.iti0200.bordercontrol.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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
        person.setBorderCrossingId((long) 543254826);
        assertEquals((long) 543254826, person.getBorderCrossingId());
    }

    @Test
    void setBorderCrossingId() {
        person.setBorderCrossingId((long) 657544658);
        assertEquals((long) 657544658, person.getBorderCrossingId());
    }
}