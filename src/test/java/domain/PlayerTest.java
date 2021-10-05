package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static domain.ErrorMessage.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("입력값이 모두 숫자가 아니면 실패")
    @CsvSource(value = {"abc", "12a", "1@!"})
    @ParameterizedTest
    void testFailWithStringInput(String input) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList("1", "2", "3"));
        assertEquals(NUMBER_RANGE_ERROR.getMessage(), result);
    }

    @DisplayName("입력값이 범위가 맞지 않으면 실패")
    @CsvSource(value = {"150", "062", "028"})
    @ParameterizedTest
    void testFailWithWrongNumberInput(String input) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList("1", "2", "3"));
        assertEquals(NUMBER_RANGE_ERROR.getMessage(), result);
    }

    @DisplayName("입력값이 중복되면 실패")
    @CsvSource(value = {"112", "1212", "222"})
    @ParameterizedTest
    void testFailWithDuplicatedInput(String input) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList("1", "2", "3"));
        assertEquals(DUPLICATED_NUMBER_ERROR.getMessage(), result);
    }

    @DisplayName("입력값이 3자리가 아니면 실패")
    @CsvSource(value = {"1234", "5678", "23"})
    @ParameterizedTest
    void testFailWithWrongLengthInput(String input) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList("1", "2", "3"));
        assertEquals(NUMBER_SIZE_ERROR.getMessage(), result);
    }

    @DisplayName("3스트라이크")
    @CsvSource(value = {"123,123", "423,423", "987,987"})
    @ParameterizedTest
    void testThreeStrike(String input, String computerNumber) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertEquals("3스트라이크 ", result);
    }

    @DisplayName("2스트라이크")
    @CsvSource(value = {"123,163", "823,423", "387,987"})
    @ParameterizedTest
    void testTwoStrike(String input, String computerNumber) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertEquals("2스트라이크 ", result);
    }

    @DisplayName("1스트라이크 1볼")
    @CsvSource(value = {"139,123", "283,423", "782,987"})
    @ParameterizedTest
    void testOneStrikeOneBall(String input, String computerNumber) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertEquals("1스트라이크 1볼", result);
    }

    @DisplayName("1스트라이크 2볼")
    @CsvSource(value = {"321,123", "432,423", "978,987"})
    @ParameterizedTest
    void testOneStrikeTwoBall(String input, String computerNumber) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertEquals("1스트라이크 2볼", result);
    }

    @DisplayName("1볼")
    @CsvSource(value = {"435,123", "318,423", "825,987"})
    @ParameterizedTest
    void testOneBall(String input, String computerNumber) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertEquals("1볼", result);
    }

    @DisplayName("2볼")
    @CsvSource(value = {"237,123", "384,423", "892,987"})
    @ParameterizedTest
    void testThreeBall(String input, String computerNumber) {
        Player player = new Player();
        String result = player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertEquals("2볼", result);
    }

    @DisplayName("숫자를 맞혔을 경우 완료 상태")
    @CsvSource(value = {"457,457", "892,892", "153,153"})
    @ParameterizedTest
    void testGameFinish(String input, String computerNumber) {
        Player player = new Player();
        player.getResult(input, Arrays.asList(computerNumber.split("")));
        assertTrue(player.isFinished());
    }

    @DisplayName("strike, ball 개수와 set 초기화")
    @CsvSource(value = {"457,457", "892,892", "153,153"})
    @ParameterizedTest
    void testInitialize(String input, String computerNumber) {
        Player player = new Player();
        player.getResult(input, Arrays.asList(computerNumber.split("")));
        player.initialize();
        assertFalse(player.isFinished());
    }

}