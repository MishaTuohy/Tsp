# Tsp

-- The Travelling Salesperson Problem --

The travelling salesperson optimisation problem is a NP-Hard problem
which means it is at least as hard to solve as the hardest NP problems.

My solution will attempt to find the most efficient/fastest route for a
pizza delivery driver(Travelling Salesperson). Using the Simulated Annealing Algorithm to do so.

The Simulating Annealing Algorithm imitates a heat treatment process used to
increase the ductility and reduce the hardness of a material.
This process is basically heating it up to a very high temperature and slowly cooling down the material.

How this algorithm makes use of this process is that we have a temperature variable
and we have a coolingFactor variable. The temperature represents the starting temperature
and the coolingFactor represents the rate at which we cool down or reduce the temperature variable.

Why is this useful? The higher the temperature the more likely the algorithm is to take a slower route.
As the temperature lowers, so does the likelihood of the algorithm to take in slower routes, allowing for us
to hone in on the fastest solution.

We do this so we don't get trapped in a local optimum. We are looking for the global optimum for our solution.
If we only choose the fasted answers straight away we would very quickly limit our search area for the fastest route.
Using the Simulated Annealing Algorithm, we can much better mitigate this issue.

How is this done in practice?
We create two copies of the original data set and do the following.
Choose two random indexes from both copies and swap them.
We then compare the resulting sets and choose which is the faster route.
Given the previous explanation, we use a probablity density function that uses the current temperature
to choose whether or not we take in the fast or slow route.

We repeat this process until the temperature reaches below 1. We then hopefully have the fastest route at the end.
