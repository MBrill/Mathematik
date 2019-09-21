// --------------------------------------------------------------------
//  Shape.cpp
// --------------------------------------------------------------------
#include "Shape.h"
#include "vlgSphere.h"

#include <iostream>
#include <cmath>


// Anwendungs-Initialisierung 
void Shape::init(void) 
{   
	// "Nordpol" ist  auf der y-Achse, das entspricht dem
	// ersten Punkt in der Geometrie. Der rest wird über eine
	// Schleife berechnet. Die Normalen stimmen mit der Geometrie
	// überein!

	// Idee: noch eine Struktur als Wireframe, ein Fan, das die Fläche
	// mit dem Mittelpunkt verbindet ...
	const int n=128;
	int i;
	vlgSphere unitSphere;

	double theta, phi, p[3], delta;
	GLfloat geometry[n][3], vertexNormals[n][3];

	geometry[0][0] = 0.0f;
	geometry[0][1] = 0.0f;
	geometry[0][2] = 1.0f;

	theta = 0.572; // entspricht 32.77 Grad, dem Öffnungswinkel für 1 ster
	phi = 0.0;
	delta = (2.0*M_PI)/static_cast<double>(n-1);

	for (i=1; i<n; i++)
	{
		unitSphere.getPointOnSphere(theta, phi, p);
		geometry[i][0] = static_cast<float>(p[0]);
		geometry[i][1] = static_cast<float>(p[1]);
		geometry[i][2] = static_cast<float>(p[2]);
		phi += delta;
	}

	for (i=0; i<n; i++)
	{
		vertexNormals[i][0] = geometry[i][0];
		vertexNormals[i][1] = geometry[i][1];
		vertexNormals[i][2] = geometry[i][2];
	}
		
	GLuint topology[n+1];
	for (i=0; i<n; i++)
		topology[i] = i;
	topology[n] = 1;

	solidAngle = new vlgPolyData(n, n+1, geometry, topology, vertexNormals, GL_TRIANGLE_FAN);

	geometry[0][0] = 0.0f;
	geometry[0][1] = 0.0f;
	geometry[0][2] = 0.0f;
	trichter = new vlgPolyData(n, n+1, geometry, topology, vertexNormals, GL_TRIANGLE_FAN);
}

// OpenGL-Initialisierung 
void Shape::initContext(void) 
{
    wks->show();
	grid->noShow();
	setWindowTitle("Solid Angle");
	//camera->set(0.0f, 0.0f, 2.0f, -30.0f, 75.0f, 0.0);
	useLightedAssets();
    useExamineZUpCamera(2.0f, 45.0f, -45.0f);

    glClearColor(1.0f, 1.0f, 1.0f, 1.0f); 
	glEnable(GL_LIGHTING);
	glLightModeli(GL_LIGHT_MODEL_LOCAL_VIEWER, GL_TRUE);
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

    glEnableClientState(GL_VERTEX_ARRAY);
	glEnableClientState(GL_NORMAL_ARRAY);
	//solidAngle->setPointer();
}

// Funktion mit Applikationsanweisungen für die grafische Ausgabe
void Shape::display(void)
{
	GLfloat specularColor[4] = {1.0, 1.0, 1.0, 1.0};
    GLfloat exponent = 20.0f;
    GLfloat light0Pos[] = {0.0f, -5.0f, 5.0f, 1.0f};
	glLightfv(GL_LIGHT0, GL_POSITION, light0Pos);

	glColor3f(1.0f, 1.0f, 0.0f);
	solidAngle->setPointerAndDraw();

	glColor3f(0.2f, 0.2f, 0.2f);
	trichter->setPointerAndDraw();

	// Die ganze Kugel als Wireframe
	// Den Radius leicht kleiner als 1.0, um z-Buffer-Fighting zu verhindern!
	glColor3f(0.0f, 0.5f, 0.0);
	glutWireSphere(0.95, 16, 8);

}

Shape* Shape::instance = 0;
// Gibt die  Instanz der Klasse zurück
// Muss überschrieben werden, um den richtigen Pointer zurückzugeben.
// Alternativen finden man in Gamma et. al. ...
Shape* Shape::Instance(void)
{
	if (instance == 0) {
		Shape::instance = new Shape;
		vlgGlutEngine::instance = Shape::instance;
	}
	return instance;
}
