## 유진스의 하입보이 23/05/08 문제
- [A.직사각형(1945)](https://www.acmicpc.net/problem/1945)  
- [B.Треугольная рамка(21475)](https://www.acmicpc.net/problem/21475) 

### 1. [A.직사각형(1945)](https://www.acmicpc.net/problem/1945)  
0,0에서 어떤 직사각형을 지나는 직선을 그으려면 그 직선의 기울기는 왼쪽 위 꼭지점을 지날 때가 최대이고 
오른쪽 아래를 지날 때가 최소이다. 조심해야 할 점은 점을 지나면 그 직사각형을 지난다고 판단하는 것이다.
기울기를 0부터 시작해서 오른쪽 아래 점에 닿으면 현재 지나가는 직사각형을 +1, 왼쪽 위 꼭지점에 닿은 그 다음 순간에 -1
을 하는 식으로 구현했고, 최대값을 구하는 것이기 떄문에 오른쪽 아래 꼭지점이 더이상 없다면 스탑하는 거로 했다.
이를 구현하기 위해 플러스 마이너스라는 배열을 만들어 오른쪽 아래 꼭지점들을 플러스 배열에, 왼쪽 위 꼭지점들을 마이너스
배열에 넣었고, 와일문을 돌리는데, 플러스 배열의 길이가 0이 되면 멈추는 것으로 했다.

```python
plus = []
minus = []

t = int(input())
for _ in range(t):
    a, b, c, d = map(int, input().split())
    plus.append(b/c)
    minus.append(d/a)
plus.sort(reverse=True)
minus.sort(reverse=True)
max = -1 # 통과하는 직사각형 개수 최대값
now = 0 # 현재 지나가는 직사각형 개수
last = 0 # 전 기울기 값
buffer = 0 # 예를 들어 마이너스에 1이란 기울기가 3개 들어있으면 이 3개를 모두 지나고 이것의 다음 기울기가 왔을떄 한꺼번에 빼줘야 하므로 이걸 기다려주는 버퍼를 만듦
while plus:
    k = -1 #기울기 담을 변수 초기화
    if plus[-1]<minus[-1]: # 더 낮은 쪽 pop하기
        k = plus.pop()
        now+=1
        if last != k:
            now-= buffer
            buffer=0

    elif plus[-1]>minus[-1]:
        k = minus.pop()
        if last != k:
            now-= buffer
            buffer=1
        else: 
            buffer+=1
    else:                   #기울기 같으면 둘다 pop하기
        k= plus.pop()
        minus.pop()
        now+=1
        if last != k:
            now-= buffer
            buffer=1
        else: 
            buffer+=1
    if max<now:
        max = now

    last = k
print(max)
```

### 2. [B.Треугольная рамка(21475)](https://www.acmicpc.net/problem/21475) 
프레임을 세 개의 사다리꼴로 볼 수 있다. 그렇다면 이 합을 구하기 위해서는 사다리꼴의 큰 밑변은 a, b, c로 주어졌으므로 사다리꼴의 작은 밑변인 작은 삼각형의 세 변의 길이a', b', c'의 길이를 알아 내어
(a+a')*d/2+(b+b')*d/2+(c+c')*d/2 를 구해주면 된다. a', b', c'는 각 변의 길이를 알고 있으므로 제2코사인 법칙으로 세 각의 크기(알파, 베타, 감마)를 알아내고 꿑부분에 수선의 발을 내려 높이가 d이고 
세타가 아까 구한 그 각(알파, 베타, 감마)인 삼각형을 만들어 밑변의 길이, 즉 d*cot(알파, 베타, 감마)를 구한다(cot=코탄젠트) 작은 삼각형의 각 변의 길이는 (a-베타-감마), (b-감마-알파), (c-알파-베타)이므로
아까 위 식에 대입해보면 답을 구할 수 있다.
```python
from math import acos,sqrt,tan
a, b, c, d = map(int,input().split())

angleA = acos((b**2+c**2-a**2)/(2*b*c))     #제2코사인 법칙으로 세 각 구하기
angleHalfA = angleA/2                       # 그려보면 한 변을 공유하고 나머지 한 변은 d로 같게 주어지며 직각이므로 합동이다 따라서 각을 반으로 나눠준다.
angleB = acos((c**2+a**2-b**2)/(2*c*a))
angleHalfB = angleB/2
angleC = acos((a**2+b**2-c**2)/(2*a*b))
angleHalfC = angleC/2

aa =d/tan(angleHalfA)      #구한 각과 주어진 d를 이용하여 수선의 발을 내린 지점부터 꼭지점인 부분의 거리를 구함
bb=d/tan(angleHalfB)
cc=d/tan(angleHalfC)

answer = round((a+b+c-aa-bb-cc)*d,5) #세 개의 사다리꼴의 합을 구하고 소수점 5자리까지 표현한다.
print(answer)

```
