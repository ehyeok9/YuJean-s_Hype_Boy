## 유진스의 하입보이 23/05/08 문제
- [A.안테나(18310)](https://www.acmicpc.net/problem/1945)  
- [B.Треугольная рамка(21475)](https://www.acmicpc.net/problem/21475) 

### 1. [A.안테나(18310)](https://www.acmicpc.net/problem/1945)  
원점을 지나는 1차 함수가 가장 많은 직사각형을 지나야 하는 문제이다.  
각 직사각형에서 직선이 지날 수 있는 범위는 좌측 위 점의 기울기와 우측 아래 점의 기울기이다.  
그러므로 각 직사각형의 최소-최대 범위의 기울기를 구한다.  
기울기를 구한 후 이를 오름차순으로 정렬한다.  
코드 리뷰를 통해 알게된 사실인데, 나는 살짝 잘못 접근했다.  
사실 모든 기울기를 하나의 리스트에 넣고 이를 정렬해서 반복문을 돈 다음 최고가 되는 값을 골라야 하는데,  
나는 그냥 끝 점의 값으로 2중 for문을 돌려서 답을 얻었다.  
원래라면 시간초과가 나지만, pypy 인터프리터로 하니 통과가 되었다.  

```python
import sys

if __name__ == '__main__':
    n = int(sys.stdin.readline())
    # 기울기 범위 저장
    inclination = []
    for i in range(n):
        x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
        inclination.append((y1/x2, y2/x1))
    
    #  오름차순으로 정렬
    inclination.sort()
    
    answer = 0
    # print(inclination)
    for std in range(n):
        low, high = inclination[std]
        fir = 0 ; sec = 0
        for val in range(n):
            lb, hb = inclination[val]
            if (low >= lb and low <= hb): fir += 1
            if (high >= lb and high <= hb): sec += 1
        if (fir > answer): answer = fir
        if (sec > answer): answer = sec

    print(answer)
```

### 2. [B.Треугольная рамка(21475)](https://www.acmicpc.net/problem/21475) 
주어진 세 변을 이용해 원래 삼각형의 넓이를 구한다.  
이 넓이를 바탕으로 원래 삼각형의 내접원의 길이를 구한다.  
내접원의 길이를 d 만큼 줄인다.  
r^2 : (r-d)^2 의 닮음비로 줄어든 삼각형의 넓이를 구할 수 있다.  
원래 넓이 * (1 - (r-d)^2 / r^2) = 정답 이 된다.  
```python
import sys
import math

if __name__ == '__main__':
    a,b,c,d = map(int, sys.stdin.readline().split())

    # 원래 삼각형의 넓이 구하기
    s = (a + b + c)/2 
    value = s * (s-a)*(s-b)*(s-c)
    originalArea = math.sqrt(value)
    r = originalArea/s
    
    # 닮음 비율 구하기
    # 기준을 중앙값으로
    originalR = (2*originalArea)/(a+b+c)
    r = originalR - d
    ratio = pow(r, 2) / pow(originalR, 2)
    ratio = 1 - ratio
    print("{:.5f}".format(originalArea*ratio))
```
