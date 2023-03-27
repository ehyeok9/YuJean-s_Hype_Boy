## 유진스의 하입보이 23/03/20 문제
- [A.격자상의 경로(10164)](https://www.acmicpc.net/problem/10164)  
- [B.돌 게임2(9556)](https://www.acmicpc.net/problem/9656)  
- [C.주식(11501)](https://www.acmicpc.net/problem/11501)  
- [D.점프(1890)](https://www.acmicpc.net/problem/1890)  


### 1. [A.격자상의 경로(10164)](https://www.acmicpc.net/problem/10164)

격자상의 경로는 얼마 전 풀었던 문제라서 깔끔하게 푸는데 집중하며 풀었다.
1->격자상에 표시된 O-> 오른쪽 아래로 가는 경우의 수를 구하면 되는데, 이는
(1->격자상에 표시된 O) + (격자상에 표시된 O->오른쪽 아래 도착)하는 경우의 수를 각각 더해주면 된다.
코드를 재사용하면서 풀도록 예쁘게 구성하는데 집중하며 풀었다.
```c++
#include <iostream>
using namespace std;

int func(int si, int sj, int ei, int ej)
{
    int arr[20][20]={0,};
    arr[si][sj]=1;
    for(int i=si; i<=ei ; i++){
        for(int j=sj ; j<=ej ; j++){
            if(i-1>=si) arr[i][j]+=arr[i-1][j];
            if(j-1>=sj) arr[i][j]+=arr[i][j-1];
        }
    }
    return arr[ei][ej];
}
int main()
{
    int n,m,k;
    int result=0;
    int arr[20][20]={0,};
    cin>>n>>m>>k;

    if(k==0){
        cout<<func(0, 0, n-1, m-1);
        return 0;
    }
    int mi = (k-1)/m;
    int mj = (k-1)%m;
    cout<<func(0, 0, mi, mj) * func(mi, mj, n-1, m-1);
}

```

### 2. [B.돌 게임2(9556)](https://www.acmicpc.net/problem/9656)  
예전에 풀어봤던 문제이다. DP로도 풀 수 있지만, 이 문제는 그리디스럽게도 풀 수 있다.
손으로 해보면 금방 답이 보인다.
  
```c++
#include <iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    cout<<(n%2 ? "CY":"SK");
}

```
### 3. [C.주식(11501)](https://www.acmicpc.net/problem/11501)  
이것도 얼마전에 풀어본 문제다. 미래부터 과거로 for문으로 돌면서, 가장 비싼 지점을 저장해두고,비싼 지점이 아니면 무조건 사들이면 된다.
  
```c++
#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    int T;
    cin>>T;
    while(T--){
        int n;
        cin>>n;
        int input[1100000];
        for(int i=0 ; i<n ; i++){
            cin>>input[i];
        }
        ll result=0;
        ll m=0; // max주식
        ll buy=0; // 주식개수
        ll buyMoney=0; // 사는데 필요한 돈

        for(int i=n-1 ; i>=0 ; i--){
            if(m<input[i]){
                result += m*buy-buyMoney;
                buy=buyMoney=0;
                m=input[i];
            }else{
                buy++;
                buyMoney+=input[i];
            }
        }
        result += m*buy-buyMoney;
        cout<<result<<endl;
    }
}

```

### 4. [D.점프(1890)](https://www.acmicpc.net/problem/1890)  
전형적인 DP이다.
```c++
#include <iostream>
using namespace std;
typedef long long ll;
int main(){
    int n;
    cin>>n;
    ll input[110][110]={0,};
    ll arr[110][110]={0,};
    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            cin>>input[i][j];
        }
    }

    arr[0][0]=1;
    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n; j++){
            int t = input[i][j];
            if(t==0) continue;
            if(i+t <n) arr[i+t][j] += arr[i][j];
            if(j+t <n) arr[i][j+t] += arr[i][j];
        }
    }
    cout<<arr[n-1][n-1];
}
```
