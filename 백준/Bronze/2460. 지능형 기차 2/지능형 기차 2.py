maximum:int = 0
total:int = 0

for i in range(10):
    N,M = map(int, input().split())
    total += M
    total -=N
    if maximum < total:
        maximum = total

print(maximum)