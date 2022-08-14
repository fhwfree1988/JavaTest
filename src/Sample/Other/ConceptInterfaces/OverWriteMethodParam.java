package Sample.Other.ConceptInterfaces;

public class OverWriteMethodParam {

    static class NewString{
        String val;
        public NewString(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }
    public String myMethod(String val){
        System.out.println("Old Value -->" + val);
        val = "New Value";
        System.out.println("New Value -->" + val);
        return val;
    }

    public NewString myMethodModel(NewString val){
        System.out.println("NewString Old Value -->" + val.getVal());
        val.setVal("New Value");
        System.out.println("NewString New Value -->" + val.getVal());
        return val;
    }

    public static void main(String[] args) {
        OverWriteMethodParam overWriteMethodParam = new OverWriteMethodParam();

        String Value = "OldValue";
        overWriteMethodParam.myMethod(Value);
        System.out.println("Modified Value -->" + Value);

        System.out.println("-------------");
        System.out.println("-------------");

        NewString newString = new NewString("OldValue");
        overWriteMethodParam.myMethodModel(newString);
        System.out.println("Modified Value -->" + newString.getVal());
    }
}
