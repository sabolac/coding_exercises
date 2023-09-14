#include <assert.h>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int minSubArrayLen(int target, vector<int> &nums)
{
    const int n = nums.size();
    int subarray_length = INT_MAX;
    int l = 0, r = 0, sum = 0;
    while (r < n)
    {
        sum += nums[r];
        while (sum >= target)
        {
            subarray_length = min(subarray_length, r - l + 1);
            sum -= nums[l++];
        }
        ++r;
    }
    if (subarray_length == INT_MAX)
    {
        return 0;
    }

    return subarray_length;
}

int main()
{
    cout << endl << "START" << endl;
    vector<int> nums {1, 2, 3};
    int r = minSubArrayLen(4, nums);
    assert(r == 2);

    cout << endl << "END" << endl;
}
