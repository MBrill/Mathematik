""" Planare Parameterkurven 

   Return-Werte werden als Tupel erzeugt 
"""
import numpy as np

"""Zykloide """
def cycloid(radius, theta) :
    x = radius*(theta - np.sin(theta))
    y = radius*(1.0 - np.cos(theta))
    return x, y

"""Erstes Kurvenbeispiel aus der Vorlesung"""
def first_example(t) :
    x = t*t-2.0*t
    y = t + 1.0
    return x, y

""" Aufgabe 1a), Blatt Ebene Parameterkurven """
def aufgabe1a(t) :
    t2 = t*t
    x = 3.0*(t2-3.0)
    y = t2*t-3.0*t
    return x, y

""" Aufgabe 1b), Blatt Ebene Parameterkurven """
def aufgabe1b(t) :
    t3 = t*t*t
    x = t3*t - 1.0
    y = t3 + 1.0
    return x, y

""" Logarithmische Spirale """
def logSpiral(a, k, theta) :
    r = a * np.exp(k*theta)
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return x, y

""" Archimedische Spirale """
def archimedeanSpiral(k, theta) :
    r = k * theta
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return x, y