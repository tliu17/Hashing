# Hashing
Both program first ask the user to enter a table size. Then it repeatedly asks for a command (‘1’, ‘2’, ‘3’, or negative number) and a value until the user quits or illegal input is detected. When a user enters a illegal input, it throws InputMismatchException and quits.

Commands:

1 = insert

2 = look-up

3 = delete

negative number = quit

I tested the program by manually entering inputs, testing each command with various inputs (large int, small int, doubles, & non-int inputs).
ClosedHashing uses linear probing to shift, and quits when the table is filled.
