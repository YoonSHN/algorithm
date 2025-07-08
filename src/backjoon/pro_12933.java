package backjoon;

import java.util.Scanner;

public class pro_12933 {
    static final String SEQ = "quack";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        char[] chars = input.toCharArray();
        int length = chars.length;
        boolean[] visited = new boolean[length];

        int duckCount = 0;
        boolean found;

        while (true) {
            int idx = 0;  // "quack" 문자열의 인덱스
            found = false;
            for (int i = 0; i < length; i++) {
                if (visited[i]) continue;

                if (chars[i] == SEQ.charAt(idx)) {
                    visited[i] = true;
                    idx++;

                    if (idx == 5) idx = 0;  // "quack" 한 사이클 끝
                    found = true;
                }
            }

            if (!found) break;
            if (idx != 0) {
                // "quack"으로 끝나지 않았다는 뜻 → 불완전
                System.out.println(-1);
                return;
            }

            duckCount++;
        }

        // 모든 문자를 사용했는지 체크
        for (boolean v : visited) {
            if (!v) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(duckCount);
    }
}
