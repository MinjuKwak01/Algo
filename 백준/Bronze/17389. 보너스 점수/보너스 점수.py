N = int(input())
score = input()

# 리스트로 변환
lst = list(score)
bonus = 0
cur = 0

for i in range(N):
    if lst[i] == 'X':
        # 보너스는 0으로 초기화
        bonus = 0
    #보너스 점수 여기서 더해야함
    cur += bonus
    if lst[i] == 'O':
        bonus +=1
        cur += (i+1)

print(cur)
