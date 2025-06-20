// TestLight.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <algorithm>
#include "Light.h"

static void lower(string s) {
    transform(s.begin(), s.end(), s.begin(), ::tolower);
}

Light::Light(): Light(true, false, "white") {
}

Light::Light(bool o, bool b, string c) {
    /*
        to-do
    */
}

Light::~Light() {
}

string Light::getColor() const {
    /*
        to-do
    */
}

void Light::setColor(const string& c) {
    /*
        to-do
    */
}

void Light::burnOut() {
    /*
        to-do
    */
}

void Light::flip() {
    /*
        to-do
    */
}

bool Light::isOn() {
    /*
        to-do
    */
}

ostream& operator<<(ostream& os, const Light& lt) {
    /*
        to-do
    */
}