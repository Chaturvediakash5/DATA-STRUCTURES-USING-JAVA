import java.util.*;
class Find_Target
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter  Sie of Arrya");
        int N=sc.nextInt();
        System.out.println("Enter Target Element");
        int tar=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Elements");
        for(int i=0;i<N;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        System.out.println("First Occurance"+first_OCC(arr,0,N-1,tar,N));
        
        System.out.println("Last Occurance"+last_OCC(arr,0,N-1,tar,N));
        
        
    }
    public static int last_OCC(int arr[],int low,int high,int tar,int n)
    
    {
        if(high>=low)
        {
            int mid=low+((high-low)/2);

            if((mid==n-1 || tar<arr[mid+1]) && arr[mid]==tar)
            {
                return mid;
            }
           else if(tar<arr[mid])
            {
                return last_OCC(arr,low,(mid-1),tar,n);
            }
            else
            {
                return last_OCC(arr,(mid+1),high,tar,n);
            }
        }
        return -1;
    }
    {

    }
    public static int  first_OCC(int arr[],int low,int high,int tar,int n)
    {
        if(high>=low)
        {
            int mid=low+((high-low)/2);
            if(tar>arr[mid-1] && arr[mid]==tar)
            {
                return mid;
            }
            if(tar>arr[mid])
            {
                return first_OCC(arr,(mid+1),high,tar,n);
            }
            else
            {
                return first_OCC(arr,low,mid-1,tar,n);
            }
        }
        return -1;
    }
}
