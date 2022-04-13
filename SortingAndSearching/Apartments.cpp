/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

/** Java implementation is tricky due to sort timeout and outdated java version in cses backend **/
int main()
{
    
    int n, l, k;
    cin >> n >> l >> k;
    
    vector<int> c;
    vector<int> a;
    for(int i = 0; i < n; i++){
        int v;
        cin >> v;
        c.push_back(v);
    }
    
    for(int i = 0; i < l; i++){
        int v;
        cin >> v;
        a.push_back(v);
    }

    sort(a.begin(), a.end());
    sort(c.begin(), c.end());
    
    int i = 0; int j = 0;
    
    int res = 0;
    while(i < n && j < l){
        if(abs(c[i] - a[j]) <= k){
            res++;
            i++;
            j++;
        }else{
            if(a[j] < c[i]) j++;
            else i++;
        }
    }
    
    cout << res << endl;
    return 0;
}
