package microunit;

import example.ExampleTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AdvancedTestRunner
        extends TestRunner {

    public AdvancedTestRunner(Class<?> testClass) {
        super(testClass);
    }

    @Override
    protected void invokeTestMethod(Method testMethod,
                                    Object instance,
                                    Result result) throws IllegalAccessException {

        Test testAnnotation = testMethod.getAnnotation(Test.class);
        try {
            testMethod.invoke(instance);
            if(testAnnotation.expected() != Test.None.class) {
                throw new InvocationTargetException(
                        new AssertionError(
                                testAnnotation.expected() + " is not thrown"
                        )
                );
            }
            result.onSuccess();
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            cause.printStackTrace(System.out);
            if (cause instanceof AssertionError) {
                result.onFailure();
            } else {
                result.onError();
            }
        }
    }

    public static void main(String[] args) {
        new AdvancedTestRunner(ExampleTest.class).runTestMethods();
    }
}
