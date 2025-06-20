prob_table = {
    'A': 0.082, 'B': 0.015, 'C': 0.028, 'D': 0.043, 'E': 0.127, 'F': 0.022,
    'G': 0.020, 'H': 0.061, 'I': 0.070, 'J': 0.002, 'K': 0.008, 'L': 0.040,
    'M': 0.024, 'N': 0.067, 'O': 0.075, 'P': 0.019, 'Q': 0.001, 'R': 0.060,
    'S': 0.063, 'T': 0.091, 'U': 0.028, 'V': 0.010, 'W': 0.023, 'X': 0.001,
    'Y': 0.020, 'Z': 0.001
}


def calc_probability(ct, s):
    """
    Return probability of cipher text shifted by s characters
    :param ct: the ciphertext
    :param s: the shift amount
    :return: the probability
    """
    r = 1
    for i in range(len(ct)):
        if ct[i] != ' ':
            r *= prob_table[shift_char(ct[i], s)]
    return r


def shift_char(c, s):
    """
    Shifts character c by s positions.  Wraps around to 'A' after 'Z'
    :param c: the character
    :param s: the shift amount
    :return: the shifted character
    """
    chr_ord = ord(c) + s
    if chr_ord > ord('Z'):
        chr_ord -= 26
    return chr(chr_ord)


def print_cipher_text(ct, k):
    for i in range(len(ct)):
        print(' ' if ct[i] == ' ' else shift_char(ct[i], k), end='')
    print()


num_cases = int(input())
for n in range(num_cases):
    ciphertext = input()
    max_p = 0
    for k in range(26):
        p = calc_probability(ciphertext, k)
        if max_p < p:
            max_p = p
            max_k = k
    print_cipher_text(ciphertext, max_k)




