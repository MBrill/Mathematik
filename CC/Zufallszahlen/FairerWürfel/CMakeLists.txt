cmake_minimum_required (VERSION 2.8)
project (Fair)

include(buildtype.txt)

# Ein fairer Würfel
add_executable (fair fair.cpp)
TARGET_LINK_LIBRARIES(fair mathpack)
