# -*- coding: utf-8 -*-
"""
Beispiel für die grafische Ausgabe
von Punkten auf einer Parameterkurve.
"""
import matplotlib.pyplot as plt
import numpy as np

fig = plt.figure()
ax = fig.add_subplot(111)

"""Erstes Kurvenbeispiel aus der Vorlesung"""
def first_example(t) :
    x = t*t-2.0*t
    y = t + 1.0
    return x, y

# Parameterintervall digitalisieren
# Wie viele Samples?
n = 7
tmin = -4.0
tmax = 6.0
t = np.linspace(tmin, tmax, n)

# x und y-Koordinaten der Kurve berechnen
x, y = first_example(t)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Punkte auf unserer Kurve'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, linestyle='None', marker='o', markersize=10.0, color='g')

plt.show()