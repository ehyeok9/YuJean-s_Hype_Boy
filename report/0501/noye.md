## 유진스의 하입보이 23/05/01 문제
- [A.안테나(18310)](https://www.acmicpc.net/problem/18310)  

### 1. [A.안테나(18310)](https://www.acmicpc.net/problem/18310)  

중앙값(내림)을 선택해서 출력이 끝이다.  
관찰을 통해 아래와 같은 재미있는 성질들을 확인할 수 있다.
1. 왼쪽으로 이동 시, X보다 오른쪽에 있는 집들과의 거리가 1씩 증가한다. 즉 비용의 기울기가 `-(오른쪽의 집들)`이 된다.
2. 오른쪽으로 이동 시, X보다 왼쪽에 있는 집들과의 거리가 1씩 증가한다. 즉 비용의 기울기가 `+(왼쪽의 집들)`이 된다.
3. 위에서 구한 기울기로 함수를 만들면 아래로 볼록한 함수다. 따라서 최소값은 중간을 살펴보면 된다.
4. 기울기는 집을 지날때만 변한다. 즉 항상 답은 집들 중에 있다.
따라서 왼쪽과 오른쪽의 집의 개수가 같은 지점이 정답이고, 그건 중간값이다.

```c++
#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#ifdef ONLINE_JUDGE
    #define endl '\n'
#endif
#define all(x) x.begin(), x.end()
#define sz(x) x.size()
using namespace std;
typedef long long ll;

int main() {
    fastio;
    
    int N; cin>>N;
    vector<int> A(N);
    for (auto& a:A) cin>>a;
    sort(all(A));
    cout<<A[(N-1)/2]<<endl;
}
```
