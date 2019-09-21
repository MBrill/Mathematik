/* -------------------------------------------------------------------
 * Visualisierung eines Raumwinkels der Größe 1 steradian
 * -------------------------------------------------------------------*/
#include "Shape.h"

int main(int argv, char **argc)
{
    vlgGlutEngine *app = Shape::Instance();
    app->initApplication(argv, argc, 500, 500, 20, 20);
    app->run();
    return 0;
}
