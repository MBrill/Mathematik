// -------------------------------------------------------------------
// $File$
// $Revision$
// $Date$
// --------------------------------------------------------------------
#include "EulerEngine.h"

int main(int argv, char **argc)
{
    vlgGlutEngine *app = EulerEngine::Instance();
    app->initApplication(argv, argc, 500, 500, 20, 20);
    app->run();
    return 0;
}
