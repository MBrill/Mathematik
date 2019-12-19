"""
Grafische Ausgabe der Zykloide

Wir geben sowohl die Kurve als auch
die Tangentialvektoren, die durch die 
Geschwindigkeit gegebens sind, an
ausgewählten Punkten aus.
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
theta = np.linspace(0, 4*np.pi, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.cycloid(radius, theta)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Zykloide'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.ylim(0.0, 3.0)

# Kurve ausgeben
plt.plot(x, y, 'C1')
# Einige Geschwindigkeitsvektoren
n = 64
parametervalues = np.linspace(0.0, 4.0*np.pi, n)

for i in range(0, n):
    theta = parametervalues[i]
    x,y = curves.cycloid(radius, theta)
    dx,dy = curves.cycloidVelocity(radius, theta)
    
    plt.arrow(x,y, dx, dy, width=0.01, fc='r', ec='none')
    
    
plt.show()

fig.savefig('images/zykloideTangente.png', dpi=300)