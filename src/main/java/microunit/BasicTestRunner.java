package microunit;

import example.ExampleTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasicTestRunner
        extends TestRunner {

    public BasicTestRunner(Class<?> testClass) {
        super(testClass);
    }

    @Override
    protected void invokeTestMethod(Method testMethod,
                                    Object instance,
                                    Result result) throws IllegalAccessException {

        try {
            testMethod.invoke(instance);
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
        new BasicTestRunner(ExampleTest.class).runTestMethods();
    }
}
