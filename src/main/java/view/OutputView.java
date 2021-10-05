package view;

import nextstep.utils.Console;

public class OutputView {

    public void printResult(String result) {
        System.out.println(result);
    }

    public String ask() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return Console.readLine();
    }
}