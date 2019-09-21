// --------------------------------------------------------------------
// $File$
// $Revision$
// $Date$
// --------------------------------------------------------------------
#ifndef EULERENGINE
#define EULERENGINE
#include <gmtl/gmtl.h>

#include <vlgGlutEngine.h>
#include <vlgSolidAxis.h>

//! EulerEngine - Test der Klasse vlgPolyData
/*!
 *  Die Eulerwinkel als Beschreibung einer Orientierung können
 *  in OpenGL als Rotationen in umgekehrter Reihenfolge bzgl.
 *  dem festen Weltkoordinatensystem beschrieben werden.
 * 
 *  Wenn man dann per Knopfdruck oder durch Einlesen aus einer Datei
 *  eine Veränderung dieser Orientierung durchführen möchte, dann
 *  bezieht sich diese Veränderung auf die aktuellen Achsen. Deshalb
 *  darf das nicht so realisiert werden, dass man einfach auf den entsprechenden
 *  Winkel die Veränderung aufaddiert. Man hat beispielsweise für eine
 *  Veränderung des x-Werts (wenn man XYZ-Eulerwinkel verwendet) 
 *  den Ausdruck
 *      R_x(delta) R_z(z_rot) R_y(y_rot) R_x (x_rot).
 *  Die Multiplikation ist nicht kommutativ, also müssen wir eine Veränderung
 *  mit Hilfe von Matrixmultiplikation ausgeführt werden.
 *
 *  Die aktuelle Orientierung wird mit Hilfe der gmtl in eine gmtl::Matrix44f
 *  gespeichert. Wenn eine Veränderung auftritt, dann wird eine entsprechende
 *  Rotationsmatrix mit Hilfe von gmtl::setRot berechnet und entsprechend
 *  an die aktuelle Matrix multipliziert.
 */
class EulerEngine : public vlgGlutEngine
{
//
// public
//
public:
	//! OpenGL-Initialisierung 
	void initContext(void);
	//! Funktion mit Applikationsanweisungen für die grafische Ausgabe
	void display(void);
	//! Keyboard-Funktion
    void keyboard(unsigned char key, int x, int y);
	//! Konsolenausgabe
	void about(void);
	//! Gibt die  Instanz der Klasse zurück
	// Muss überschrieben werden, um den richtigen Pointer zurückzugeben.
	// Alternativen finden man in Gamma et. al. ...
	static EulerEngine* Instance(void);
//
// private
//
private:
	//! Lokales Koordinatensystem ausgeben
	vlgSolidAxis *local;
	//! Die Matrix mit den Euler-Winkeln
	gmtl::Matrix44f matrix;
	//! Textur-Idsin OpenGL
    GLuint texNames[1];

	// singleton-Zeiter
	static EulerEngine* instance;
	//! Konstruktor
	EulerEngine(void) : vlgGlutEngine() {};
};
#endif /* EULERENGINE */
