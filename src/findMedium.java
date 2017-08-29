import java.util.Arrays;

/**
 * Created by equation on 17-8-29.
 */
public class findMedium {
    public static double findMedium(int[] n1,int[] n2){
        int n = n1.length;
        int m = n2.length;
        int[] num = new int[n+m];
        int i=0,j=0;
        int k=0;
        while(i<n||j<m){
            if(i==n){
                num[k]=n2[j];
                j++;
            }else if(j==m){
                num[k]=n1[i];
                i++;
            }else{
                if(n1[i]<n2[j]){
                    num[k]=n1[i];
                    i++;
                }else{
                    num[k]=n2[j];
                    j++;
                }
            }
            k++;
        }
        if(n+m%2==0){
            return (num[(n+m)/2-1]+num[(n+m)/2])/2.0;
        }else{
            return (double)num[(n+m)/2];
        }
    }

    public static double findMid(int[] nums1,int[] nums2){
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    private static int findKth(int[] nums1, int[] nums2, int k){
        int n=nums1.length;
        int m=nums2.length;
        if(m>n) return findKth(nums2,nums1,k);
        if(m==0) return nums1[k-1];
        if(k==1) return Math.min(nums1[0],nums2[0]);
        int x=Math.min(k/2,n);
        int y=Math.min(k/2,m);
        if(nums1[x-1]<nums2[y-1]){
            return findKth(Arrays.copyOfRange(nums1,x,n),nums2,k-x);
        }else{
            return findKth(nums1,Arrays.copyOfRange(nums2,y,m),k-y);
        }
    }
}
