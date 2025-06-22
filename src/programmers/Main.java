package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/389478?language=java
public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(13,3,6));
    }
}
class Solution {
    public int solution(int n, int w, int num) { // n -> 전채 개수, w -> 한줄에 들어갈 개수, num -> 빼야 하는 상자 번호
        int result = 1;
        int[] first_plus = new int[w];
        int[] second_plus = new int[w];

        int[][] board = new int[n / w + 1][w];

        for (int i = 0; i < board.length; ++i) {
            int tt = i * 2 + 1;
            int t = w * 2 - tt;

            first_plus[i] = t;
            second_plus[i] = tt;
        }
        int tx = 0, ty = 0; //num 좌표

        for (int i = 0; i < board.length; ++i) {
            if (tx == 0) {
                for (int j = 0; j < w; ++j) {

                    if (i == 0) {
                        board[i][i] = i + 1;
                    } else if (i % 2 == 0) {
                        board[i][j] = board[i - 1][j] + first_plus[j];
                        if (board[i][j] == num) {
                            tx = j;
                            ty = i;
                            break;
                        }
                    } else {
                        board[i][j] = board[i - 1][j] + second_plus[j];
                        if (board[i][j] == num) {
                            tx = j;
                            ty = i;
                            break;
                        }
                    }
                }
            } else {
                for (int j = 1; ; ) {
                    if (i % 2 == 0) {
                        if (num + first_plus[tx] * j <= n) {
                            result++;
                        } else {
                            System.out.println(result);
                            return result;
                        }
                    } else {
                        if (num + second_plus[tx] * j <= n) {
                            result++;
                        } else {
                            System.out.println(result);
                            return result;
                        }
                    }
                }
            }

        }
        return 0;
    }
}
