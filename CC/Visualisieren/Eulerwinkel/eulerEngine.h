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
 *  Die Eulerwinkel als Beschreibung einer Orientierung k�nnen
 *  in OpenGL als Rotationen in umgekehrter Reihenfolge bzgl.
 *  dem festen Weltkoordinatensystem beschrieben werden.
 * 
 *  Wenn man dann per Knopfdruck oder durch Einlesen aus einer Datei
 *  eine Ver�nderung dieser Orientierung durchf�hren m�chte, dann
 *  bezieht sich diese Ver�nderung auf die aktuellen Achsen. Deshalb
 *  darf das nicht so realisiert werden, dass man einfach auf den entsprechenden
 *  Winkel die Ver�nderung aufaddiert. Man hat beispielsweise f�r eine
 *  Ver�nderung des x-Werts (wenn man XYZ-Eulerwinkel verwendet) 
 *  den Ausdruck
 *      R_x(delta) R_z(z_rot) R_y(y_rot) R_x (x_rot).
 *  Die Multiplikation ist nicht kommutativ, also m�ssen wir eine Ver�nderung
 *  mit Hilfe von Matrixmultiplikation ausgef�hrt werden.
 *
 *  Die aktuelle Orientierung wird mit Hilfe der gmtl in eine gmtl::Matrix44f
 *  gespeichert. Wenn eine Ver�nderung auftritt, dann wird eine entsprechende
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
	//! Funktion mit Applikationsanweisungen f�r die grafische Ausgabe
	void display(void);
	//! Keyboard-Funktion
    void keyboard(unsigned char key, int x, int y);
	//! Konsolenausgabe
	void about(void);
	//! Gibt die  Instanz der Klasse zur�ck
	// Muss �berschrieben werden, um den richtigen Pointer zur�ckzugeben.
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
