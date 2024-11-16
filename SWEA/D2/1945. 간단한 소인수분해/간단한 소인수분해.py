T = int(input())

for t in range(T):
    num = int(input())

    a, b, c, d, e = 0, 0, 0, 0, 0
    while num % 2 == 0:
        num = num // 2
        a += 1
    while num % 3 == 0:
        num = num // 3
        b += 1
    while num % 5 == 0:
        num = num // 5
        c += 1
    while num % 7 == 0:
        num = num // 7
        d += 1
    while num % 11 == 0:
        num = num // 11
        e += 1
    print(f"#{t+1} {a} {b} {c} {d} {e}")
