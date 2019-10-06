"""Grafische Ausgabe der Zykloide mit matplotlib.pyplot
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Eigenschaften der Zykloide (Radius)
radius = 1.0
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
theta = np.linspace(-6*np.pi, 6*np.pi, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.cycloid(radius, theta)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Zykloide'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()