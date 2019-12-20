# -*- coding: utf-8 -*-
"""
Beispiel für ein Bild

Wir verwenden die Hermite-Polynome
für den Übergang zwischen schwarz und weiss
in unserem Beispiel zur Kantendetektion
"""
import hermitePolynome as hp
import matplotlib.pyplot as plt
import numpy as np

def f(t) :
    if t<=2.95:
        return 0.0
    elif t >= 6.05:
        return 0.0
    elif 3.05 <= t <= 5.95:
        return 1.0
    elif 2.95 < t < 3.05:
        return hp.h33(t)
    elif 5.95 < t < 6.05:
        return hp.h03(t)
    else:
        print("Falscher t-Wert")

def fs(t) :
    if t <= 2.95:
        return 0.0
    elif t >= 6.05:
        return 0.0
    elif 3.05 <= t <= 5.95:
        return 0.0
    elif 2.95 < t < 3.05:
        return hp.h33s(t)
    elif 5.95 < t < 6.05:
        return hp.h03s(t)
    else:
        print("Falscher t-Wert")
        
        
def fss(t) :
    if t <= 2.95:
        return 0.0
    elif t >= 6.05:
        return 0.0
    elif 3.05 <= t <= 5.95:
        return 0.0
    elif 2.95 < t < 3.05:
        return hp.h33ss(t)
    elif 5.95 < t < 6.05:
        return hp.h03ss(t)
    else:
        print("Falscher t-Wert")

       
# Funktionen vektorisieren!
vf = np.frompyfunc(f, 1, 1)
vfs = np.frompyfunc(fs, 1, 1)
vfss = np.frompyfunc(fss, 1, 1)

delta = 0.1
t = np.arange(0.0, 9.0, delta)
yf = vf(t)       
yfs = vfs(t)
# für die zweite Ableitung benötigen wir mehr Punkte
delta2 = 0.01
t2 = np.arange(0.0, 9.0, delta2)
yfss = vfss(t2)

fig = plt.figure()

style = 'seaborn'
plt.style.use(style)

bild1 = fig.add_subplot(111)
bild1.plot(t, yf, color= 'C1', linewidth=2)
bild1.set_xlabel("Bild y-Achse")
bild1.set_ylabel("Grauwerte")
bild1.set_title("Das skalare Feld für unser Bild")
bild1.grid(True)

fig.savefig('images/bwvalues.png', dpi=300)

fig2 = plt.figure()
bild2 = fig2.add_subplot(1,1,1)

bild2.plot(t, yfs, color= 'C1', linewidth=2)
bild2.set_xlabel("Bild y-Achse")
bild2.set_ylabel("Grauwerte: 1. Ableitung")
bild2.set_title("Die erste Ableitung des skalaren Felds für unser Bild")
bild2.grid(True)

fig2.savefig('images/bwvalues+strich.png', dpi=300)

fig3 = plt.figure()
bild3 = fig3.add_subplot(1,1,1)

bild3.plot(t2, yfss, color= 'C1', linewidth=2)
bild3.set_xlabel("Bild y-Achse")
bild3.set_ylabel("Grauwerte: 2. Ableitung")
bild3.set_title("Die zweite Ableitung des skalaren Felds für unser Bild")
bild3.grid(True)

plt.show()

fig3.savefig('images/bwvalues+strichstrich.png', dpi=300)