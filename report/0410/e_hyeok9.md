## 유진스의 하입보이 23/04/10 문제
- [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  
- [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 
- [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

### 1. [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  

조합 알고리즘을 사용해 9개의 입력 중 7개를 선택해 합을 구했다.  
만약 합이 100이라면 지금가지 거쳐온 루트를 저장해놓은 배열의 값을 순서대로 출력하였다.  

```python
import sys

global input
global visited

def combination(array, start, n, r):
    if (r == 0):
        if (sum(array) == 100):
            for i in range(len(array)-1, -1, -1):
                print(array[i])
        return
    
    for i in range(start, n):
        visited[i] = True
        array[r-1] = input[i] 
        combination(array, i+1, n, r-1)
        visited[i] = False


if __name__ == "__main__":
    input = []
    for i in range(9):
        input.append(int(sys.stdin.readline()))
    visited = [False for _ in range(len(input))]
    array = [0]*7
    combination(array, 0, 9, 7)
    
```

### 2. [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 

```python
```

### 3. [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

```python
```
