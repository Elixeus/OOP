#!/usr/bin/env python
# -*- coding: utf-8 -*-


class SortObj(object):

    def __init__(self, data):
        self.data = data

    def selection_sort(self, reverse=False):
        '''This is a python implementation of the selection sort algorithm
        It can sort the data of the object in either ascending or descending
        order. The elements in the data attribute must be comparable (having
        at least __eq__ and __lt__ methods defined).
        --------------------
        parameters:
            reverse: boolean value to control the sorting order. If False
                     by default, then sort by ascending order. If True, sort
                     by descening order.'''
        targetind = 1
        for ind in range(0, len(self.data) - 1):
            targetind = ind
            for j in range(ind + 1, len(self.data)):
                compare = self.data[j] <= self.data[targetind]
                # use the reverse marker to check the sort order
                # if not reverse:  # ascending order
                #     if compare:
                #         targetind = j
                # else:  # descending order
                #     if not compare:
                #         targetind = j
                if (compare if not reverse else not compare):
                    targetind = j
            # swap the values
            self.data[targetind], self.data[
                ind] = self.data[ind], self.data[targetind]


def main():
    x = SortObj([4, 2, 8, 10, 8, 15, 4])
    x.selection_sort()
    print x.data
    x.selection_sort(reverse=False)
    print x.data
    x.selection_sort(reverse=True)
    print x.data


# def selection_sort_reverse(self.data):
#     targetind = 1
#     for ind in sorted(range(1, len(self.data)), reverse=True):
#         targetind = ind
#         for j in sorted(range(ind - 1, len(self.data) - 1), reverse=True):
#             if self.data[j] > self.data[targetind]:
#                 targetind = j
#         self.data[targetind], self.data[ind] = /
#         self.data[ind],self.data[targetind]

if __name__ == '__main__':
    main()
