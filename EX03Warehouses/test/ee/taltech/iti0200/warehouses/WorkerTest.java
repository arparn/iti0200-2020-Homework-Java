package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("Isac", "Clark", "50003103867", 75);
    }

    @Test
    void getWorkerSummary() {
        assertEquals("Isac Clark, 75 (50003103867)", worker.getWorkerSummary());
    }

    @Test
    void getFirstName() {
        assertEquals("Isac", worker.getFirstName());
    }

    @Test
    void setFirstName() {
        worker.setFirstName("Henry");
        assertEquals("Henry", worker.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Clark", worker.getLastName());
    }

    @Test
    void setLastName() {
        worker.setLastName("Karius");
        assertEquals("Karius", worker.getLastName());
    }

    @Test
    void getIdCode() {
        assertEquals("50003103867", worker.getIdCode());
    }

    @Test
    void setIdCode() {
        worker.setIdCode("582281337");
        assertEquals("582281337", worker.getIdCode());
    }

    @Test
    void getAge() {
        assertEquals(75, worker.getAge());
    }

    @Test
    void setAge() {
        worker.setAge(20);
        assertEquals(20, worker.getAge());
    }
}