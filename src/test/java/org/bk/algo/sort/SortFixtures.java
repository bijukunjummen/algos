package org.bk.algo.sort;

public class SortFixtures {
	public static Integer[] fixture1(){
		return new Integer[]{5,3,10,2000,15,9,2,1};
	}

	public static Integer[] fixture1Expected(){
		return new Integer[]{1,2,3,5,9,10,15,2000};
	}

   public static Integer[] fixture2(){
        return new Integer[]{5,3,10,2000,15,9,2,3,5,1};
    }

    public static Integer[] fixture2Expected(){
        return new Integer[]{1,2,3,3,5,5,9,10,15,2000};
    }

    public static Integer[] fixture3(){
        return new Integer[]{54,35,23,1,0,9,8,5,3,2,7,89,203,10,11,12,32,10,9,8,112,211,32,16};
    }

    public static Integer[] fixture3Expected(){
        return new Integer[]{0,1,2,3,5,7,8,8,9,9,10,10,11,12,16,23,32,32,35,54,89,112,203,211};
    }
}
