package utilities;



public class Log extends Utilities{

    static Console console = new Console();

    /*
     * Get Step Definition name
     * @param: N/A
     */
//    public static void stepDefinitionName(){
//        // Get invoking method name as step definition
//        String methodName = getMethodName().replace("_", " ").toUpperCase();
//        console.setStepDefinitionName(methodName);
//        try{
//            stepDefinition = scenario.createNode(new GherkinKeyword("Given"), methodName);
//            console.setStepDefinitionName(methodName);
//
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SecurityException e) {
//            e.printStackTrace();
//        }
//    }






    /*
     * Returns the name of the invoking method
     * @param: N/A
     */
//    private static String getMethodName(){
//
//        String methodName = null;
//        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
//        StackTraceElement e = stacktrace[3];
//        methodName = getMethodName();
//        return methodName;
//
//    }




}
