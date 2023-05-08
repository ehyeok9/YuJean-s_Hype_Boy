## 유진스의 하입보이 23/05/08 문제
- [A.직사각형(1945)](https://www.acmicpc.net/problem/1945)  
- [B.Треугольная рамка(21475)](https://www.acmicpc.net/problem/21475) 

### 1. [A.직사각형(1945)](https://www.acmicpc.net/problem/1945)  
직사각형이 1사분면에 있고, 가장 많이 지나는 직선을 찾으면 된다.  
모든 점이 1사분면에 있기 때문에 y=ax를 찾으면 된다.  
이 문제의 핵심 아이디어는, 입력받은 직사각형을 왼쪽 위 점과 오른쪽 아래 점을 잇는 선분으로 치환해도 된다는 점이다.  
먼저 왼쪽 위 점과 오른쪽 아래 점 각각의 기울기를 구해 기울기의 범위를 구한다.  
그럼 이 문제를, 선분들이 주어졌을 때 가장 많이 겹치는 점을 찾는 문제로 바꿀 수 있다.  
그건 간단히 정렬 후 스위핑으로 풀 수 있다.

```cpp
#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#ifdef ONLINE_JUDGE
    #define endl '\n'
#endif
#define all(x) x.begin(), x.end()
#define sz(x) x.size()
using namespace std;
typedef long long ll;
typedef long double ld;

int main() {
    fastio;
    
    int N; cin>>N;
    vector<pair<pair<ld, int>, int>> segs; // a, is_add(0 is add, 1 is remove), idx 
    for (int i=0; i<N; i++) {
        ld xbl, ybl, xtr, ytr; cin>>xbl>>ybl>>xtr>>ytr;
        // 사각형을 그냥 2개의 점을 잇는 선분으로 취급 (xbl, ytr) -> (xtr, ybl)
        segs.push_back({{ybl / xtr, 0}, i});
        segs.push_back({{ytr / xbl, 1}, i});
    }
    sort(segs.begin(), segs.end());
    unordered_set<int> now_sq;
    int res = 0;
    for (auto [add, i]: segs) {
        ld a = add.first;
        int act = add.second;
        if (act == 0) {
            now_sq.insert(i);
            res = max(res, (int)now_sq.size());
        } else {
            now_sq.erase(i);
        }
    }
    cout<<res<<endl;
}
```

### 2. [B.Треугольная рамка(21475)](https://www.acmicpc.net/problem/21475) 
세 선분의 길이를 주고, 각 선분에서 수직 방향으로 d만큼 줄였을 때 넓이를 구하는 문제다.  
삼각형의 넓이는 헤론의 공식을 이용하면 쉽게 구할 수 있다.  
그럼 줄어든 삼각형의 넓이는 어떻게 구할 수 있을까?  
세 선분에서 수직 방향으로 줄인다는 것에서, 우리는 내접원을 이용한다는 아이디어를 떠올릴 수 있다.  
내접원은 각 선분에 수직으로 접하며, 삼각형의 넓이의 비와 같은 비를 가질 것이기 때문이다.  
따라서 큰 내접원의 반지름은 r, 작은 내접원의 반지름은 r-d가 된다.  
넓이의 닮음이므로 r^2 : (r-d)^2 = 원래넓이 : 새넓이 이다. 
```cpp
#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#ifdef ONLINE_JUDGE
    #define endl '\n'
#endif
#define all(x) x.begin(), x.end()
#define sz(x) x.size()
using namespace std;
typedef long long ll;
typedef long double ld;

int main() {
    fastio;
    
    ld a, b, c, d; cin>>a>>b>>c>>d;
    ld p = (a+b+c)/2;

    ld sq_area = p*(p-a)*(p-b)*(p-c);
    ld area = sqrt(sq_area);
    // cout<<"area "<<area<<endl;
    ld r = (2*area) / (a+b+c);
    // cout<<"r "<<r<<endl;
    ld ratio = ((r-d) / r) * ((r-d) / r);
    cout<<fixed;
    cout<<setprecision(5);
    cout<<(area - (area * ratio))<<endl;
}
```
