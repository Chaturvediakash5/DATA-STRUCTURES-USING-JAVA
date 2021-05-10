import java.util.*;
public class Quadratic_Probing {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size Of Hash Function and Array");
        int hash=sc.nextInt();
        int n=sc.nextInt();
    
        //Creation Of Hash Array and Key Array
        

        int ar[]=new int[n];

        System.out.println("Enter Array Elements");
        for(int i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
        }
        mapper(hash,ar);
    }
    public static void mapper(int hash,int ar[])
    {
        int arr[]=new int[hash];
        for(int i=0;i<hash;i++)
        {
            arr[i]=-1;
          /*  System.out.print(arr[i]+" ");*/
        }
        int i=0;
        while(i<ar.length)
        {
        int key=ar[i]%hash;
        if(arr[key]!= -1)
        {
            int k=0;
            int c=ar[i];
            int j=1;
            while(k<hash)
            {
                
                int k1=(c+j*j)%hash;
                if(arr[k1]== -1)
                {
                    arr[k1]=ar[i];
                    break;
                }
                else{
                    k++;
                    j++;
                }
            }
        }
        else
        {
            arr[key]=ar[i];
        }
        i++;
    }
        print_hash1(arr);
    }
    public static void print_hash1(int arr[])
    {
        System.out.println("Mapped Hash is:");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
