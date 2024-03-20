package example;

import microunit.Assert;
import microunit.Result;
import microunit.Test;
import microunit.TestRunner;

import java.io.IOException;
import java.lang.reflect.Method;

public class ExampleTest {

    @Test
    public void a() {
        Assert.assertTrue(1 + 1 == 2,
                "This should always be true");
    }

    @Test
    public void b() {
        Assert.assertTrue(1 + 1 == 0,
                "This should always be false");
    }

    @Test
    public void c() {
        Integer.parseInt("Hello World!");
    }

    @Test(expected = IOException.class)
    public void d() throws Exception {
    }

    @Test(expected = IOException.class)
    public void e() throws Exception {
        throw new IOException("hehe");
    }

    @Test(expected = IOException.class)
    public void f() throws Exception {
        throw new RuntimeException("hehe");
    }

    public void g() {
    }

    public static void main(String[] args) {
        new TestRunner(ExampleTest.class) {
            @Override
            protected void invokeTestMethod(Method testMethod,
                                            Object instance,
                                            Result result) {

            }
        }.runTestMethods();
    }
}
