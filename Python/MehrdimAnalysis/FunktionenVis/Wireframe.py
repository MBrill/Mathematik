"""
Wireframe-Darstellung einer Funktion von zwei reellen Veraenderlichen

Andere Funktion verwenden: die Berechnung der z-Werte anpassen
Und nicht vergessen, den Dateinamen fuer die Bitmap zu veraendern!
"""
import numpy as np
import matplotlib.pyplot as plt
#from mpl_toolkits.mplot3d import Axes3D

import functions as fun

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Paraboloid
r = np.arange(0, 6.0*np.pi, 0.05)
t = np.arange(0.0, 2.0*np.pi, 0.01)
r, t = np.meshgrid(r, t)
# Kartesische Koordinaten
x = r*np.cos(t)
y = r*np.sin(t)
z = fun.ellParaboloid(x, y)

# sinsin
#x = np.linspace(0, 1.0*np.pi, 200)
#y = np.linspace(0, 2.0*np.pi, 200)
#x, y = np.meshgrid(x, y)
#z = fun.sinsin(x, y)

# Sombrero
# Definitionsbereich
#xmin = -2.0
#xmax = 2.0
#ymin = -2.0
#ymax = 2.0
#n = 2000
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(xmin, xmax, n)
#x, y = np.meshgrid(x, y)
#frequency = 6.0
#z = sombrero(x, y, frequency)

 # Rosenbrock-Banane
#n = 2000
#xmin = -2.0
#xmax = 2.0
#ymin = -1.0
#ymax = 3.0
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
#x, y = np.meshgrid(x, y)
#z = fun.rosenbrock(x, y)

#
linewidth = 0.8
dpi = 100
quality = 100
plotfile = 'images/paraboloid.png'

ax.plot_wireframe(x, y, z,  
                alpha=0.9, 
                rstride=30, cstride=20, 
                linewidth=linewidth,
                color = 'g'
                )

ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_zlabel('z')

# Plot abspeichern


plt.savefig(plotfile, 
            dpi = dpi, quality=quality)


plt.show()
