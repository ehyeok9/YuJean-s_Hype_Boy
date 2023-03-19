## 유진스의 하입보이 23/03/13 문제
- [A : 단지번호붙이기(2667)](https://www.acmicpc.net/problem/2667)
- [B : Z(1074)](https://www.acmicpc.net/problem/1074)  
- [C : 에디터(1406)](https://www.acmicpc.net/problem/1406)  
- [D : 다음 순열(10972)](https://www.acmicpc.net/problem/10972)  
- [E : 회의실 배정(1931)](https://www.acmicpc.net/problem/1931) 

### 1. [A : 단지번호붙이기(2667)](https://www.acmicpc.net/problem/2667)

1. collections library에서 deque import
2. N : 테스트 케이스 개수
3. vilage : 0,1 로 표현된 이중배열. 0이면 없고 1이면 집이 있음.
4. answer : 단지의 크기로 정렬한 단지 크기의 배열
5. def BFS(graph,a,b) : 너비우선탐색 알고리즘을 이용하여 서로 붙어있는 집의 수를 세어 단지의 크기를 측정하는 함수. 만약 vilage[a][b]의 값이 1이면 그 인덱스의 상하좌우에 1이 있는 지를 탐색 하고 큐에 append한다. 
```python
from collections import deque
N = int(input())
vilage = []
answer= []
for i in range(N):
    a= input()
    vilage.append(list(map(int,a)))

def BFS(graph, a, b):
    queue = deque()
    queue.append((a,b))
    graph[a][b] = 0
    count = 1

    dx= [-1,1, 0, 0]
    dy= [0, 0, 1, -1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if-1<nx<N and -1<ny<N:
                if graph[nx][ny] ==1:
                    graph[nx][ny] = 0
                    queue.append((nx,ny))
                    count+=1
    return count

for i in range(N):
    for j in range(N):
        if vilage[i][j]==1:
            answer.append(BFS(vilage, i, j))

answer.sort()
l = len(answer)
print(l)
for i in range(l):
    print(answer[i])
```

### 2. [B : Z(1074)](https://www.acmicpc.net/problem/1074)  

규칙성 : z 모양으로 돌 때 각각의 꼭지점을 방문하는 순서대로 섹터 0 1 2 3을 메겨 큰 z 부터 작은 z까지 각 자리마다 섹터별로 덧셈을 해줌 

```python
N, r, c = map(int, input().split())
sector= -1
answer = 0
for i in range(1, N+1):
    std = 2**(N-i)
    if r<std:
        if c<std:
            sector = 0
        else:
            c = c-std
            sector = 1
    else:
        r = r-std
        if c<std:
            sector = 2
        else:
            sector = 3
            c = c-std
    answer +=(2**(2*N-2*i))*sector
    
print(answer)
```

### 3. [C.에디터(1406)](https://www.acmicpc.net/problem/1406)
커서를 기준으로 앞뒤에 있을 deque를 두 개 만들어 준다.  
입력에 맞게 값들을 앞뒤 값들을 디큐 사이에서 옮겨준다.  
두 디큐를 앞쪽에서부터 빌 때까지 프린트해준다.



### 4. [D.다음 순열(10972)](https://www.acmicpc.net/problem/10972)  

2 4 3 1 5
2 4 3 5 1
2 4 5 1 3
2 4 5 3 1

 
 위에서 규칙성을 말해보자면 뒤에서부터 탐색해서 앞쪽 수가 더 작은 곳을 찾아서 인덱스를 저장하고 다시 맨 뒤부터 탐색해서 저장한 인덱스(i-1)의 값보다 큰 곳이 나오면 서로 스위치 해주고 i-1 번쨰 인덱스 뒤를 다시 정렬해준다.

```python
t = int(input())
combi = list(map(int, input().split()))

for i in range(t-1, 0, -1):
    if combi[i-1] < combi[i]:
        for j in range(t-1, 0, -1):
            if combi[i-1] < combi[j]:
                combi[i-1], combi[j] = combi[j], combi[i-1]
                combi = combi[:i] + sorted(combi[i:])
                print(*combi)
                exit()
print(-1)
```

### 5. [E.회의실 배정(1931)](https://www.acmicpc.net/problem/1931) 

 시작시간과 끝시간을 배열에 넣고 모든 회의 일정을 넣은 배열을 만든다.
 이후 끝시간, 시작시간 을 우선순으로 하여 정렬한다.
 이후 포문을 돌려 첫 회의는 넣고 다음부턴  다음 회의의 시작시간이 전 회의의 끝시간보다 일찍이면 넘어가고 아니면 붙이는 식으로 하여 총 회의 개수를 구한다.

```python
N = int(input())
meetings = []
for i in range(N):
    meetings.append(list(map(int, input().split())))
meetings.sort(key=lambda x:(x[1],x[0]))
cnt=1
a=meetings[0]
if N!=1:
    for i in range(1,N):
        if a[1]>meetings[i][0]:
            continue
        else:
            cnt+=1
            a=meetings[i]
            
print(cnt)

```
