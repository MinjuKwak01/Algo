N = int(input())

lst1 = list(map(int, input().split()))
lst1.sort()

M = int(input())

lst2 = list(map(int, input().split()))

def binary_search(target, data):
    start = 0
    end = len(data) - 1

    while start<= end :
        mid = (start + end) //2
        if data[mid] == target:
            return 1
        elif data[mid] < target:
            start = mid+1
        else:
            end = mid -1

    return 0

for e in lst2:
    isIn = binary_search(e,lst1)
    print(isIn)
