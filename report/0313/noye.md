1주차 풀이
----

## A번: [2667] 단지번호붙이기
매 칸에 대해서 dfs로 몇 칸짜리 덩어리인지 확인하면 된다.
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


int arr[26][26];
int N;

int dfs(int y, int x) {
    if (y<0 || y>=N || x<0 || x>=N || arr[y][x] == 0) return 0;
    arr[y][x] = 0;
    return 1 + dfs(y+1, x) + dfs(y-1, x) + dfs(y, x+1) + dfs(y, x-1);
}

int main() {
    fastio;
    
    cin>>N;
    for (int y=0; y<N; y++) {
        string tmp; cin>>tmp;
        for (int x=0; x<N; x++) {
            arr[y][x] = tmp.at(x) - '0';
        }
    }
    
    vector<int> res;
    for (int y=0; y<N; y++) {
        for (int x=0; x<N; x++) {
            int r = dfs(y, x);
            if (r) res.push_back(r);
        }
    }
    cout<<res.size()<<endl;
    sort(all(res));
    for (auto r: res) cout<<r<<endl;
}
```

## B번: [1074] Z
관심 영역을 전체로 잡은 후, 매번 4등분 한 조각 중 어디로 가야 하는지를 정하면 된다. (백트래킹)

어디로 가느냐에 따라, 그 전에 몇 칸이 있는지를 세 주며 들어가면 된다.
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

void dfs(int n, int s, int r, int c, int now) {
    if (n==0) cout<<now<<endl;
    else {
        int half = s/2;
        now += ((r/half)*2 + (c/half)) * (half*half);
        dfs(n-1, half, r%half, c%half, now);
    }
}

int main() {
    fastio;
    
    int N, R, C; cin>>N>>R>>C;
    int S = 1<<N;
    dfs(N, S, R, C, 0);
}
```

## C번: [1406] 에디터
현재 커서의 앞과 뒤를 나눠서 스택으로 취급하면 이동,삽입,삭제를 모두 $\mathcal{O}(1)$에 할 수 있다.
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
    
    string S; cin>>S;
    vector<char> L;
    vector<char> R;
    for (char c: S) L.push_back(c);
    int M; cin>>M;
    while (M--) {
        char C; cin>>C;
        if (C == 'L') {
            if (L.size() > 0) {
                char x = L[L.size()-1];
                L.pop_back();
                R.push_back(x);
            }
        } else if (C == 'D') {
            if (R.size() > 0) {
                char x = R[R.size()-1];
                R.pop_back();
                L.push_back(x);
            }
        } else if (C == 'B') {
            if (L.size() > 0) {
                L.pop_back();
            }
        } else {
            char x; cin>>x;
            L.push_back(x);
        }
    }

    reverse(all(R));
    for (char c: L) cout<<c;
    for (char c: R) cout<<c;
    cout<<endl;
}
```

## D번: [10972] 다음 순열

1. 뒤쪽 끝부터 시작해서, A[i] < A[i+1]인 부분을 찾는다.
2. A[i+1:] 부분에서 A[i]보다 큰 수 중 가장 작은 수를 A[i]의 자리에 넣고, 뒤로 간 A[i]와 나머지 수를 정렬해 뒤에 채운다.
예외: 역정렬된 배열, 즉 위 조건을 하나도 만족 못하면 불가능이다.

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

/*
1. 뒤쪽 끝부터 시작해서, A[i] < A[i+1]인 부분을 찾는다.
2. A[i+1:] 부분에서 A[i]보다 큰 수 중 가장 작은 수를 A[i]의 자리에 넣고, 뒤로 간 A[i]와 나머지 수를 정렬해 뒤에 채운다.
예외: 역정렬된 배열, 즉 위 조건을 하나도 만족 못하면 불가능이다.
*/
int A[10001];
int main() {
    fastio;
    
    int N; cin>>N;
    for (int i=0; i<N; i++) cin>>A[i];
    
    int ai = -1, bi = -1;
    for (int i=N-2; i>=0; i--) {
        if (A[i] < A[i+1]) {
            ai = i;
            bi = i+1;
            break;
        }
    }

    if (ai == -1 and bi == -1) {
        cout<<-1<<endl;
        return 0;
    }

    int ci = -1;
    int c = 987654321;
    for (int i=bi; i<N; i++) {
        if (A[ai] < A[i] and A[i] < c) {
            c = A[i];
            ci = i;
        }
    }
    swap(A[ai], A[ci]);
    sort(A+bi, A+N);
    for (int i=0; i<N; i++) cout<<A[i]<<' ';
    cout<<endl;
}
```

## E번: [1931] 회의실 배정
웰노운 그리디 문제. 끝나는 시간으로 정렬해서 빨리 끝나는 회의부터 채우면 된다.

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
    
    int N; cin>>N;;

    vector<pair<int, int>> uses(N);

    for (int i=0; i<N; i++) cin>>uses[i].second>>uses[i].first; // e, s

    sort(all(uses));

    int now = 0;
    int cnt = 0;
    for (auto [e, s]: uses) {
        if (now <= s) {
            now = e;
            cnt++;
        }
    }
    cout<<cnt<<endl;
}
```
