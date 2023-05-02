## 유진스의 하입보이 23/05/01 문제
- [A.안테나(18310)](https://www.acmicpc.net/problem/18310)  

### 1. [A.안테나(18310)](https://www.acmicpc.net/problem/18310)  

예전에 풀었던 문제인데, 다시 생각해보니 헷갈렸다.
정렬 후 무조건 (n-1)/2번째(가운데) 값이 정답이 된다.

나는 왼쪽에서 몇 칸, 오른쪽에서 몇 칸멀어지고 가까워지는지 고민해보다가 알게되었다.
근데 창훈이가 풀이를 그래프로 설명해서 신기했다.
같은 문제라도 풀이가 여러개 나오는게 신기하다.


```c++
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main()
{
    ios_base::sync_with_stdio();
    cin.tie(0);
    cout.tie(0);
    int n;
    cin>>n;
    
    vector<int> v;
    int a;
    for(int i=0 ; i<n ; i++){
        cin>>a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    
    cout<<v[(n-1)/2];
}

```
