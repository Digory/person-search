This is my solution to the final exercise in week 9 of the University of Helsinki's (free) object-oriented programming course. See here for more details: https://materiaalit.github.io/2013-oo-programming/part2/week-9/

The program is a text-based application for managing phone numbers and addresses. It implements the following functionality:
- adding a phone number attached to a specific person
- searching for a phone number by person
- searching for a name by phone number
- adding an address attached to a specific person
- searching for a person's address and phone number
- removing a person's information
- filtered search by keyword, sorted alphabetically

This is what I think after reviewing my code:

I need to re-read how to implement the Comparable interface; I'm not sure if I've done it 100% right.

A Hashmap with Person objects as either a key or a value might have made sense.

I used multiple 'if' statements in the obtainInput() method when I should have used switch.
