// ----------------------------------------------------------------------------------------
// Ein fairer Würfel mit Hilfe der MathPack-Klasse mpDiscreteDistribution
// ----------------------------------------------------------------------------------------
#include <mpDiscreteDistribution1D.h>
#include <mpRandom1D.h>
#include <mpStratified1D.h>

#include <iostream>
#include <fstream>

using namespace mathPack;

//  Hauptprogramm
int main(void)
{
	// Anzahl Samples
	const int roll = 60000,    // Wie oft würfeln wir
	             num = 6;    // Häufigkeiten für die Definition der diskreten Verteilungsfunktion
    // Feld für die absoluten Häufigkeiten
    int frequencies[num] = {0, 0, 0, 0, 0, 0}, rawData[roll];	             
	double p, h[num] = {10.0, 10.0, 10.0, 10.0, 10.0, 10.0};

	// Verteilungsfunktion erzeugen
	mathPack::mpDiscreteDistribution1D dist(h, num);
	
    // Die Zufallszahlen erzeugen		
    // Mit Stratified ist das Ergebnis perfekt ...	
	//mathPack::mpStratified1D pseudo(1, roll);
	mathPack::mpRandom1D pseudo(1, roll);
	pseudo.generateSamples();
			   
	for (int i=0; i<roll; i++) 
	{
		    rawData[i] = dist.sampleDiscrete( pseudo.sampleUnitInterval(), p)+1;
		   // std::cout << "Das entspricht einem Wuerfeln einer " << rawData[i] << std::endl;
		    frequencies[rawData[i]-1]++;
	}

    // Häufigkeiten ausgeben
    std::cout << "Die absoluten Haeufigkeiten" << std::endl;
    std::cout << "1 " << frequencies[0] << std::endl;
    std::cout << "2 " << frequencies[1] << std::endl;
    std::cout << "3 " << frequencies[2] << std::endl;
    std::cout << "4 " << frequencies[3] << std::endl;
    std::cout << "5 " << frequencies[4] << std::endl;
    std::cout << "6 " << frequencies[5] << std::endl;
    
    std::cout << "Die relativen Haeufigkeiten" << std::endl;
    std::cout << "1 " << frequencies[0]/static_cast<double>(roll) << std::endl;
    std::cout << "2 " << frequencies[1]/static_cast<double>(roll) << std::endl;
    std::cout << "3 " << frequencies[2]/static_cast<double>(roll) << std::endl;
    std::cout << "4 " << frequencies[3]/static_cast<double>(roll) << std::endl;
    std::cout << "5 " << frequencies[4]/static_cast<double>(roll) << std::endl;
    std::cout << "6 " << frequencies[5]/static_cast<double>(roll) << std::endl;    
    
	// Ausgabefiles generieren
	std::fstream ofile1("dice_raw.csv", ios::out);

    if( !ofile1.good()) {
		std::cout << "Fehler beim Anlegen der Ausgabedatei für die Urliste" << std::endl;
		exit(1);
    }
    
    ofile1 << "Nummer des Versuchs; Ergebnis" << std::endl;
    for (int i = 0; i<roll; i++)
        ofile1 <<  i << " ; " << rawData[i] << std::endl;
	std::cout  << "Der CSV-File fuer die Urliste ist geschrieben!" << std::endl;            
	
	// Ausgabefiles generieren
	std::fstream ofile2("dice_frequencies.csv", ios::out);

    if( !ofile2.good()) {
		std::cout << "Fehler beim Anlegen der Ausgabedatei für die absoluten Haeufigkeiten" << std::endl;
		exit(2);
    }
    ofile2 << "Würfelseite; absolute Häufigkeit" << std::endl;
    ofile2 << "1 ;" << frequencies[0] << std::endl;
    ofile2 << "2 ;" << frequencies[1] << std::endl;
    ofile2<< "3 ;" << frequencies[2] << std::endl;
    ofile2<< "4; " << frequencies[3] << std::endl;
    ofile2 << "5 ;" << frequencies[4] << std::endl;
    ofile2 << "6 ;" << frequencies[5] << std::endl;
	std::cout << "Der CSV-File fuer die relativen Haeufigkeiten ist geschrieben!" << std::endl;    
    				
    return 0;
}
