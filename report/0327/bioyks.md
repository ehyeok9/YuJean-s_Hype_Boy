## 유진스의 하입보이 23/03/27 문제
- [A.팔(10164)](https://www.acmicpc.net/problem/1105)  
- [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  
- [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

### 1. [A.팔(10164)](https://www.acmicpc.net/problem/1105)  

일단 자릿수가 차이나면 모든 자릿수를 8이 아닌 숫자로 할 수 있기 때문에 0을 출력한다.

만약 자릿수가 같으면 맨 앞자리부터 비교한다. 높은 자리수부터 돌며 만약 수가 같으면 8인지를 검사하고 맞다면 카운트를 해준다.
만약 같지 않다면 b쪽이 더 클 것이고 그렇다면  그 자리 포함 그 자리 아래 모든 수들은 8이 아닌 숫자로 할 수 있기 때문에 break를 한다.
```python 
a, b = map(int,input().split())

strA, strB = str(a), str(b)

if len(strA) != len(strB):
    print(0)
else:
    count=0
    for i in range(len(strA)):
        if strA[i] == strB[i]:
            if strA[i] =='8':
                count+=1
        elif strA[i]<strB[i]:
            break

    print(count)
```

### 2. [B.관중석(9556)](https://www.acmicpc.net/problem/10166) 
못풀음
아이디어: 뒤에서부터 돌기? 아니면 기약분수
```python
```

### 3. [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

일단 모든 수를 2로나눈 몫과 나머지를 구하여 최대로 2를 넣을 수 있는 공간을 각자 센다
만약 이 때 1이 더 많다면 2를 쪼개서 1을 넣어야 하는데 그게 불가능 하므로 NO 출력
같다면 짝이 맞다는 뜻이므로 YES 출력
two가 크다면 계속 2를 쪼개보면서 2와 1이 같아지는 순간이 오면 YES 안오면 NO 출력
```python

t = int(input())

trees = list(map(int,input().split()))
one = 0
two = 0
for i in trees:
    if i%2 ==0:
        two+=i//2
    else:
        two+= i//2
        one+= 1

# 이 문제는 1이 주적이라 일단 2로 저장할 수 있는 건 모두 2로 저장하고 1 개수랑 비교
# 이랬는데도 1의개수가 더 크면 노 같으면 다 짝지으면 되니까 예쓰 2가 더 크면 2를 1로 쪼개면서 계속 2랑 1의 개수 비교하다가 같아지면 예쓰 같아지지 않으면 노
if(two<one):
    print("NO")
elif(two==one):
    print("YES")
else:
    a = two-one
    if a%3==0:
        print("YES")
    else:
        print("NO")


```
