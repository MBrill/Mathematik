from mpl_toolkits import mplot3d
import matplotlib.pyplot as plt
#from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import space_curves

fig = plt.figure()


# Eigenschaften der Helix (Radius)
radius = 1.0
height = 2.0
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
theta_min = 0.0
theta_max = 2.0
theta = np.linspace(theta_min, theta_max, n)

# x, y und z-Koordinaten der Kurve berechnen
x, y, z = space_curves.helix(radius, height, theta)

style = 'seaborn'
plt.style.use(style)
ax = fig.add_subplot(111, projection='3d')
ax.set_title('Helix'.format(style), color='C0')
ax.plot(x, y, z, label='Helix')
#ax.legend()

ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_ylabel('z')
plt.plot(x, y, z, 'C1')

plt.show()

fig.savefig('images/helix.png', dpi=300)