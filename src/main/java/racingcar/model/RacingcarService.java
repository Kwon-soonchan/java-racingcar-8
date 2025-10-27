package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingcarService {
    private final List<Car> cars = new ArrayList<>();

    public void createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void raceOneRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getCurrentCarsState() {
        return cars;
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();

        // stream 사용
        return cars.stream()
                .filter(car -> car.getPosition() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxDistance) {
                maxDistance = car.getPosition();
            }
        }
        return maxDistance;
    }
}
