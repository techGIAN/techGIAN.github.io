#pragma once
using namespace std;

class Light {
public:
    Light();
    Light(bool o, bool b, string c);
    ~Light();

    string getColor() const;
    void setColor(const string& c);
    void burnOut();
    void flip();
    bool isOn();

    string RED = "red";
    string BLUE = "blue";
    string GREEN = "green";
    string WHITE = "white";

    bool burntOut;
    bool on;
    string color;
};

ostream& operator<<(ostream& os, const Light& lt);