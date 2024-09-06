N:int = int(input())
lst:list = list(map(int, input().split()))
max_val = -1e9
min_val = 1000001

for i in range(N):
    if lst[i] > max_val:
        max_val = lst[i]
    if lst[i] < min_val:
        min_val = lst[i]

print(min_val, max_val)