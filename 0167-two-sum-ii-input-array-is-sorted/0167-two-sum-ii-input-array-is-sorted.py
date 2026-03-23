class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """

        m = {}
        for i in range(len(numbers)):
            first = numbers[i]
            sec = target - first

            if sec in m:
                return m[sec] + 1,i + 1
            m[first] = i

        return [-1, -1]
        