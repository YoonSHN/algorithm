package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class pro_1706 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine(); // 줄바꿈 처리

        char[][] puzzle = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                puzzle[i][j] = line.charAt(j);
            }
        }

        List<String> words = new ArrayList<>();

        // 가로 단어 추출
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (puzzle[i][j] != '#') {
                    sb.append(puzzle[i][j]);
                } else {
                    if (sb.length() >= 2) words.add(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() >= 2) words.add(sb.toString());
        }

        // 세로 단어 추출
        for (int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                if (puzzle[i][j] != '#') {
                    sb.append(puzzle[i][j]);
                } else {
                    if (sb.length() >= 2) words.add(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() >= 2) words.add(sb.toString());
        }

        // 사전순 정렬
        Collections.sort(words);
        System.out.println(words.get(0));
    }

}
