package medium;

public class Jump {
	
	public static void main(String[] args) {
		int[] m ={5,9,3,2,1,0,2,3,3,1,0,0};
		Jump j = new Jump();
		int k = j.jump(m);
		System.out.println("Min jumps:"+k);
	}
	
	int[] dpArr;
	
	public boolean canJump(int[] nums) {
		if(nums.length==0)
			return true;
		dpArr = new int[nums.length];
		for(int i=0;i<dpArr.length;i++) {
			dpArr[i] = -1;
		}
		dpArr[nums.length-1]=0;
        return jump(nums,0,dpArr);
    }
	

	public boolean jump(int[] nums,int index,int[] dpArr) {
		if(nums[index]+index>=nums.length-1) {
			dpArr[index]=1;
			return true;
		}
		if(dpArr[index]!=-1)
			return dpArr[index]==1?true:false;
		
		for(int i=1;i<=nums[index];i++) {
			if(jump(nums, index+i,dpArr)) {
				dpArr[index+i]=1;
				return true;
			}
		}
		dpArr[index]=0;
		return false;
	}
    
    public int jump(int[] nums) {
		if(nums.length==1)
			return 0;
		dpArr = new int[nums.length];
		for(int i=0;i<dpArr.length;i++) {
			dpArr[i] = -1;
		}
		dpArr[nums.length-1]=0;
        jumpMin(nums,0,dpArr);
        System.out.println(dpArr.length+","+nums.length);
        for(int i=0;i<dpArr.length;i++) {
        		System.out.print(dpArr[i]+",");
        }
        System.out.println("");
        return dpArr[0];
    }
    public void jumpMin(int[] nums,int index,int[] dpArr) {
    		if(index==nums.length-1) {
    			return;
    		}
    		if(nums[index]==0) {
    			dpArr[index]=-1;
    			return;
    		}
		if(nums[index]+index>=nums.length-1) {
			dpArr[index]=1;
			return;
		}
		if(dpArr[index]>=0)
			return;
		
		int minJump = -1;
		for(int i=1;i<=nums[index];i++) {
			jumpMin(nums, index+i,dpArr);
			if(dpArr[index+i]>=0) {
				if(dpArr[index+i]==1) {
					dpArr[index] = 2;
					return;
				}
				if(minJump==-1) {
					minJump = dpArr[index+i];
                    continue;
				}
				if(minJump!=-1 && dpArr[index+i]<minJump) {
					minJump = dpArr[index+i];
				}
			}
		}
		dpArr[index]=minJump==-1?-1:minJump+1;
		
	}

}
