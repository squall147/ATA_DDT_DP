package singleton;

/**
 * Created by Robert_Kaszubowski on 11/21/2016.
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {

/*
        If you will try to use:

        SingleObject object = new SingleObject();

        Illegal construct
        Compile Time Error: The constructor SingleObject() is not visible
*/

        // Get the only object available
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}
