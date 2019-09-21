"""Raum-Kurven 

   Return-Werte werden als Tupel erzeugt 
   Bisher realisiert:
   Zykloide . cycloid
"""
import numpy as np

"""Helix"""
def helix(radius, height, theta) :
    twopi = 2.0*np.pi
    x = radius*np.cos(twopi * theta)
    y = radius*np.sin(twopi * theta)
    z = height * theta
    return x, y, z


