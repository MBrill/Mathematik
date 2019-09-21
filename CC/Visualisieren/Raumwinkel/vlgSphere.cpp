// --------------------------------------------------------------------
//  (C) Copyright Manfred Brill 2010.
//  Distributed under the FreeBSD Copyright,
//  See accompanying file LICENSE.txt.
// --------------------------------------------------------------------
//  Implementierung
// --------------------------------------------------------------------
//  $RCSfile$
//  $Revision$
//  $Date$
// --------------------------------------------------------------------
#include "vlgSphere.h"

#include <cmath>
using namespace std;

// Default-Konstruktor
vlgSphere::vlgSphere(void)
{
	radius = 1.0;
	point[0] = 0.0;
	point[1] = 0.0;
	point[2] = 0.0;
}

// Kopierkonstruktor
vlgSphere::vlgSphere(const vlgSphere &copy)
{
	radius = copy.radius;
	point[0] = copy.point[0];
	point[1] = copy.point[1];
	point[2] = copy.point[2];
}

// Konstruktor mit Radius; Mittelpunkt ist der Ursprung 
vlgSphere::vlgSphere(double r)
{
	radius = r;
	point[0] = 0.0;
	point[1] = 0.0;
	point[2] = 0.0;
}

// Konstruktor mit Radius und Mittelpunkt
vlgSphere::vlgSphere(double p[3], double r)
{
	radius = r;
	point[0] = p[0];
	point[1] = p[1];
	point[2] = p[2];
}	    

// Abfragen des Radius
double vlgSphere::getRadius(void)
{
	return radius;
}

// Abfragen des Mittelpunkts
void vlgSphere::getMidPoint(double p[3])
{
	p[0] = point[0];
	p[1] = point[1];
	p[2] = point[2];
}

// Setzen des Radius
void vlgSphere::setRadius(double r)
{
	radius = r;
}

// Setzen des Mittelpunkts
void vlgSphere::setPoint(double p[3])
{
	point[0] = p[0];
	point[1] = p[1];
	point[2] = p[2];
}
// Abfragen, ob die Instanz mit der Einheitskugel übereinstimmt
bool vlgSphere::isUnitSphere(void)
{
	bool midpoint;
	midpoint = (point[0]==0.0&&point[1]==0.0&&point[2]==0.0);
	return (midpoint && radius==1.0);
}
	    
void vlgSphere::getPointOnSphere(double theta, double phi, double p[3])
{
    p[0] = radius*sin(theta)*cos(phi) + point[0];
    p[1] = radius*sin(theta)*sin(phi) + point[1];
    p[2] = radius*cos(theta) + point[2];
}

