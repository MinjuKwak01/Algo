init = input()

# 26
strr = init
cnt = 0
while True:
    if len(strr) != 2:
        strr = '0' + strr

    summ = int(strr[0]) + int(strr[1])
    if summ >= 10:
        summ = str(summ)[1]
    strr = strr[1] + str(summ)

    cnt += 1
  #  print(strr)
    if int(strr) == int(init):
        break

print(cnt)

