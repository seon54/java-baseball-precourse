package domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static domain.Constant.NUMBER_SIZE;

public class Computer {

    private List<String> numbers = new ArrayList<>();

    public Computer() {
    }

    public List<String> getNumbers() {
        return numbers;
    }

    private boolean hasNumber(int number) {
        return numbers.contains(String.valueOf(number));
    }

    private void addComputerNumber(int num) {
        if (!hasNumber(num)) {
            numbers.add(String.valueOf(num));
        }
    }

    public void createComputerNumbers() {
        while (numbers.size() != NUMBER_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            addComputerNumber(number);
        }
    }
}