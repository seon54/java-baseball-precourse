package domain;

import java.util.*;

import static domain.Constant.NUMBER_SIZE;
import static domain.ErrorMessage.*;

public class Player {

    private List<String> numbers = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    private int strike;
    private int ball;

    public Player() {
    }

    private boolean isRightNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return !inputNumber.contains("0");
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isDuplicated(String input) {
        set.addAll(Arrays.asList(input.split("")));
        return input.length() != set.size();
    }

    private boolean isRightSize() {
        return set.size() == NUMBER_SIZE;
    }

    public String getResult(String input, List<String> computerNumbers) {
        // 숫자인지 확인하기
        if (!isRightNumber(input)) {
            return NUMBER_RANGE_ERROR.getMessage();
        }

        // 서로 다른 숫자인지 확인하기
        if (isDuplicated(input)) {
            set.clear();
            return DUPLICATED_NUMBER_ERROR.getMessage();
        }

        // 3자리인지 확인하기
        if (!isRightSize()) {
            set.clear();
            return NUMBER_SIZE_ERROR.getMessage();
        }

        addNumbers(input);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < NUMBER_SIZE; i++) {
            String numstr = computerNumbers.get(i);
            countStrike(i, numstr);
            countBall(i, numstr);
        }

        if (strike > 0) {
            sb.append(String.format("%d스트라이크 ", strike));
        }

        if (ball > 0) {
            sb.append(String.format("%d볼", ball));
        }

        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        return String.valueOf(sb);
    }

    private void addNumbers(String input) {
        numbers = Arrays.asList(input.split(""));
    }

    public void initialize() {
        strike = 0;
        ball = 0;
        set.clear();
    }

    private void countStrike(int index, String comNum) {

        if (numbers.get(index).equals(comNum)) {
            strike++;
        }
    }

    private void countBall(int index, String comNum) {

        if (numbers.contains(comNum) && numbers.indexOf(comNum) != index) {
            ball++;
        }
    }

    public boolean isFinished() {
        return strike == NUMBER_SIZE;
    }
}

