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
