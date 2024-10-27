t = int(input())

for i in range(1, t + 1) :
    a, b = map(int, input().split())
    if a == b :
        print('#%d %s' % (i, '='))
    elif a < b :
        print('#%d %s' % (i, '<'))
    else :
        print('#%d %s' % (i, '>'))