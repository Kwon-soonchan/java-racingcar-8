package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String positionBar = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + positionBar);
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winners);
    }
}
