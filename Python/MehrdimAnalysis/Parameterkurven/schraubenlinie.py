from mpl_toolkits import mplot3d
import matplotlib.pyplot as plt
#from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import space_curves

fig = plt.figure()

# Eigenschaften der Zykloide (Radius)
radius = 1.0
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 10000
t_min = -1000.0
t_max = 200.0
t = np.linspace(t_min, t_max, n)

# x, y und z-Koordinaten der Kurve berechnen
x, y, z = space_curves.schraubenlinie(radius, t)

style = 'seaborn'
plt.style.use(style)
ax = fig.add_subplot(111, projection='3d')
ax.set_title('Schraubenlinie'.format(style), color='C0')
ax.plot(x, y, z, label='schraubenlinie')
#ax.legend()

ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_ylabel('z')
plt.plot(x, y, z, 'C1')

plt.show()

fig.savefig('images/schraube.png', dpi=300)