## 유진스의 하입보이 23/03/13 문제
- [A : 단지번호붙이기(2667)](https://www.acmicpc.net/problem/2667)
- [B : Z(1074)](https://www.acmicpc.net/problem/1074)  
- [C : 에디터(1406)](https://www.acmicpc.net/problem/1406)  
- [D : 다음 순열(10972)](https://www.acmicpc.net/problem/10972)  
- [E : 회의실 배정(1931)](https://www.acmicpc.net/problem/1931)  

### 1. [A : 단지번호붙이기(2667)](https://www.acmicpc.net/problem/2667)
전형적인 dfs, bfs문제. 쭉 반복하면서 찾으면 된다.

```c++
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;
int n;
vector<int> resultList;
char input[100][100];
int result=0;
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};

void func(int x, int y){
    for(int i=0 ; i<4 ; i++){
        int X = dx[i]+x;
        int Y = dy[i]+y;
        if(X>=0 && Y>=0 && X<n && Y<n && input[X][Y]=='1'){
            result++;
            input[X][Y]='0';
            func(X,Y);
        }
    }
}

int main()
{
    
    cin>>n;
    for(int i=0 ; i<n ; i++){
        scanf("%s",input[i]);
    }

    for(int i=0 ; i<n ; i++){
        for(int j=0 ;j< n; j++){
            if(input[i][j]=='1'){
                input[i][j]='0';
                result=1;
                func(i,j);
                resultList.push_back(result);
            }
        }
    }

    sort(resultList.begin() , resultList.end());
    cout<<resultList.size()<<endl;
    for(int i=0 ; i<resultList.size() ; i++){
        cout<<resultList[i]<<endl;
    }

}
```

### 2. [B : Z(1074)](https://www.acmicpc.net/problem/1074) 
생각보다 오래걸렸다. 재귀를  왼쪽위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서로 출력하면 된다.

```c++
#include <iostream>
using namespace std;
typedef long long ll;
ll N, C, R;
ll result = 0;
void func(ll n, ll c, ll r)
{
    if (n == -1 && c == C && r == R)
    {
        cout << result;
        return;
    }

    if (n == -1)
    {
        result++;
        return;
    }
    int num = (1 << n);
    int dx[4] = {0, 0, num, num};
    int dy[4] = {0, num, 0, num};

    for (int i = 0; i < 4; i++)
    {
        if (c + dx[i] <= C &&
            C < c + num + dx[i] &&
            r + dy[i] <= R &&
            R < r + num + dy[i])
        {
            func(n - 1, c + dx[i], r + dy[i]);
    
        }
        result += num * num;
    }
}

int main()
{
    cin >> N >> C >> R;
    func(N - 1, 0, 0);
    return 0;
}
```

### 3. [C.에디터(1406)](https://www.acmicpc.net/problem/1406)  
처음에 string 클래스를 이용하여 무지성으로 작성했는데, 시간초과났다.
예전에 스택으로 풀었던 경험이 있어서, 데큐 두개를 이용하여 커서위치가 바뀔때마다 왔다갔다 하며 풀었다.
start는 커서 앞, end는 커서 뒤를 저장하는 값이다.
 
```c++
#include <cstdio>
#include <string>
#include <iostream>
#include <deque>

using namespace std;
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);

    deque<char> start;
    deque<char> end;

    string input;
    cin>>input;
    for(int i=0 ; i<input.size() ; i++){
        start.push_back(input[i]);
    }

    int n;
    cin>>n;
    while (n--)
    {
        char command;
        cin>>command;
        switch (command){
        case 'D':
            if(end.size()==0) continue;
            start.push_back(end.front());
            end.pop_front();
            break;
        case 'L':
            if(start.size()==0) continue;
            end.push_front(start.back());
            start.pop_back();
            break;
        case 'B':
            if(start.size()==0) continue;
            start.pop_back();
            break;
        case 'P':
            char s;
            cin>>s;
            start.push_back(s);
            break;
        }
    }

    for(int i=0 ; i<start.size() ; i++){
        cout<<start[i];
    }
    for(int i=0 ; i<end.size() ; i++){
        cout<<end[i];
    }
}
```

### 4. [D.다음 순열(10972)](https://www.acmicpc.net/problem/10972)  

```c++
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int n;
int input[10010]={0,};

int main(){
    scanf("%d",&n);
    for(int i=0 ; i<n ; i++){
        scanf("%d",&input[i]);
    }
    
    int t;
    for(t=n-1; t>0 ; t--){
        if(input[t-1] < input[t]){
            break;
        }
    }

    if(t==0){
        printf("-1");
        return 0;
    }

    for(int i=0 ; i<t-1 ; i++){
        printf("%d ",input[i]);
    }
    int first=input[t-1];
    int second=0;
    sort(input+t-1, input+n);
    
    for(int i=t-1 ; i<n ; i++){
        if(input[i]==first){
            second = input[i+1];
            break;
        }
    }
    printf("%d ",second);
    for(int i=t-1 ; i<n ; i++){
        if(second != input[i]){
            printf("%d ",input[i]);
        }
    }
}

```


### 5. [E.회의실 배정(1931)](https://www.acmicpc.net/problem/1931)  
끝나는 순서대로 정렬한다음, 먼저 끝나는거를 그리디하게 선택해주면 된다.
조심해야할 것이, 시작시간과 끝나는 시간이 같은 것이 있는데 이런경우 시작시간과 끝나는 시간이 같은 일을 먼저 처리해주기 위해
시작시작으로도 내림차순으로 함께 정렬해야한다.
  
```c++
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<long long,long long> a, pair<long long ,long long> b)
{
    if(a.second < b.second)
    {
        return true;
    }
    else if(a.second == b.second && a.first < b.first)
    {
        return true;
    }
    return false;
}

int main()
{
    int n;
    vector<pair<long long ,long long>> data;
    scanf("%d",&n);
    
    int a,b;
    for(int i=0 ; i<n ; i++)
    {
        scanf("%d %d",&a, &b);
        data.push_back(make_pair(a,b));
    }
    
    sort(data.begin(), data.end(), cmp);
    
    long long start =0;
    int result=0;
    for(int i=0 ; i<n ; i++)
    {
        if(data[i].first>=start)
        {
            start= data[i].second;
            result++;
        }
    }
    printf("%d",result);
}

```
