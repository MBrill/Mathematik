"""
Darstellung einer Funktion von zwei reellen Veränderlichen
als gefärbte Fläche und mit einer Darstellung mit Konturlinien
in der xy-Ebene.

Andere Funktion verwenden: die Berechnung der z-Werte anpassen
Und nicht vergessen, den Dateinamen für die Bitmap zu verändern!
"""
import matplotlib.pyplot as plt
from matplotlib import cm
from mpl_toolkits.mplot3d import Axes3D

import numpy as np

import functions as fun

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Elliptisches/hyperbolisches Paraboloid
# Gitter in Zylinderkoordinaten
r = np.arange(0, 4.0*np.pi, 0.1)
t = np.arange(0, 8.0*np.pi, 0.2)
r, t = np.meshgrid(r, t)

# Kartesische Koordinaten
x = r*np.cos(t)
y = r*np.sin(t)
#z = fun.ellParaboloid(x, y)
z = fun.hypParaboloid(x, y)

# iso1 Aufgabe
#x = np.linspace(-4.0, 4.0, 1000)
#y = np.linspace(-8.0, 8.0, 1000)
#x, y = np.meshgrid(x, y)
#z = fun.iso1(x, y)

# iso2 Aufgabe
#x = np.linspace(0.0, 10.0, 500)
#y = np.linspace(-3.0, 3.0, 500)
#x, y = np.meshgrid(x, y)
#z = fun.iso2(x, y)

# Beispiel einer quadratischen Funktion aus der Vorlesung
#x = np.linspace(-8.0, 8.0, 1000)
#y = np.linspace(-8.0, 8.0, 1000)
#x, y = np.meshgrid(x, y)
#z = fun.quadFunction(x, y)

# imshow Beispiel
#n=200
#x = np.linspace(0, 1.0*np.pi, n)
#y = np.linspace(0, 2.0*np.pi, n)
#x, y = np.meshgrid(x, y)
#z = sinsin(x, y)

# Sombrero
#n = 2000
#x = np.linspace(-2.0, 2.0, n)
#y = np.linspace(-2.0, 2.0, n)
#x, y = np.meshgrid(x, y)
#r = np.sqrt(x*x + y*y)
#frequency = 6.0
#z = np.exp(-r) * np.cos(frequency*r)

# Rosenbrock-Banane
#n = 2000
#xmin = -2.0
#xmax = 2.0
#ymin = -1.0
#ymax = 3.0
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
#x, y = np.meshgrid(x, y)
#z = rosenbrock(x, y)


surf = ax.plot_surface(x, y, z,  
                alpha=0.9, 
                rstride=10, cstride=10, 
                linewidth=0.5,
                cmap=cm.coolwarm)

cbar = fig.colorbar(surf, shrink=0.5)

cset = ax.contourf(x, y, z, zdir='z',
                   cmap=cm.coolwarm,
                   offset=-1)
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Funktionswerte', rotation=270)

# Plot abspeichern
dpi = 100
quality = 100
plotfile = 'images/ColoredContour.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()