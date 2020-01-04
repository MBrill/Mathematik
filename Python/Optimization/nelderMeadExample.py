# -*- coding: utf-8 -*-
"""
Beispiel für die Verwendung des Nelder-Mead-Algorithmus in SciPy
"""
import numpy as np
from scipy import optimize

# Die Funktion, für die wir ein Minimum suchen
# Als erstes Beispiel verwenden wir eine quadratische
# Form, so wie in den Folien
def f(x) :
    """ Elliptisches Paraboloid """
    return 4.0*x[0]*x[0] + 9.0*x[1]*x[1]


# Startwert
# In den Folien zu steepest descent hatten wir (0.5,0)
x0 = np.array([0.5, 0.0])

print("---------------------------------")
print("------  Nelder-Mead       -------")
print("Startwert:", x0)
print("Exaktes lokales Minimum ist der Punkt (0,0)")
print("---------------------------------")

# Nelder-Mead-Algorithmus aufrufen
maxIter = 100

# xatol und fatol: absolute Fehler in x und f(x)
# für Konvergenzüberprüfung
# disp: Ausgaben oder nicht?
result = optimize.minimize(f, x0,
                           method="nelder-mead",
                           options={'maxiter': maxIter,
                                    'xatol': 1e-5,
                                    'fatol': 1e-5,
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
#print("SciPy-Ausgabe des Ergebnisses")
#print(result)          
          