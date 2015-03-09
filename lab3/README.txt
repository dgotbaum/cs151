Names: James Capuder and Jack Benson
We affirm that we have adhered to the honor code in this assignment



Any known problems or assumptions made in your classes or program:
The only problem that we have encountered is when dealing with an unsolvable maze. Encountering such a maze does not break our program, but it does not terminate it either.

The Big-O complexity of your solver algorithm and some explanation of how you computed it:
We believe that the Big-O complexity of our solver algorithm is n squared. We reached this conclusion because our solver algorithm contains only one loop, a for loop, the complexity of which is n squared.

One or two sentences explaining which version of the search algorithm is "better" and examples of why. You should point specifically to the examples provided, and form your hypotheses by watching how the maze solver proceeds through the maze, and the solution it finds. Is one solver faster at finding solutions than the other? Does one solver find better solutions than the other?:
We have found that the stack algorithm solves mazes substantially faster. For example, maze-5, which has no walls, is solved by a stack in a fraction of the time it takes to solve the same maze with a queue. The stack may find fewer solitons, but it generally finds just as direct a solution as the queue.

If you know it, give the "real name" of each of these solver algorithms.
On a graph that represents all the paths from start, the stack-based algorithm is a depth first search, the queue-based algorithm is a breadth first search

