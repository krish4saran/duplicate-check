# duplicate-check

Has component to check for duplicate strings
- If the string was passed before return true
- If the string is passed for the first time return false
- Null is not a valid input - throw Unsupported exception

Requirement:
- JDK 8 Only

Key Points:
 - ConcurrentHashMap.newKeySet was used to create a HashSet to save the input words.
 - Set makes sure no duplicate values are added. So all the entries are unique.
 - ConcurrentHashMap in the background provides thread safety and concurrent access in multi threaded environment. 
 - HashSet Add and Contains check are done in O(1) complexity which makes it the best data structure for this service.
