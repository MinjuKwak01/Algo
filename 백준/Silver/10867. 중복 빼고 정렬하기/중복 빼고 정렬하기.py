N = int(input())
lst = list(map(int, input().split(" ")))
setlst = set(lst)
lst = list(setlst)
lst.sort()

for e in lst:
    print(e, end=' ')