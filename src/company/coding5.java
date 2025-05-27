package company;

/*
숫자 목록을 이용해 만든 두 자연 합의 최솟값
Coding Quiz 5
 */

import java.util.*;

public class coding5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] left_num; int[] right_num;

        while(true) {
            int left = 0, right = 0; // 위치 변수(인덱스)
            String tmp_str = scan.nextLine();
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(tmp_str, ", ");

            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            int zero_count = 0;
            for (int i = 0; i < list.size(); ++i) {
                if (list.get(i) == 0)
                    zero_count++;
                else
                    break;
            }
            if (zero_count == list.size() - 1) {
                System.out.println(-1);
                break;
            }

            for (int i = 0;  i < 2; ++i) {
                list.set(i, list.get(zero_count + i));
                list.set(zero_count + i, 0);
                if(zero_count == 1)
                    break;
            }


            if (list.size() % 2 == 0) { // 길이가 짝수 인경우 두개의 숫자의 길이는 같아짐
                left_num = new int[list.size() / 2];
                right_num = new int[list.size() / 2];
            } else {
                left_num = new int[list.size() / 2 + 1];
                right_num = new int[list.size() / 2];
            }

            for (int i = 0; i < list.size(); ++i) {
                if (i % 2 == 0) {
                    left_num[left++] = list.get(i);
                } else
                    right_num[right++] = list.get(i);
            }

            StringBuilder left_sb = new StringBuilder();
            StringBuilder right_sb = new StringBuilder();
            for (int left_value : left_num) {
                left_sb.append(left_value);
            }
            for (int right_value : right_num) {
                right_sb.append(right_value);
            }

            System.out.println(left_sb);
            System.out.println(right_sb);
            System.out.println(Long.parseLong(left_sb.toString()) + Long.parseLong(right_sb.toString()));

        }
    }

}
