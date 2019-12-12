"""
Funktionen von R^2 nach R

@author: Manfred Brill
"""
import numpy as np

"""Die Rosenbrock-Banane """
def rosenbrock(x, y) :
    return 100.0*(y - x**2)**2 + (1.0-x)*(1.0-x)

""" Beispiel zu imshow """
def sinsin(x, y) :
    return -np.sin(x)*np.sin(y)

""" Paraboloid """
def ellParaboloid(x, y) :
    return x*x + y*y

""" Hyperbolisches Paraboloid """
def hypParaboloid(x, y) :
    return x*x - y*y

"""Sombrero-Funktion mit einstellbarer Frequenz """
def sombrero(x, y, frequency) :
    r = np.sqrt(x*x + y*y)
    return np.exp(-r) * np.cos(frequency*r)

"""Funktion aus Aufgabe iso1 (Elliptisches Paraboloid)"""
def iso1(x, y) :
    return 2.0*x*x + y*y
    
"""Funktion aus Aufgabe iso2"""
def iso2(x, y) :
    return x + y*y

"""Quadratische Funktion"""
def quadFunction(x, y) :
    return x*x - x+y + y*y

"""Beispiel lokale Extrema in Vorlesung"""
def extremwertExample(x, y) :
    return -((x*x+y*y)*(x*x+y*y)) + x*x - y*y
    #return -(x**2+y**2)**2 + x*+2 - y**2
