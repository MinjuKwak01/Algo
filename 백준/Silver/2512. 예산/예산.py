import sys

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
m = int(input())

start, end = 0, max(lst)

while start <= end:
    sum = 0
    mid = (start + end) // 2

    for e in lst:
        if e > mid:
            sum += mid
        else:
            sum += e

    if sum > m:
        end = mid - 1
    else:
        start = mid + 1

print(end)
