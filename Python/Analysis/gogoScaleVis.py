"""
Grafische Darstellung der Skalierungsfunktion
für die Go-Go-Technik in Virtual Reality
"""
import numpy as np
import matplotlib.pyplot as plt

def gogo(r) :
    return r + alphaScale*(r - D)*(r - D)
    

fig = plt.figure()
ax = fig.add_subplot(111)

# Parameter
D = 0.6
rMax = 1.2
alphaScale = 0.8/0.09
fMax = gogo(rMax)

print("Der Parameter alpha ist", alphaScale)
print("Der maximale Funktionswert ist", fMax)

r1 = np.linspace(0.0, D, 3)
r2 = np.linspace(D, rMax, 100)
f2 = gogo(r2)
r3 = np.array([rMax, 1.2*rMax])
f3 = np.array([fMax, fMax])
#
linewidth = 0.8
dpi = 100
quality = 100

ax.plot(r1, r1, linewidth=linewidth, color = 'g')
ax.plot(r2, f2, linewidth=linewidth, color = 'g')
ax.plot(r3, f3, linewidth=linewidth, color = 'g')
     
ax.set_xlabel('r')
ax.set_ylabel('f')
ax.set_title('Go Go Skalierungsfunktion')

plt.show()
