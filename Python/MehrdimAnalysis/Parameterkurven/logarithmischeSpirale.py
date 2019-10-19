"""Grafische Ausgabe der logarithmischen Spirale
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

# Parameterintervall digitalisieren
# Wie viele Samples?
n = 1000
thetaMin = 0.0*np.pi
thetaMax = 6.0*np.pi
theta = np.linspace(thetaMin, thetaMax, n)
a = 1.0
k = 0.25

# x und y-Koordinaten der Kurve berechnen
x, y = curves.logSpiral(a, k, theta)

fig = plt.figure()
ax = fig.add_subplot(111)
style = 'seaborn'
plt.style.use(style)
title = 'Logarithmische Spirale mit a=' + str(a) + ' und k=' + str(k)
ax.set_title(title.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()

fig.savefig('images/logarithmischeSpirale.png', dpi=300)