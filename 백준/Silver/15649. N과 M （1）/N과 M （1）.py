N, M = map(int, input().split())
num = []
def dfs():
  if len(num) == M:
    print(' '.join(map(str, num)))
    return

  for i in range(1, N+1):
    if i in num:
      continue
    num.append(i)
    dfs()
    num.pop()

dfs()