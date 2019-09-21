/* Examples for atan2 and atan functions in C+ +*/
#include <iostream>
#include <cmath>

using namespace std;

int main ()
{
  double x, y, z, result;
  z = 50.0;

  cout << "atan(" << z << ") = " << atan(z) << " radians" << endl;
  cout << "The result using degrees is: " << atan(z)*180.0/M_PI << " degrees " << endl << endl;
  cout << "The result in the interval [0, pi] is: " << atan(z)+M_PI/2.0 << " radians" << endl;
  cout << "The result using degrees in the interval [0, 90] is: " << (atan(z)+M_PI/2.0)*180.0/M_PI << " degrees" << endl<< endl;

  cout << "1. Quadrant " << endl;
  x = 10.0;
  y = 10.0;
  cout << "x = " << x << endl;
  cout << "y = " << y << endl << endl;
  result = atan2 (y,x);
  cout << "y/x = " << y/x << endl;
  cout << "arctan(y/x) = " << result << " radians" << endl;
  cout << "The result using degrees is: " << result*180.0/M_PI << " degrees " << endl << endl;

  cout << "The result in the interval [0, 2pi]:  " << result+M_PI << endl;
  cout << "The result using degrees in the interval [0, 2pi]:  " << (result+M_PI)*180.0/M_PI << " degrees " << endl << endl;

  cout << "2. Quadrant " << endl;
  x = -10.0;
  y = 10.0;
  cout << "x = " << x << endl;
  cout << "y = " << y << endl << endl;
  result = atan2 (y,x);
  cout << "y/x = " << y/x << endl;
  cout << "arctan(y/x) = " << result << " radians" << endl;
  cout << "The result using degrees is: " << result*180.0/M_PI << " degrees " << endl << endl;

  cout << "The result in the interval [0, 2pi]:  " << result+M_PI << endl;
  cout << "The result using degrees in the interval [0, 2pi]:  " << (result+M_PI)*180.0/M_PI << " degrees " << endl << endl;

  cout << "3. Quadrant " << endl;
  x = -10.0;
  y = -10.0;
  cout << "x = " << x << endl;
  cout << "y = " << y << endl << endl;
  result = atan2 (y,x);
  cout << "y/x = " << y/x << endl;
  cout << "arctan(y/x) = " << result << " radians" << endl;
  cout << "The result using degrees is: " << result*180.0/M_PI << " degrees " << endl << endl;

  cout << "The result in the interval [0, 2pi]:  " << result+M_PI << endl;
  cout << "The result using degrees in the interval [0, 2pi]:  " << (result+M_PI)*180.0/M_PI << " degrees " << endl << endl;

  cout << "4. Quadrant " << endl;
  x = 10.0;
  y = -10.0;
  cout << "x = " << x << endl;
  cout << "y = " << y << endl << endl;
  result = atan2 (y,x);
  cout << "y/x = " << y/x << endl;
  cout << "arctan(y/x) = " << result << " radians" << endl;
  cout << "The result using degrees is: " << result*180.0/M_PI << " degrees " << endl << endl;

  cout << "The result in the interval [0, 2pi]:  " << result+M_PI << endl;
  cout << "The result using degrees in the interval [0, 2pi]:  " << (result+M_PI)*180.0/M_PI << " degrees " << endl;

  return 0;
}

