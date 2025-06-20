// TestLight.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <sstream>
#include <assert.h>
#include "Light.h"

template<class T>
string toString(const T& x) {
    std::ostringstream ss;
    ss << x;
    return ss.str();
}

int main() {

    cout << "Running Light tests..." << endl;
    // 1. Test Light()
    Light n = Light();
    assert(toString<Light>(n) == "on white\tnot burnt out");

    // 2. Test Light(o, b, c)
    n = Light(false, true, "green");
    assert(toString<Light>(n) == "off green\tburnt out");

    // 3. Test burn_out()
    n = Light();
    n.burnOut();
    assert(toString<Light>(n) == "off white\tburnt out");

    // 4. Test flip()
    n = Light(true, false, "white");
    assert(toString<Light>(n) == "on white\tnot burnt out");
    n.flip();
    assert(toString<Light>(n) == "off white\tnot burnt out");
    n.flip();
    assert(toString<Light>(n) == "on white\tnot burnt out");
    n.burnOut();
    n.flip();
    assert(toString<Light>(n) == "off white\tburnt out");

    // 5. Test is_on()
    n = Light();
    assert(n.isOn());
    n.flip();
    assert(!n.isOn());

    // 6. Test get_color()
    n = Light(true, false, "red");
    assert(n.getColor() == "red");
    n = Light(true, false, "green");
    assert(n.getColor() == "green");
    n = Light(true, false, "blue");
    assert(n.getColor() == "blue");
    n = Light(true, false, "white");
    assert(n.getColor() == "white");
    n = Light(true, false, "purple");
    assert(n.getColor() == "white");

    // 7. Test set_color()
    n = Light();
    n.setColor("red");
    assert(n.getColor() == "red");
    n.setColor("green");
    assert(n.getColor() == "green");
    n.setColor("blue");
    assert(n.getColor() == "blue");
    n.setColor("white");
    assert(n.getColor() == "white");
    n.setColor("purple");
    assert(n.getColor() == "white");

    cout << "Tests completed." << endl;
}