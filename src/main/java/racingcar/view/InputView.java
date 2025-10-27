package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryNumber = Integer.parseInt(Console.readLine());
            validateTryNumber(tryNumber); // 0 이하의 값이 들어오는지 검증
            return tryNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateTryNumber(int tryNumber) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
