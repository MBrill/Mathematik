"""
Funktion von zwei reellen Veraenderlichen als gefaerbte Flaeche

Die Farben werden mit Hilfe einer Farbtabelle gewaehlt,
die abhaengig vom Funktionswert einfaerbt.

Andere Funktion verwenden: die Berechnung der z-Werte anpassen
Und nicht vergessen, den Dateinamen fuer die Bitmap zu veraendern!
"""
import matplotlib.pyplot as plt
from matplotlib import cm
#from mpl_toolkits.mplot3d import Axes3D
import numpy as np

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

import functions as fun

# Elliptisches/hyperbolisches Paraboloid
# Gitter in Zylinderkoordinaten
#r = np.arange(0, 4.0*np.pi, 0.1)
#t = np.arange(0, 8.0*np.pi, 0.05)
#r, t = np.meshgrid(r, t)

# Kartesische Koordinaten
#x = r*np.cos(t)
#y = r*np.sin(t)
#z = fun.ellParaboloid(x, y)
#z = fun.hypParaboloid(x, y)

#n=200
# imshow Beispiel
#x = np.linspace(0, 1.0*np.pi, n)
#y = np.linspace(0, 2.0*np.pi, n)
#x, y = np.meshgrid(x, y)
#z = -np.sin(x)*np.sin(y) 


# Beispiel für lokale Extrema aus der Vorlesung
xmin = -0.85
xmax = 0.85
ymin = -0.85
ymax = 0.85
n=800
x = np.linspace(xmin, xmax, n)
y = np.linspace(ymin, ymax, n)
x, y = np.meshgrid(x, y)
z = fun.extremwertExample(x, y)

# Sombrero
#n = 500
#x = np.linspace(-2.0, 2.0, n)
#y = np.linspace(-2.0, 2.0, n)
#x, y = np.meshgrid(x, y)

#frequency = 6.0
#z = fun.sombrero(x, y, frequency)

style = 'seaborn'
plt.style.use(style)
surf = ax.plot_surface(x, y, z,  
                alpha=0.9, 
                rstride=10, cstride=10, 
                linewidth=0.5,
                #cmap=cm.Oranges)
                cmap=cm.coolwarm)

cbar = fig.colorbar(surf, shrink=0.5)
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Funktionswerte', rotation=270)

# Plot abspeichern
dpi = 100
quality = 100
plotfile = 'Colored.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()