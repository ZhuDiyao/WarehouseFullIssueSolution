package Entity;

public class StockBean {
    /***
     * 仓库名称
     */
    public String Name;
    /***
     * 库存数量
     */
    public int Number;

    public StockBean(){

    }

    public StockBean(String Name_,int Number_){
        Name = Name_;
        Number = Number_;
    }


}
