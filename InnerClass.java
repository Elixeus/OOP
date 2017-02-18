public class InnerClass {
    public static final int LENGTH = 10;
    private int[] array = new int[LENGTH];
    // initialization block
    public InnerClass(){
        for (int i=0; i<array.length; i++){
            this.array[i] = i%3;
        }
        System.out.println("initialization finished!");
    }

    public void switchElement(){
        class Element{
            private String sign;
            public Element(int eleInt){
                this.sign = Integer.toString(eleInt);
            }
        }
        for (int j=0; j<array.length; j++){
            (String) array[j] = new Element(j).sign;
        }
        System.out.println(InnerClass.array);
        System.out.println("work completed");
    }

    public static void main(String[] args){
        InnerClass x = new InnerClass();
        x.switchElements();
    }
}
