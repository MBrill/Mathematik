# -*- coding: utf-8 -*-
"""
Lösung von linearen Gleichungssyxstemen
mit NumPy und SymPy

Wir verwenden np.linalg.solve
mit der Koeffizientenmatrix und
der rechten Seite und alternativ dazu
die Funktion linsolve aus SymPy.
"""
import numpy as np
import sympy as sp

# NumPy, wie Woyand
A = np.array([[1,2],[3,4]])
b = np.array([[5],[11]])

x = np.linalg.solve(A,b)
print("Die Lösung mit Hilfe von NumPy und linalg.solve")
print(x)

print("Probe:", np.dot(A,x))

# Noch ein Beispiel
A = np.array([[-1.0, 1.0, 1.0], [1.0, -3.0, -2.0], [5.0, 1.0, 4.0]])
b = np.array([[0.0], [5.0], [3.0]])

print(A)
print(b)
x = np.linalg.solve(A, b)
print(x)
print(np.dot(A,x))


# Mit SymPy
x, y = sp.symbols('x y')

sol = sp.linsolve([x + 2*y - 5, 3*x + 4*y - 11], (x, y))
print("Die Lösung mit Hilfe von SymPy und linsolve")
print(sol)