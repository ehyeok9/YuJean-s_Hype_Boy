# 모각코 3주차
## 1번: [1105]팔
L과 R이 주어졌을 때 [L, R]에서 8이 가장 적게 들어있는 수에서의 8의 개수 구하기
1. 자릿수가 다르면 0이다. (항상 1000 꼴의 수가 사이에 있다.)
2. 길이가 같다면, a와 b의 공통 prefix 부분을 확인해서 8이 몇 개나 있는지 보면 된다. (공통 부분이 있지 않으면 모든 경우에 8을 피할 수 있으므로 같은 부분만 보면 된다.)
```py
a, b = input().split()

if len(a) != len(b):
    print(0)
    exit(0)
    
res = 0
for ca, cb in zip(a, b):
    if ca == cb:
        if ca == '8':
            res += 1
    else:
        break
print(res)
```

## 2번: [10166] 관중석
이 문제는 두 가지 방법으로 풀 수 있다.
### 풀이 1: 기약분수 사용
원의 어느 지점에 좌석이 있는지를 분수로 나타내서, 기약분수의 set을 관리한다는 느낌으로 가면 된다.
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

int used[2001][2001];

int main() {
    fastio;
    
    int D1, D2; cin>>D1>>D2;

    int cnt = 0;
    for (int mo=D1; mo<=D2; mo++) {
        for (int ja=1; ja<=mo; ja++) {
            int g = gcd(mo, ja);
            if (used[ja/g][mo/g] == 0) cnt++;
            used[ja/g][mo/g] = 1;
        }
    }
    cout<<cnt<<endl;
}
```
### 풀이 2: 유클리드 호제법 이용
유클리드 호제법과 유사하게 접근해서 풀었는데, 자세한 방식은 설명하기에 약간 복잡해서 생략한다. 이 방법이 더 빠르다.
```py
D1, D2 = map(int, input().split())
  
dp = [i for i in range(2001)]

add = 0
res = 0
for i in range(1, D2+1):
    first = True
    for j in range(i*2, D2+1, i):
        if first and D2 >= j >= D1 and i < D1:
            add += dp[i]
            first = False
        dp[j] -= dp[i]
#print(dp)
print(sum(dp[D1:D2+1])+add)
```

### 3번: [19549] 사과나무
설명은 주석에 있다.
```cpp
#include <bits/stdc++.h>
#define fastio cin.tie(0)->sync_with_stdio(0)
#ifdef ONLINE_JUDGE
    #define endl '\n'
#endif
#define all(x) x.begin(), x.end()
using namespace std;
typedef long long ll;

int main() {
    fastio;
    
    int N; cin>>N;

    int sum = 0;
    int no0 = 0, no1 = 0;

    for (int i=0; i<N; i++) {
        int x; cin>>x;
        sum += x;
        if (x%2 == 0) no0++; else no1++;
    }

    // step 1: 3으로 나눠지는지 확인. 안되면 실패
    if (sum % 3 != 0) {
        cout<<"NO"<<endl;
        return 0;
    }

    int uses = sum/3;

    // 최대 uses 번의 1을 이용할 수 있음
    if (no1 <= uses) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;
}
```
