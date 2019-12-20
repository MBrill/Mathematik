"""
Isolinien eines quadratischen Form als Beispiel
für die Optimierung dieser Funktion.
"""
import matplotlib.pyplot as plt
import numpy as np

def ellParaboloid(x, y) :
    """ Elliptisches Paraboloid """
    return 4.0*x*x + 9*y*y


fig = plt.figure()
ax = fig.add_subplot(111)
ax.set_aspect(1.0)

# Definitionsbereich
xmin = -1.0
xmax = 1.0
ymin = -1.0
ymax = 1.0
n = 200
x = np.linspace(xmin, xmax, n)
y = np.linspace(ymin, ymax, n)
x, y = np.meshgrid(x, y)
# Funktionsvorschrift
z = ellParaboloid(x, y)

# Isolinien konfigurieren
Cmin = 0.25
Cmax = 2.5
Cstep = 0.25
levels = np.arange(Cmin, Cmax, Cstep)

# Minimum und Startpunkt einzeichnen
plt.scatter(0, 0, s=5, color='green')

cplot = ax.contour(x, y, z, levels=levels,
                   extent=(xmin, xmax, ymin, ymax))

#plt.scatter(0.5, 0, s=5, color='red')
plt.scatter(0.5, 1.0/3.0, s=5, color='red')
plt.scatter(0.23195, -0.068728, s = 5, color='green')
plt.title('Isolinien von 4*x^2 + 9y^2')
ax.set_xlabel("x")
ax.set_ylabel("y")
cbar = plt.colorbar(cplot, shrink=0.8, extend='both')
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Konturwerte', rotation=270)


# Plot abspeichern
dpi = 100
quality = 100
plotfile = 'images/quadratic.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()