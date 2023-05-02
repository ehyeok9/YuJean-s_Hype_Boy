## 유진스의 하입보이 23/04/03 문제
- [A.관중석(10166)](https://www.acmicpc.net/problem/10166)  
- [B.카드 정렬하기(1715)](https://www.acmicpc.net/problem/1715)  

### 1. [A.관중석(9556)](https://www.acmicpc.net/problem/10166)  
공약수를 이용한 DP느낌으로 풀었다.

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

### 2. [B.카드 정렬하기(9556)](https://www.acmicpc.net/problem/1715)

PQ를 이용하여 그리디하게 작은것부터 합치면 된다.

```c++
#include <cstdio>
#include <queue>
using namespace std;
int main()
{
    int n;
    priority_queue<int, vector<int>, greater<int> > q;
    scanf("%d",&n);
    int input;
    for(int i=0 ; i<n ; i++)
    {
        scanf("%d",&input);
        q.push(input);
    }
    
    int result=0;
    int a,b;
    while(q.size()!=1)
    {
        a= q.top();
        q.pop();
        b= q.top();
        q.pop();
        q.push(a+b);
        result+=a+b;
    }
    printf("%d",result);
}

```
