// CC1JrLesson14.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <unordered_set>
#include <queue>
#include <map>
using namespace std;

/*
 * Builds a tree
 * m: number of edges
 * return tree
 */
map<int, unordered_set<int>> buildTree(int m) {
    map<int, unordered_set<int>> t;
    for (int i = 1; i <= m; ++i) {
        int a, b;
        cin >> a;
        cin >> b;
        if (t.find(a) != t.end()) {
            t[a].insert(b);
        } else {
            unordered_set<int> s{ b };
            t[a] = s;
        }
    }
    return t;
}

/*
 * BFS the tree t, starting from value p, for value q.
 * n: nodes are from 1 to n
 * t: the tree
 * p: source value
 * q: target value
 * return true if q is reachable from p.  false if it is not.
 */
bool searchTree(map<int, unordered_set<int>> t, int p, int q) {
    unordered_set<int> discovered;
    queue<int> queue;
    queue.push(p);
    while (!queue.empty()) {
        int u = queue.front();
        queue.pop();
        if (u == q) {
            return true;
        }
        if (t.find(u) != t.end()) {
            for (int v: t[u]) {
                if (discovered.find(v) == discovered.end()) {
                    discovered.insert(v);
                    queue.push(v);
                }
            }
        }
    }
    return false;
}

int main() {
    int N, M;
    cin >> N;
    cin >> M;

    map<int, unordered_set<int>> myTree = buildTree(M);
    int P, Q;
    cin >> P;
    cin >> Q;
    if (searchTree(myTree, P, Q)) {
        cout << "yes" << endl;
    } else if (searchTree(myTree, Q, P)) {
        cout << "no" << endl;
    } else {
        cout << "unknown" << endl;
    }
}
