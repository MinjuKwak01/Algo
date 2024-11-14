n = int(input())

lst = []
for _ in range(n):
    strr = str(input())
    lst.append(strr)

for j in range(n-1):
    for i in range(n - 1):
        if len(lst[i]) > len(lst[i + 1]):
            lst[i + 1], lst[i] = lst[i], lst[i+1]
        elif len(lst[i]) == len(lst[i + 1]):
            sum1 = sum([int(num) for num in lst[i] if num.isdigit()])
            sum2 = sum([int(num) for num in lst[i + 1] if num.isdigit()])
            if sum1 > sum2:
                lst[i + 1], lst[i] = lst[i], lst[i+1]
            elif sum1 == sum2:
                if lst[i+1] < lst[i]:
                    lst[i + 1], lst[i] = lst[i], lst[i + 1]

for e in lst:
    print(e)
