def hanoi(n, from_rod, to_rod, spare_rod):
    """
    Recursive program to solve Tower of Hanoi
    :param n: number of disks
    :param from_rod: from rod
    :param to_rod: to rod
    :param spare_rod: spare rod
    """
    if n == 1:
        print("Move disk 1 from rod", from_rod, "to rod", to_rod)
    else:
        hanoi(n-1, from_rod, spare_rod, to_rod)
        print("Move disk", n, "from rod", from_rod, "to rod", to_rod)
        hanoi(n-1, spare_rod, to_rod, from_rod)


hanoi(5, "Left", "Right", "Middle")