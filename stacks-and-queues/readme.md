
Not Thread Safe
Not Serializable


Bags Queues and Stacks

Stack
LIFO -> last in first out
Add -> Push
Remove -> Pop

--- Stack Considerations
- Overflow and Underflow
  * Underflow: throw exception if pop from an empty stack
  * Overflow: use resizing array for array implementation
- Null Items: we allow null items to be inserted
- Loitering: holding a reference to an object when it is no longer needed

--- Resizing Stack Considerations
* when list is full resize the list to twice its size
* when only 1/4th of the list is occupied, resize the list to half its size

Queue
FIFO -> first in first out
Add -> enqueue
Remove -> dequeue

--- Queue Special Case
* when element is added to empty queue, the first and last element should be set as same
* when all elements are consumed, the first and last element should be set to null

--- Generics Considerations
* we cannot initialize an array of custom objects in java directly
* we will have to create an Object[] and cast it
  * `Item[] s = (Item[]) new Object[capacity];`

--- Iterator Considerations
* remove -> optional: use at your own risk -> can cause debugging problems
* Iterable makes foreach loop possible

```
Iterator<String> i = stack.iterator();
while (i.hasNext()) {
    String s = i.next();
    System.out.println(s)
} 
```
```
for (String s: stack) {
    System.out.println(s)
}
```
* if next is called on empty Collection without checking for hasNext throw exception

--- Bag Consideration
* take STack and remove po
* take Queue and remove dequeue

Sample Assignment:
Generate random open sites in an N-by-N percolation system
As N-by-N becomes huge, algorithm should perform -> Array vs LinkedList

Dijkstra's Two-Stack Algorithm