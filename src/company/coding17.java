package company;

public class coding17 {
    public static void main(String [] args){
        int []under_twenty = new int[]{0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8,6};   //0~20 까지 글자수
        int [] unit_of_ten = new int[]{0,3,6,6,5,5,5,7,6,6}; // 10~ 90까지
        int hundred_and = 10; // 백의 자리 에 항상 더해질 값
        int sum = 0; // 결과값
        int count1 = 0, count2 = 0, count3 = 0;

        int t,tt;
        for(int i = 1;i <  1000; ++i){
            if(i <= 20){
                sum += under_twenty[i];
                count1++;
            }
            else if(i < 100){
                t = i / 10; //십의 자리 구하기
                sum += unit_of_ten[t] + under_twenty[i % 10];
                count2++;
            }
            else{
                tt = i / 100; //백의 자리 구하기
                t = (i % 100 - i % 10) / 10; //십의 자리구하기
                if(i % 100 == 0){
                    sum += under_twenty[tt] + hundred_and - 3;
                }
                else if(i % 100 <= 20) { //
                    sum += under_twenty[tt] + hundred_and + under_twenty[i % 100];
                }else {
                    sum += under_twenty[tt] + hundred_and + unit_of_ten[t] + under_twenty[i % 10];
                }
                count3++;
            }
        }
        System.out.println(sum + 11);
        System.out.println("count1 = " + count1 +  "  count2 = "  +count2 + "  count3 = " + count3);
    }
}
