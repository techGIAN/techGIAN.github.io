#include <iostream>
using namespace std;

int main() {
    int year;
    bool isLeap = false;
    cin >> year;
    
    if (year % 400 == 0) {
        isLeap = true;
    } else if (year % 100 == 0) {
        isLeap = false;
    } else if (year % 4 == 0) {
        isLeap = true;
    }

    if (isLeap) {
        cout << year << " is a leap year." << endl;
    } else {
        cout << year << " is not a leap year." << endl;
    }

    return 0;
}