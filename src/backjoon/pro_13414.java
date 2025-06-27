package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pro_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();

        int K = Integer.parseInt(tmp.split(" ")[0]);
        int L = Integer.parseInt(tmp.split(" ")[1]);

        Set<String> set = new LinkedHashSet<>();

        for(int i = 0;i < L;++i){
            tmp = br.readLine();

            set.remove(tmp);
            set.add(tmp);
        }

        int cnt = 0;
        for(String s :set){
            if(cnt == K) break;
            System.out.println(s);
            cnt++;
        }


    }
}
