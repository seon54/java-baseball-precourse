package view;

import nextstep.utils.Console;

public class InputView {

    public void start() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String getInput() {
        return Console.readLine();
    }

}