#include <iostream>
#include <string>
#include <sstream>
#include <cmath>

int main() {
    std::string input;
    
    // Read the initial position
    std::getline(std::cin, input);
    std::istringstream iss(input);
    int x0, y0;
    iss >> x0 >> y0;
    
    // Initializations
    int x = x0;
    int y = y0;
    bool isOn = false;
    int bat = 50;
    
    std::cout << x << " " << y << std::endl;
    
    // Read commands
    while (std::getline(std::cin, input) && input != "Q") {
        
        if (input == "C") {
            bat = 100;
        } else if (input == "P" && bat > 0) {
            isOn = !isOn;
        } else {
            std::istringstream cmdStream(input);
            std::string dirn;
            cmdStream >> dirn;
            int steps;
            
            if (isOn) {
                if (!(cmdStream >> steps)) { // If steps are not provided, assume 1 step
                    steps = 1;
                }
            } else {
                steps = 0;
            }
            
            int moveSteps = std::min(steps, bat);
            
            if (dirn == "F") {
                y += moveSteps;
            } else if (dirn == "B") {
                y -= moveSteps;
            } else if (dirn == "L") {
                x -= moveSteps;
            } else if (dirn == "R") {
                x += moveSteps;
            }
            
            bat -= moveSteps;
        }
        
        if (bat == 0) {
            isOn = false;
        }
        
        std::cout << x << " " << y << std::endl;
    }
    
    double d = std::sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
    std::cout << std::fixed;
    std::cout.precision(2);
    std::cout << d << std::endl;
    
    return 0;
}