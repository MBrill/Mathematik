"""Planare Parameterkurven 

   Return-Werte werden als Tupel erzeugt 
   Bisher realisiert:
   Zykloide - cycloid
   Erstes Beispiel - first_example
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
