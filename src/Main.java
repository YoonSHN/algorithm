import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main{
    static Map<Integer, Boolean> happyCache = new HashMap<>();

    public static void main(String[] args){
        try{
             System.out.println(method1());
        }catch(Exception e){
            System.out.println("main 메서드에서 예외가 처리 되었습니다.");
        }
    }

    BufferedReader

    static int method1() throws Exception{
       try{
           System.out.println("mehtod1() 이 호출되엇습니다.");
           throw new Exception("ㅁㄴ");
       }catch(Exception e){
           e.printStackTrace();
           System.out.println("catch문");
           throw e;
       }finally{
           System.out.println("method1()의 finally블럭이 실행되었습니다.");
           return 3;
       }
    }
}
