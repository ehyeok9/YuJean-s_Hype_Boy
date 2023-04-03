## 유진스의 하입보이 23/03/20 문제
- [A.격자상의 경로(10164)](https://www.acmicpc.net/problem/10164)  
- [B.돌 게임2(9556)](https://www.acmicpc.net/problem/9656)  
- [C.주식(11501)](https://www.acmicpc.net/problem/11501)  
- [D.점프(1890)](https://www.acmicpc.net/problem/1890)  


### 1. [A.격자상의 경로(10164)](https://www.acmicpc.net/problem/10164)  

일단 가로와 세로로 가야하는 횟수를 구한다. a와 b중에서 더 큰수로 나눈 몫과 나머지를 구하면 된다.
이후 중간 지점 까지, 중간 지점에서 도착 지점까지 갈 때 필요한 가로 세로 횟수를 구하고  각각 콤비네이션을 한 후 곱하면 된다.
```python
from math import comb

a,b,c=map(int,input().split())
if(c == 0):
    combi =comb(a+b-2, a-1)
    print(combi)
else:
    mogs_before, nameoji_before = divmod(c-1, max(a,b))
    mogs_after,nameoji_after =a-1-mogs_before,b-1-nameoji_before
    answer = comb(mogs_before+nameoji_before,mogs_before)*comb(nameoji_after+mogs_after, nameoji_after)
    print(answer)


```

### 2. [B.돌 게임2(9556)](https://www.acmicpc.net/problem/9656)  
규칙성을 찾아서 풀었다.
잉여류로 풀었다. 4n, 4n+2이면 SK가 이기고 4n+1, 4n+3이면 CY가 이긴다.

```python
p= int(input())
if p%2 ==0:
    print('SK')
else:
    print('CY')
```

### 3. [C.주식(11501)](https://www.acmicpc.net/problem/11501)  

  
```python

```

### 4. [D.점프(1890)](https://www.acmicpc.net/problem/1890)  

한번한번 움직일때마다 
그 위치에 
거기에 갈 수 있는 모든 경우의 수를 저장해주면서 갔다.
포문을 돌면서 모든 위치를 돌며 그 위치의 아래나 오른쪽이 범위를 벗어나지 않으면 현위치의 값을 그 다음 움직인 값에 더해줬다.
그리고 0인 지점을 만나면 break를 하고 도착지점에 저장된 값을 프린트해줬다.

```python
from collections import deque
t = int(input())
jump_lst=[]
for _ in range(t):
    jump_lst.append(list(map(int,input().split())))
able_jump=deque()
able_jump.append([0,0])
cnt = 0
count_list = [[0 for i in range(t)] for i in range(t)]
count_list[0][0]=1
for i in range(t):
    for j in range(t):
        size = jump_lst[i][j]
        if size == 0:
            break
        if (i+size)<t:
            count_list[i+size][j] += count_list[i][j]
        if (j+size)<t:
            count_list[i][j+size] += count_list[i][j]


print(count_list[-1][-1])

```
