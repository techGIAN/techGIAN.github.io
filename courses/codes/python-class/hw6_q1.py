vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}


def last_syllable(word):
    for i in range(len(word)-1, -1, -1):
        if word[i] in vowels:
            return word[i:len(word)].lower();
    return word.lower()


n = int(input())
for i in range(n):
    poem = [last_syllable(input().split()[-1]) for j in range(4)]
    if poem[0] == poem[1] == poem[2] == poem[3]:
        print("perfect")
    elif poem[0] == poem[1] and poem[2] == poem[3]:
        print("even")
    elif poem[0] == poem[2] and poem[1] == poem[3]:
        print("cross")
    elif poem[0] == poem[3] and poem[1] == poem[2]:
        print("shell")
    else:
        print("free")

