# -*- coding: utf-8 -*-
"""
Grafische Darstellung von Funktionsgraphen.
"""
import numpy as np
import matplotlib.pyplot as plt


def simple_plotter(f, a, b, n, title, showgrid=False):
    """
    Simple plotter for functions y = f(x)

    Parameters
    ----------
    f : function
        the function to be plotted.
    a : float
        left point of x-interval.
    b : float
        right point of x-interval.
    n : int
        how many points do we use for the polyline.
    title : string
        title string of our vis.
    showgrid : boolean
        Show a grid in the plot? Default is False

    Returns
    -------
    None.
    """
    xValues = np.linspace(a, b, n)
    yValues = f(xValues)
    plt.grid(showgrid)
    plt.plot(xValues, yValues, 'g-')
    plt.title(title)
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.show()


def xy_plotter(f, a, b, n, title, showgrid=False):
    """
    Plotter for functions y = f(x).

    We use x- and y-axis centered at the origin and no box
    like the default plots in matplotlib.

    Parameters
    ----------
    f : function
        the function to be plotted.
    a : float
        left point of x-interval.
    b : float
        right point of x-interval.
    n : int
        how many points do we use for the polyline.
    title : string
        title string of our vis.
    showgrid : boolean
        Show a grid in the plot? Default is False

    Returns
    -------
    None.
    """
    xValues = np.linspace(a, b, n)
    yValues = f(xValues)

    fig = plt.figure()
    ax = fig.add_subplot(1, 1, 1)

    # Source of the solution:
    # https://stackoverflow.com/questions/31556446/how-to-draw-axis-in-the-middle-of-the-figure
    ax.spines['left'].set_position('center')
    ax.spines['bottom'].set_position('center')
    ax.spines['right'].set_color('none')
    ax.spines['top'].set_color('none')
    ax.xaxis.set_ticks_position('bottom')
    ax.yaxis.set_ticks_position('left')

    plt.plot(xValues, yValues, 'g-')
    ax.grid(showgrid)
    plt.title(title)
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.show()


def main():
    """
    Code to demonstrate the functions in this module.

    Returns
    -------
    None.

    """
    print('Demonstrate the plotting of functions\n')
    a = -2.0*np.pi
    b = 2.0*np.pi
    n = 100
    title = 'sin(x)'
    simple_plotter(np.sin, a, b, n, title, True)

    xy_plotter(np.sin, a, b, n, title, True)


if __name__ == "__main__":
    main()
