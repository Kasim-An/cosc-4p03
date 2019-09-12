package pkg403a2;

import java.util.*;

public class Assign2 {
    public ArrayList<ArrayList<int[]>> realreallist=new ArrayList();
    public ArrayList<int[]> reallist=new ArrayList();//record all fitable
    public ArrayList<int[]> totallist=new ArrayList();//all possible
    public ArrayList<Integer> doing=new ArrayList();
    public int length=0;
    public int level=0;
    public int maxlevel=-1;
    public String buildrandomlist(){
        length=0;
        System.out.println("Enter list length");
        Scanner sc=new Scanner(System.in);
        length=sc.nextInt();
        String templine="";
        for(int i=0;i<length;i++){
            if(Math.random() < 0.5){
                templine+="0";
            }
            else{
                templine+="0";
            }
        }
        String temp=(Integer.valueOf(templine,2)).toString();
        int tempint=Integer.valueOf(templine,2);
        //System.out.println("tempint "+tempint);
        Integer.toBinaryString(Integer.valueOf(templine,2));
        //System.out.println("templine "+templine);
        return templine;
    }
    public boolean limit4(int[]one,int[]two){//separate byte as single
        if(one.length!=two.length){
            return false;
        }
        else{
            int tempcompare[]=new int[one.length];
            int tempcount=0;
            for(int i=0;i<one.length;i++){
                if(one[i]==two[i]){
                    tempcompare[i]=0;//compare yes, set true
                }
                else
                    tempcompare[i]=1;
            }
            for(int i=0;i<tempcompare.length;i++){
                //System.out.print(tempcompare[i]);//get position
                if(tempcompare[i]==1){//count difference until 4
                    tempcount++;
                }
            }
            return tempcount == 4;
        }
    }
    public void backtrack(ArrayList<int[]> temp,int pos){////////////////
        for(int i=0;i<totallist.size();i++){
            if(compareall(temp)){
                level++;
                System.out.println("level is"+level);
                temp.add(totallist.get(i));
                if(maxlevel<level)
                {
                    maxlevel=level;
                }
                doing.add(level);
                ArrayList<int[]> tem=(ArrayList<int[]>) temp.clone();
                realreallist.add(tem);
                backtrack(temp,pos);
                temp.remove(temp.size()-1);
                level--;
            }
        }
        
    }
    public ArrayList loop(ArrayList arr){//loop library
        if(arr!=null){
            int[] a=(int[]) arr.get(0);
            arr.add(a);
            arr.remove(0);
        }
            return arr;
    }
    public boolean compareall(ArrayList<int[]> templist){
        ArrayList<Boolean> testarr=new ArrayList();
        if(templist.size()>1){
            for(int i=0;i<templist.size()-1;i++){//0 to n-1 item compares last one
                int[] arr1=templist.get(i);
                int[] arr2=templist.get(templist.size()-1);
                boolean test=limit4(arr1,arr2);
                testarr.add(test);
            }
            for(boolean a:testarr){
                if(a==false)
                    return false;
            }
        }
        return true;
    }//calculate all limit4
    public boolean falseall(ArrayList<int[]> templist,ArrayList<int[]> adding){//nothing can be add
        ArrayList<Boolean> testarr=new ArrayList();
        ArrayList<int[]> testa=(ArrayList<int[]>) templist.clone();
        for(int i=0;i<templist.size();i++){
            testa.add(adding.get(i));
            boolean test=compareall(testa);
            testarr.add(test);
            testa.remove(templist.get(templist.size()-1));
        }
        for(boolean a:testarr){
            if(a==true){
                return false;
            }
        }
        return true;
    }
    public void travel(String path){
        int tempint=Integer.valueOf(path,2);
        String tempintstring=null;
        String testintstring=path;
        char[] tempintch;
        char[] testintch;
        for(int i=0;i<Math.pow(2,length);i++){//length 6 loop 2^6-1
            if((tempint+1)==Math.pow(2,length)){
                tempint=0;
            }
            tempintstring=Integer.toBinaryString(tempint);
            
            tempintch=tempintstring.toCharArray();
            testintch=testintstring.toCharArray();
            int[] tempintarr=new int[testintch.length];
            Arrays.fill(tempintarr,0);
            int[] testintarr=new int[testintch.length];
            Arrays.fill(testintarr,0);//first 2 element to 0?
            int fit1=length-tempintch.length;
            for(int lp=0;lp<fit1;lp++){
                tempintarr[lp]=0;
            }
            for(int lp=0;lp<length-fit1;lp++){
                int a=tempintch[lp]-'0';
                tempintarr[fit1+lp]=a;
            }
            for(int i2=0;i2<testintch.length;i2++)
            testintarr[i2]=testintch[i2]-'0';
            if(limit4(tempintarr,testintarr)){
                totallist.add(tempintarr);
            }
            
            tempint++;
            
        }
    }
    public int convert(int a){
        if(a==0){
            return 1;
        }
        else 
            return 0;
    }
    public int[] reversal(int[] a){
        for(int i=0;i<a.length;i++){
            a[i]=convert(a[i]);
        }
        return a;
    }
    public Assign2(){
        String a=buildrandomlist();
        System.out.println("first line is ");
        System.out.print(a);
        System.out.println();
        System.out.println();
        travel(a);
        int[] tempa=new int[a.toCharArray().length];
        Arrays.fill(tempa, 0);
        for(int lp=0;lp<a.toCharArray().length;lp++){
            tempa[lp]=a.toCharArray()[lp]-'0';
        }
        totallist.set(0,tempa);
        reallist=new ArrayList<>();
        backtrack(reallist,0);
        System.out.println("library size is "+totallist.size());
        System.out.println("looplist size is"+reallist.size());
        System.out.println("realreallist size is "+realreallist.size());
        System.out.println("max level "+maxlevel);
        for(int t1=0;t1<totallist.size();t1++){
            //for(int t2=0;t2<length;t2++)
            //System.out.print(totallist.get(t1)[t2]+" ");
            //System.out.println();
        }
        //System.out.println(doing.size());
        System.out.println("final loop times "+realreallist.size());
        int outside=0;
        ArrayList<int[]> output=new ArrayList();
        for(int t1=0;t1<doing.size();t1++){
            int t2=t1+1;
            if(doing.get(doing.size()-1-t1)==maxlevel-1){//
                //if(doing.get(doing.size()-1-t2)<maxlevel){
                    outside=t1;//first max position changed
                    if(compareall(realreallist.get(realreallist.size()-1-outside))){
                        output=realreallist.get(realreallist.size()-1-outside);
                        break;
        }
                //}
            }
        }
        System.out.println();
        
        for(int t1=0;t1<totallist.size();t1++){
            output.add(totallist.get(t1));
            for(int t2=0;t2<totallist.get(t1).length;t2++)
            if(compareall(output)){
                System.out.println("");
                break;
            }
            output.remove(output.size()-1);
        }
        
        for(int t1=0;t1<output.size();t1++){
            for(int t2=0;t2<length;t2++)
            System.out.print(output.get(t1)[t2]+" ");
            System.out.println("@@@");
        }
    }
    /*
    public void checkandprint(int i){
        ArrayList<int[]> output=new ArrayList();
        if(compareall(realreallist.get(realreallist.size()-1-i))){
            output=realreallist.get(realreallist.size()-1-i);
            System.out.println();
            for(int t1=0;t1<output.size();t1++){
                for(int t2=0;t2<length;t2++)
                System.out.print(output.get(t1)[t2]+" ");
                System.out.println("@@@");
            }
        }
    }
*/
    public static void main(String[] args) {
        Assign2 a=new Assign2();
    }
    
}
