def isValid(s: str) -> bool:
    # Map of closing symbols to their corresponding opening symbols
    matchingSymbols = {')': '(', '}': '{', ']': '['}
    
    # Stack to hold opening symbols
    stack = []
    
    for c in s:
        if c in matchingSymbols.values():  # c is an opening symbol
            stack.append(c)
        else:  # c is a closing symbol
            if not stack:  # Stack is empty, unpaired closing symbol
                return False
            else:
                x = stack.pop()
                if matchingSymbols[c] != x:  # Wrongly paired
                    return False
    
    return not stack  # Stack should be empty for a valid string

# Example usage
s = "({[]})"
print(isValid(s))  # Output: True