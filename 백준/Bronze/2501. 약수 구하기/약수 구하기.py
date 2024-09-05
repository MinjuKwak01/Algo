numbers: list = list(map(int, input().split()))
yak:list = []
for i in range(1, numbers[0]+1):
    if numbers[0] % i ==0:
        yak.append(i)

try:
    print(yak[numbers[1] - 1])
except IndexError:
    print(0)


