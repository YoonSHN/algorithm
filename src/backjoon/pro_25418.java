package backjoon;

import java.util.*;
public class pro_25418 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int K = scan.nextInt();

        scan.close();

        int MAX = 1_000_001;
        boolean[] visited = new boolean[MAX];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 0));
        visited[A] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.value == K){
                System.out.println(current.count);
                return;
            }

            if(current.value + 1 < MAX && !visited[current.value + 1]){
                visited[current.value + 1] = true;
                queue.add(new Node(current.value + 1, current.count + 1));
            }

            if(current.value * 2 < MAX && !visited[current.value * 2]){
                visited[current.value * 2] = true;
                queue.add(new Node(current.value * 2, current.count + 1));
            }
        }

    }
    static class Node{
        int value;
        int count;

        Node(int value, int count){
            this.value = value;
            this.count = count;
        }
    }

}
