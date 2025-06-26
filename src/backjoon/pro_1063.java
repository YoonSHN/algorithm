package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_1063 {
    private static Point rock;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String tmp = st.nextToken();
        Point me = new Point(tmp.charAt(0) - 'A' + 1,tmp.charAt(1) - '0');
        tmp = st.nextToken();
        rock = new Point(tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0');

        boolean flag = false; // touch 상태 값
        int count = Integer.parseInt(st.nextToken());
        for(int i = 0;i < count;++i){
            tmp = br.readLine();
            if(tmp.equals("R")){
                flag = isRockTouch(new Point(me.x + 1, me.y)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x + 1, rock.y)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.x++;
                        me.x++;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x + 1, me.y));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.x++;
                    }
                }
            }else if(tmp.equals("L")){
                flag = isRockTouch(new Point(me.x - 1, me.y)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x - 1, rock.y)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.x--;
                        me.x--;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x - 1, me.y));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.x--;
                    }
                }
            }else if(tmp.equals("B")){
                flag = isRockTouch(new Point(me.x , me.y - 1)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x, rock.y - 1)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.y--;
                        me.y--;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x, me.y - 1));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.y--;
                    }
                }
            }else if(tmp.equals("T")){
                flag = isRockTouch(new Point(me.x, me.y + 1)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x, rock.y + 1)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.y++;
                        me.y++;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x, me.y + 1));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.y++;
                    }
                }
            }else if(tmp.equals("RT")){
                flag = isRockTouch(new Point(me.x + 1, me.y + 1)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x + 1, rock.y + 1)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.x++;
                        rock.y++;
                        me.x++;
                        me.y++;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x + 1, me.y + 1));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.x++;
                        me.y++;
                    }
                }
            }else if(tmp.equals("LT")){
                flag = isRockTouch(new Point(me.x - 1, me.y + 1)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x - 1, rock.y + 1)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.x--;
                        rock.y++;
                        me.x--;
                        me.y++;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x - 1, me.y + 1));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.x--;
                        me.y++;
                    }
                }
            }else if(tmp.equals("RB")){
                flag = isRockTouch(new Point(me.x + 1, me.y - 1)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x + 1, rock.y - 1)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.x++;
                        rock.y--;
                        me.x++;
                        me.y--;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x + 1, me.y  - 1));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.x++;
                        me.y--;
                    }
                }
            }else if(tmp.equals("LB")){
                flag = isRockTouch(new Point(me.x - 1, me.y - 1)); //돌에 닿으면 true
                if(flag){// 돌에 닿았을 때
                    boolean rock_condition = isWallTouch(new Point(rock.x - 1, rock.y - 1)); //돌이 벽에 닿는가?
                    if(!rock_condition) { // 돌이 벽에 안닿을 때 -> 돌, me 이동
                        rock.x--;
                        rock.y--;
                        me.x--;
                        me.y--;
                    }
                }else { //돌에 안 닿았을 때
                    boolean me_condition = isWallTouch(new Point(me.x - 1, me.y - 1));
                    if(!me_condition){  // me가 벽에 안닿을 때 -> me 이동
                        me.x--;
                        me.y--;
                    }
                }
            }
        }

        System.out.println((char)(me.x - 1 + 'A')+""+me.y);
        System.out.println((char)(rock.x - 1 +'A')+""+rock.y);
    }

    private static boolean isWallTouch(Point point){ //벽에 닿으면 true
        return point.x < 1 || point.x > 8 || point.y < 1 || point.y > 8;
    }
    private static boolean isRockTouch(Point point){ //돌에 닿으면 true
        return (point.x == rock.x) && (point.y == rock.y);
    }
}
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
