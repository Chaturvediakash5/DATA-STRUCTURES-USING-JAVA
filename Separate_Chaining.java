import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Separate_Chaining {
	public static void main (String[] args) throws IOException{
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            
        
                String str[] = br.readLine().trim().split(" ");
                int capacity = Integer.parseInt(str[0]);
                int n = Integer.parseInt(str[1]);
                str = br.readLine().trim().split(" ");
                /* ArrayList<Integer> array = new ArrayList<>();
                    At every entry I only have integers.
                    What I want is, at every entry I want is ArrayList();
                    We want something like: 
                    [ArrayList(), ArrayList(), ArrayList()...ArrayList()]
                    Array of ArrayList of capacity length
                */
                //[ArrayList,ArrayList,ArrayList,ArrayList,ArrayList,ArrayList,ArrayList,.....ArrayList];
                ArrayList<Integer> ht[] = new ArrayList[capacity];
                
                //str = ["92","22","11"] capacity = 5
                for(int i = 0; i < n; i++){
                    int key = Integer.parseInt(str[i]); //key = 92, 22, 11
                    int hashKey = key % capacity; //hashKey = 2, 2, 1
                    if(ht[hashKey] == null){
                        //first time I am entering key
                        ht[hashKey] = new ArrayList<Integer>(); //ht[2] = new ArrayList<>();
                        // ArrayList<Integer> temp = ht[hashKey];
                        // temp.add(key);
                        // ht[hashKey] = temp;
                        ht[hashKey].add(key);
                    }
                    else{
                        //this position is visited again, collision
                        ht[hashKey].add(key);
                    }
                }

                //[null,[11],[92, 22],null,null]*capacity
                //1->11
                //2->92->22
                for(int i = 0; i < capacity; i++){//i = 0, 1, 2
                    if(ht[i]!=null){
                        System.out.print(i); //1, 2
                        ArrayList<Integer> row = ht[i]; //row = [92, 22]
                        for(int j = 0; j < row.size(); j++){
                            System.out.print("->"+row.get(j));
                        }
                        System.out.println();
                    }
                }
                System.out.println("~");
            
	}
}
