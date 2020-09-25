# -*- coding: utf-8 -*-
"""
Grafische Darstellung der Sinus-Funktion zwischen -2pi und 2pi.
"""
import numpy as np
import matplotlib.pyplot as plt

# Intervall, und Auflösung der Kurve
a = -2.0*np.pi
b = 2.0*np.pi

n = 100


# f = lambda x: np.sin(x)
def f(x):
    return np.sin(x)


# Wir erzeugen diskrete x-Werte
xValues = np.linspace(a, b, n)
yValues = f(xValues)

# Abbildung erzeugen
fig = plt.figure()
plt.figure(dpi=600)
plt.grid(True)
# Attribute für die grafische Ausgabe
linewidth = 0.8
# Grafische Ausgabe
plt.plot(xValues, yValues, 'g-')
plt.title('$f(x) = sin(x)$')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.show()
