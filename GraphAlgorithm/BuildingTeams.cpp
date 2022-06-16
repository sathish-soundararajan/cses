#include <bits/stdc++.h>
using namespace std;

const int maxN = 1e5+1;
bool team[maxN], vis[maxN], impossible;
vector<int> g[maxN];

void dfs(int node, int parent = 0){
    for(int v: g[node]){
        if(v == parent) continue;
        if(!vis[v]){
            team[v] = !team[node];
            vis[v] = true;
            dfs(v, node);
        }else{
            if(team[node] == team[v]){
                impossible  = true;
            }
        }
    }
}

int main(){
    
    int n, m;
    cin >> n >> m;

    for(int i = 0; i < m; i++){
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    for(int i = 1; i <= n; i++){
        if(!vis[i]){
            vis[i] = true;
            dfs(i);
        }
    }

    if(impossible)
        printf("IMPOSSIBLE\n");
    else
        for(int i = 1; i <= n; i++)
            printf("%d%c", (team[i] ? 1 : 2), (" \n")[i==n]);
    return 0;
}