# --------------------------------------------------------------------------
cmake_minimum_required (VERSION 2.8)
project (SolidAngle)

# Option einfuegen, ob glut64 oder glut32 installiert ist
option(USE_GLUT64 "glut64 installed" ON)    

if(NOT APPLE)
	set(VLG_LIB_DIR "C:/local/lib" CACHE PATH "vlg and vlgGluT Lib Path")
	set(VLG_HEADER_DIR "C:/local/include" CACHE PATH "vlg and vlgGluT HEader Path")
else()
	set(VLG_LIB_DIR "/Developer/usr/local/lib" CACHE PATH "vlg and vlgGluT Lib Path")
	set(VLG_HEADER_DIR "/Developer/usr/local/include" CACHE PATH "vlg and vlgGlut Header Path")
endif()

# Pfad zu den Bibliotheken
link_directories(${VLG_LIB_DIR})
# Pfad zu den Headerfiles
include_directories(${VLG_HEADER_DIR})

# Variable setzen f�r die verschiedenen Namen der OpenGL-Libs
if(WIN32)
   set(GLUT_LIB "glut32")
   set(GLU_LIB "glu32")
   set(GL_LIB "opengl32")
endif()

if(USE_GLUT64 AND WIN32)
   set(GLUT_LIB "glut64")
endif()

if(APPLE)
	find_library(GLUT_LIB GLUT)
    	set(GLU_LIB "")
    	find_library(GL_LIB OpenGL )
elseif(UNIX)
        set(GLUT_LIB "glut")
        set(GLU_LIB "GLU")
        set(GL_LIB "GL")
endif()

if(APPLE)
	add_definitions(-DMACOS)
endif(APPLE)

# Pr�prozessor Anweisungen f�r Visual Studio
if(MSVC)
    add_definitions(-D_CRT_SECURE_NO_WARNINGS)
    add_definitions(-D_USE_MATH_DEFINES)
    add_definitions(-DGLUT_BUILDING_LIB)
endif()

# XCode arbeitet nicht mit relativen Pfaden
if(NOT APPLE) 
    set(CMAKE_USE_RELATIVE_PATHS TRUE)
endif(NOT APPLE)

SET(CMAKE_BUILD_TYPE Release CACHE STRING
      "Build-Type festlegen: None Debug Release RelWithDebInfo MinSizeRel."
      FORCE)
# Ausf�hrbares Programm
add_executable (main main.cpp Shape.cpp Shape.h vlgSphere.h vlgSphere.cpp)

TARGET_LINK_LIBRARIES(main vlgGlut vlg ${GLUT_LIB} ${GLU_LIB} ${GL_LIB})
