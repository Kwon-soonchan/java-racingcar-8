package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());

        String[] carNameList = carNames.split(",");
        int[] countForward = new int[carNameList.length];

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < carNameList.length; j++) {
                int num = Randoms.pickNumberInRange(0, 9);

                if (num >= 4) {
                    countForward[j]++;
                }
                System.out.println(carNameList[j] + " : " + "-".repeat(countForward[j]));
            }
            System.out.println();
        }

        int maxDistance = 0;
        for (int count : countForward) {
            if (count > maxDistance) {
                maxDistance = count;
            }
        }

        List<String> winners = new ArrayList<String>();

        for (int i = 0; i < countForward.length; i++) {
            if (countForward[i] == maxDistance) {
                winners.add(carNameList[i]);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));

    }
}
