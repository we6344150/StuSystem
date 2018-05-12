package calculate;

import java.util.Arrays;

public class CalculateDemo {
   
     public static void main(String[] args) {
    	  int[] a= {1,8,5,2,4,9,7};
    	   for(int i=0;i<a.length;i++) {
    		  for(int j=0;j<a.length-1;j++) {
    			  if(a[i]>a[j]) {
    				  int tem=a[i];
    				  a[i]=a[j];
    				  a[j]=tem;
    			  }
    		  }
    	   }
    	   System.out.println(Arrays.toString(a));
	}
   
}
