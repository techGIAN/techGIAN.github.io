forty_evens = {i for i in range(41) if  i % 2 == 0}
forty_odds = {i for i in range(41) if  i % 2 == 1}
forty = forty_evens.union(forty_odds)
print(forty)
