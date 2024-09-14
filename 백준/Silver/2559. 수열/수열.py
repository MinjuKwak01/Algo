N, K = map(int, input().split())
lst = list(map(int, input().split()))

# 첫 번째 구간 합을 미리 구해둠
current_sum = sum(lst[:K])
maximum = current_sum

# 슬라이딩 윈도우 방식으로 구간 합을 구함
for i in range(1, N-K+1):
    # 현재 구간 합에서 앞의 값을 빼고 뒤의 값을 더함
    current_sum = current_sum - lst[i-1] + lst[i+K-1]
    if maximum < current_sum:
        maximum = current_sum

print(maximum)
