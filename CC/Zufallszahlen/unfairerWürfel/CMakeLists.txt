cmake_minimum_required (VERSION 2.8)
project (Unfair)

include(buildtype.txt)

# Ein unfairer W�rfel
add_executable (unfair unfair.cpp)
TARGET_LINK_LIBRARIES(unfair mathpack)
