// ---------------------------------------------------------
// Berechnung von Integralen über die Halbkugel,
// mit Kugelkoordinaten, mit Raumwinkel und
// mit Malley-Samples.
// ---------------------------------------------------------
// $File$
// $Date$
// $Revision$
// ---------------------------------------------------------
#include <boost/function.hpp>

#include "mpHammersley2D.h"
#include "mpHalton2D.h"
#include "mpRandom2D.h"
#include "mpStratified2D.h"
#include "mpImportanceSampling2D.h"
#include "mpDoubleMonteCarlo.h"
#include "mpDoubleSimpsonRule.h"
#include "mpMonteCarloMalley.h"
#include "bfHemiSphere.h"
#include "gmtl/gmtl.h"

using namespace mathPack;
using namespace TNT;

// Die Testfunktion:
// wir verwenden die Funktion f(theta, phi) = sin^2(theta) cos^2(phi) cos(theta),
// das ist im Endeffekt die Funktion f(x, y, z) = x^2 cos(theta).
// Wir implementieren zwei Funktionen; einmal die Funktion f wie oben, ohne
// den Kosinusterm, und mit dem Kosinusterm.
// Es soll überprüft werden, ob sich wirklich bei Malley die Kosinus-Terme
// wegkürzen ...
double kern(double theta, double phi) 
{
	return cos(phi)*cos(phi);
	//return cos(phi);
}

double mitKosinus(double theta, double phi)
{ 
	return kern(theta, phi) * cos(theta);
}

double mitKugelKoordinaten(double theta, double phi)
{
	return kern(theta, phi) * cos(theta) * sin(theta);
}

// Test 
int main(void)
{
    // Anzahl der Stützstellen, a und b
    double a = 0.0, 
           bOuter = 2.0*M_PI, bInner = M_PI/2.0,
		   resultat, exakt;
    int    i, nInner, nOuter, nSamples;

	boost::function<double (double theta, double phi)> f;

	// Das exakte Ergebnis ist M_PI/4.
	exakt = M_PI/2.0;
	//std::cout << "Das exakte Ergebnis = " << exakt << std::endl;
	// 1. Mit Simpson, um zu sehen was das korrekte Ergebnis ist
	f = mitKugelKoordinaten;
    nOuter = 9;
    nInner = nOuter;

    // Instanz der Quadratur
    mpDoubleSimpsonRule simpson(a, a, bInner, bOuter, nOuter, nInner, f);
	resultat = simpson.compute();
	//exakt = resultat;

	std::cout << "Das Ergebnis der Simpsonregel " << endl;
	std::cout << "Quadraturergebnis mit Simpson: " << resultat << std::endl;
	//std::cout << "Absoluter Fehler " << std::abs(resultat-exakt) << std::endl;

	// 2. Monte-Carlo über die Kugelkoordinaten
	// Daten für die Monte-Carlo-Integration
	nSamples = 10000;

	// Sampler
	mpRandom2D samples(nSamples);
	samples.generateSamples();

	// Monte-Carlo durchführen
	mpDoubleMonteCarlo monte(a, a, bInner, bOuter, &samples, f);
	resultat = monte.compute();

	std::cout << std::endl << "Das Ergebnis von Monte-Carlo" << std::endl;
    std::cout << "Anzahl der Samples: " << nSamples << std::endl;
    std::cout << "Quadraturergebnis: " << resultat << std::endl;
	std::cout << "Absoluter Fehler zu Simpson: " << std::abs(resultat-exakt) << std::endl;

	// 3. Mit Malley Samples erzeugen und cosine-weighted Importance Sampling simulieren
	std::cout << std::endl << "Integrale auf der Halbkugel mit Malley" << std::endl;

	// Sampler
	//mpHammersley2D samples3(nSamples);
	mpRandom2D samples3(nSamples);
	samples3.generateSamples();
	samples3.concentricMapToUnitDisk();
	samples3.malleyMapToHemiSphere();


	// Monte-Carlo mit Malley durchführen
	f = kern;
	mpMonteCarloMalley monteMalley(&samples, f);
	resultat = monteMalley.compute();

	std::cout << "Das Ergebnis mit Malley? " << resultat << std::endl;
    std::cout << "Anzahl der Samples: " << nSamples << std::endl;
	std::cout << "Absoluter Fehler zu Simpson: " << std::abs(resultat-exakt) << std::endl;
	return 0;
}
