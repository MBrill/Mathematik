"""Grafische Ausgabe der logarithmischen Spirale
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 20000
theta = np.linspace(0.0, 6.0*np.pi, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.logSpiral(1.0, theta)

print(x)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Logarithmische Spirale'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()