# -*- coding: utf-8 -*-
"""
Verschiedene Alternativen für die Vieta'sche Formel
"""
import numpy as np

# Funktionen
def numberOne(p, q) :
    return -p + np.sqrt(p*p-q)

def numberTwo(p, q) :
    denum = p + np.sqrt(p*p-q)
    return (-q)/denum

# Die Werte für Teilaufgabe a
p = 3.0
q = 8.0
print("Das korrekte Ergebnis fuer p=3, q=8 ist -2.0")
print("Lösung mit (1): x = ", numberOne(p, q))
print("Lösung mit (2): x = ", numberTwo(p, q))
p = 4.0
q = 7.0
print("Das korrekte Ergebnis fuer p=4, q=7 ist -1.0")
print("Lösung mit (1): x = ", numberOne(p, q))
print("Lösung mit (2): x = ", numberTwo(p, q))
p = 5.0
q = 9.0
print("Das korrekte Ergebnis fuer p=5, q=9 ist -1.0")
print("Lösung mit (1): x = ", numberOne(p, q))
print("Lösung mit (2): x = ", numberTwo(p, q))
    
# Teilaufgabe b
print("-----------------------")
print("-     Teilaufgabe b   -")
print("-----------------------")
p = 999.0
q = 1.0e-1
for i in range(1, 21) :
    print("Das korrekte Ergebnis fuer p=",p, ", q=", q)
    print("Lösung mit (1): x = ", numberOne(p, q))
    print("Lösung mit (2): x = ", numberTwo(p, q))
    q = q*1.0e-1
    
