## 유진스의 하입보이 23/04/10 문제
- [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  
- [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 
- [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

### 1. [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  

9개중 7개 조합을 구하는 경우인데, 9C7은 9C2므로 2개를 구해서 확인하면 된다.
```py
l=[*map(int,open(0))]
s,e,r=sum(l)-100,len(l),range
for i in r(e):
 for j in r(i+1,e):
  if l[i]+l[j]==s:
   for k in r(e):
    if k!=i and k!=j:print(l[k])
```

### 2. [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 
i<j<k일 때, A[i]>A[j] && A[j]<A[k]인 경우에는 A[j]는 더이상 볼 필요가 없다.  
따라서 오른쪽으로 하나씩 움직이면서 위 경우를 없애며 셀 수 있도록 스택을 잘 이용해 주면 된다.
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define endl '\n'
pair<int, int> stack[500001]; // value, ammount
int sp=0;
void solve() {
    int N; cin>>N;
    unsigned long long res = 0;
    int x; cin>>x;
    stack[sp++] = {x, 1};
    for (int i=1; i<N; i++) {
        int x; cin>>x;
        for (int i = sp-1; i>=0; i--) {
            if (stack[i].first < x) {
                sp--;
                res+=stack[i].second;
                //cout<<stack[i].first<<", "<<x<<endl;
            } else if (stack[i].first > x) {
                res++;
                //cout<<stack[i].first<<", "<<x<<endl;
                break;
            } else {
                res+=stack[i].second;
                //for (int _=0; _<stack[i].second; _++) cout<<stack[i].first<<", "<<x<<endl;
            }
        }
        if (stack[sp-1].first == x) stack[sp-1].second++;
        else stack[sp++] = {x, 1};
    }
    cout<<res<<endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    solve();
    return 0;
}
```

### 3. [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

두 가지 부분이 필요하다.  
1. 주어진 T 안에서 X만큼 부드럽게 만드는 것이 가능한지, 가능하다면 배열을 그렇게 만드는 함수 make_smooth를 만든다.  
2. 파라메트릭 서치를 통해 최소의 X를 구해 줘서, 최소인 X에서의 smooth한 배열을 구한다.  

make_smooth를 하는 과정에서 아래와 같은 아이디어가 사용되었다.  
1. 오른쪽으로만 보면서, 모든 i에 대해 A[i+1] = max(A[i+1], A[i] + X)를 만족하도록 만든다.
2. 마찬가지로 왼쪽으로만 보면서, 모든 i에 대해 A[i-1] = max(A[i-1], A[i] + X)를 만족하도록 만든다.
이렇게 좌우 한바퀴만 보면 된다. 최적인데 그 이유를 말로 설명하긴 힘들고, 직접 그림으로 그려보면 쉽게 알 수 있다.
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define endl '\n'
typedef long long ll;

ll make_smooth(vector<ll>& arr, ll smooth) {
    ll cnt = 0;
    for (ll i=0; i<arr.size()-1; i++) {
        if (arr[i]+smooth < arr[i+1]) {
            cnt += arr[i+1] - (arr[i]+smooth);
            arr[i+1] = arr[i]+smooth;
        }
    }
    for (ll i=arr.size()-1; i>0; i--) {
        if (arr[i]+smooth < arr[i-1]) {
            cnt += arr[i-1] - (arr[i]+smooth);
            arr[i-1] = arr[i]+smooth;
        }
    }
    return cnt;
}

void solve() {
    int N, T; cin>>N>>T;
    vector<ll> arr(N);
    for (int i=0; i<N; i++) {
        cin>>arr[i];
    }
    
    ll left = 0; ll right = 1000000000;
    ll cnt;
    while(left < right) {
        vector<ll> tmp(arr);
        ll mid = (left + right) / 2;
        cnt = make_smooth(tmp, mid);
        if(T < cnt) {
            left = mid + 1;
        } else {
            right = mid;
	    }
    }
    make_smooth(arr, left);
    for (int i=0; i<N; i++) {
        cout<<arr[i]<<' ';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    solve();
    return 0;
}
```
