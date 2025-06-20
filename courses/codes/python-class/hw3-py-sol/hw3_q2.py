kg1 = int(input("Enter a first weight (kg): "))
g1 = int(input("Enter a first weight (g): "))
kg2 = int(input("Enter a second weight (kg): "))
g2 = int(input("Enter a second weight (g): "))

kg_total = kg1 + kg2
g_total = g1 + g2

if g_total >= 1000:
    kg_total = kg_total + g_total // 1000
    g_total = g_total % 1000

print("The sum is %dkg, %dg" % (kg_total, g_total))