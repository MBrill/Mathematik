# -*- coding: utf-8 -*-
"""
Beispiel für die Erstellung einer Wertetabelle
für Parameterkurven
"""
import numpy as np
n=7
t=np.linspace(-2.0, 4.0, n)
x = t*t - 2.0*t
y = t+1.0
values = np.transpose((x,y))
head = "Wertetabelle\n"
head += "x,   y"
np.savetxt('myData.txt', values, fmt='%5.1f %5.1f', header=head)

