IGNORED = "Ignored"
forward_stack = []
backward_stack = []
current_page = "http://www.acm.org"


def do_back():
    global current_page
    if len(backward_stack) > 0:
        forward_stack.append(current_page)
        current_page = backward_stack.pop()
        print(current_page)
    else:
        print(IGNORED)


def do_forward():
    global current_page
    if len(forward_stack) > 0:
        backward_stack.append(current_page)
        current_page = forward_stack.pop()
        print(current_page)
    else:
        print(IGNORED)


def do_visit(url):
    global current_page
    backward_stack.append(current_page)
    current_page = url
    print(current_page)
    forward_stack.clear()


while True:
    cmd = input()
    if cmd == "BACK":
        do_back()
    elif cmd == "FORWARD":
        do_forward()
    elif cmd[:5] == "VISIT":
        do_visit(cmd[6:])
    elif cmd == "QUIT":
        break
    else:
        print("Invalid command")
