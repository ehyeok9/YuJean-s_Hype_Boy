2주차 풀이
--

## A번: [10164] 격자상의 경로

중학교 수학에 나오는 경우의 수 문제와 같은 방법으로 dp를 구성하면 된다.
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

int count(int Y, int X) {
    vector<vector<ll>> A(Y, vector<ll>(X));
    for (int y=0; y<Y; y++) {
        for (int x=0; x<X; x++) {
            if (y==0 && x==0) A[y][x] = 1;
            if (y != 0) A[y][x] += A[y-1][x];
            if (x != 0) A[y][x] += A[y][x-1];
        }
    }
    return A[Y-1][X-1];
}

int main() {
    fastio;
    
    int N, M, O; cin>>N>>M>>O;
    if (O==0) {
        cout<<count(N, M)<<endl;
    } else {
        int OY = (O-1) / M;
        int OX = (O-1) % M;
        cout<<(count(OY+1, OX+1) * count(N-OY, M-OX))<<endl;
    }
}
```

## B번: [9656] 돌 게임
정말 간단한 게임 이론 문제
게임이론이라 dp로 풀 수 있는데, 이 문제의 경우 패턴을 관찰하다 보면 0과 1이 반복된다는 것을 알 수 있다.
dp가 뭔지 생각해 볼 수 있는 문제라고 생각해서 넣었다.
```py
print('SCKY'[int(input())%2::2])
```

## C번: [11501] 주식
웰노운 그리디? 문제
i번에서 얻을 수 있는 이득은, A[i] 가격에 산 뒤 i이상에서 나오는 max에서 팔면 된다.
따라서 역방향으로 조회하며 max와 비교하거나, postfix max배열을 만들어놓으면 된다. (이 점이 dp라고도 볼 수 있기도 하고, 그리디 하나정도 넣으면 좋을 것 같아서 넣었다.)
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

int main() {
    fastio;
    
    int T; cin>>T;

    while (T--) {
        int N; cin>>N;

        vector<int> A(N);
        for (int i=0; i<N; i++) cin>>A[i];
        vector<int> postmax(N);
        postmax[N-1] = A[N-1];
        for (int i=N-2; i>=0; i--) postmax[i] = max(A[i], postmax[i+1]);

        ll res = 0;
        for (int i=0; i<N; i++)
            if (A[i] <= postmax[i]) res += postmax[i] - A[i];
        cout<<res<<endl;
    }
}
```
## D번: [1890] 점프
간단한 dp긴 한데, 코드 상에서 dp[i] = dp[i-b] + a 형태가 아니라 dp[i+b] = dp[i] + a 형태로 짜야 해서, 좀 더 dp를 유연하게 쓸 수 있도록 익혀보라고 넣었다.
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

int A[111][111];
ll dp[111][111];

int main() {
    fastio;
    
    int N; cin>>N;
    for (int y=0; y<N; y++) {
        for (int x=0; x<N; x++) {
            cin>>A[y][x];
        }
    }

    dp[0][0] = 1;

    for (int y=0; y<N; y++) {
        for (int x=0; x<N; x++) {
            int len = A[y][x];
            if (len == 0) continue;
            dp[y][x+len] += dp[y][x];
            dp[y+len][x] += dp[y][x];
        }
    }

    cout<<dp[N-1][N-1]<<endl;
}
```
