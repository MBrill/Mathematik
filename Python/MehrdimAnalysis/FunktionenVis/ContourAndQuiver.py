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
xmin = -100.0
xmax = 100.0
ymin = -100.0
ymax = 100.0
n = 200
x = np.linspace(xmin, xmax, n)
y = np.linspace(ymin, ymax, n)
x, y = np.meshgrid(x, y)
# Funktionsvorschrift
k = 0.03
z = fun.hypPara(k,x,y)
   
Cmin = 0.0
Cmax = 251.0
Cstep = 50.0

levels = np.arange(Cmin, Cmax, Cstep)
cplot = ax.contour(x, y, z, levels=levels,
                   origin='lower',
                   cmap=cm.rainbow,
                   extent=(xmin, xmax, -ymin, ymax))

# Die nächste Zeile kommentieren wenn wir keine Labels in 
# den Konturlinien haben möchten
#plt.clabel(cplot, inline=1, fontsize=6)
cbar = plt.colorbar(cplot, shrink=0.8, extend='both')
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Konturwerte', rotation=270)
plt.title('Isolinien und Gradienten')

# Als erster Test einen Vektor ausgeben
# Wir berechnen einen Punkt mit x=-90,
# der auf der Linie zu C=150 liegt.
cV = 50.0
gx = [-90.0, -80.0, -70.0, -60.0, 60.0, 70.0, 80.0, 90.0]
gy = []
nablaX = []
nablaY = []

for i in range(0, 8):
    gy.append(np.sqrt(gx[i]*gx[i] - cV/k))
    nablaX.append(2.0*k*gx[i])
    nablaY.append(-2.0*k*gy[i])

plt.quiver(gx, gy, nablaX, nablaY, 
           color='b',
           linewidth=0.25,
           scale = 1,
           units = 'xy'
           ) 

# Plot abspeichern
dpi = 300
quality = 100
plotfile = 'images/ContourAndQuiver.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()
