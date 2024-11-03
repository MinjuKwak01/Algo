T = int(input())
lst = list(map(int,input().split()))
lst.sort()
print(lst[round(T/2)]-1)