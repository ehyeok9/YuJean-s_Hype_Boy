## 유진스의 하입보이 23/04/03 문제
- [A.관중석(10166)](https://www.acmicpc.net/problem/10166)  
- [B.카드 정렬하기(1715)](https://www.acmicpc.net/problem/1715)  

### 1. [A.관중석(9556)](https://www.acmicpc.net/problem/10166)  


```python
```

### 2. [B.카드 정렬하기(9556)](https://www.acmicpc.net/problem/1715)

heap 자료구조로 만들어진 Priority Queue를 사용해 시간 초과를 해결하였다.
매 반복마다 sort하면 시간 복자도가 O(n^2)이 되는데 우선순위큐를 사용하면 최소 O(log n) / 최대 O(n)이기에 무사히 통과할 수 있었다. 

```python
from queue import PriorityQueue
import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline())
    
    if (n == 1): print(0)
    else:
        pq = PriorityQueue()
        for i in range(n):
            tmp = int(sys.stdin.readline())
            pq.put(tmp)
        
        answer = 0
        while (pq.qsize() > 2):
            a = pq.get()
            b = pq.get()
            answer += a+b
            pq.put(a+b)
        
        a = pq.get()
        b = pq.get()
        answer += a+b
        print(answer) 
```
