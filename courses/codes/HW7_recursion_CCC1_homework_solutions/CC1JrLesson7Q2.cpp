// CC1JrLesson7Q2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
using namespace std;

string bounce(int k) {
    if (k <= 0) {
        return to_string(k);
    } else {
        return to_string(k) + " " + bounce(k - 5) + " " + to_string(k);
    }
}

int main() {
    int n;
    cin >> n;
    cout << bounce(n) << endl;
}
