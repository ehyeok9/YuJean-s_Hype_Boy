## 유진스의 하입보이 23/03/27 문제
- [A.팔(10164)](https://www.acmicpc.net/problem/1105)  
- [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  
- [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

### 1. [A.팔(10164)](https://www.acmicpc.net/problem/1105)  

- 두 수를 각 자리수로 쪼개어 리스트 형태로 변환한다.
- 두 수의 자리수가 맞지 않으면 답은 0
- 앞에서 부터 비교하여 8로 일치하면 카운트
- 8로 일치하지 않으면 종료한다.

```python
L, R = input().split()

L = list(map(int, list(L)))
R = list(map(int, list(R)))

cnt = 0

if len(L) != len(R):
    cnt = 0
else:
    for i in range(len(L)):
        if R[i] > L[i]:
            break

        if R[i] == 8 and L[i] == 8:
            cnt += 1

print(cnt)
```



### 2. [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  

- 0으로 채워진 2차원 배열을 생성한다
- 시작부터 끝까지 생성가능한 기약분수를 2차원 배열의 인덱스로하여 1로 저장하고 카운트한다.
- 만약 해당하는 인덱스에 값이 1이면 카운트하지 않고 넘어간다.
- 기약분수는 두 수의 최대공약수로 나누어서 만든다.

```python
from math import gcd
from sys import stdin

S, E = map(int, stdin.readline().split())
matrix = [[0]*E for _ in range(E)]
cnt = 0

for i in range(S, E+1):
    for j in range(1, i+1):
        g = gcd(i, j)
        x, y = i//g, j//g
        if not matrix[x-1][y-1]:
            matrix[x-1][y-1] = 1
            cnt += 1

print(cnt)

```

### 3. [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

- 만약 3으로 나누어 떨어지지 않고 3으로 나눈 몫이랑 각 나무를 2로 나눈 몫의 합이 일치하다면 YES
- 그렇지 않다면 NO

```python
N = int(input())
T = list(map(int, input().split()))
print("YES" if (sum(T) % 3 == 0) and (sum(T) // 3 <= sum([x//2 for x in T])) else "NO")
```
