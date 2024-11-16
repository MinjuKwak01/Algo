T = int(input())
for test_case in range(1, T + 1):
    line = str(input())
    rline = line[::-1]
    value = 1 if line == rline else 0
    print(f"#{test_case} {value}")