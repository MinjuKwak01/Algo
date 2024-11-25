import sys

input = sys.stdin.readline

n, k = map(int, input().split())
lst = []
for _ in range(n):
    num = int(input())
    lst.append(num)

start, end = 1, max(lst)

while start <= end:
    mid = (start + end) // 2
    sum = 0
    for e in lst:
        sum += e // mid
    if sum < k:
        end = mid - 1
    else:
        start = mid + 1

print(end)
