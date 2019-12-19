""" 
   Planare Parameterkurven 

   Return-Werte werden als Tupel erzeugt 
"""
import numpy as np


def cycloid(radius, theta) :
    """Zykloide """
    x = radius*(theta - np.sin(theta))
    y = radius*(1.0 - np.cos(theta))
    return x, y

def cycloidVelocity(radius, theta) :
    """ 
    Zykloide erste Ableitung
    Wir werden mittelfristig die Kurven
    als Klassen implementieren, dann wird
    diese Funktion und die oben zu einer
    Funktion der Klasse.
    """
    x = radius*(1.0-np.cos(theta))
    y = radius*np.sin(theta)
    return x, y


def first_example(t) :
    """Erstes Kurvenbeispiel aus der Vorlesung"""
    x = t*t-2.0*t
    y = t + 1.0
    return x, y


def aufgabe1a(t) :
    """ Aufgabe 1a), Blatt Ebene Parameterkurven """
    t2 = t*t
    x = 3.0*(t2-3.0)
    y = t2*t-3.0*t
    return x, y


def aufgabe1b(t) :
    """ Aufgabe 1b), Blatt Ebene Parameterkurven """
    t3 = t*t*t
    x = t3*t - 1.0
    y = t3 + 1.0
    return x, y


def logSpiral(a, k, theta) :
    """ Logarithmische Spirale """
    r = a * np.exp(k*theta)
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return x, y


def archimedeanSpiral(k, theta) :
    """ Archimedische Spirale """
    r = k * theta
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return x, y