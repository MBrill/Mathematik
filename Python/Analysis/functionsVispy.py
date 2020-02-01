"""
Grafische Darstellung von Funktionsgraphen
"""
import numpy as np
from numpy.polynomial.polynomial import polyval
import matplotlib.pyplot as plt

# Beispiele für Polynome, inkl. der Standardparabeln
def parabola(x) :
    return polyval(x, [0.0, 0.0, 1.0])

def cubicparabola(x) :
    return polyval(x, [0.0, 0.0, 0.0, 1.0])

def poly1(x) :
    return polyval(x, [3.0, 0.0, -2.0, 1.0])


def poly2(x) :
    return polyval(x, [0.5, -0.75, 0.0, 0.25]) 
   

# Intervall, und Auflösung der Kurve
#a = -2.0*np.pi
#b = 2.0*np.pi
a = -1.2
b = 3.2
n = 100
# Wir erzeugen diskrete x-Werte
xValues = np.linspace(a, b, n)
# Mit Hilfe von NumPy können wir die Auswertung vektorisieren
#yValues = np.sin(xValues)
yValues = poly1(xValues)
# Abbildung erzeugen
fig = plt.figure()
ax = fig.add_subplot(111)
# Attribute für die grafische Ausgabe
linewidth = 0.8
# Grafische Ausgabe
ax.plot(xValues, yValues, linewidth=linewidth, color = 'g')
     
a#x.set_xlabel('x')
# Angaben in label_coords beziehen sich 
# auf die Grafik, also auf Einheitsintervalle!
# Die Position für das Label an der x-Achse
# an den Funktionsverlauf anpassen!
ax.xaxis.set_label_coords(1.0, 0.55)
#ax.set_ylabel('x^3')
ax.yaxis.set_label_coords(0.55, 0.1)
# Achsen verschieben und oben, rechts verbergen
ax.spines['left'].set_position(('data', 0))
ax.spines['bottom'].set_position(('data', 0))
ax.spines['top'].set_visible(False)
ax.spines['right'].set_visible(False)

plt.show()
