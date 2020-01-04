# -*- coding: utf-8 -*-
"""
Beispiel für die Verwendung des Newton-Algorithmus in SciPy.

Wir verwenden hier sowohl den exakten Gradienten als
auch die exakte Hesse-Matrix!
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
    return np.array(8.0*x[0], 18.0*x[1])

# Die Hesse-Matrix für die Zielfunktion
def hesse(x) :
    return np.array([[8.0, 0.0], [0.0, 18.0]])


# Startwert
# In den Folien zu steepest descent hatten wir (0.5,0)
x0 = np.array([0.5, 1.0])

print("---------------------------------")
print("------  Newton       -------")
print("Startwert:", x0)
print("Exaktes lokales Minimum ist der Punkt (0,0)")
print("---------------------------------")

# Nelder-Mead-Algorithmus aufrufen
maxIter = 100

# disp: Ausgaben oder nicht?
result = optimize.minimize(f, x0,
                           method="newton-cg",
                           jac=jacobi,
                           hess=hesse,
                           options={'maxiter': maxIter,
                                    'xtol': 1e-1,
                                    'disp': True})
                                  
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
          