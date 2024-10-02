import java.io.*;
import java.util.*;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] notLeap = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //365
        int [] leap = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //366
        int answer = 0;
        int n  = Integer.parseInt(br.readLine());
        int start = 4; // 1/4이 금요일임
        for(int i = 2019;i <= n;++i){
            boolean check = isLeap(i); // 윤년 체크
            if(check) {
                for (int j = 1; j <= 12; ++j) {
                    while(true){
                        if(start == 13)
                            answer++;
                        start += 7;
                        if(start > leap[j])
                            break;
                    }
                    start -= leap[j];
                }
            }
            else{
                for(int j = 1;j <= 12;++j){
                    while(true){
                        if(start == 13)
                            answer++;
                        start += 7;
                        if(start > notLeap[j])
                            break;
                    }
                    start -= notLeap[j];
                }
            }
        }
        System.out.println(answer);

    }
    public static boolean isLeap(int year){
        if(year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))){
            return true;
        }
        return false;
    }
}
