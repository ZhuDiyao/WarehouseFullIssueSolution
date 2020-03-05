package SLN;

import Entity.StockBean;
import Entity.StockBeanList;

import java.util.ArrayList;

public class Test2 {

    static StockBeanList 仓库列表 = null;
    public static void main(String[] args) {
        //1、准备26个仓库,并填值
        仓库列表 = new StockBeanList();
        for(int i=0;i<26;i++){
            仓库列表.AddBean(new StockBean((char)(65+i)+"", (int) (System.currentTimeMillis()%50+1)));
            延时();
        }
        仓库列表.PrintBean("仓库总览");
        //2、列举符合条件的子集合
        iRoot2(new StockBeanList(),0,仓库列表.仓库列表.size(),100);
        //3、打印所有子集合
        for(int i=0;i<所有子集.size();i++){
            所有子集.get(i).PrintBeanSimple();
        }
    }

    static ArrayList<StockBeanList> 所有子集 = new ArrayList<StockBeanList>();
    static int SNumber = 0;

    /***
     * 列举所有子集合的递归方法
     * @param 子集
     * @param 下标计数器
     * @param 父集合长度
     */
    static void iRoot(StockBeanList 子集,int 下标计数器,int 父集合长度){
        if(下标计数器 == 父集合长度){
            所有子集.add(子集);
            return;
        }
        iRoot(子集.克隆(仓库列表.仓库列表.get(下标计数器)),下标计数器+1,父集合长度);
        iRoot(子集,下标计数器+1,父集合长度);
    }

    /***
     * 列举所有子集合的递归方法,在原基础上剪枝。
     *
     * @param 子集
     * @param 下标计数器
     * @param 父集合长度
     */
    static void iRoot2(StockBeanList 子集,int 下标计数器,int 父集合长度,int 目标求和值){
        if(子集.Check(目标求和值)==-1){
            //值已溢出
            return;
        }
        if(下标计数器 == 父集合长度){
            if(子集.Check(目标求和值)==0){
                所有子集.add(子集);
            }
            return;
        }
        iRoot2(子集.克隆(仓库列表.仓库列表.get(下标计数器)),下标计数器+1,父集合长度,目标求和值);
        iRoot2(子集,下标计数器+1,父集合长度,目标求和值);
    }

    static void 延时(){
        try {
            Thread.sleep((int) (System.currentTimeMillis()%20+1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
