# -*- coding: utf-8 -*-
"""
Integralrekursionen
"""
import numpy as np

# Funktionen
def forward(n) :
    iterationValue = 1.0 - 1.0/np.e
    print("I_0", iterationValue)
    for counter in range(1, n+1) :
        iterationValue = 1.0 - counter*iterationValue
        print("I_", counter, ", =", iterationValue)
    return iterationValue


def backward(start, end, istart) :
    iterationValue = istart
    print("I_", start, " = ", iterationValue)
    for counter in range(start-1, end-1, -1):
        iterationValue = (1.0-iterationValue)/float(counter)
        print("I_", counter, " = ", iterationValue)
    return iterationValue
    
# Teilaufgabe a
n = 30
print("Ergebnis der Vorwärts-Berechnung")    
forward(n)

# Teilaufgabe b
istart = 0.0
print("Ergebnisse der Rückwärts-Berechnung mit Startwert", istart)
backward(50, n, istart)
istart = 10.0e10
print("Ergebnisse der Rückwärts-Berechnung mit Startwert", istart)
backward(50, n, istart)
istart = -10.0e10
print("Ergebnisse der Rückwärts-Berechnung mit Startwert", istart)
result = backward(50, n, istart)

# Teilaufgabe c
# Wir vergleichen mit den Abschätzungen
print("\nDie Abschätzung für n=", n, ":", 1.0/(3.0*(n+1)), result, 1.0/(n+1.0))