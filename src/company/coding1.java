package company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class coding1 {
    static int [] isHappy = new int[10000]; // 1~9999까지의 수 중에 행복수 -> 2, 슬픈수 -> 1, 기본값 0
    public static void main(String[] args){
        int num_happy = 1;
        int sum_happy = 1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 2;i <= 9999;++i) {
            List<Integer> happy_assemble = new ArrayList<>(); // 어떤 수가 행복수 일때 그 행복수를 만들기 위한 숫자 조합을 저장
            int result = i;
            while (true) {
                if (isHappy[result] == 1|| happy_assemble.contains(result)) { //다시 반복 ( 슬픈수 확정)
                    for (int k = 0; k < happy_assemble.size(); ++k) { //슬픈수 조합 숫자들을 1로 저장
                        isHappy[happy_assemble.get(k)] = 1;
                    }
                    break;
                } else if (isHappy[result] == 2 || result == 1) { // 행복수 확정
                    for (int k = 0; k < happy_assemble.size(); ++k) {
                        isHappy[happy_assemble.get(k)] = 2;
                    }
                    num_happy++;
                    sum_happy += i;
                    break;
                }
                happy_assemble.add(result);
                result = makeNumber(result);
            }
            if (i == 9) {
                System.out.println("1 ~ " + i + " 범위의 행복수는 " + num_happy + "개이고 총합은 " + sum_happy + "입니다");
            } else if (i == 99) {
                System.out.println("1 ~ " + i + " 범위의 행복수는 " + num_happy + "개이고 총합은 " + sum_happy + "입니다");
            } else if (i == 999) {
                System.out.println("1 ~ " + i + " 범위의 행복수는 " + num_happy + "개이고 총합은 " + sum_happy + "입니다");
            } else if (i == 9999) {
                System.out.println("1 ~ " + i + " 범위의 행복수는 " + num_happy + "개이고 총합은 " + sum_happy + "입니다");
            }
        }
    }
    public static int makeNumber(int num){
        int result = 0;
        while(num > 0){
            result += (num % 10) * (num % 10);
            num /= 10;
        }
        return result;
    }
}
