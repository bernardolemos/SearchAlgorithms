# Search Algorithms in JAVA
## Implementation of several search algorithms applied to _The 8 game_
## Algorithms:
* A* (A star) search
* Greedy Search
* Depth First Search (DFS)
* Iterative Depth First Search (IDFS)
* Breadth First Search (BFS)

## The 8 game
### _The 8 game_ is a table game that given an initial and table states, the goal is to manipulate the inital table so that the final configuration is reached.
### A table consists of 9 cells, a _3x3_ matrix. Each cell is, except one, contains a number. One must move the cells around in such a way that the target table is reached. This is achieved by moving the empty cell up, down, right or left, one step at a time.
### **Example**:

 
_Initial table_
|1|2|3 |
|--|--|--|
|8|0|4
|7|6|5|
_Target table_ ad input: 6 2 7 5 0 3 8 1 4
|6|2|7|
|--|--|--|
|5|0|3|
|8|1|4|

Here, one must move the _empty ceel_ around, `0`, starting from the _initial table configuration_ to the _target table configuration_.

## Usage

Compile `.java` files
Run _AppliedSearch_
### Input
_AppliedSearch_ expects three lines of input, using the examples above:
1. Expects the **_initial configuration_** `1 2 3 8 0 4 7 6 5`
2. Expects the **_target configuration_** `6 2 7 5 0 3 8 1 4`
3. Expects a **_search algorithm_**: `1`, `2`, `3`, `4` or `5`
* `DFS`: `1`
* `BFS`: `2`
* `IDFS`: `3`
* `Greedy`: `4`
* `A*`: `5`
### Ouput
The system returns the `depth` and `path`/`plays` of the solution. The `path`reflects the empty cell's movements.
* `Up`: `U`
* `Down`: `D`
* `Left`: `L`
* `Right`: `R`
Try _Config1.txt_. Applies A* search to examples.
```
java AppliedSearch < Configuration2.txt
```