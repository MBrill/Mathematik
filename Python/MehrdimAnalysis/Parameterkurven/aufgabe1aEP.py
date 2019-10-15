"""Grafische Ausgabe

Aufgabe 1a und b aus dem Übungsblatt
Ebene Parameterkurven
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
t = np.linspace(-2.5, 2.5, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.aufgabe1a(t)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Aufgabe 1a'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
plt.plot(x, y, 'C1')

plt.show()

fig.savefig('images/aufgabe1a.png', dpi=300)