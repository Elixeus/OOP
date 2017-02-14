def main():
    x = [4, 2, 8, 10]
    selection_sort(x)
    print x
    selection_sort_reverse(x)
    print x


def selection_sort(lis):
    targetind = 1
    for ind in range(0, len(lis) - 1):
        targetind = ind
        for j in range(ind + 1, len(lis)):
            if lis[j] < lis[targetind]:
                targetind = j
        lis[targetind], lis[ind] = lis[ind], lis[targetind]


def selection_sort_reverse(lis):
    targetind = 1
    for ind in sorted(range(1, len(lis)), reverse=True):
        targetind = ind
        for j in sorted(range(ind - 1, len(lis) - 1), reverse=True):
            if lis[j] > lis[targetind]:
                targetind = j
        lis[targetind], lis[ind] = lis[ind], lis[targetind]

if __name__ == '__main__':
    main()
