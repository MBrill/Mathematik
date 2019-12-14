"""
Isolinien eines quadratischen Form als Beispiel
für die Optimierung dieser Funktion.
"""
import matplotlib.pyplot as plt
import numpy as np

def ellParaboloid(x, y) :
    """ Elliptisches Paraboloid """
    return 4.0*x*x + 9*y*y


print("------------")
print("Manuelles Beispiel für das elliptische Paraboloid")
print("------------")
x0 = 0.5
y0 = 1.0/3.0
print("Startpunkt (", x0, ", ", y0, ")")
print("Funktionswert an diesem Punkt ist ", ellParaboloid(x0, y0))

t0 = 52.0/776.0
x1 = 0.5 - t0*4.0
y1 = 1.0/3.0 - t0*6.0

print("Die optimale Schrittweite mit Hilfe der ersten Ableitung ist", t0)
print("Die erste Approximation ist (", x1, ", ", y1, ")")
print("Funktionswert an diesem Punkt ist ", ellParaboloid(x1, y1))

