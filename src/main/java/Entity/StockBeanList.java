package Entity;

import java.util.ArrayList;

public class StockBeanList {
    /***
     * 仓库列表实体
     */
    public ArrayList<StockBean> 仓库列表 = new ArrayList<StockBean>();


    public StockBeanList 克隆(){
        StockBeanList newStockBeanList = new StockBeanList();
        for(int i=0;i<仓库列表.size();i++){
            newStockBeanList.仓库列表.add(仓库列表.get(i));
        }
        return newStockBeanList;
    }
    public StockBeanList 克隆(StockBean stockBean){
        StockBeanList newStockBeanList = new StockBeanList();
        for(int i=0;i<仓库列表.size();i++){
            newStockBeanList.仓库列表.add(仓库列表.get(i));
        }
        newStockBeanList.仓库列表.add(stockBean);
        return newStockBeanList;
    }

    /**
     * 向列表对象添加一个成员，如果仓库名重复，则不添加。
     * @param stockBean
     */
    public void AddBean(StockBean stockBean){
        for(int i=0;i<仓库列表.size();i++){
            if(仓库列表.get(i).Name.equals(stockBean.Name)){
                return;
            }
        }
        仓库列表.add(stockBean);
    }

    public void DeleteLastOBJ(){
        仓库列表.remove(仓库列表.get(仓库列表.size()-1));
    }

    public void PrintBean(){
        PrintBean("");
    }
    public void PrintBean(String Head){
        System.out.print(Head+"===>");
        for(int i=0;i<仓库列表.size();i++){
            System.out.print(仓库列表.get(i).Name + ":" + 仓库列表.get(i).Number + " | ");
        }
        System.out.println("");
    }
    public void PrintBeanSimple(){
        String R = "";
        for(int i=0;i<仓库列表.size();i++){
            R=R+仓库列表.get(i).Name+"";
        }
        R=R+",";
        System.out.print(R);
    }

    /***
     * 检查当前库存值和目标值是否一致，
     * 列表和 > 目标值 , 返回-1，不需要继续添加了，因为值已经溢出了
     * 列表和 < 目标值 , 返回 1, 还可以继续尝试添加
     * 列表和 = 目标值 , 返回 0, 这就是其中一种解
     * @param terget
     * @return
     */
    public int Check(int terget){
        int sum = 0;
        for(int i=0;i<仓库列表.size();i++){
            sum =sum+仓库列表.get(i).Number;
        }
        if(sum == terget){
            return 0;
        }
        else if(sum < terget){
            return 1;
        }
        else{
            return -1;
        }
    }
}
