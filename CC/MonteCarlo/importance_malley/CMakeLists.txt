# --------------------------------------------------------
# 2D Monte-Carlo mit diskretem Importance Sampling
# für die Berechnung der hemispherical directional reflectance
# von BRDF-Funktionen
# --------------------------------------------------------
# $File$
# $Date$
# $Revision$
# --------------------------------------------------------
cmake_minimum_required (VERSION 2.8)
project (MonteCarloBRDF)

include (CMakeOptions.txt)

add_executable (importanceBRDF importanceBRDF.cpp)
TARGET_LINK_LIBRARIES(importanceBRDF openbrdf mathpack)

add_executable (malley malleyTesting.cpp)
TARGET_LINK_LIBRARIES(malley mathpack)
