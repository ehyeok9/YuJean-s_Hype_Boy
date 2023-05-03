
## 유진스의 하입보이 23/04/10 문제
- [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  
- [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 
- [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

### 1. [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  

 

```python
lst = []
for i in range(9):
    lst.append(int(input()))
summ = sum(lst)

lst_2 =[]
for i in range(9):
   if summ - lst[i]<=100:
      continue
   else:
      for j in range(i+1,9):
         if summ- lst[i] - lst[j] ==100:
            lst[i] = -1
            lst[j] = -1
for i in lst:
   if i>0:
      print(i)            

```

### 2. [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 

스택을 이용한다. for문으로 한명씩 받고 cnt를 1로 초기화해준다. 리스트가 비거나  다음에 뽑을 값이 현재 값보다 작거나 같을 때까지만 뽑는다.
만약 값이 같다면 볼수 있는 사람은 그 사람 +1만큼 볼수 있는 것이므로 +1을 해준다. 그리고 리스트가 존재한다면 한명은 최소 보는 것이므로 +1을 해준다.
마지막으로 현재의 값(h)와 바뀐 cnt값을 페어로 리스트에 저장한다.
```python

import sys
input = sys.stdin.readline
t = int(input())
lst=[]
sum=0
for _ in range(t):       
    inputt =int(input())
    cnt = 1

    while lst and lst[-1][0] <= inputt:
        h, cnt = lst.pop()
        sum += cnt
        if h == inputt:
            cnt+=1
        elif h<inputt:
            cnt = 1
    if lst:
        sum+=1
    lst.append((inputt,cnt))
print(sum)


```

### 3. [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

최소 값을 x라 했을 때 이 값이 가능한지를 검사한다.(이분탐색 이용) 그러다 불가능에서 가능으로 바뀌는 시점의 값을 보고 이 값이 나오게끔 재정렬을 시킨다.

```python
```
