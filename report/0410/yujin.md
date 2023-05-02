## 유진스의 하입보이 23/04/10 문제
- [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  
- [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 
- [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)

### 1. [A.백설 공주와 일곱 난쟁이(3040)](https://www.acmicpc.net/problem/3040)  
9개를 모두 합한 후, 몇이 초과되는지 보았다.
그 후 두개의 합이 100이 되는 경우를 찾아 출력하였다.

```c++
#include <iostream>
using namespace std;
int arr[10];
int check[10];
int result[10];
bool hasResult=false;
void func(int num, int sum)
{
    if(hasResult) return;
    if(sum>100){
        return;
    }
    else if(sum==100 && num==7){
        for(int i=0 ; i<7 ; i++){
            cout<<result[i]<<endl;
        }
        hasResult=true;
        return;
    }

    for(int i=0 ; i<9 ; i++){
        if(check[i]==0){
            check[i]=1;
            result[num]=arr[i];
            func(num+1, sum+arr[i]);
            check[i]=0;
        }
    }
}

int main()
{
    for(int i=0 ; i<9 ; i++){
        cin>>arr[i];
    }
    func(0,0);
}
    
```

### 2. [B.오아시스 재결합(3015)](https://www.acmicpc.net/problem/3015) 
풀지 못했는데, 다른 친구들의 설명을 들으니 풀 수 있을 것 같았다.
스택을 이용하여 무조건 볼 수 있는 친구들이 유지되도록 하면 된다.
```c++
```

### 3. [C.차이를 최소로(3090)](https://www.acmicpc.net/problem/3090)
다른 친구의 설명을 듣고 이해했으나 풀 자신이 없다. 그래도 시도해봐야겠다.
```c++
```
