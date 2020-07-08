from typing import List


def kmp(s: str, p: str) -> int:
    if len(s) == 0 or len(p) == 0:
        return -1
    str_len = len(s)
    i = 0
    j = 0
    n = build_next(p)
    while i < str_len and j < len(p):
        if j < 0 or s[i] == p[j]:
            i += 1
            j += 1
        else:
            j = n[j]
    if j == len(p):
        return i - j
    else:
        return -1


def build_next(p: str) -> List:
    if len(p) == 0:
        return []
    str_len = len(p)
    n = [0] * str_len
    n[0] = -1
    j = 0
    t = n[0]
    while j < str_len - 1:
        if t < 0 or p[j] == p[t]:
            t += 1
            j += 1
            n[j] = t
        else:
            t = n[t]
    return n


p = "bba"
s = "aaaaa"
n = build_next(p)
start = kmp(s, p)
print(start)

