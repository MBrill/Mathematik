/// ---------------------------------------------------------
// Ein fairer Würfel mit der neuen Boost-Version
// ---------------------------------------------------------
#include <ctime>
#include <boost/random/mersenne_twister.hpp>
#include <boost/random/uniform_int_distribution.hpp>
#include <boost/random/uniform_01.hpp>
#include <boost/random/uniform_real_distribution.hpp>
#include <boost/random/discrete_distribution.hpp>

boost::mt19937 generator(static_cast<boost::uint32_t>(std::time(0)));

#include <iostream>

double probabilities[6] = {0.6, 0.05, 0.1, 0.1, 0.1, 0.05};
boost::random::discrete_distribution<> unfair(probabilities);

int roll_fair_dice(void) 
{
    boost::random::uniform_int_distribution<> dist(1, 6);
    return dist(generator);
}

int roll_unfair_dice(void)
{
    return unfair(generator) + 1;
}

// 
int main(void)
{
	int i;
	// Würfeln und ausgeben
	for (i=0; i<10; i++)
	{
		std::cout << "Die " << i << "-te Zufallszahl des fairen Wuerfels " << roll_fair_dice() << std::endl;
	}
	std::cout << std::endl;
	for (i=0; i<10; i++)
	{
		std::cout << "Die " << i << "-te Zufallszahl des unfairen Wuerfels " << roll_unfair_dice() << std::endl;
	}
    return 0;
}
