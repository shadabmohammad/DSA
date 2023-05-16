import java.io.*;
import java.util.*;
class Trie{
    Trie child[]=new Trie[26];
    int count=0;
    Trie(){
        for(int i =0;i<26;i++){
            child[i]=null;
        }
    }

}
public class rhymes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> l = new ArrayList<>();
        List<String> w = new ArrayList<>();
        Trie r = new Trie();
        for(int i =0;i<N;i++){
            String A=sc.next();
            l.add(A);
        }
        int M = sc.nextInt();
        for(int i =0;i<M;i++){
            String B = sc.next();
            w.add(B);
        }
        for(int i=0;i<N;i++){
            insert(r,l.get(i));
        }
        for(int i =0;i<M;i++){
            System.out.println(rhymes(r,w.get(i)));
        }

    }
    static void insert(Trie r, String S){

        for(int i=S.length()-1;i>=0;i--){
            if(r.child[S.charAt(i)-'a']==null){
                r.child[S.charAt(i)-'a']=new Trie();
            }
            r = r.child[S.charAt(i) - 'a'];
            r.count=Math.max(r.count,S.length());
        }

    }
    static int rhymes(Trie r , String Q){
        for(int j =Q.length()-1;j>=0;j--){
            if(r.child[Q.charAt(j)-'a']==null){
                return r.count;
            }
            r=r.child[Q.charAt(j)-'a'];
        }
        if(r==null){
            return 0;
        }
        return r.count;

    }
}