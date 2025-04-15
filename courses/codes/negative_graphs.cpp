#include <iostream>
#include <map>
#include <vector>
#include <set>
#include <fstream>
#include <sstream>
#include <limits>
#include <algorithm>  // For std::min

using namespace std;

// DO NOT MODIFY!
// Create a class called Pair to handle ordered pairs
template <typename X, typename Y>
class Pair {
public:
    X x;
    Y y;

    Pair(X x, Y y) : x(x), y(y) {}

    void print() const {
        cout << "(" << x << ", " << y << ")";
    }

    void print(const string& s) const {
        cout << "(" << x << ", " << y << ")" << s;
    }

    bool operator==(const Pair<X, Y>& other) const {
        return x == other.x && y == other.y;
    }

    bool operator<(const Pair<X, Y>& other) const {
        return tie(x, y) < tie(other.x, other.y);
    }
};

// DO NOT MODIFY!
// Given a map of edge to edge weights, return a list of nodes
vector<string> getNodeList(const map<Pair<string, string>, int>& weights) {
    set<string> nodeSet;
    for (const auto& edge : weights) {
        nodeSet.insert(edge.first.x);
        nodeSet.insert(edge.first.y);
    }

    return vector<string>(nodeSet.begin(), nodeSet.end());
}

// DO NOT MODIFY!
// Given a map of edge to edge weights, return a list of edges
vector<Pair<string, string>> getEdgeList(const map<Pair<string, string>, int>& weights) {
    vector<Pair<string, string>> edgeList;
    for (const auto& edge : weights) {
        edgeList.push_back(edge.first);
    }
    return edgeList;
}

// DO NOT MODIFY!
// Read a file path of the weights, then return a map with keys as edges (Pair) and values as weights (int)
map<Pair<string, string>, int> readWeightsFromFile(const string& filePath) {
    map<Pair<string, string>, int> weights;
    ifstream file(filePath);
    string node1, node2;
    int weight;
    while (file >> node1 >> node2 >> weight) {
        Pair<string, string> edge(node1, node2);
        weights[edge] = weight;
    }
    return weights;
}

// DO NOT MODIFY!
// Simulates x + y and avoids overflows especially when arguments are infinity
int addXY(int x, int y) {
    if (x == numeric_limits<int>::max() || y == numeric_limits<int>::max()) {
        return numeric_limits<int>::max();
    }
    return x + y;
}

// DO NOT MODIFY!
// Reads a filePath and creates a graph
map<Pair<string, string>, int> createGraph(const string& weightsFile) {
    return readWeightsFromFile(weightsFile);
}

// Modify this code depending on your graph (no need to modify if you are using a file)
map<Pair<string, string>, int> createGraph() {
    map<Pair<string, string>, int> w;
    w[Pair<string, string>("S", "A")] = 3;
    w[Pair<string, string>("S", "B")] = 14;
    w[Pair<string, string>("A", "B")] = 5;
    // Add other edges as needed
    return w;
}

// Implement this code!
// Given a src node and map with keys as edges (Pair) and values as weights (int),
// output the map with keys as nodes (string) and values as cheapest distance (int)
map<string, int> bellmanFord(const map<Pair<string, string>, int>& weights, const string& src) {
    
    // Initialization
    vector<string> nodeList = getNodeList(weights);
    vector<Pair<string, string>> edgeList = getEdgeList(weights);

    map<string, int> dist;
    for (const auto& node : nodeList) {
        dist[node] = numeric_limits<int>::max();
    }
    dist[src] = 0;

    // First round of relaxation: relax edges |N| - 1 times
    for (int i = 0; i < nodeList.size() - 1; i++) {
        for (const auto& edge : edgeList) {
            string nodeFrom = edge.x;
            string nodeTo = edge.y;
            dist[nodeTo] = min(addXY(dist[nodeFrom], weights.at(edge)), dist[nodeTo]);
        }
    }

    // Second round of relaxation: relax edges |N| - 1 times to catch nodes in negative cycles
    for (int i = 0; i < nodeList.size() - 1; i++) {
        for (const auto& edge : edgeList) {
            string nodeFrom = edge.x;
            string nodeTo = edge.y;
            if (addXY(dist[nodeFrom], weights.at(edge)) < dist[nodeTo]) {
                dist[nodeTo] = numeric_limits<int>::min(); // Negative cycle detected
            }
        }
    }

    return dist;
}



void q2() {
    ifstream sc("inputTextQ2.txt");
    if (!sc) {
        cerr << "Error opening file" << endl;
        return;
    }

    int N, M;
    sc >> N >> M;
    map<Pair<string, string>, int> timeFactors;

    for (int i = 0; i < M; ++i) {
        int u, v, weight;
        sc >> u >> v >> weight;
        timeFactors[Pair<string, string>(to_string(u), to_string(v))] = weight;
    }

    int s, d;
    sc >> s >> d;

    map<string, int> dist = bellmanFord(timeFactors, to_string(s));
    cout << dist[to_string(d)] << endl;
}

int main() {
    q2();
}