## 유진스의 하입보이 23/03/27 문제
- [A.팔(10164)](https://www.acmicpc.net/problem/1105)  
- [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  
- [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  

### 1. [A.팔(10164)](https://www.acmicpc.net/problem/1105)  

앞자리 숫자부터 비교를 한다. 앞자리가 모두 만약 8이라면 그 자리는 8이 올 수 밖에 없기 때문에 result++을 한다.
만약 
```c++
#include <iostream>
using namespace std;
int main()
{
    string l,r;
    cin>>l>>r;
    if(l.length() != r.length()){
        cout<<0;
        return 0;
    }
    int result=0;
    for(int i=0 ; i<l.length() ; i++){
        if(l[i]=='8' && r[i]=='8'){
            result++;
        }else if(l[i]==r[i]){
            continue;
        }else{
            break;
        }
    }
    cout<<result;
}
```

### 2. [B.관중석(9556)](https://www.acmicpc.net/problem/10166)  

예전에 틀렸던 문제인데 맞춰서 뿌듯하다.
약수들은 무조건 겹치는 것을 확인했다.
예를 들어, 반지름이 6일 때 : 반지름이 1, 2, 3인 관중석에 완전하게 가려진다.
그래서 DP처럼 접근했다.
반지름이 작은 숫자부터 완전하게 가려지는 것이 몇 개인지 세는 것이다.
1일 때, 0개
2일 때, 1개 (1한테 가려짐)
3일 때, 1개 (1한테 가려짐)
4일 때, 2개(1, 2한테 가려짐)
모두 약수임을 알 수 있다.

이 때 앞에서 약수의 약수로 가려진 것은 제외한다.
예를들면, 12의 약수인 6에 저장된 수는, 이미 2에 가려진 개수와 3에 가려진 개수를 중복해서 세지 않는다.
따라서 반지름 12일 때 관중석은 12 - [1, 2, 3, 4, 6의 관중석 수]와 같다.



```c++
#include <iostream>
#include <math.h>
using namespace std;
int main()
{
    int d1, d2;
    int arr[2200]={0,};
    int check[2200]={0};
    cin>>d1>>d2;

    if(d1 == d2){
        cout<<d1;
        return 0;
    }

    arr[1]=1;
    arr[2]=1;
    int result=2;
    for(int i=3 ; i<=d2 ; i++){
        arr[i] = i-1;
        for(int j=2 ; j<=sqrt(i) ; j++){
            if(i%j==0){
                arr[i]-=arr[j];
                if(j*j!=i)
                    arr[i]-=arr[i/j];
                if(d1<=i && i<=d2){
                    check[j]=1;
                    check[i/j]=1;
                }
            }
        }
        result+=arr[i];
    }
    for(int i=2 ; i<d1 ; i++){
        if(check[i]==0){
            result-=arr[i];
        }
    }
    cout<<result;
}
```

### 3. [C.사과나무(11501)](https://www.acmicpc.net/problem/19539)  
일단 총합이 3으로 나누어 떨어지지 않으면 절대 정답이 될 수 없다.

이 문제에서 가장 중요한 것은 "1물뿌리개를 최소 몇 번 사용해야하는지, 그 최소만큼 2물뿌리개를 사용할 수 있는지"이다.
왜 2물뿌리개의 최소를 구하지 않았냐면, 1물뿌리개를 2번 뿌리면 2물뿌리개가 되기 때문에, 1물뿌리개로 대체할 수 있지만,
2 물뿌리개로는 절대 1물뿌리개를 대체할 수 없기 때문이다. (2물뿌리개로는 절대 홀수를 만들 수 없다)

따라서, cnt1(1물뿌리개가 필요한 최소 수) : sum(홀수의 개수)
cnt2(2물뿌리개를 최대 몇 번 사용할 수 있는지) : sum(숫자/2) 후
cnt1<=cnt2이면 무조건 만들 수 있다.

```c++
#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int arr[110000]={0,};
    int sum=0;
    for(int i=0 ; i<n ; i++){
        cin>>arr[i];
        sum+=arr[i];
    }
    if(sum%3!=0){
        cout<<"NO";
        return 0;
    }
    sort(arr, arr+n);
    int cnt1=0;
    int cnt2=0;
    for(int i=0 ; i<n ; i++){
        if(arr[i]%2==1){
            cnt1++;
        }
        cnt2+=(arr[i]/2);
    }
    cout<< ((cnt1 <= cnt2) ? "YES" : "NO");
}
```
