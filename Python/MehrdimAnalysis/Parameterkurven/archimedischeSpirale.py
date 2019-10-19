"""Grafische Ausgabe der logarithmischen Spirale
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
thetaMin = 0.0
thetaMax = 6.0*np.pi
theta = np.linspace(thetaMin, thetaMax, n)
k = 0.5

# x und y-Koordinaten der Kurve berechnen
x, y = curves.archimedeanSpiral(k, theta)

style = 'seaborn'
plt.style.use(style)
title = 'Archimedische Spirale mit k=' + str(k)
ax.set_title(title.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()

fig.savefig('images/archimedes.png', dpi=300)