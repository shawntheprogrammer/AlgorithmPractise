

public class Singleton {
    /**
     * @return: The same instance of this class every time
     */
    public static Singleton mySolution;
    
    public static Singleton getInstance() {
        // write your code here
        if (mySolution == null) {
            instantiateInstance();
        }
        
        return mySolution;
    }
    
    public static void instantiateInstance() {
        mySolution = new Singleton();
    }
};
