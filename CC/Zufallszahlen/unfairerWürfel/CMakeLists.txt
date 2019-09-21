cmake_minimum_required (VERSION 2.8)
project (Unfair)

include(buildtype.txt)

# Ein unfairer Würfel
add_executable (unfair unfair.cpp)
TARGET_LINK_LIBRARIES(unfair mathpack)
