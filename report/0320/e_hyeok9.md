## 유진스의 하입보이 23/03/20 문제
- [A.격자상의 경로(10164)](https://www.acmicpc.net/problem/10164)  
- [B.돌 게임2(9556)](https://www.acmicpc.net/problem/9656)  
- [C.주식(11501)](https://www.acmicpc.net/problem/11501)  
- [D.점프(1890)](https://www.acmicpc.net/problem/1890)  


### 1. [A.격자상의 경로(10164)](https://www.acmicpc.net/problem/10164)  


```python

```

### 2. [B.돌 게임2(9556)](https://www.acmicpc.net/problem/9656)  
규칙성을 찾아서 풀었다.
낼 수 있는 경우의 수가 1과 3이기에 홀수인 경우는 창연이가, 짝수인 경우는 상근이가 이기게 된다.
그 이유는 3이 1의 배수이기에 최선의 선택을 한다고 가정한다면 위의 결과가 나오게 된다.

```python
import sys
    
if __name__ == "__main__":
    n = int(sys.stdin.readline())
    if (n % 2 == 0):
        print("SK")
    else:
        print("CY")
    
    # 1 = 1 cy
    # 2 = 1 1 sk
    # 3 = 1 1 1 cy
    # 4 = 3 1 sk 
    # 5 = 3 1 1 cy
    # 6 = 1 3 1 1 sk
    # 7 = 3 3 1 cy 
    # 8 = 3 3 1 1 sk
```

### 3. [C.주식(11501)](https://www.acmicpc.net/problem/11501)  

  
```python

```

### 4. [D.점프(1890)](https://www.acmicpc.net/problem/1890)  
다이나믹 프로그래밍 알고리즘을 사용하여 문제를 풀었다.
배열의 범위값을 벗어나면 리턴.
만약 이미 방문했다면 방문한 결과값을 리턴.
배열의 값이 0이라면 리턴 해주어 답을 구했다.

```python
import sys

global array
global answer
global n
global visited

def dp(y, x, cnt):
    global answer
    if (y < 0 or y >= n): return 0
    if (x < 0 or x >= n): return 0
    
    if (visited[y][x] != 0): return visited[y][x]
    if (y == n-1 and x == n-1): return 1
    if (array[y][x] == 0): return 0
    
    visited[y][x] = dp(y+array[y][x], x, cnt+1) + dp(y, x+array[y][x], cnt+1)
    return visited[y][x]
    
if __name__ == "__main__":
    n = int(sys.stdin.readline())
    array = []
    visited = [[0] * n for _ in range(n)]
    answer = 0
    for i in range(n):
        tmp = list(map(int, sys.stdin.readline().split()))
        array.append(tmp)
    print(dp(0, 0, 1))
    
```
