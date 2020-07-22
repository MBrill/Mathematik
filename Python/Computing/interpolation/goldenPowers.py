# -*- coding: utf-8 -*-
"""
Beispiel für den Einfluss von Rundungsfehler 
auf eine Berechnung.

Wir berechnen die Potenzen des goldenen Schnitts.
"""

tau0 = 1.0
# Annäherung des goldenen Schnitts
tau1 = 0.61803398

print("tau^ 0 = ", tau0)
print("tau^ 1 = ", tau1)
# Bis zu welcher Potenz berechnen wir tau^n?
n = 25

for i in range(n):
    tau = tau0 - tau1
    print("tau^",i+2, " = ", tau)
    tau0 = tau1
    tau1 = tau
    

    


