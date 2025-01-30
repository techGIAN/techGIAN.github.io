// CC1SrLesson2Q1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include <stack>
using namespace std;

const string IGNORED = "Ignored";
stack<string> forward_stack;
stack<string> backward_stack;
string current_page = "http://www.acm.org";

void doBack() {
    if (!backward_stack.empty()) {
        forward_stack.push(current_page);
        current_page = backward_stack.top();
        backward_stack.pop();
        cout << current_page << endl;
    } else {
        cout << IGNORED << endl;
    }
}

void doForward() {
    if (!forward_stack.empty()) {
        backward_stack.push(current_page);
        current_page = forward_stack.top();
        forward_stack.pop();
        cout << current_page << endl;
    } else {
        cout << IGNORED << endl;
    }
}

void doVisit(string url) {
    backward_stack.push(current_page);
    current_page = url;
    cout << current_page << endl;
    forward_stack = stack<string>();
}

int main() {
    while (true) {
        string cmd;
        getline(cin, cmd);
        if (cmd == "BACK") {
            doBack();
        } else if (cmd == "FORWARD") {
            doForward();
        } else if (cmd.rfind("VISIT", 0) == 0) {
            doVisit(cmd.substr(6));
        } else if (cmd == "QUIT") {
            break;
        } else {
            cout << "Invalid command" << endl;
        }
    }
}
