# -*- coding: utf-8 -*-
"""
Bogenlängenfunktionen für ebene Parameterkurven
"""
import numpy as np
import curves

n = 512
tmin = 0.0
tmax = 1.0
t = np.linspace(tmin, tmax, n) 

x, y = curves.circle(t)

arc = curves.polylineLength(x, y)

print("Die berechnete Näherung mit Hilfe der Polyline:", arc)
print("Die berechnete Näherung der Funktion arcL:", 
      curves.arcL(curves.circle))
print("Der exakte Wert:", 2.0*np.pi)

print("Die halbe Bogenlänge des Einheitskreises ist ", 
      curves.arcL(curves.circle, 0.0, 0.5, 200))

# Wir berechnen die Bogenlänge der semikubischen Parabel
# Diese Kurve finden wir als curves.semicubicParabola
correctValue = 2.87942
print("\n")
print("Bogenlänge der semikubischen Parabel mit Parameterintervall [-1, 1] laut Vorlesung: "
      , correctValue)

a = -1.0
b = 1.0
n = 200
computedValue = curves.arcL(curves.semicubicParabola, a, b, n)
print("Berechneter Wert mit n=", n, "Werten")
print("Näherung =", computedValue)
n = 400
computedValue = curves.arcL(curves.semicubicParabola, a, b, n)
print("Berechneter Wert mit n=", n, "Werten")
print("Näherung =", computedValue)
n = 1000
computedValue = curves.arcL(curves.semicubicParabola, a, b, n)
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

computedValue = curves.polylineLength(x, y)
print("Berechnung der Bogenlänge der Ellipse mit a=", a, " und b=", b)
print("Der Berechnete Wert:", computedValue)

