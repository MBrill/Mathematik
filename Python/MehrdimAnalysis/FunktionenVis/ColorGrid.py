import matplotlib.pyplot as plt
from matplotlib import cm
import numpy as np

import functions as fun

fig = plt.figure()
ax = fig.add_subplot(111)

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

#imshow-Beipiel
#x = np.linspace(0, 1.0*np.pi, n)
#y = np.linspace(0, 2.0*np.pi, n)
#x, y = np.meshgrid(x, y)
#z = -np.sin(x)*np.sin(y) 

# Sombrero
#n = 2000
#xmin = -2.0
#xmax = 2.0
#ymin = -2.0
#ymax = 2.0
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
#x, y = np.meshgrid(x, y)
#frequency = 6.0
#z = fun.sombrero(x, y, frequency)

# Rosenbrock-Banane
#n = 2000
#xmin = -2.0
#xmax = 2.0
#ymin = -1.0
#ymax = 3.0
#x = np.linspace(xmin, xmax, n)
#y = np.linspace(ymin, ymax, n)
#x, y = np.meshgrid(x, y)
#z = 100.0*(y - x**2)**2 + (1.0-x)*(1.0-x)

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.xticks([0, 499, 1999], ['-2', '0', '2'])
plt.yticks([0, 499, 1999], ['-2', '0', '2'])
ax = plt.imshow(z, cmap=cm.jet, origin='lower')  

cbar = fig.colorbar(ax)
cbar.ax.get_yaxis().labelpad=15
cbar.ax.set_ylabel('Funktionswerte', rotation=270)

# Plot abspeichern
dpi = 100
quality = 100
plotfile = 'ColorGrid.png'

plt.savefig(plotfile, 
            dpi = dpi, quality=quality)

plt.show()