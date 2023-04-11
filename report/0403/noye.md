# 모각코 4주차
## 1번: [10166] 관중석
저번 주에 푼 문제라 풀이 생략

## 2번: [1715] 카드 정렬하기
pq를 이용해서 가장 작은 두 개를 합치고, 합친 뭉치를 다시 넣으면 된다.
```cpp
#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;
#define endl '\n'
typedef unsigned long long ull;
typedef pair<int, int> ii;
typedef pair<ull, ull> ll;

void solve() {
    int N; cin>>N;
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i=0; i<N; i++) {
        int x; cin>>x;
        pq.push(x);
    }
    int cost = 0;
    while (pq.size()>=2) {
        int a = pq.top();
        pq.pop();
        int b = pq.top();
        pq.pop();
        cost += a+b;
        pq.push(a+b);
    }
    cout<<cost<<endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    solve();
    return 0;
}
```
