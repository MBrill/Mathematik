"""Grafische Ausgabe einer Bezierkurve

Verwendet das Package bezier.
Dieses Package wird so installiert:
    
    python -m pip install --upgrade bezier
    
Eventuell wird eine neuere numpy-Version
mit installiert.

Das Python-Package bezier findet man in Github unter
https://github.com/dhermes/bezier.
"""
import matplotlib.pyplot as plt
import numpy as np
import bezier

# Kontrollpunkte als numpy-Array definieren
nodes1 = np.asfortranarray([
        [0.0, 0.5, 1.0],
        [0.0, 1.0, 0.0]
        ])
x1 = nodes1.transpose()[:,0]
y1 = nodes1.transpose()[:,1]

nodes2 = np.asfortranarray([
        [0.0, 0.25,  0.5, 0.75, 1.0],
        [0.0, 2.0 , -2.0, 2.0 , 0.0],
        ])
   
x2 = nodes2.transpose()[:,0]
y2 = nodes2.transpose()[:,1]

# Bezier-Splines erzeugen
# die erste Kurve ist ein quadratischer Spline
spline1 = bezier.Curve(nodes1, degree=2)


# die zweite Kurve ist ein kubischer Spline  
spline2 = bezier.Curve(nodes2, degree=3)
  
# Ohne grafische Ausgabe, aber mit bezier können wir
# auch Schnitte zwischen den Kurven berechnen
# intersections = curve1.intersect(curve2)

# Grafische Ausgabe
fig = plt.figure()
ax = fig.add_subplot(111)
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 256

spline1.plot(num_pts=n, ax=ax)
spline2.plot(num_pts=n, ax=ax)
# Kontrollpolygone
ax.plot(x1, y1, color='C0', label='Quadratischer Spline')
ax.plot(x2, y2, color='C1', label='Kubischer Spline')

style = 'seaborn'
plt.style.use(style)

ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_xlim(-0.125, 1.125)
ax.set_ylim(-2.125, 2.125)
ax.set_title('Bezierkurven und Kontrollpolygone'.format(style), color='C0')
ax.legend()

plt.show()

fig.savefig('images/bezier.png', dpi=300)