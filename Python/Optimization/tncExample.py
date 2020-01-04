# -*- coding: utf-8 -*-
"""
Beispiel für die Verwendung des diskreten
Newton-Algorithmus in SciPy.

Wir verwenden hier den exakten Gradienten,
die Hesse-Matrix wird in der Funktion angenähert!
"""
import numpy as np
from scipy import optimize

# Die Funktion, für die wir ein Minimum suchen
# Als erstes Beispiel verwenden wir eine quadratische
# Form, so wie in den Folien
def f(x) :
    """ Elliptisches Paraboloid """
    return 4.0*x[0]*x[0] + 9.0*x[1]*x[1]


# Der Gradient, als "jacobian"
def jacobi(x) :
    return np.array([8.0*x[0], 18.0*x[1]])

# Startwert
# In den Folien zu steepest descent hatten wir (0.5,0)
# und als zweiten Startwert (0.5, 0.333)
x0 = np.array([0.5, 1.0/3.0])

print("---------------------------------")
print("------         TNC        -------")
print("Startwert:", x0)
print("Exaktes lokales Minimum ist der Punkt (0,0)")
print("---------------------------------")

# Algorithmus aufrufen
maxIter = 100

# disp: Ausgaben oder nicht?
result = optimize.minimize(f, x0,
                           method="tnc",
                           jac=jacobi,
                           options={'maxiter': maxIter,
                                    'xtol': 1e-5,
                                    'disp': False})
                                  
if result.success:
    print("Der Algorithmus war erfolgreich!")
    print("Der berechnete Punkt des lokalen Minimums:")
    print(result.x)
    print("Der Funktionswert an diesem Punkt:", result.fun)
    print("Wir haben", result.nfev, "Funktionsauswertungen benötigt")
    print("Wir haben", result.nit, "Iterationen durchgeführt")
    print("---------------------------------")
    
# result als Ganzes ausgeben
# Würden wir auch mit disp=True erhalten
print("SciPy-Ausgabe des Ergebnisses")
print(result)          
          