package Sample.Other.ConceptInterfaces.DefualtStatic;

public interface Evaluate {
    double getMount();
    default double ConsiderInsurance(){
        if(isHightValue(getMount()))//using static method and implementation method
            return getMount() - 200;

        return getMount();
    }
    static boolean isHightValue(double mount){
        //ERROR
        /*if(ConsiderInsurance()){
            if (getMount() > 3000) {
                return true;
            }
          }*/

        if (mount > 3000) {
            return true;
        }
        return false;
    }
}
