N = int(input())
prev = 0
nextt = 1
result = 0
if N ==0:
    print(0)
elif N ==1:
    print(1)
else:
    for i in range(N - 1):
        result = prev + nextt
        prev = nextt
        nextt = result
    print(result)
