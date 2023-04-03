## 유진스의 하입보이 23/03/27 문제
- [A.관중석(9556)](https://www.acmicpc.net/problem/10166)  
- [B.카드 정렬하기(1715)](https://www.acmicpc.net/problem/19539)  

### 1. [A.관중석(9556)](https://www.acmicpc.net/problem/10166)  
각도가 같으면 안된다 . -> 2/4, 3/6, 4/8 이런 값들은 중복이므로 하나만 카운트 해야한다.
D1부터 D2를 돌며 최대공약수를 구해서 만약 1이면 기약분수라는 뜻이므로 카운트한다. 기약 분수가 아니면 
기약 분수로 만들었을 때 그 분모가 범위 안에 있는지를 검사하고 범위 안에 있다면 다른 값이랑 중복된다는 뜻이므로 카운트 하지 않는다. 그런데 만약에 범위 내에 없다면 기약분수 형태를 만들어서 집합에 넣는다.카운트를 하지 않고 집합에 넣는이유는 돌다가 같은 값이 또 나올 수 있기 때문이다.(ex 4~8 2/4, 3/6, 4/8. 이 경우에는 기약분수로 만들었을 때 분모가 2라 범위를 벗어나는데, 만약 카운트를 다 한다면 중복된 값이 생기는 것이다. 따라서 기약분수 형태로 만들어서 집합에 넣어준다.)
집합은 자동으로 중복제거를 해주기 때문에  포문이 끝난 뒤 카운티 값고 집합의 길이를 더해주면 된다.

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
