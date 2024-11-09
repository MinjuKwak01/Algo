x = int(input())

for i in range(x):
  A = list(map(int, input().split()))
  A.sort()
  # A 리스트에서 3번째로 큰 수(역순)를 출력
  print(A[-3])