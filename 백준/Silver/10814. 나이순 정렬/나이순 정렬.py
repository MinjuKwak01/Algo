N = int(input())

lst = []

for _ in range(N):
    x, y = input().split()
    lst.append((int(x), y))

lst.sort(key = lambda x : x[0])

for lst in lst:
    print(lst[0], lst[1])