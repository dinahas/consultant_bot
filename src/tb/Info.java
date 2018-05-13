package tb;

import java.util.ArrayList;

/**
 * Created by user on 13.03.2018.
 */
public class Info {


    public String getCare(String mat){
        ArrayList<Care> listCare = new ArrayList<Care>();
        String inf = "Проверьте правильность введенных данных!";
        Info info = new Info();
        info.addCare(listCare);
        for(int i = 0; i < listCare.size(); i++){
            if(listCare.get(i).getMaterial().equals(mat.toLowerCase())){
                inf =  listCare.get(i).getCare();
            }
        }
        return inf;
    }

    public String getSize(String params){
        ArrayList<Size> listSize = new ArrayList<Size>();
        String inf;
        String chest = null, waist = null, thighs = null;
        Info info = new Info();
        String[] strings = new String[3];
        int i = 0;

        info.addSize(listSize);
        String Str = params;

        for (String retval : Str.split(" ", 3)) {
            strings[i] = retval;
            i++;
        }

        if (!(chestSize(strings[0], listSize) == null))
            chest = chestSize(strings[0], listSize);
        if (!(waistSize(strings[1], listSize) == null))
            waist = waistSize(strings[1], listSize);
        if (!(thighsSize(strings[2], listSize) == null))
            thighs = thighsSize(strings[2], listSize);

        if (chest == null || waist == null || thighs == null)
            inf = "Проверьте правильность введенных данных!";
        else if (fromString(strings[0]) < listSize.get(0).getMinChest()
                || fromString(strings[1]) < listSize.get(0).getMinWaist()
                || fromString(strings[2]) < listSize.get(0).getMinThighs()){
            inf = "Проверьте правильность введенных данных!";
        }
        else if (chest.equals(waist)){
            inf = ("Разер брюк/юбки: " + thighs + ". Размер футболки/платья: " + chest);
        }
        else{
            String size = normSize(chest, waist,listSize);
            inf = ("Разер брюк/юбки: " + thighs + ". Размер футболки/платья: " + size);
        }
        return inf;
    }

    private  String normSize(String param1, String param2, ArrayList<Size> listSize){
        int i = 0, j = 0;

        while (!listSize.get(i).getSize().equals(param1)){
            i++;
        }

        while (!listSize.get(j).getSize().equals(param2)){
            j++;
        }
         float num = (i + j)/2;
        return listSize.get(Math.round(num)).getSize();
    }

    private String thighsSize(String param, ArrayList<Size> listSize){
        int size = fromString(param);
        int i = 0;
        try {
            while (size > listSize.get(i).getMaxThighs()){
                i++;
            }
            return listSize.get(i).getSize();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private  String chestSize(String param, ArrayList<Size> listSize) {
        int size = fromString(param);
        int i = 0;
        try {
            while (size > listSize.get(i).getMaxChest()) {
                i++;
            }
            return listSize.get(i).getSize();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private  String waistSize(String param, ArrayList<Size> listSize){
        int size = fromString(param);
        int i = 0;
        try {
            while (size > listSize.get(i).getMaxWaist()){
                i++;
            }
            return listSize.get(i).getSize();
        }catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private int fromString(String string) {
        int num;
        try {
            num = Integer.parseInt(string);
        } catch (Exception e) {
            return 0;
        }
        return num;
    }

    private void addCare(ArrayList<Care> listCare){

        Care care1 = new Care("хлопок", "Здесь должен быть уход за хлопком");
        Care care2 = new Care("шелк", "Здесь должен быть уход за шелком");
        Care care3 = new Care("шерсть", "Здесь должен быть уход за шерстью");
        Care care4 = new Care("лен", "Здесь должен быть уход за льном");
        Care care5 = new Care("шифон", "Здесь должен быть уход за шифоном");
        Care care6 = new Care("деним","Здесь должен быть уход за денином");
        listCare.add(care1);
        listCare.add(care2);
        listCare.add(care3);
        listCare.add(care4);
        listCare.add(care5);
        listCare.add(care6);
    }

    private void addSize(ArrayList<Size> listSize){

        Size size1 = new Size("XXS", 74, 77,
                58, 62,
                85, 88);
        Size size2 = new Size("XS", 78, 81,
                63, 65,
                99 , 91);
        Size size3 = new Size("S", 82, 85,
                66, 69,
                92, 95);
        Size size4 = new Size("M", 86, 89,
                70 , 73,
                96, 98);
        Size size5 = new Size("L", 90, 93,
                74, 77,
                99, 101);
        Size size6 = new Size("XL", 94, 97,
                78, 81,
                102, 103);
        listSize.add(size1);
        listSize.add(size2);
        listSize.add(size3);
        listSize.add(size4);
        listSize.add(size5);
        listSize.add(size6);
    }
}
