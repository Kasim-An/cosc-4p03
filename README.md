# cosc-4p03
Algorithm, code is for backtracking algorithm and none-linear string

# Description
None-linear string can be define with length, like length in 6 will be random 110101 and this requirement is to set different with 4, which means keep two place in same, and move all place to fit, until find next fitable none-linear string, for example 101011 can be difference 4 with 110101, and the goal is to find as many as possible fitable string. The more consider strings, the deeper it needs to calculate.

# Sample output
<div><img src="https://github.com/Kasim-An/cosc-4p03/blob/master/sample output/403a2-1.jpg"></div>
<div><img src="https://github.com/Kasim-An/cosc-4p03/blob/master/sample output/403a2-2.jpg"></div>
<div><img src="https://github.com/Kasim-An/cosc-4p03/blob/master/sample output/403a2-3.jpg"></div>
<div><img src="https://github.com/Kasim-An/cosc-4p03/blob/master/sample output/403a2-4.jpg"></div>

# Details
Modifying first string for customized length and finding 1st fitable string adding to library, then to find 2nd fitable string, if the 2nd string is fitable to all string, then find next one. So library will contain all fitable string, and select from library to real container, until the loop ends.
