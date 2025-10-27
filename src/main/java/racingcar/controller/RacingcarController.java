package racingcar.controller;

import java.util.List;
import racingcar.model.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingcarService racingCarService;

    public RacingcarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingCarService = new RacingcarService();
    }

    public void run() {
        // 1. 입력
        String carNames = inputView.getCarNames();
        racingCarService.createCars(carNames);

        int tryNumber = inputView.getTryNumber();

        // 2. 실행
        outputView.printRaceStart();
        for (int i = 0; i < tryNumber; i++) {
            racingCarService.raceOneRound();
            outputView.printRoundResult(racingCarService.getCurrentCarsState());
        }

        // 3. 결과
        List<String> winners = racingCarService.findWinners();
        outputView.printWinners(winners);
    }
}
