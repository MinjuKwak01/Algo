T = int(input())

for t in range(T):
    num = int(input())
    summation = 1
    for i in range(2, num + 1):
        if i % 2 == 0:
            summation -= i
        else:
            summation += i
    print(f"#{t + 1} {summation}")
