## 유진스의 하입보이 23/05/115 문제
- [A.최소 스패닝 트리(1197)](https://www.acmicpc.net/problem/1197)  
- [B.원수의 원수(23818)](https://www.acmicpc.net/problem/23818) 
- [C.나무 자르기(2805)](https://www.acmicpc.net/problem/2805) 
- [D.줄 세우기(2252)](https://www.acmicpc.net/problem/2252) 

### 1. [A.최소 스패닝 트리(1197)](https://www.acmicpc.net/problem/1197)  


```python

```

### 2. [B.원수의 원수(23818)](https://www.acmicpc.net/problem/23818) 

```python

```

### 3. [C.나무 자르기(2805)](https://www.acmicpc.net/problem/2805) 

이분 탐색으로 입력으로 받은 값들을 탐색하며 그 값이 sum을 충족할 때, 멈추고 이를 출력하여 문제를 풀이하였다.  

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.Format;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.io.*;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class Main{
    static long[] array;
    static long m;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        m = Long.parseLong(ip[1]);

        String[] input = br.readLine().split(" ");
        array = new long[n];

        for (int i=0; i<n; i++){
            array[i] = Long.parseLong(input[i]);
        }
        input = null;

        bw.write(binarySearch(0, (long)Integer.MAX_VALUE + 1) + "\n");
        bw.flush();
        bw.close();
        br.close();    
    }

    public static long binarySearch(long lo, long hi){
        while (lo+1 < hi){
            long mid = (lo +hi)/2;
            if (cutting(mid)){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static boolean cutting(long val){
        long sum = 0;
        for (int i=0; i<array.length; i++){
            long tmp = array[i] - val;
            if (tmp > 0){
                sum += tmp;
            }
        }
        if (sum >= m){
            return true;
        }
        return false;
    }

    
    
    public static void printArray(int[] tmp){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<tmp.length; i++){
            sb.append(tmp[i] + " ");
        }
        System.out.println(sb);
    }
}

```

### 4. [D.줄 세우기(2252)](https://www.acmicpc.net/problem/2252) 

```python

```
