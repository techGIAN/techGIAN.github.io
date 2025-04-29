#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <sstream>
#include <climits>
#include <iomanip>

using namespace std;

// MODIFY THIS!
// Floyd-Warshall algorithm implementation
vector<vector<double>> floydWarshall(const vector<vector<double>>& W) {
    int n = W.size();
    vector<vector<double>> D(n, vector<double>(n, 0));

    // TO-DO: Students should implement the algorithm here

    return D;
}

// DO NOT MODIFY!
// Simulates x + y and avoids overflows especially when arguments are infinity
double addXY(double x, double y) {
    if (x == DBL_MAX || y == DBL_MAX) {
        return DBL_MAX;
    } else if (x == -DBL_MAX || y == -DBL_MAX) {
        return -DBL_MAX;
    } else {
        return x + y;
    }
}

// DO NOT MODIFY!
// Reads the Q1 input file and calculates shortest paths using Floyd-Warshall
void q1(const string& filename) {
    // DO NOT MODIFY: READS THE INPUT Q1 FILE
    // In the end, you should get adj matrix weights
    vector<string> lines;
    ifstream file(filename);
    string line;

    while (getline(file, line)) {
        lines.push_back(line);
    }

    int n = lines[0].size();
    vector<vector<double>> weights(n, vector<double>(n, 0));

    for (int i = 0; i < lines.size(); ++i) {
        stringstream ss(lines[i]);
        for (int j = 0; j < n; ++j) {
            ss >> weights[i][j];
        }
    }

    vector<vector<double>> dist = floydWarshall(weights);
    for (const auto& row : dist) {
        for (double d : row) {
            cout << static_cast<int>(d) << " ";
        }
        cout << endl;
    }
}

// MODIFY THIS!
// Reads the Q2 input file and processes it
void q2(const string& filename) {
    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "File not found: " << filename << endl;
        return;
    }

    int N, M;
    file >> N >> M;
    vector<vector<double>> W(N, vector<double>(N, DBL_MAX));

    for (int i = 0; i < M; ++i) {
        int s, t;
        double timeST, timeTS;
        file >> s >> t >> timeST >> timeTS;
        s -= 1;  // Adjust for 0-based indexing
        t -= 1;  // Adjust for 0-based indexing
        W[s][t] = timeST;
        W[t][s] = timeTS;
    }

    // TO-DO: Students should complete this method

    file.close();
}

int main() {
    // Uncomment/comment the function calls to test
    // q1("inputQ1.txt");
    // q2("inputQ2.txt");

    return 0;
}