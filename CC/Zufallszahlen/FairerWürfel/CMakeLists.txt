cmake_minimum_required (VERSION 2.8)
project (Fair)

include(buildtype.txt)

# Ein fairer W�rfel
add_executable (fair fair.cpp)
TARGET_LINK_LIBRARIES(fair mathpack)
