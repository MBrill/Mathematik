// --------------------------------------------------------------------
//  L-förmiges Objekt für die Demonstration von Face und Vertex Normals
// --------------------------------------------------------------------
#ifndef SHAPE
#define SHAPE

#include "vlgGlutEngine.h"
#include "vlgPolyData.h"

// Shape - Einfache OpenGL-Anwendungsklasse, abgeleitet von vlgGraphicsEngine
// Gibt zwei Dreiecke als Demonstration von GL_TRIANGLES aus. 
class Shape : public vlgGlutEngine
{
//
// public
//
public:
	// Gibt die  Instanz der Klasse zurück
	static Shape* Instance(void);
	// Anwendungs-Initialisierung 
	void init(void);
	// OpenGL-Initialisierung 
	void initContext(void);
	// Funktion mit Applikationsanweisungen für die grafische Ausgabe
	void display(void);
//
// private
//
private:
	//! Instanzen der Klasse vlgPolyData
	vlgPolyData *solidAngle, *trichter;
	// Instanzvariable
	static Shape* instance;
	// Konstruktor
	Shape(void) : vlgGlutEngine() {} 
};
#endif /* SHAPE */
