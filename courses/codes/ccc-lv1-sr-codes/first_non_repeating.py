from queue import Queue

def firstNonRepeating(s: str) -> None:
    # Initialize queue and frequency map
    queue = Queue()
    frequency_map = {}
    
    for c in s:
        if c not in frequency_map:  # Character not in frequency map
            frequency_map[c] = 0
        frequency_map[c] += 1
        
        if frequency_map[c] == 1:  # c is unique so far
            queue.put(c)
        
        # Remove repeating characters from the front of the queue
        while not queue.empty() and frequency_map[queue.queue[0]] > 1:
            queue.get()
        
        # Print the first non-repeating character or 0 if none
        if queue.empty():
            print('0', end="")
        else:
            print(queue.queue[0], end="")

# Example usage
s = "aabc"
firstNonRepeating(s)  # Output: a00b