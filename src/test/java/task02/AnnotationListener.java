package task02;


import org.testng.*;
import org.testng.annotations.CustomAttribute;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String className = method.getTestMethod().getTestClass().getName();
        String methodName = method.getTestMethod().getMethodName();

        try {
            Class<?> aClass = Class.forName(className);
            Method classMethod = aClass.getMethod(methodName, method.getTestMethod().getParameterTypes());
            for (Annotation annotation : classMethod.getAnnotations()) {
                if (annotation.annotationType().equals(TestMethodInfo.class)) {
                    System.out.print(((TestMethodInfo) annotation).priority() + "   ");
                    System.out.print(((TestMethodInfo) annotation).author() + "   ");
                    System.out.println(((TestMethodInfo) annotation).lastModified());
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
