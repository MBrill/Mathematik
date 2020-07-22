# -*- coding: utf-8 -*-
"""
Beispiel für die Verwendung des Brent-Algorithmus in SciPy
"""
import numpy as np
from scipy import optimize

# Die Funktion, für die wir ein Minimum suchen
def f(x):
    return (np.exp(x) - 2.5*x*x + x - 1.0)


# Bracket suchen
# Brent benötigt zu Beginn drei Punkte,
# bei denen der mittlere x-Wert den kleinsten Funktionswert
# hat. 
#
# Wir überzeugen uns, dass die drei Werte 0, 2 und 3.5 diese
# Bedingung erzeugen:
print("---------------------------------")
print("------    Brent           -------")
print("---------------------------------")
print("Wir überprüfen, ob eine Klammerung für das gesuchte Minimum kennen:")
print("f(0)=", f(0.0))
print("f(2)=", f(2.0))
print("f(3.5)=",f(3.5))
    

# Brent-Algorithmus aufrufen
maxIter = 50

result = optimize.minimize_scalar(f, 
                                  method="brent",
                                  bracket=(0.0, 2.0, 3.5), 
                                  tol=np.finfo(1.).eps,
                                  options={'maxiter': maxIter})
                                  
if result.success:
    print("Der Algorithmus war erfolgreich!")
    print("Der berechnete x-Wert des lokalen Minimums:", result.x)
    print("Der Funktionswert an diesem x-Wert:", result.fun)
    print("Wir haben", result.nfev, "Funktionsauswertungen benötigt")
    print("Wir haben", result.nit, "Iterationen durchgeführt")
    print("---------------------------------")
    
# result als Ganzes ausgeben, so habe ich die verschiedenen Variablen gesehen
print("SciPy-Ausgabe des Ergebnisses")
print(result)          
          