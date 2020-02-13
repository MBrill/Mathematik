""" Ausgabe unseres ersten Beispiels aus der Vorlesung
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
tmin = 0.0
tmax = 1.0
t = np.linspace(tmin, tmax, n)

# x und y-Koordinaten der Kurve berechnen
a = 4.0
b = 9.0
x, y = curves.ellipse(t, a, b)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Ellipse mit a=4, b=9'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()

fig.savefig('images/ellipse.png', dpi=300)