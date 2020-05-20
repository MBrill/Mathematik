# -*- coding: utf-8 -*-
"""
Umrechnung Quaterionen in Rotationsmatrix
mit SciPy

@author: brill
"""
import numpy as np
from scipy.spatial.transform import Rotation as R

r = R.from_quat([0,0,np.sin(np.pi/2), np.cos(np.pi/2)])

print(r.as_euler('zyx', degrees=True))


print(r.as_quat())



