"""
Isolinien eines skalaren Felds
und grafische Ausgabe des Gradienten
an ausgewählten Punkten.

Angelehnt an Bautista, Mathematics and Python Programming,
pp. 242 ff.
"""
import matplotlib.pyplot as plt
from matplotlib import cm
import numpy as np

import functions as fun

fig = plt.figure()
ax = fig.add_subplot(111)

# Definitionsbereich
xmin = -5.0
xmax = 2.0
ymin = -2.0
ymax = 2.0
n = 200
x = np.linspace(xmin, xmax, n)
y = np.linspace(ymin, ymax, n)
x, y = np.meshgrid(x, y)
# Funktionsvorschrift
z = fun.iso2(x,y)
   
Cmin = -1.0
Cmax = 2.1
Cstep = 1.0

levels = np.arange(Cmin, Cmax, Cstep)
cplot = ax.contour(x, y, z, levels=levels,
                   origin='lower',
                   cmap=cm.coolwarm,
                   extent=(xmin, xmax, -ymin, ymax))

cbar = plt.colorbar(cplot, shrink=0.8, extend='both')
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Konturwerte', rotation=270)
plt.title('Isolinien und Gradienten')

# Wir berechnen einen Punkt mit x=-90,
# der auf der Linie zu C=150 liegt.
cV = -1.0
gx = []
gy = [-0.5, 0.0, 0.5,]
nablaX = [1.0, 1.0, 1.0]
nablaY = []

for i in range(0, 3):
    gx.append(cV - gy[i]*gy[i])
    nablaY.append(2.0*gy[i])
    plt.arrow(gx[i], gy[i], nablaX[i], nablaY[i],
          width = 0.05, 
          fc = 'r',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5) 

cV = 1.0
gx = []
gy = [-0.5, 0.0, 0.5,]
nablaX = [1.0, 1.0, 1.0]
nablaY = []

for i in range(0, 3):
    gx.append(cV - gy[i]*gy[i])
    nablaY.append(2.0*gy[i])
    plt.arrow(gx[i], gy[i], nablaX[i], nablaY[i],
          width = 0.05, 
          fc = 'g',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)    
    
# Plot abspeichern
dpi = 300
quality = 100
plotfile = 'images/ContourAndGradientArrow2.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()
