
public class Arrays
{
    public boolean firstLast6(int[] nums)
    {
        if (nums[0] == 6 || nums[nums.length - 1] == 6)
        {
            return true;
        }
        return false;
    }

    public boolean sameFirstLast(int[] nums)
    {
        return (nums.length >= 1 && nums[0] == nums[nums.length - 1]);
    }

    public int[] makePi()
    {
        int[] pi = {3, 1, 4};
        return pi;

    }

    public boolean commonEnd(int[] a, int[] b)
    {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];

    }

    public int sum3(int[] nums)
    {
        int x = 0;
        for (int i = 0; i < nums.length; i++)
        {
            x += nums[i];
        }
        return x;
    }

    public int[] rotateLeft3(int[] nums)
    {
        int tem = nums[0];
        nums[0] = nums[1];
        nums[1] = nums[2];
        nums[2] = tem;
        return nums;
    }

    public int[] reverse3(int[] nums)
    {
        int tem = nums[0];
        nums[0] = nums[2];
        nums[2] = tem;
        return nums;
    }

    public int[] maxEnd3(int[] nums)
    {
        int greater = nums[0] > nums[2] ? 1 : 0;
        if (greater == 1)
        {
            nums[1] = nums[0];
            nums[2] = nums[0];
        } else
        {
            nums[0] = nums[2];
            nums[1] = nums[2];
        }
        return nums;
    }

    public int[] maxEnd4(int[] nums)
    {
        int max = Math.max(nums[0], nums[2]);
        nums[0] = max;
        nums[1] = max;
        nums[2] = max;
        return nums;
    }

    public int sum2(int[] nums)
    {
        if (nums.length < 2)
        {
            if (nums.length == 0)
            {
                return 0;
            }
            return nums[0];
        }
        return nums[0] + nums[1];
    }

    public int[] middleWay(int[] a, int[] b)
    {
        int j = a[1];
        int k = b[1];
        int[] joker = {j, k};
        return joker;

    }

    public int[] makeEnds(int[] nums)
    {
        if (nums.length == 1)
        {
            int[] numbers = {nums[0], nums[0]};
            return numbers;
        }
        int[] numbers = {nums[0], nums[nums.length - 1]};
        return numbers;
    }

    public boolean has23(int[] nums)
    {
        return (nums[0] == 2 || nums[1] == 2 || nums[0] == 3 || nums[1] == 3);
    }


    public boolean no23(int[] nums)
    {
        return (nums[0] != 2 && nums[1] != 2 && nums[0] != 3 && nums[1] != 3);
    }

    public int[] makeLast(int[] nums)
    {
        int len = nums.length * 2;
        int[] newArray = new int[len];
        if (nums.length == 1)
        {
            newArray[0] = 0;
            newArray[1] = nums[0];
            return newArray;
        }
        for (int i = 0; i < len - 1; i++)
        {
            newArray[i] = 0;

        }
        newArray[newArray.length - 1] = nums[nums.length - 1];
        return newArray;
    }

    public boolean double23(int[] nums)
    {
        if (nums.length < 2)
        {
            return false;
        }
        return nums[0] == 2 && nums[1] == 2 || nums[0] == 3 && nums[1] == 3;
    }

    public int[] fix23(int[] nums)
    {
        int[] newArray = new int[3];
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if (a == 2 && b == 3)
        {
            newArray[0] = 2;
            newArray[1] = 0;
            newArray[2] = nums[2];
            return newArray;

        } else if (b == 2 && c == 3)
        {
            newArray[0] = a;
            newArray[1] = 2;
            newArray[2] = 0;
            return newArray;
        } else
        {
            newArray[0] = a;
            newArray[1] = b;
            newArray[2] = c;
            return newArray;
        }


    }

    public int start1(int[] a, int[] b)
    {
        int count = 0;
        if (a.length != 0)
        {
            if (a[0] == 1) count++;
        }
        if (b.length != 0)
        {
            if (b[0] == 1) count++;
        }
        return count;

    }

    public int[] biggerTwo(int[] a, int[] b)
    {
        int[] newArray = new int[2];
        int c = a[0] + a[1];
        int d = b[0] + b[1];
        if (c == d)
        {
            newArray[0] = a[0];
            newArray[1] = a[1];
            return newArray;
        }
        if (c > d)
        {
            newArray[0] = a[0];
            newArray[1] = a[1];
            return newArray;
        }
        newArray[0] = b[0];
        newArray[1] = b[1];
        return newArray;
    }

    public int[] makeMiddle(int[] nums)
    {
        int[] newArray = new int[2];
        int half = nums.length / 2;
        if (nums.length == 2)
        {
            newArray[0] = nums[0];
            newArray[1] = nums[1];
            return newArray;
        }
        newArray[0] = nums[half - 1];
        newArray[1] = nums[half];
        return newArray;
    }

    public int[] plusTwo(int[] a, int[] b)
    {
        int[] newArray = new int[4];
        newArray[0] = a[0];
        newArray[1] = a[1];
        newArray[2] = b[0];
        newArray[3] = b[1];
        return newArray;
    }

    public int[] swapEnds(int[] nums)
    {
        int len = nums.length;
        int[] newArray = new int[len];
        if (nums.length == 1)
        {
            newArray[0] = nums[0];
            return newArray;
        }
        for (int i = 1; i < len - 1; i++)
        {
            newArray[i] = nums[i];

        }
        newArray[0] = nums[len - 1];
        newArray[len - 1] = nums[0];
        return newArray;

    }

    public int[] midThree(int[] nums)
    {
        int[] newArray = new int[3];
        int len = nums.length / 2;
        newArray[0] = nums[len - 1];
        newArray[1] = nums[len];
        newArray[2] = nums[len + 1];
        return newArray;
    }

    public int maxTriple(int[] nums)
    {
        int max = nums[0];
        if (max <= nums[nums.length - 1])
            max = nums[nums.length - 1];
        if (max <= nums[nums.length / 2])
            max = nums[nums.length / 2];
        return max;
    }

    public int[] frontPiece(int[] nums)
    {
        if (nums.length == 1)
        {
            return new int[]{nums[0]};
        } else if (nums.length == 0)
        {
            return new int[]{};
        } else
        {
            return new int[]{nums[0], nums[1]};
        }
    }

    public boolean unlucky1(int[] nums)
    {
        if (nums.length < 2)
        {
            return false;
        } else if (nums.length > 2)
        {
            if ((nums[0] == 1 && nums[1] == 3) || nums[1] == 1 && nums[2] == 3)
            {
                return true;
            } else if (nums[nums.length - 2] == 1 && nums[nums.length - 1] == 3)

            {
                return true;
            }
        } else if (nums.length == 2 && nums [0] == 1 && nums[1] == 3)
        {
            return true;
        }
        return false;
    }

    public int[] make2(int[] a, int[] b) {
        int[] newOne = new int[2];
        int c = a.length;
        if (c >= 2)
        {
            newOne[0] = a[0];
            newOne[1] = a[1];
            return newOne;
        } else if (c == 1)
        {
            newOne[0] = a[0];
            newOne[1] = b[0];
            return newOne;
        }else
        {
            newOne[0] = b[0];
            newOne[1] = b[1];
            return newOne;
        }
    }

    public int[] front11(int[] a, int[] b)
    {
        if (a.length == 0 && b.length == 0)
        {
            return new int[] {};
        } else if (a.length != 0 && b.length == 0)
        {
            return new int[]{a[0]};
        } else if (a.length == 0 && b.length != 0)
        {
            return new int[]{b[0]};
        } else
        {
            return new int[]{a[0], b[0]};
        }
    }

    public static void main(String[] args)
    {
        Arrays newOne = new Arrays();
        int[] one = {1, 1, 1,  3, 1};
        System.out.println(newOne.unlucky1(one));


    }

}

