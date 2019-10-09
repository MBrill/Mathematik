"""Grafische Ausgabe

Aufgabe 1a  aus dem Übungsblatt
Ebene Parameterkurven

Grafische Ausgabe der Funktionen f und g
"""
import matplotlib.pyplot as plt
import numpy as np
import curves

fig = plt.figure()
ax = fig.add_subplot(111)
 
# Parameterintervall digitalisieren
# Wie viele Samples?
n = 200
t = np.linspace(-2.0, 2.0, n)

# x und y-Koordinaten der Kurve berechnen
x, y = curves.aufgabe1b(t)

style = 'seaborn'
plt.style.use(style)
ax.set_title('Aufgabe 1b'.format(style), color='C0')

ax.set_xlabel('x')
ax.set_ylabel('y')
ax.plot(t, x, 'C1', label='f(t)')
ax.plot(t, y, 'C2', label='g(t)')
ax.legend()


plt.show()

fig.savefig('images/aufgabe1bComp.png', dpi=300)