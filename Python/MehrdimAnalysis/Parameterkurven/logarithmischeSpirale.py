"""Grafische Ausgabe der logarithmischen Spirale
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

# Parameterintervall digitalisieren
# Wie viele Samples?
n = 40
thetaMin = 0.0*np.pi
thetaMax = 3.0*np.pi
theta = np.linspace(thetaMin, thetaMax, n)
radius = 0.15

# x und y-Koordinaten der Kurve berechnen
x, y = curves.logSpiral(radius, theta)

fig = plt.figure(figsize=(10,10))
ax = fig.add_subplot(111)
style = 'seaborn'
plt.style.use(style)
ax.set_title('Logarithmische Spirale'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()