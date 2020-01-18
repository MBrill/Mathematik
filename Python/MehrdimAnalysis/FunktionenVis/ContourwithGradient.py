"""
Isolinien mit Hilfe der pyplot-Funktion contour.

Code ist angelehnt an contour_demo.py

Andere Funktion verwenden: die Berechnung der z-Werte anpassen
Und nicht vergessen, den Dateinamen für die Bitmap zu verändern!
"""
import matplotlib.pyplot as plt
import numpy as np

import functions as fun

fig = plt.figure()
ax = fig.add_subplot(111)
#ax.set_aspect(1.0)

# Definitionsbereich
#xmin = -2.0
#xmax = 2.0
#ymin = -2.0
#ymax = 2.0
#n = 200
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
#x, y = np.meshgrid(x, y)
# Funktionsvorschrift
#z = ellParaboloid(x,y)

# sin(x)sin(y)
# Definitionsbereich
xmin = 0.0
xmax = 3.0
ymin = 0.0
ymax = 6.0
n = 200
x = np.linspace(0, 1.0*np.pi, n)
y = np.linspace(0, 2.0*np.pi, n)
x, y = np.meshgrid(x, y)
z = fun.sinsin(x, y)

# Sombrero
#n = 2000
#xmin = -2.0
#xmax = 2.0
#ymin = -2.0
#ymax = 2.0
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
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
#z = fun.rosenbrock(x, y)

# Beispiel einer quadratischen Funktion aus der Vorlesung
#xmin = -4.0
#xmax = 5.0
#ymin = -5.0
#ymax = 4.0
#n = 500

#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
#x, y = np.meshgrid(x, y)
#z = fun.quadFunction(x, y)

Cmin = -1.0
Cmax = 1.0
Cstep = 0.2

levels = np.arange(Cmin, Cmax, Cstep)
cplot = ax.contour(x, y, z, levels=levels,
                   origin='lower',
                   #colors=('blue', 'yellow', 'green', 'red'),
                   extent=(xmin, xmax, -ymin, ymax))

# Die nächste Zeile kommentieren wenn wir keine Labels in 
# den Konturlinien haben möchten
#plt.clabel(cplot, inline=1, fontsize=12)
cbar = plt.colorbar(cplot, shrink=0.8, extend='both')
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Konturwerte', rotation=270)
#plt.title('Isolinien mit Labels')

# Als erster Test einen Vektor ausgeben
v = np.array([1,1])
origin = [0], [0] 

plt.quiver(*origin, [1, 1] , color='r', scale_units='xy', scale=20)
# Plot abspeichern
dpi = 300
quality = 100
plotfile = 'Contour.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()
