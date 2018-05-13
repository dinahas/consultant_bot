package tb;

/**
 * Created by user on 11.03.2018.
 * Класс, в которм будем подбирать размер одежды
 */
public class Size {
    private String size;
    private int minChest, maxChest, minWaist, maxWaist, minThighs, maxThighs;

    public Size(String size, int minChest, int maxChest,
                int minWaist, int maxWaist,
                int minThighs, int maxThighs){
        this.setSize(size);
        this.setMinChest(minChest);
        this.setMaxChest(maxChest);
        this.setMinWaist(minWaist);
        this.setMaxWaist(maxWaist);
        this.setMinThighs(minThighs);
        this.setMaxThighs(maxThighs);
    }

    private void setSize(String size){

        this.size = size;
    }

    private void setMinChest(int min){
        this.minChest = min;
    }

    private  void setMaxChest(int max){
        this.maxChest = max;
    }

    private void setMinWaist(int min){
        this.minWaist = min;
    }

    private  void setMaxWaist(int max){
        this.maxWaist = max;
    }

    private void setMinThighs(int min){
        this.minThighs = min;
    }

    private  void setMaxThighs(int max){
        this.maxThighs = max;
    }

    public String getSize(){

        return  size;
    }

    public int getMinChest(){
        return minChest;
    }

    public int getMaxChest(){
        return maxChest;
    }

    public int getMinWaist(){
        return  minWaist;
    }

    public int getMaxWaist(){
        return  maxWaist;
    }

    public int getMinThighs(){
        return minThighs;
    }

    public int getMaxThighs(){
        return maxThighs;
    }
}
