"""
Grafische Darstellung von kubischen
Polynomen.

Die Polynome stammen aus Lösungen
von Interpolationsaufgaben aus
der linearen Algebra oder anderen Aufgaben.

Polynome, die zu Aufgaben gehören
haben als Funktion die Aufgabendatei als Name.
"""
import numpy as np
import matplotlib.pyplot as plt
from numpy.polynomial.polynomial import polyval


def lgs9(x):
    return polyval(x, [3.0, 0.0, -2.0, 1.0])


def lgs68(x):
    return polyval(x, [0.5, -0.75, 0.0, 0.25])


# Eine spezielle Lösung für lgs69, lambda = 1
def lgs69(x):
    return polyval(x, [1.0, 1.0, -1.0, -1.0])


fig = plt.figure()
ax = fig.add_subplot(111)

# Parameter
xmin = -1.2
xmax = 1.2
# lgs9
# xmax = 3.2
n = 100

xValues = np.linspace(xmin, xmax, n)
yValues = lgs68(xValues)
#
linewidth = 0.8

ax.plot(xValues, yValues, linewidth=linewidth, color='g')

ax.set_xlabel('x')
# Angaben in label_coords beziehen sich
# auf die Grafik, also auf Einheitsintervalle!
ax.xaxis.set_label_coords(1.0, 0.1)
ax.set_ylabel('p(x)')
ax.yaxis.set_label_coords(0.55, 1.0)
# Achsen verschieben und oben, rechts verbergen
ax.spines['left'].set_position(('data', 0))
ax.spines['bottom'].set_position(('data', 0))
ax.spines['top'].set_visible(False)
ax.spines['right'].set_visible(False)

# Abspeichern
dpi = 300
quality = 100
# plotfile = 'images/lgs9.png'
plotfile = 'images/lgs68.png'
# plotfile = 'images/lgs69.png'

plt.savefig(plotfile, dpi=dpi, quality=quality)

plt.show()
