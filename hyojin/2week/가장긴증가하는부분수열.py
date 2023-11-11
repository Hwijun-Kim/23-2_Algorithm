def lis(arr):
    n = len(arr)
    lis_length = [1] * n

    for i in range(1, n):
        for j in range(0, i):
            if arr[i] > arr[j] and lis_length[i] < lis_length[j] + 1:
                lis_length[i] = lis_length[j] + 1

    return max(lis_length)

# 입력 처리
n = int(input())
sequence = list(map(int, input().split()))

# LIS 출력
result = lis(sequence)
print(result)
