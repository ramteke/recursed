Given a 2D array with characters from A to Z, 0 to 9.<br><br>

Get max. consecutive sequence path (between A to Z) in given matix.<br><br>
Paths are either horizontal or vertical.<br><br>

<b>LOGIC:</b><br><br>

This recursion requires seeds at every index [i][j]
<pre>
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[0].length; j++) {
        maxLength = Math.max(maxLength, recursed(arr, i, j, 0, '-'));
    }
}
</pre>

We need max. length of consecutive path.<br><br>

The Max length could be some path we are recursing through OR A Path which can start from current index.<br><br>

So we recurse running path and also start a new fresh recursion at current index.<br><br>

Which ever give max. is returned.<br><br>
