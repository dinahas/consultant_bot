package tb;

import java.util.ArrayList;

/**
 * Created by user on 11.03.2018.
 * Класс, в которм будем подбирать уход за одеждой
 */
public class Care
{
    private String material, care;

    public Care(String material, String care){
        this.setMaterial(material);
        this.setCare(care);
    }

    public Care(){

    }

    public void setMaterial(String material){
        this.material = material;
    }

    private void setCare(String care){
        this.care = care;
    }


    public String getMaterial(){
        return material;
    }

    public String getCare(){
        return  care;
    }
}
