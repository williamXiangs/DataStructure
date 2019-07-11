public class Main {

    public static void main(String[] args) {
        Array<String> stringArray = new Array<String>();

        for (int i = 0; i < 10 ; i++){
            stringArray.add(i,i+"");
        }
        System.out.println(stringArray.toString());

        stringArray.remove(0);
        System.out.println(stringArray.toString());

    }
}
