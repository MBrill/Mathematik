# -*- coding: utf-8 -*-
"""
Hermite-Polynome und ihre Ableitungen

Wir verwenden die Hermite-Polynome
für den Übergang zwischen schwarz und weiss
in unserem Beispiel zur Kantendetektion
"""
#import numpy as np

def h33(t) :
    a = 2.95
    tilde = t - a
    return 300.0*tilde*tilde - 2000.0*tilde*tilde*tilde

def h33s(t) :
    a = 2.95
    tilde = t - a
    return 600.0*tilde - 6000.0*tilde*tilde

def h33ss(t) :
    a = 2.95
    tilde = t - a
    return 600.0 - 12000.0*tilde

def h03(t) :
    a = 5.95
    tilde = t - a
    return 1.0 - 300.0*tilde*tilde + 2000.0*tilde*tilde*tilde
    
def h03s(t) :
    a = 5.95
    tilde = t - a
    return -600.0*tilde + 6000.0*tilde*tilde

def h03ss(t) :
    a = 5.95
    tilde = t - a
    return -600.0 + 12000.0*tilde



