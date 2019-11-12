"""Raum-Kurven 

   Return-Werte werden als Tupel erzeugt 
   Bisher realisiert:
   Helix
   Schraubenlinie
"""
import numpy as np

"""Helix"""
def helix(radius, height, theta) :
    twopi = 2.0*np.pi
    x = radius*np.cos(twopi * theta)
    y = radius*np.sin(twopi * theta)
    z = height * theta
    return x, y, z

"""Schraubenlinie

Diese Kurve liegt auf dem Kegel x^2 + y^2 - z^2 = 0
(falls r = 1).
Die Projektion dieser Kurve in die x-y-Ebene ist
die logarithmische Spirale.
"""
def schraubenlinie(radius, t) :
    mult = radius*np.exp(t)
    x = mult*np.cos(t)
    y = mult*np.sin(t)
    return x, y, mult

