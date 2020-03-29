# OceanCar
Simple program that makes your car brand suggestions, according to your OCEAN score

The five factor model (Big Five personality traits) is a well known psychological framework.
Evolutionary psychologist Geoffrey Miller has speculated the correspondence 
between Central Six traits (Big Five + Intelligence) and car brand preference, e.g. high openness -> Lotus, Mini, Subaru...
Of course, there is no quantitative evidence to support this.

This short piece of code takes this list of corresponences and in rather trivial way makes your car brand suggestions.
So, you can take the OCEAN test, like https://www.truity.com/test/big-five-personality-test, get a score 0-1 (in percents) for each factor,
and substitute it into program.

Just type run in sbt, and enter you scores in proper format. For example, your scores are:

Openness - 30%
Conscientiousness - 70%
Extraversion - 90%
Agreeableness - 10%
Neuroticism - 20%

This will correspond to
O0.3C0.7E0.9A0.1N0.2 string.

You will get:

Here are your best car suggestions (score from 0 to 1):
Acura : 1.0
BMW : 1.0
Porsche : 1.0
