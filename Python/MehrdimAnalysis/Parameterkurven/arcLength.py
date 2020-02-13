# -*- coding: utf-8 -*-
"""
Funktion für die Näherung der Bogenlänge
mit Hilfe eines Polygonzugs

Bogenlängenfunktion: entweder polylineLength mit
varierenden Endpunkt verwenden, oder, 
falls wir einen ganzen Graphen berechnen möchten,
immer einen Abschnitt des Polygonzugs hinzufügen.
Dafür können wir polylineLength ändern und
zusätzlich, mit der Zuweisung auf sum,
auch einen wert in einem Feld zuweisen.
"""
import numpy as np
import curves

def polylineLength(x, y) :
    """ Bogenlänge berechnen mit Hilfe eines 
        übergebenen Polygonzugs
    """       
    sum = 0.0
    for i in range(0, x.size-1) :
        sum += np.sqrt((x[i+1] - x[i])**2 + (y[i+1]-y[i])**2)
    return sum
  
def arcL(curve, a = 0.0, b = 1.0, n = 100) :
    """ Bogenlänge mit übergebener Kurve
        und Anzahl der Punkte, die für die Näherung
        verwendet werden soll.
    """
    t = np.linspace(a, b, n)
    x, y = curve(t)
    return polylineLength(x, y)

n = 512
tmin = 0.0
tmax = 1.0
t = np.linspace(tmin, tmax, n) 

x, y = curves.circle(t)

arc = polylineLength(x, y)

print("Die berechnete Näherung mit Hilfe der Polyline:", arc)
print("Die berechnete Näherung der Funktion arcL:", 
      arcL(curves.circle))
print("Der exakte Wert:", 2.0*np.pi)

print("Die halbe Bogenlänge des Einheitskreises ist ", 
      arcL(curves.circle, 0.0, 0.5, 200))

# Wir berechnen die Bogenlänge der semikubischen Parabel
# Diese Kurve finden wir als curves.semicubicParabola
correctValue = 2.87942
print("\n")
print("Bogenlänge der semikubischen Parabel mit Parameterintervall [-1, 1] laut Vorlesung: "
      , correctValue)

a = -1.0
b = 1.0
n = 200
computedValue = arcL(curves.semicubicParabola, a, b, n)
print("Berechneter Wert mit n=", n, "Werten")
print("Näherung =", computedValue)
n = 400
computedValue = arcL(curves.semicubicParabola, a, b, n)
print("Berechneter Wert mit n=", n, "Werten")
print("Näherung =", computedValue)
n = 1000
computedValue = arcL(curves.semicubicParabola, a, b, n)
print("Berechneter Wert mit n=", n, "Werten")
print("Näherung =", computedValue)

# Berechnungen für Ellipsen
a = 9.0
b= 4.0
n = 200
tmin = 0.0
tmax = 1.0
t = np.linspace(tmin, tmax, n) 

x, y = curves.ellipse(t, a, b)

computedValue = polylineLength(x, y)
print("Berechnung der Bogenlänge der Ellipse mit a=", a, " und b=", b)
print("Der Berechnete Wert:", computedValue)

