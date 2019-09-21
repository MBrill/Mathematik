// --------------------------------------------------------------------
//  (C) Copyright Manfred Brill 2010.
//  Distributed under the FreeBSD Copyright,
//  See accompanying file LICENSE.txt.
// --------------------------------------------------------------------
//  Repräsentation einer Kugel in mathematischer Normallage
// --------------------------------------------------------------------
//  $RCSfile$
//  $Revision$
//  $Date$
// --------------------------------------------------------------------
#ifndef VLG_SPHERE_H
#define VLG_SPHERE_H

//! vlgSphere - Basis-Klasse zur Repräsentation einer Kugel
/*!
 *  Die Klasse enthält keine Funktionen für die grafische Ausgabe!
 */
class vlgSphere
{
    //
    // public
    //
    public:
	    //! Default-Konstruktor (Einheitskugel)
	    vlgSphere(void);
	    //! Kopierkonstruktor
	    vlgSphere(const vlgSphere&);
	    //! Konstruktor mit Radius
	    vlgSphere(double r);
	    //! Konstruktor mit Radius und Mittelpunkt
	    vlgSphere(double p[3], double r);
	    //! Abfragen des Radius
	    double getRadius(void);
	    //! Abfragen des Mittelpunkts
	    void getMidPoint(double p[3]);
	    //! Setzen des Radius
	    void setRadius(double r);
	    //! Setzen des Mittelpunkts
	    void setPoint(double p[3]);
	    //! Abfragen, ob die Instanz mit der Einheitskugel übereinstimmt
	    bool isUnitSphere(void);
	    //! Kartesische Koordinaten eines Punkts auf der Kugel für gegebene Kugelkoordinaten
		/*!
		 *  Achtung: die Kugelkoordinaten müssen in Bogenmass angegeben werden!
		 */
	    void getPointOnSphere(double theta, double phi, double p[3]);
    //
    // protected
    //
    protected:
           //! Radius
           double radius;
	   //! Mittelpunkt
	   double point[3];
};
#endif /* VLG_SPHERE_H */
