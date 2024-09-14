# N, M = map(int, input().split())
# 
# lst = []
# 
# # 포켓몬 이름 입력받고 리스트에 저장하기
# for _ in range(N):
#     name = input()
#     lst.append(name)
# 
# qslst = []
# for _ in range(M):
#     qs = input()
#     qslst.append(qs)
# 
# # 숫자는 숫자로 문자열은 문자열로 다시 리스트에 저장
# qslst2 = []
# for e in qslst:
#     if e.isdigit():
#         qslst2.append(int(e))
#     else:
#         qslst2.append(e)
# 
# anslst = []
# for i in range(M):
#     if isinstance(qslst2[i], int):
#         anslst.append(lst[qslst2[i] -1])
#     if isinstance(qslst2[i], str):
#         try:
#             index = lst.index(qslst2[i])
#             anslst.append(str(index+1))
#         except ValueError:
#             print("asdf")
# 
# for i in range(M):
#     print(anslst[i])

# 문제점
# index() 메서드의 반복적인 호출로 시간 복잡도는 O(N*M)
# 숫자는 즉시 접근 가능하지만 문자열은 index()로 직접 탐색 해야함

# 해결법
# 딕셔너리 사용해서 키, 값을 저장해서 탐색 시간복잡도 O(1)
N, M = map(int, input().split())

lst = []
name_to_idx = {}

for i in range(N):
    name = input()
    lst.append(name)
    name_to_idx[name] = i + 1

for _ in range(M):
    qs = input()
    if qs.isdigit():
        print(lst[int(qs) - 1])
    else:
        print(name_to_idx[qs])