# Lab 1: Binary Search

# Background: Binary Search
Consider a sorted array:
<table>
    <tr>
        <td>3</td>
        <td>6</td>
        <td>11</td>
        <td>12</td>
        <td>45</td>
        <td>67</td>
        <td>108</td>
    </tr>
</table>

Let's say you would like to find a value, e.g. 45 

In binary search, the value is narrowed down by dividing the search range by approximately half in every comparison.

You start by checking the middle element:

<table>
    <tr>
        <td>3</td>
        <td>6</td>
        <td>11</td>
        <td style="background-color: darkslategray">12</td>
        <td>45</td>
        <td>67</td>
        <td>108</td>
    </tr>
</table>

We perform the following checks:
```jupyterpython
12 = 45 -> false
12 > 45 -> false
12 < 45 -> true
```
We know the array is sorted and we know 45 is greater than 12. 
This means, the value we are looking for is in the right half of the array.

<table>
    <tr>
        <td>45</td>
        <td>67</td>
        <td>108</td>
    </tr>
</table>

We check the middle element of this array again, and perform the same checks:
<table>
    <tr>
        <td>45</td>
        <td style="background-color: darkslategray">67</td>
        <td>108</td>
    </tr>
</table>

```jupyterpython
67 = 45 -> false
67 > 45 -> true
```

Since the search value is lesser than this middle value, we know it has to be in the left half of this array.
So we check the left half:
<table>
    <tr>
        <td style="background-color: darkslategray">45</td>
    </tr>
</table>

```jupyterpython
45 = 45 -> true
```

Since this is true, we have found the element we were looking for in just 3 checks.

Complexity: <span style="font-family:'Times New Roman';"><i>O(log(n))</i></span>

## Part 1: Checking if a value exists in an array
This part involved implementing the functions 
<span style="font-family:'Courier New';">containsIterative</span> and <span style="font-family:'Courier New';">containsRecursive</span>:

```java
public static<V extends Comparable<? super V>> boolean containsIterative(V[] array, V value) {
        //the implementation goes here
    }
    
public static<V extends Comparable<? super V>> boolean containsRecursive(V[] array, V value) {
    //the implementation goes here
}
```
The functions return <span style="font-family:'Courier New'; color:#cf8e6d;">true</span> if the given 
<span style="font-family:'Courier New';">array</span>
contains <span style="font-family:'Courier New';">value</span>, and
<span style="font-family:'Courier New'; color:#cf8e6d;">false</span> if it doesn't. <br>

The <span style="font-family:'Courier New';">containsIterative</span> function implements binary search algorithm using loops.
The <span style="font-family:'Courier New';">containsRecursive</span> function implements binary search algorithm using recursion in a helper function.

## Part 2: Finding index of the value

This part involved implementing the function <span style="font-family:'Courier New';">firstIndexOf</span>:

```java
    public static<V extends Comparable<? super V>> int firstIndexOf(V[] array, V value) {
        //the implementation goes here
    }
```

The function returns the index of the <span style="font-family:'Courier New';">value</span> if the
<span style="font-family:'Courier New';">value</span> exists in the
<span style="font-family:'Courier New';">array</span>.
Otherwise, it returns -1.

If the <span style="font-family:'Courier New';">value</span> occurs multiple times in the <span style="font-family:'Courier New';">array</span>,
then the index of the first occurrence is returned.








