package backjoon;

import java.util.*;

public class pro_2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] height = new int[1001]; // 위치별 높이 저장
        int left = 1001, right = 0;
        int maxHeight = 0, maxPos = 0;

        // 입력 처리
        for (int i = 0; i < N; i++) {
            int pos = sc.nextInt();
            int h = sc.nextInt();
            height[pos] = h;

            left = Math.min(left, pos);
            right = Math.max(right, pos);

            if (h > maxHeight) {
                maxHeight = h;
                maxPos = pos;
            }
        }

        // 최고 높이 구간의 시작과 끝 찾기
        int maxStart = maxPos;
        int maxEnd = maxPos;
        while (maxStart > left && height[maxStart - 1] == maxHeight) {
            maxStart--;
        }
        while (maxEnd < right && height[maxEnd + 1] == maxHeight) {
            maxEnd++;
        }

        int area = 0;

        // 왼쪽 → 최고 높이 시작 이전까지
        int curMax = 0;
        for (int i = left; i < maxStart; i++) {
            if (height[i] > curMax) curMax = height[i];
            area += curMax;
        }

        // 오른쪽 → 최고 높이 끝 다음까지
        curMax = 0;
        for (int i = right; i > maxEnd; i--) {
            if (height[i] > curMax) curMax = height[i];
            area += curMax;
        }

        // 최고 높이 구간 면적 추가
        int maxWidth = maxEnd - maxStart + 1;
        area += maxHeight * maxWidth;

        System.out.println(area);
    }
}
