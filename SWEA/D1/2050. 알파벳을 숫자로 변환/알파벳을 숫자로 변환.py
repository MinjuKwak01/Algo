dict = {}

for i in range(1, 27):
    dict[i] = chr(64 + i)

dict_swapped = {value: key for key, value in dict.items()}
lst = list(str(input()))

answer = []
for e in lst:
    answer.append(dict_swapped[e])

for i in range(len(answer)):
    print(answer[i], end=" ")

