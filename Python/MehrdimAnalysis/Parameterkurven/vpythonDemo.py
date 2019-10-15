"""Grafische Ausgabe von 3D Objekten mit VPython

Verwendet das Package vpython.
Dieses Package wird in anaconda so installiert:
    
    conda install -c vpython vpython
    
Mehr zu diesem Paket findet man in Woyand, Python
für Ingenieure und Naturwissenschaftler, Hanser Verlag, 2019.

Die Ausgabe erfolgt mit WebGL in einem Browser.
"""
from vpython import *

scene.width = scene.height = 600
scene.background = color.white
scene.title = "Hello VPython"
scene.autocenter = True

# Grundkörper
b = box(pos=vector(-3,6,0), color=color.yellow)
s = sphere(pos=vector(0,6,0), color=color.yellow)
c = cylinder(pos=vector(3,6,0), color=color.yellow)
a = arrow(pos=vector(-3,3,0), color=color.yellow)
co = cone(pos=vector(0,3,0), color=color.yellow)
e = ellipsoid(pos=vector(3,3,0), color=color.yellow)
h = helix(pos=vector(-3,0,0), color=color.yellow)
r = ring(pos=vector(0,0,0), color=color.yellow)
p = pyramid(pos=vector(3,0,0), color=color.yellow)
t = text(text="Hallo", pos=vector(0,-3,0), color=color.yellow)

# Kurve als Polygonzug
# Diese Kurven können direkt mit einem Radius
# gezeichnet werden, um sie besser sichtbar zu machen
p = [vector(-3,-3,0), vector(-3,-2,0), vector(-2,-2,0),\
     vector(-2,-3,0), vector(-3,-3,0)]

kurve = curve(pos=p, radius = 0.1, color=color.green)


# Punkte
p = [vector(-3,-6,0), vector(-3,-5,0), vector(-2,-5,0), vector(-2,-6,0)]
punkte = points(pos=p, radius=5, color=color.red)

# Dreiecksnetz
a = vertex(pos=vector(0, -6, 0), color=color.red)
b = vertex(pos=vector(2, -5, 0), color=color.blue)
c = vertex(pos=vector(2, -6, 2), color=color.green)
topo = [a,b,c]
dreieck = triangle(vs=topo)
         