# euler-jason-solutions

I chose problems 35 and 104, because they are unique twists on mathematical concepts that I find interesting. I figured solving a familiar problem from a new angle would be fun.

I chose problem 112, because it seemed interesting as a mathematical concept I hadn't heard of before.

I opted to use a Maven-built Java project to solve all 3 problems. The solution to each problem is contained within its own class (named after the problem) in the root package of the project. Simply running the main method in each of these classes will solve the problem and output the solution along with the calculation time.

## [Problem 35: Circular Primes](https://projecteuler.net/problem=35)

### Sample Output
The number of circular primes below one million: 55  
Calculation time: 172ms

### Process
I started by creating a method that could determine the primality of a number. The most basic implementations of this algorithm are fairly simple, and I was able come up with a coarse solution. Upon doing some research, however, I found there to be a large number of ways to write the algorithm, ranging from brute force easy to very complex. Ultimately, I used [this](https://stackoverflow.com/questions/1801391/what-is-the-best-algorithm-for-checking-if-a-number-is-prime) resource as a template for the algorithm (with a few adjustments and a small fix). I also wrote a very simple method to rotate an integer, as this would also be necessary to solve the problem.

Finally, I wrote the core logic for the problem by looping through every integer between 2 and 1,000,000 and checking each for circular primality.

I spent roughly 1.5 hours on this problem, including solving, coding, documenting, and unit testing.

## [Problem 104: Pandigital Fibonacci Ends](https://projecteuler.net/problem=104)

### Sample Output
First fibonacci number pandigital on both ends: 329468  
Calculation time: 7860ms

### Process
This was the most difficult problem of the 3 for me. I was able to come up with a basic solution on my own; however, the running time of my algorithm was unreasonably long. Upon doing some research, I was able to identify and fix two of my significant bottlenecks. 

Initially, I was converting each fibonacci number to a string in order to retrieve the first and last 9 digits to check if they were pandigital. However, string manipulation is fairly expensive in Java (especially at higher lengths and compared to other languages), so getting the digits withouit converting the number was an obvious optimization. Retrieving the last 9 digits from a number is fairly simple by using the mod (%) operator. Retrieving the first 9 digits is a little more complex, as it relies upon knowing the length of the number. [This](https://stackoverflow.com/questions/18828377/biginteger-count-the-number-of-decimal-digits-in-a-scalable-method) resource provided me with a simple mathematical equation for checking the number of decimal digits in a number. After that, it was just a matter of using powers of 10 to divide out the appropriate number of digits.

This led me to my second bottleneck. Using [this](https://stackoverflow.com/questions/15216777/splitting-bigintegers-digits) resource, I was able to identify that creating the powers of 10 that I needed was an expensive operation to do on-the-fly. The suggestion was to create all of the necessary powers of 10 beforehand, store them in an array, and retrieve them when needed.

Finally, I wrote the core logic of the problem by continually building fibonacci numbers and checking both ends until they were both pandigital.

I spent roughly 2.5 hours on this problem, including solving, coding, documenting, and unit testing.

## [Problem 112: Bouncy Numbers](https://projecteuler.net/problem=112)

### Sample Output
The least number for which the proportion of bouncy numbers is exactly 99%: 1587000  
Calculation time: 19ms

### Process
The majority of the logic in this problem was writing an algorithm to check whether or not a number was bouncy. Based on my experience with problem 104, I opted to avoid integer to string conversion right out of the gate. Thankfully, since I only needed to compare each digit one-at-a-time, it was simple enough to to divide and mod by 10 to retrieve them. Using this method, I was able to come up with a few solutions that were all fairly fast, but not as clean as I wanted. None of the implementations posed a problem with the calculation time. However, I still decided to use [this](http://www.mathblog.dk/project-euler-112-density-bouncy-numbers/) solution to clean up the method a bit.

Lastly, I wrote the core logic by looping over every integer starting from zero, keeping track of each bouncy number I encountered, and checking to see if a 99% proportion had been reached.

I spent roughly 2 hours on this problem, including solving, coding, documenting, and unit testing.
