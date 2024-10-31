// CC1JrLesson7Q1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <list>
using namespace std;

list<string> grow(list<string>s, int k) {
    if (k == 0) {
        return s;
    }
    list<string> r;
    for (string i: s) {
        r.push_back(i + "0");
        if (i[i.length() - 1] == '0') {
            r.push_back(i + "1");
        }
    }
    return grow(r, k - 1);
}

int main() {
    int d;
    cin >> d;

    list<string> zero;
    zero.push_back("0");
    list<string> zeroes = grow(zero, d - 1);
    list<string> one;
    one.push_back("1");
    list<string> ones = grow(one, d - 1);

    for (string a: zeroes) {
        cout << a << endl;
    }

    for (string a: ones) {
        cout << a << endl;
    }
}
