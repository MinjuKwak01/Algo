import sys

input = sys.stdin.readline

n, m = map(int, input().split())
lst = list(map(int, input().split()))

start, end = 1, max(lst)
while start <= end:
    sum = 0
    mid = (start + end) // 2

    for e in lst:
        if e > mid:
            sum += e - mid
    if sum < m:
        end = mid - 1 # 높이 낮추기
    else:
        start = mid + 1 # 높이 높이기

print(end)
