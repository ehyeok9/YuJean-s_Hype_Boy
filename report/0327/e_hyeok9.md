## 유진스의 하입보이 23/03/27 문제
- [A.팔(10164)](https://www.acmicpc.net/problem/1105)  
- [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  
- [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

### 1. [A.팔(10164)](https://www.acmicpc.net/problem/1105)  

두 수의 제일 앞 자리 수부터 계산을 한다.  
만약 두 수의 인덱스의 값이 같다면, 계속 진행을 하고 그 값이 8이면 결과값에 +1을 해준다.  
만약 다르다면 멈추고 결과값을 출력한다.  
```python
from collections import deque
import imp
import sys
from collections import deque

def getArr(num):
    answer = deque()
    while(num > 0):
        answer.appendleft(num%10)
        num //= 10
    return answer

if __name__ == "__main__":
    l, r = map(int, sys.stdin.readline().split())
    
    arrl = getArr(l)
    arrr = getArr(r)
    
    if (len(arrl) != len(arrr)):
        print(0)
    else:
        answer = 0
        while(arrl and arrr):
            lval = arrl.popleft() 
            rval = arrr.popleft()
            if (lval != rval): break
            if (lval == 8 and rval == 8): answer += 1
        print(answer)
```

### 2. [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  


```python
```

### 3. [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

2/1을 동시에 써야하기 때문에 수들의 총합이 3으로 나누어 떨어지지 않으면 성립하지 않는다.  
만약 성립한다고 가정한다면 n번 했을 때, 2의 몫(이하 2)과 2로 나누어 떨어졌을 때의 값(이하 1)이 같아야 한다.  
1의 값이 2보다 많다면 가정이 성립하지 않는다.
1의 값과 2의 값이 같다면 성립한다.
2의 값이 1의 값보다 더 크다면 2에서 1을 뺀 값(이하 a)이 3으로 나누어 떨어진다면 성립한다. 그렇지 않다면 성립하지 않는다.  
```python
from functools import total_ordering
import math
import sys
from collections import deque

if __name__ == "__main__":
    n = int(sys.stdin.readline())
    input = list(map(int, sys.stdin.readline().split()))
    
    tval = sum(input)
    if (tval%3 != 0):
        print("NO")
    else:
        two = 0
        one = 0
        
        for val in input:
            two += val//2
            if (val%2 == 1): one += 1
        # print(two, one)
        
        if (two < one): print("NO")
        elif (two == one): print("YES")
        elif (two > one):
            a =two-one
            if a%3==0:
                print("YES")
            else:
                print("NO")
            # print(total)
            # if (total%2 == 0): print("YES")
            # else: print("NO")
```
