# -*- coding: utf-8 -*-
"""
Beispiel für die grafische Ausgabe
von Punkten auf einer Parameterkurve.
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)


# Parameterintervall digitalisieren
# Wie viele Samples?
n = 7
tmin = -4.0
tmax = 6.0
t = np.linspace(tmin, tmax, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.first_example(t)

plt.plot(x, y, 'go', markersize=10.0)
plt.xlabel('x')
plt.ylabel('y')
plt.title('Punkte auf unserer Kurve')

plt.show()
