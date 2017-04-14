Given a 2D array, get Starting Indexes of all paths that form the String 'RAMTEKE'.  i will put my github username here  !!! <br>

Each path + 1 is available in three directions: Horizontal, Vertical, Diagonal <br>


<b>LOGIC</b><br>

With Recursion it is easy to hold MIN/MAX values as MIN and MAX will come to you at last index (if u start from 0) or 0th index (if you start from end)

For this you need to trigger recursion outside. i.e at every [i][j], whenever a starting condition is met

//Alternative to this problem would be to get max length of path with consecutive letters. 



