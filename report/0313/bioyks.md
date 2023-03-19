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

