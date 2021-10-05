package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    @DisplayName("랜덤으로 생성된 숫자는 3자리")
    void testComputerNumberLength() {
        Computer computer = new Computer();
        computer.createComputerNumbers();
        assertEquals(3, computer.getNumbers().size());
    }

    @Test
    @DisplayName("컴퓨터의 숫자는 중복된 값이 없는 3자리의 수")
    void testUniqueNumber() {
        Computer computer = new Computer();
        computer.createComputerNumbers();
        Set<String> set = new HashSet<>(computer.getNumbers());
        assertEquals(3, set.size());
    }

}