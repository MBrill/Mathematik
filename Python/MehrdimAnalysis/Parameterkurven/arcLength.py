# -*- coding: utf-8 -*-
"""
Funktion für die Näherung der Bogenlänge
mit Hilfe eines Polygonzugs
"""
import numpy as np
import curves


# Parameterintervall digitalisieren
# Wie viele Samples?
n = 512
tmin = 0.0
tmax = 1.0
t = np.linspace(tmin, tmax, n)

def arcLength(x, y, n) :
    """ Bogenlänge berechnen mit Hilfe eines 
        übergebenen Polygonzugs
    """
    sum = 0.0
    for i in range(0, n-1) :
        sum += np.sqrt((x[i+1] - x[i])**2 + (y[i+1]-y[i])**2)
    return sum
  
def arcL(c, a = 0.0, b = 1.0, n = 100) :
    """ Bogenlänge mit übergebener Kurve
        und Anzahl der Punkte, die für die Näherung
        verwendet werden soll.
    """
    t = np.linspace(a, b, n)
    x, y = c(t)
    sum = 0.0
    for i in range(0, n-1):
        sum += np.sqrt((x[i+1] - x[i])**2 + (y[i+1]-y[i])**2)
    return sum

# x und y-Koordinaten der Kurve berechnen
x, y = curves.circle(t)

arc = arcLength(x, y, n)

print("Die berechnete Näherung:", arc)
print("Die berechnete Näherung mit der zweiten Methode:", arcL(curves.circle))
print("Der exakte Wert:", 2.0*np.pi)

print("Die halbe Bogenlänge des Einheitskreises ist ", arcL(curves.circle, 0.0, 0.5, 200))


