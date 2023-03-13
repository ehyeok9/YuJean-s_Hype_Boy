## 유진스의 하입보이 23/03/13 문제
- [A : 단지번호붙이기(2667)](https://www.acmicpc.net/problem/2667)
- [B : Z(1074)](https://www.acmicpc.net/problem/1074)  
- [C : 에디터(1406)](https://www.acmicpc.net/problem/1406)  
- [D : 다음 순열(10972)](https://www.acmicpc.net/problem/10972)  
- [E : 회의실 배정(1931)](https://www.acmicpc.net/problem/1931)  

### 1. [A : 단지번호붙이기(2667)](https://www.acmicpc.net/problem/2667)
Pair class : 좌표값을 저장할 클래스  
Main : 입출력 및 배열 초기화, 배열 전체를 돌며 방문하지 않았고 배열값이 1인 경우 bfs를 돌려줌. 그 후 결과값이 있는 리스트를 정렬 후 순차적으로 출력함.  
bfs : 매개변수로 전달받은 지점으로부터 상하좌우를 탐색해 방문하지 않았고 1인 경우를 카운트 한 다음 전역변수로 선언 된 리스트에 카운트한 값을 추가해줌.  
check : 좌표가 배열의 범위값을 넘어갔는지 판단하는 함수    

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class Main{
    static int[][] array;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0 , 0};
    static int[] dx = {0 , 0, -1, 1};
    static ArrayList<Integer> result = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++){
            String input = br.readLine();
            for (int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(input.substring(j, j+1));
            }
        }
        
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (array[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        bw.write(result.size() + "\n");
        Collections.sort(result);
        for (int val : result){
            bw.write(val + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();    
    }

    public static void bfs(int y, int x){
        Deque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(y, x));
        int sum = 1;
        while (!deque.isEmpty()){
            Pair node = deque.pollFirst();
            visited[node.first][node.second] = true;

            for (int i=0; i <4; i++){
                int ny = node.first + dy[i];
                int nx = node.second + dx[i];
                if (check(ny, nx) && !visited[ny][nx]){
                    if (array[ny][nx] == 1){
                        deque.add(new Pair(ny, nx));
                        sum++;
                    }
                    visited[ny][nx] = true;
                }
            }
        }
        result.add(sum);
    }

    public static boolean check(int y, int x){
        if (y >= n || y < 0){
            return false;
        }
        if (x >= n || x < 0){
            return false;
        }
        return true;
    }

    public static void printArray(int[][] tmp){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<tmp.length; i++){
            for (int j=0; j<tmp[i].length; j++){
                sb.append(tmp[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
```

### 2. [B : Z(1074)](https://www.acmicpc.net/problem/1074)  
Main : 입력 받은 값을 getVal함수의 매개변수로 넘겨준 후 함수 실행. 결과값을 출력한다.  
getVal : 매개변수로 전달 받은 length가 1이 될 때까지 재귀를 돌려줌. 재귀 도중 목표로 하는 위치의 사분면과 다르면 그 재귀는 멈춤. 만약 재귀 도중 목표 지점에 도착하면 num의 결과를 저장해준다.    

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    static int len;
    static int r;
    static int c;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        len = (int)Math.pow(2, n);
        
        getval(0, 0, len, 0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();    
    }

    public static void getval(int y, int x, int length, int num){
        if (length == 1){
            if (y == r && x == c){
                result = num;
            }
            return;
        }
        
        if (y+length < r || x+length < c || y > r || x > c ) return;
        // System.out.println(num);
        
        int lenval = length/2;
        int valplus = (int)Math.pow(lenval, 2);

        getval(y, x, lenval, num);
        getval(y, x+lenval, lenval, num+valplus);
        getval(y+lenval, x, lenval, num+(valplus*2));
        getval(y+lenval, x+lenval, lenval, num+(valplus*3));
    }
}
```

### 3. [C.에디터(1406)](https://www.acmicpc.net/problem/1406)  
커서를 기준으로 앞뒤에 있을 deque를 두 개 만들어 준다.  
입력에 맞게 값들을 앞뒤 값들을 디큐 사이에서 옮겨준다.  
두 디큐를 앞쪽에서부터 빌 때까지 프린트해준다.
  
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main{
    static boolean[][] visited;
    static int[][] array;
    static int n;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Character> deque_left = new ArrayDeque<>();
        ArrayDeque<Character> deque_right = new ArrayDeque<>();
        for (int i=0; i<str.length(); i++){
            deque_left.add(str.charAt(i));
        }
        
        for (int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            String edit = input[0];
            if (edit.equals("L")){
                if (deque_left.isEmpty()) continue;
                deque_right.addFirst(deque_left.pollLast());
            } else if (edit.equals("D")){
                if (deque_right.isEmpty()) continue;
                deque_left.add(deque_right.pollFirst());
            } else if (edit.equals("B")){
                if (deque_left.isEmpty()) continue;
                deque_left.pollLast();
            } else if (edit.equals("P")){
                deque_left.add(input[1].charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque_left.isEmpty()){
            sb.append(deque_left.pollFirst());
        }
        while (!deque_right.isEmpty()){
            sb.append(deque_right.pollFirst());
        }
        bw.write(sb +"\n");
        bw.flush();
        bw.close();
        br.close();    
    }
}
```

### 4. [D.다음 순열(10972)](https://www.acmicpc.net/problem/10972)  
reverse 배열을 만들어 input 배열과 같을 경우 -1을 출력한다.  
다를 경우, 뒤에서부터 앞의 값이 현재 위치의 값보다 큰 인덱스를 찾아 저장한다. 이를 tidx라 한다.  
다시 뒤에서부터 순차적으로 tidx의 값보다 큰 값의 인덱스를 찾는다. 이를 pidx라고 한다.  
tidx의 값과 pidx의 값을 바꾼다. pidx 이후의 값은 정렬한다.  
이를 앞에서부터 순차적으로 출력한다.  

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] reverse = new int[input.length];
        int[] list = new int[input.length];

        int cnt = 1;
        for (int i=input.length-1; i>-1; i--){
            list[i] = Integer.parseInt(input[i]);
            reverse[i] = cnt++;
        }
        input = null;

        if (check(reverse, list)){
            bw.write(-1 + "\n");
        } else {
            int pidx = 0;
            for (int i=list.length-1; i>0; i--){
                if (list[i-1] < list[i]){
                    pidx = i-1;
                    break;
                }
            }
            
            int tidx = 0;
            for (int i=list.length-1; i>-1; i--){
                if (list[i] > list[pidx]){
                    tidx = i;
                    break;
                }
            }
            
            int num = list[pidx];
            list[pidx] = list[tidx];
            list[tidx] = num;
            
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i<=pidx; i++){
                sb.append(list[i] + " ");
            }
            int[] arr = Arrays.copyOfRange(list, pidx+1, list.length);
            Arrays.sort(arr);
            for (int i : arr){
                sb.append(i + " ");
            }
            
            System.out.println(sb);
        }

        bw.flush();
        bw.close();
        br.close();    
    }

    public static boolean check(int[] a, int[] b){
        for (int i=0; i<a.length; i++){
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
```


### 5. [E.회의실 배정(1931)](https://www.acmicpc.net/problem/1931)  
회의실 배정은 종료 시간이 빠른 순서로 카운트해주면 된다.  
입력을 받아 Pair 제네릭으로 리스트를 만든다.  
리스트를 회의 종료가 빠른 순서대로 정렬한다. 만약 종료 시간이 같다면 시작 시간으로 오름차순으로 정렬한다.  
앞에서부터 리스트를 순차적으로 돌며 이전 종료시간보다 같거나 큰 시작 시간을 카운트한다.  
이를 출력한다.
  
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Pair{
    int start;
    int end;
    int len;

    public Pair(int start, int end, int len){
        this.start = start;
        this.end = end;
        this.len = len;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            list.add(new Pair(start, end, end-start));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b){
                if (a.end == b.end){
                    return a.start - b.start;
                }
                return a.end - b.end;
            }
        });

        int result = 1;
        int endtime = list.get(0).end;
        for (int i=1; i<list.size(); i++){
            Pair tmp = list.get(i);
            if (tmp.start >= endtime){
                result++;
                endtime = tmp.end;
            }
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();    
    }
}
```