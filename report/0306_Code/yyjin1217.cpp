#include <iostream>
#include <math.h>
using namespace std;
int main()
{
    long long n;
    cin>>n;
    for(long long i=sqrt(n*2) ;  ; i++){
        if(i*(i+1)/2>n){
            cout<<i-1;
            break;
        }
        else if(i*(i+1)/2==n){
            cout<<i;
            break;
        }
    }    