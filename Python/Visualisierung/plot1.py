# -*- coding: utf-8 -*-
"""
Lösung der Aufgabe plot1 mit Hilfe eines selbst implementierten Moduls
"""
import fctVis as fp
import numpy as np
from numpy.polynomial.polynomial import polyval


# Beispiele für Polynome, inkl. der Standardparabeln
def parabola(x):
    return polyval(x, [0.0, 0.0, 1.0])


def cubicparabola(x):
    return polyval(x, [0.0, 0.0, 0.0, 1.0])


def poly(x):
    return polyval(x, [3.0, 0.0, -2.0, 1.0])


a = -2.0*np.pi
b = 2.0*np.pi
n = 100
title = '$f(x) = sin(x)$'
fp.xy_plotter(np.sin, a, b, n, title, True)

a = -1.0
b = 4.0
n = 100
title = '$f(x) = e^x$'
fp.simple_plotter(np.exp, a, b, n, title)

a = -3.0
b = 3.0
n = 100
title = '$f(x) = x^2$'
fp.simple_plotter(parabola, a, b, n, title, True)

a = -3.0
b = 3.0
n = 100
title = '$f(x) = x^3$'
fp.xy_plotter(cubicparabola, a, b, n, title)

a = -1.5
b = 3.0
n = 100
title = '$p(x) = x^3 - 2 x^2 + 3$'
fp.xy_plotter(poly, a, b, n, title, True)
