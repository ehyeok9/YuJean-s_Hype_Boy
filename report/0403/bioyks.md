## 유진스의 하입보이 23/03/27 문제
- [A.관중석(9556)](https://www.acmicpc.net/problem/10166)  
- [B.카드 정렬하기(1715)](https://www.acmicpc.net/problem/19539)  

### 1. [A.관중석(9556)](https://www.acmicpc.net/problem/10166)  


```python
import math
a, b = map(int,input().split())
cnt=0
sett=set()
if a==b:
    print(a)
    exit()
for i in range(b, a-1,-1):
    for j in range(1,i+1):
        GCD=math.gcd(i,j)
        if GCD ==1:
            cnt+=1
        else:
            if i//GCD<a:
                sett.add(i//GCD*10000+j//GCD)
print(len(sett)+cnt)
```

### 2. [B.카드 정렬하기(1715)](https://www.acmicpc.net/problem/19539)  

우선순위 큐를 이용하여 최소값두개를 계속 추출하고 더한 다음 그 값을 우선순위 큐에 넣어 다시 정렬시키는 방식으로 하였다.
```python
from queue import PriorityQueue
que = PriorityQueue(100000)
a=int(input())
sum=0
for _ in range(a):
    que.put(int(input()))
if a==1:
    print(0)
    exit()
while True:
    first=que.get()
    second = que.get()
    tmp = first+second
    sum+=tmp
    if que.empty()!= True:
        que.put(tmp)
    else:
        break
print(sum)

```
