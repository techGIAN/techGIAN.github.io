phone_book = dict()

line = input()
cmds = line.split()

while (cmds[0] != 'quit'):
    if cmds[0] == 'add':
        phone_num = cmds[1]
        name = ' '.join(cmds[2:]).lower()
        action = 'added'
        if name in phone_book:
            action = 'updated'
        display = 'Phone number ' + action + ' for ' + ' '.join(cmds[2:])
        phone_book[name] = phone_num
    elif cmds[0] == 'lookup':
        name = ' '.join(cmds[1:]).lower()
        display = 'Phone number not found.' if name not in phone_book else phone_book[name]
    elif cmds[0] == 'remove':
        name = ' '.join(cmds[1:]).lower()
        display = 'Phone number not found.' if name not in phone_book else 'Phone number removed.'
        phone_book.pop(name, None)
    else:
        break
    print(display)
    line = input()
    cmds = line.split()

print('Thank you for using the Python Phone Book Application.')
