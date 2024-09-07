N = int(input())
out = 0
cnt = 0
while True:
    cnt+=1
    out += cnt
    if out > N:
        break

print(cnt-1)
