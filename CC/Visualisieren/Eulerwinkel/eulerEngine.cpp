// -------------------------------------------------------------------
// Euler-Winkel, angewandt auf ein Objekt zentriert im Ursprung
// --------------------------------------------------------------------
// $File$
// $Revision$
// $Date$
// -------------------------------------------------------------------
#include "EulerEngine.h"
#include <vlgOrtho.h>
#include <vlgUtil.h>
#include <vlgTextureMap2D.h>

#include <iostream>
using namespace std;

// OpenGL und Anwendungs-Initialisierung 
void EulerEngine::initContext(void) 
{
    // Textur
    vlgTextureMap2D cube;   

    setWindowTitle("Euler Winkel");
    vlgOrtho *ortho = new vlgOrtho(-2.0f, 2.0f, -2.0f, 2.0f);
    setViewProjection(ortho);

	useLightedAssets();
	//useStillCamera(3.0f, 0.0f, 0.0f);
	wks->noShow();
	grid->noShow();
	flatShading();

	local = new vlgSolidAxis();
	local->setOrigin(0.0f, 0.0f, 0.0f);

	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	glEnable(GL_LIGHTING);
	glLightModeli(GL_LIGHT_MODEL_LOCAL_VIEWER, GL_TRUE);
    glLightModeli(GL_LIGHT_MODEL_COLOR_CONTROL, GL_SEPARATE_SPECULAR_COLOR);

    /* Color Tracking anschalten               */
    glEnable(GL_COLOR_MATERIAL);
    glColorMaterial(GL_FRONT_AND_BACK, GL_AMBIENT_AND_DIFFUSE);

    /* Ambiente Lichtfarbe setzen                  */
    GLfloat ambientLight[] = {0.1f, 0.1f, 0.1f, 1.0f};
    /* Diffuse Lichtfarbe setzen                   */
    GLfloat diffuseLight[] = {0.7f, 0.7f, 0.7f, 1.0f};
    /* Spekulare Lichtfarbe setzen                 */
    GLfloat specularLight[] = {1.0f, 1.0f, 1.0f, 1.0f};
    // Eine Lichtquelle; als Headlight realisieren.
    glLightfv(GL_LIGHT0, GL_AMBIENT, ambientLight);
    glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuseLight);
    glLightfv(GL_LIGHT0, GL_SPECULAR, specularLight);
    glEnable(GL_LIGHT0);

    // Texture Mapping für 2D-Texturen aktivieren
    glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
 
    // Textur-Objekte erzeugen und ids zurückgeben
    glGenTextures(1, texNames);
    short status = 0;
    status = cube.read("../complete.bmp");
    if (status != 0)
		std::cout << "Fehler beim Einlesen der Textur" << std::endl;

    glBindTexture(GL_TEXTURE_2D, texNames[0]);   

    // Einstellungen für das aktuell gebundene Textur-Objekt
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);      
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP); 
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
    glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_REPLACE);

    cube.setTexture();  

	// Anfangskonfiguration
    float x_rot = vlgDeg2Rad(0.0f),
	      y_rot = vlgDeg2Rad(0.0f),
	      z_rot = vlgDeg2Rad(0.0f);
	gmtl::setRot(matrix, gmtl::EulerAngleXYZf(x_rot, y_rot, z_rot));
}
    
// Funktion mit Applikationsanweisungen für die grafische Ausgabe
void EulerEngine::display(void)
{
    GLfloat specularColor[4] = {1.0, 1.0, 1.0, 1.0};
    GLfloat exponent = 5;
    GLfloat light0Pos[] = {1.0f, 5.0f, 0.0f, 1.0f};
    glLightfv(GL_LIGHT0, GL_POSITION, light0Pos);

    glColor3f(0.0f, 1.0f, 0.0f);
    glMaterialf(GL_FRONT, GL_SHININESS, exponent);
    glMaterialfv(GL_FRONT, GL_SPECULAR, specularColor);

	glPushMatrix();
    glMultMatrixf(matrix.getData());
	// Lokales Koordinatensystem ausgeben
	local->draw();

	// Jetzt den texturierten Quader ausgeben
    glEnable(GL_TEXTURE_2D);
    // Ausgabe Seite vorne (=1)
	glBegin(GL_QUADS);
       glNormal3f(0.0, 0.0, 1.0);
       glTexCoord2f(0.0, 0.5);      glVertex3f(-0.5f, -0.25f, 0.25f);
       glTexCoord2f(0.333333, 0.5); glVertex3f( 0.5f, -0.25f, 0.25f);
       glTexCoord2f(0.333333, 1.0); glVertex3f( 0.5f,  0.25f, 0.25f);
       glTexCoord2f(0.0, 1.0);      glVertex3f(-0.5f,  0.25f, 0.25f);
       // Seite rechts (=3)
       glNormal3f(1.0, 0.0, 0.0);
       glTexCoord2f(0.666666, 0.5); glVertex3f( 0.5f, -0.25f, 0.25f);
       glTexCoord2f(1.0, 0.5);      glVertex3f( 0.5f,  0.25f, 0.25f);
       glTexCoord2f(1.0, 1.0);      glVertex3f( 0.5f,  0.25f, -0.25f);
       glTexCoord2f(0.666666, 1.0); glVertex3f( 0.5f,  -0.25f, -0.25f);
       // Seite hinten (= 6)
       glNormal3f(0.0, 0.0, -1.0);
       glTexCoord2f(1.0, 0.0);      glVertex3f( 0.5f,-0.25f, -0.25f);
       glTexCoord2f(0.666666, 0.0); glVertex3f(-0.5f,-0.25f, -0.25f);
       glTexCoord2f(0.666666, 0.5); glVertex3f(-0.5f, 0.25f, -0.25f);
       glTexCoord2f(1.0, 0.5);      glVertex3f( 0.5f, 0.25f, -0.25f);
       // Seite links (= 4)
       glNormal3f(-1.0, 0.0, 0.0);
       glTexCoord2f(0.0, 0.0);      glVertex3f(-0.5f,-0.25f,  0.25f);
       glTexCoord2f(0.333333, 0.0); glVertex3f(-0.5f, 0.25f,  0.25f);
       glTexCoord2f(0.333333, 0.5); glVertex3f(-0.5f, 0.25f, -0.25f);
       glTexCoord2f(0.0, 0.5);      glVertex3f(-0.5f,-0.25f, -0.25f);
       // Seite oben (= 5)
       glNormal3f(0.0, 1.0, 0.0);
       glTexCoord2f(0.333333, 0.0); glVertex3f(-0.5f, 0.25f, 0.25f);
       glTexCoord2f(0.666666, 0.0); glVertex3f( 0.5f, 0.25f, 0.25f);
       glTexCoord2f(0.666666, 0.5); glVertex3f( 0.5f, 0.25f, -0.25f);
       glTexCoord2f(0.333333, 0.5); glVertex3f(-0.5f, 0.25f, -0.25f);
       // Seite unten (= 2)
       glNormal3f(0.0, -1.0, 0.0);
       glTexCoord2f(0.333333, 0.5); glVertex3f(-0.5f,-0.25f,  0.25f);
       glTexCoord2f(0.666666, 0.5); glVertex3f(-0.5f,-0.25f, -0.25f);
       glTexCoord2f(0.666666, 1.0); glVertex3f( 0.5f,-0.25f, -0.25f);
       glTexCoord2f(0.333333, 1.0); glVertex3f( 0.5f,-0.25f,  0.25f);
    glEnd();
	glPopMatrix();
    glDisable(GL_TEXTURE_2D);
}

// Keyboard-Funktion für das Umschalten von ccw und cw
void EulerEngine::keyboard(unsigned char key, int x, int y)
{
	float delta = -static_cast<float>(M_PI)/8.0f;
	//float delta = 5.0f;
	// Update-Matrix
	gmtl::Matrix44f local;

	switch (key) {
		case 'x': gmtl::setRot(local, gmtl::EulerAngleXYZf(delta, 0.0f, 0.0f));
			      break;
		case 'X': gmtl::setRot(local, gmtl::EulerAngleXYZf(-delta, 0.0f, 0.0f));
			      break;
		case 'y': gmtl::setRot(local, gmtl::EulerAngleXYZf(0.0f, delta, 0.0f));
			      break;
		case 'Y': gmtl::setRot(local, gmtl::EulerAngleXYZf(0.0f, -delta, 0.0f));
			      break;
		case 'z': gmtl::setRot(local, gmtl::EulerAngleXYZf(0.0f, 0.0f, delta));
			      break;
		case 'Z': gmtl::setRot(local, gmtl::EulerAngleXYZf(0.0f, 0.0f, -delta));
			      break;
		case 'r': gmtl::identity(matrix);
			      gmtl::identity(local);
				  break;
	}
	// Matrizen multiplizieren
	gmtl::postMult(matrix, local);
}

//  Konsolenausgabe
void EulerEngine::about(void)
{
    cout << "----------------------------------------------- " << endl;
    cout << " EulerWinkel                                    " << endl;
    cout << "----------------------------------------------- " << endl;
	cout << " Drehung um x: x/X (positiv/negativ)            " << endl;
	cout << " Drehung um y: y/Y (positiv/negativ)            " << endl;
	cout << " Drehung um z: z/Z (positiv/negativ)            " << endl;
	cout << "----------------------------------------------- " << endl;
}

EulerEngine* EulerEngine::instance = 0;
// Gibt die  Instanz der Klasse zurück
// Muss überschrieben werden, um den richtigen Pointer zurückzugeben.
// Alternativen finden man in Gamma et. al. ...
EulerEngine* EulerEngine::Instance(void)
{
    if (instance == 0) {
        EulerEngine::instance = new EulerEngine;
        vlgGlutEngine::instance = EulerEngine::instance;
    }
    return instance;
}
