## 유진스의 하입보이 23/05/01 문제
- [A.안테나(18310)](https://www.acmicpc.net/problem/18310)  

### 1. [A.안테나(18310)](https://www.acmicpc.net/problem/18310)  

입력으로 받은 수들을 오름차순으로 정렬한 후 중앙값을 선택한다.  
만약 N이 홀수라면 중앙값을 그대로 출력하여주고, 짝수라면 중앙값 2개 중 작은 값을 출력한다.  

```python
import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline())
    input = list(map(int, sys.stdin.readline().split()))
    input.sort()
    
    if (len(input)%2 == 1): print(input[len(input)//2])
    else: print(input[len(input)//2-1])
```