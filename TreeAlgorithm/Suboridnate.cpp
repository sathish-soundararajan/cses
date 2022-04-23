/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <bits/stdc++.h>

using namespace std;
const int SZ = 200005;
int n;
vector<int> adj[SZ];
int S[SZ];

void dfs(int n, int p){
    S[n] = 1;

    for(int v: adj[n]){
        if(v!=p){
            dfs(v, n);
            S[n] += S[v];
        }
    }
}

int main()
{

    cin >> n;

    for(int i = 2; i <= n; i++){
        int v;
        cin >> v;
        adj[i].push_back(v);
        adj[v].push_back(i);
    }

    dfs(1, 0);

    for(int i = 1; i <= n; i++){
        cout << S[i] - 1 << " ";
    }
    return 0;
}
