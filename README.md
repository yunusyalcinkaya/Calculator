# Calculator
Design calculator with Java
<br><br>
A simple calculator is designed in this project.
<br>For the graphical user interface, window builder was used.
<br>The input in the infix representation was first converted into the postfix representation and then calculated. Because postfix notation is a notation that the computer can use more easily.

### The code contains 4 methods

<br>- 1 main
	<br>- 1 constructor
<br>	- 1 for convert from infix notation to postfix notation(convertion())
<br>	- 1 for calculate the postfix notation(calculate())
<br>	- 1 for writes that button to the textField when every time the button is clicked(clickButton())

### CONVERTION INFIX TO POSTFIX

Incoming infix notation is exemined from left to right.
	<br>If the next element is:
<br>-<b>A number</b>, it’s added directly to the postfix notation.
<br>- <b>‘(‘</b>, it’s pushed directly to stack.
<br>-<b>A operator (+,-,*,/)</b> and if the priority is more than priority of the element at the top of the stack, it’s pushed the stack. If the priority is less or equal, it’s popped from stack to postfix expression until the priority of the element at the top of the stack is less than the priority of the incoming element. If there are ‘(‘ at the top of the stack, it’s pushed directly to stack.
<br>-<b> ‘)’</b>, pop operation is performed from the stack to the postfix notation until the ‘(‘ is the peak element. After that ‘(‘ is popped from the stack.
<br><br>![infix to postfix](https://github.com/yunusyalcinkaya/Calculator/blob/master/photos/infixtopostfix.png)
<br>
<br>
### CALCULATION OF THE POSTFIX NOTATION

1- When an operand is encountered, it is added to the stack,
<br>2- When an operator is encountered, 2 operands are popped from the stack,
<br>3- The operator is applied to the two operations that are then executed,
<br>4- The found result is added to the stack again.
<br><br>![calculate of postfix](https://github.com/yunusyalcinkaya/Calculator/blob/master/photos/calculatepostfix.png)
