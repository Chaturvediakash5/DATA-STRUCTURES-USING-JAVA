import java.util.*;
class Doubly_Linked_List
{
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int val)
        {
            this.data=val;
            this.prev=null;
            this.next=null;
        }
    }
    public Node head=null;
    public int count=0;
    public static void main(String[]args)
    {
     Scanner sc=new Scanner(System.in);
     Doubly_Linked_List dlist=new Doubly_Linked_List();
    for(;;)
     {
        int val=0;
        int pos=0;
        int choice=0;
         System.out.println("Press 1  For Insertion");
         System.out.println("Press 2  For Insertion at First Position");
         System.out.println("Press 3  For Insertion at At Last Position");
         System.out.println("Press 4  For Insertion at At Any Position");
         System.out.println("Press 5  For Deletion From Front");
         System.out.println("Press 6  For Deletion From End");
         System.out.println("Press 7  For Deletion From Any Position");
         System.out.println("Press 8  For Display");
         System.out.println("Press 9  For Exit");

         choice=sc.nextInt();
         switch(choice)
         {
             case 1:
             System.out.println("Enter Value");
             val=sc.nextInt();
             dlist.insert(val);
             System.out.println("Insertion Successful");
             dlist.count++;
             break;

             case 2:
             System.out.println("Enter Value");
             val=sc.nextInt();
             dlist.insert_at_first_pos(val);
             System.out.println("Insertion Successful");
             dlist.count++;
             break;

             case 3:
             System.out.println("Enter Value");
             val=sc.nextInt();
             dlist.insert_at_last(val);
             System.out.println("Insertion Successful");
             dlist.count++;
             break;

             case 4:
             System.out.println("Enter Position");
             pos=sc.nextInt();
             System.out.println("Enter Value");
             val=sc.nextInt();
             dlist.insert_at_any_pos(pos,val);
             
             break;
            
            case 5:
            dlist.deletion_from_front();
            break;

            case 6:
            dlist.deletion_from_end();
            break;

            case 7:
            System.out.println("Enter Position");
            pos=sc.nextInt();
            dlist.delete_at_kth(pos);
            break;
            
            
            case 8:
            dlist.display();
            break;

             case 9:
             System.exit(0);
             break;
         }

     }   
    }
    public void delete_at_kth(int pos)
    {
        Doubly_Linked_List dlist=new Doubly_Linked_List();
        if(head==null)
        {
            System.out.println("List is Already Empty");
        }
       else if(pos==1)
        {
            deletion_from_front();
        }
        else if(pos==(count+1))
        {
            System.out.println("Invalid Position");
        }
        else if(pos==count)
        {
            deletion_from_end();
        }
        else  
        {
            int c=1;
            Node temp=head;
            while(c<(pos-1))
            {
                temp.next=temp;
                c++;
            }
           temp.next=temp.next.next;
           temp.next.prev=temp.next;
           System.out.println("Deletion Successful");
           dlist.count--;
           

        }
        return;
    }
    public void  deletion_from_end()
    {
        Doubly_Linked_List dlist=new Doubly_Linked_List();
        
        if(head==null)
        {
            System.out.println("List is Already Empty");
        }
        else if(count==1)
        {
            deletion_from_front();
        }
        else   
        {
            Node temp=head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next.prev=null;
        temp.next = null;
        System.out.println("Deletion Successful");
        dlist.count--;
         }
        return;
    }
    public void deletion_from_front()
    {
        int pos=1;
        Doubly_Linked_List dlist=new Doubly_Linked_List();
        if(head==null)
        {
            System.out.println("List is Already Empty");

        }
      else  if(count==1 & pos==1)
        {
            head=null;
            System.out.println("Deletion Successful");
            dlist.count--;
        }
        else{
            Node temp=head;
            head=temp.next;
            temp.next.prev=null;
            System.out.println("Deletion Successful");
            dlist.count--;
        }
        return;
    }
    public void insert_at_any_pos(int pos,int val)
    {
        Doubly_Linked_List dlist=new Doubly_Linked_List();
        if(pos<1 || pos>(count+2))
        {
            System.out.println("Invalid Position");
            System.out.println("Insertion Not  Possible");
        }
        else if(pos==1)
        {
            insert_at_first_pos(val);
            System.out.println("Insertion Successful");
             dlist.count++;
        }
        else if(count==(pos-1))
        {
            insert_at_last(val);
            System.out.println("Insertion Successful");
             dlist.count++;
        }
        else 
        {
            int c=1;
            Node temp=head;
            
            while(c<(pos-1))
            {
                temp=temp.next;
                c++;
            }
            Node newNode=new Node(val);
            newNode.next=temp.next;
            temp.next=newNode;
            newNode.prev=temp;
            System.out.println("Insertion Successful");
             dlist.count++;
        }
        return;
    }
    public void insert_at_last(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            insert_if_Head_Null(newNode, val);
        }
        else{
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
            newNode.next=null;
        }
    }
    public void insert_at_first_pos(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            insert_if_Head_Null(newNode, val);
        }
        else{
            
            newNode.next=head;
            head=newNode;
           /* head.prev=newNode;*/
            newNode.prev=null;
            

        }
        return;
    }
    public void  insert_if_Head_Null(Node newNode,int val)
    {
            head=newNode;
            newNode.next=null;
            newNode.prev=null;
            return;
    }
    /*public void delete_if_single_node_exists()
    {
        
    }*/
    public void insert(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            insert_if_Head_Null(newNode,val);
            /*System.out.println("Insertion Successful");*/
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
            newNode.next=null;
        }
        return;
    }
    public void display()
    {
        Node current = head;
        if(head == null) 
         {    
        System.out.println("List is empty");    
        return;    
        } 

        System.out.println("Nodes of Doubly linked list: ");    

        while(current!= null)
        {    
        //Prints each node by incrementing pointer    
        System.out.print(current.data + " ");    
        current = current.next;    
        }    
        System.out.println();
    }
}
