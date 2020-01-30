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
xmax = -20.0
ymin = -100.0
ymax = -20.0
n = 200
x = np.linspace(xmin, xmax, n)
y = np.linspace(ymin, ymax, n)
x, y = np.meshgrid(x, y)
# Funktionsvorschrift
k = 0.03
z = fun.hypPara(k,x,y)
   
Cmin = -200.0
Cmax = 150.0
Cstep = 50.0

levels = np.arange(Cmin, Cmax, Cstep)
cplot = ax.contour(x, y, z, levels=levels,
                   origin='lower',
                   cmap=cm.coolwarm,
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
gx = [-90.0, -80.0, -70.0, -60.0]
gy = []
nablaX = []
nablaY = []

for i in range(0, 4):
    gy.append(np.sqrt(gx[i]*gx[i] - cV/k))
    nablaX.append(2.0*k*gx[i])
    nablaY.append(-2.0*k*gy[i])
    plt.arrow(gx[i], gy[i], nablaX[i], nablaY[i],
          width = 1.0, 
          fc = 'r',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)
    plt.arrow(gx[i], -gy[i], nablaX[i], -nablaY[i],
          width = 1.0, 
          fc = 'r',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)
    plt.arrow(-gx[i], gy[i], -nablaX[i], nablaY[i],
          width = 1.0, 
          fc = 'r',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)
    plt.arrow(-gx[i], -gy[i], -nablaX[i], -nablaY[i],
          width = 1.0, 
          fc = 'r',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)    

cV = -100.0
gx = [-70.0, -60.0, -50.0, -40.0]
gy = []
nablaX = []
nablaY = []
for i in range(0, 4):
    gy.append(np.sqrt(gx[i]*gx[i] - cV/k))
    nablaX.append(2.0*k*gx[i])
    nablaY.append(-2.0*k*gy[i])
    plt.arrow(gx[i], gy[i], nablaX[i], nablaY[i],
          width = 1.0, 
          fc = 'g',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)
    plt.arrow(gx[i], -gy[i], nablaX[i], -nablaY[i],
          width = 1.0, 
          fc = 'g',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)
    plt.arrow(-gx[i], gy[i], -nablaX[i], nablaY[i],
          width = 1.0, 
          fc = 'g',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5)
    plt.arrow(-gx[i], -gy[i], -nablaX[i], -nablaY[i],
          width = 1.0, 
          fc = 'g',
          ec = 'none', 
          length_includes_head=True,
          lw = 0.5) 
# Plot abspeichern
dpi = 300
quality = 100
plotfile = 'images/ContourAndGradientArrowZoom.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()
