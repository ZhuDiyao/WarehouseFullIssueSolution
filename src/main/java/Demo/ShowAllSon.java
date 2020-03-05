package Demo;

public class ShowAllSon {
    public static String[] arr=new String[]{"A","B","C","D"};
    public static void main(String[] args) {
        int len=4;
        Rec("",0,len);
    }
    public static void Rec(String string,int start,int len)
    {
        if(start==len)
        {
            System.out.println(string);
            return;
        }
        Rec(string+arr[start],start+1,len);
        Rec(string,start+1,len);
    }
}
