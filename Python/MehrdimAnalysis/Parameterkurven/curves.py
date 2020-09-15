"""
   Planare Parameterkurven.

   Die Return-Werte werden als Tupel erzeugt.

   Beispiel:
   x, y = cycloid(1.0, 90.0)
"""
import numpy as np


# Ebene Parameterkurven
def cycloid(radius, theta):
    """Zykloide """
    x = radius*(theta - np.sin(theta))
    y = radius*(1.0 - np.cos(theta))
    return x, y


def cycloidVelocity(radius, theta):
    """
    Zykloide erste Ableitung
    Wir werden mittelfristig die Kurven
    als Klassen implementieren, dann wird
    diese Funktion und die oben zu einer
    Funktion der Klasse.
    """
    x = radius*(1.0-np.cos(theta))
    y = radius*np.sin(theta)
    return x, y


def first_example(t):
    """Erstes Kurvenbeispiel aus der Vorlesung"""
    x = t*t-2.0*t
    y = t + 1.0
    return x, y


def aufgabe1a(t):
    """ Aufgabe 1a), Blatt Ebene Parameterkurven """
    t2 = t*t
    x = 3.0*(t2-3.0)
    y = t2*t-3.0*t
    return x, y


def aufgabe1b(t):
    """ Aufgabe 1b), Blatt Ebene Parameterkurven """
    t3 = t*t*t
    x = t3*t - 1.0
    y = t3 + 1.0
    return x, y


def unitCircle(t):
    """ Einheitskreis auf [0, 1]"""
    x = np.cos(2.0*np.pi*t)
    y = np.sin(2.0*np.pi*t)
    return x, y


def circle(t, radius=1.0):
    """ Einheitskreis auf [0, 1]"""
    x = radius*np.cos(2.0*np.pi*t)
    y = radius*np.sin(2.0*np.pi*t)
    return x, y


def ellipse(t, a=1.0, b=1.0):
    """ Einheitskreis auf [0, 1]"""
    x = a*np.cos(2.0*np.pi*t)
    y = b*np.sin(2.0*np.pi*t)
    return x, y


def semicubicParabola(t):
    """ Semikubische Parabel """
    x = t*t
    y = x*t
    return x, y


def logSpiral(a, k, theta):
    """ Logarithmische Spirale """
    r = a * np.exp(k*theta)
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return x, y


def archimedeanSpiral(k, theta):
    """ Archimedische Spirale """
    r = k * theta
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return x, y


# Berechnung von Bogenlänge und Bogenlängenfunktionen
def polylineLength(x, y):
    """
    Bogenlänge berechnen mit Hilfe eines übergebenen Polygonzugs.
    """
    sum = 0.0
    for i in range(0, x.size-1):
        sum += np.sqrt((x[i+1] - x[i])**2 + (y[i+1]-y[i])**2)
    return sum


def arcL(curve, a=0.0, b=1.0, n=100):
    """Bogenlänge mit übergebener Kurve
       und Anzahl der Punkte, die für die Näherung
       verwendet werden soll.
    """
    t = np.linspace(a, b, n)
    x, y = curve(t)
    return polylineLength(x, y)


def arcLengthFunction(curve, a=0.0, b=1.0, n=100):
    """
    Berechnung von Werten der Bogenlängenfunktion.

       curve: Funktion, die die untersuchte Parameterfunktion auswertet
       a, b: Parameterintervall, für das die Werte der Bogenlängenfunktion
             berechnet werden soll.
       n:    Anzahl der Wertepaare, die berechnet werden sollen.

       Rückgabewert der Funktion: Wertetabelle (t, S_a(t))
    """
    t = np.linspace(a, b, n)
    x, y = curve(t)
    sct = np.zeros(shape=n, dtype=float)
    sum = 0.0
    for i in range(0, n-1):
        sum += np.sqrt((x[i+1] - x[i])**2 + (y[i+1]-y[i])**2)
        sct[i+1] = sum

    return t, sct
