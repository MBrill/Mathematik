import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
tmin = -4.0
tmax = 6.0
t = np.linspace(tmin, tmax, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.first_example(t)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Unsere erste Parameterkurve mit matplotlib'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()