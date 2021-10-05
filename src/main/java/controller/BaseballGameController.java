package controller;

import domain.Computer;
import domain.Player;
import view.InputView;
import view.OutputView;


public class BaseballGameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Player player;
    private Computer computer;

    public BaseballGameController() {

    }

    public void startGame() {
        player = new Player();
        computer = new Computer();
        computer.createComputerNumbers();

        while (!player.isFinished()) {
            inputView.start();
            player.initialize();
            String result = player.getResult(inputView.getInput(), computer.getNumbers());
            outputView.printResult(result);
        }

        askPlayer();
    }

    private void askPlayer() {
        if (outputView.ask().equals("1")) {
            startGame();
        }
    }
}