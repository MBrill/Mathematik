// ---------------------------------------------------------
// Berechnung der hemispherical directional reflectance
// für BRDF-Funktionen aus der OpenBRDF-Bibliothek
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
#include "mpDoubleSimpsonRule.h"
#include "mpImportanceSampling2D.h"
#include "mpDoubleMonteCarlo.h"

#include "bfRGBSpectrum.h"
#include "bfOrenNayar.h"
#include "bfLambert.h"
#include "bfNormalizedPhong.h"
#include "bfUtil.h"

using namespace mathPack;
using namespace obf;
using namespace TNT;

obf::bfRGBSpectrum diffuseColor(1.0, 1.0, 0.0);
obf::bfLambert myFirstLambert(diffuseColor);
obf::bfOrenNayar myOrenNayar(diffuseColor, 10.0);
obf::bfNormalizedPhong myPhong(diffuseColor, 1000.0);

// Die Testfunktion:
// eine BRDF, mit festen Werten für theta_o und phi_o,
// wir verwenden den Rot-Kanal, um eine skalare Funktion zu 
// erhalten.
double testFunction(double theta, double phi) 
{
	const double theta_out = obf::deg2Rad(45.0),
		         phi_out   = obf::deg2Rad(45.0);
	//return myFirstLambert.f(theta, phi, theta_out, phi_out).getR()*sin(theta)*cos(theta);
	//return myOrenNayar.f(theta, phi, theta_out, phi_out).getR()*sin(theta)*cos(theta);
	return myPhong.f(theta, phi, theta_out, phi_out).getR()*sin(theta)*cos(theta);
}

// Test 
int main(void)
{
    // Anzahl der Stützstellen, a und b
    double a = 0.0, 
           bOuter = 2.0*M_PI, bInner = M_PI/2.0,
		   resultat, exakt;
    int nInner, nOuter, res, nSamples;

	boost::function<double (double theta, double phi)> f;
	f = testFunction;

	// Daten für die Simpson-Integration
	std::cout << "Achtung: ungerade Anzahlen eingeben!" << std::endl;
	std::cout << "Bitte die Anzahl der Stuetzstellen angeben (muss ungerade sein!)" << std::endl;
    std::cin >> nOuter;
    nInner = nOuter;
	//nOuter = 9;
	//nInner = 9;

    // Instanz der Quadratur
    mpDoubleSimpsonRule simpson(a, a, bInner, bOuter, nOuter, nInner, f);
	resultat = simpson.compute();
	exakt = resultat;

	std::cout << "Das Ergebnis der Simpsonregel " << endl;
    std::cout << "Anzahl der Stuetzstellen des inneren Integrals: " << nInner << std::endl;
    std::cout << "Anzahl der Stuetzstellen des aeusseren Integrals: " << nOuter << std::endl;
	std::cout << "Quadraturergebnis: " << resultat << std::endl;
	//std::cout << "Absoluter Fehler " << std::abs(resultat-exakt) << std::endl;

	// Daten für die Monte-Carlo-Integration
	std::cout << "Doppelintegrale mit Monte-Carlo Integration" << std::endl;
	std::cout << "Bitte die gewuenschte Anzahl der Samples eingeben!" << std::endl;
	std::cin >> nSamples;

	// Sampler
	mpHammersley2D samples(nSamples);
	samples.generateSamples();


	// Quadratur-Formel bilden
	mpDoubleMonteCarlo monte(a, a, bInner, bOuter, &samples, f);
	resultat = monte.compute();

	std::cout << "Das Ergebnis von Monte-Carlo ohne Importance Sampling" << std::endl;
    std::cout << "Anzahl der Samples: " << nSamples << std::endl;
    std::cout << "Quadraturergebnis: " << resultat << std::endl;
	std::cout << "Absoluter Fehler zu Simpson: " << std::abs(resultat-exakt) << std::endl;

	cout << "Bitte die Aufloesung fuer die lineare Naeherung fuer die Verteilung eingeben!" << endl;
	cin >> res;
	res = 10;

	// Sampler
	mpHammersley2D samples2(nSamples);
	//mpStratified2D samples(900);
	samples2.generateSamples();

	// Quadratur-Formel bilden
	mpImportanceSampling2D importance(a, a, bInner, bOuter, res, &samples2, f);
	resultat = importance.compute();

	std::cout << "Das Ergebnis mit diskretem Importance Sampling" << std::endl;
    std::cout << "Anzahl der Samples: " << nSamples << std::endl;
	std::cout << "Aufloesung der Verteilung fuer diskretes Importance Sampling: " << res << std::endl;
    std::cout << "Quadraturergebnis: " << resultat << std::endl;
	std::cout << "Absoluter Fehler zu Simpson: " << std::abs(resultat-exakt) << std::endl;

	return 0;
}