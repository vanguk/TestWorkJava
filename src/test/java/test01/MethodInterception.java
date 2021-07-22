package test01;

import org.junit.jupiter.api.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import static org.junit.jupiter.api.Assertions.*;


public class MethodInterception {

    @Test
    public void annotationValue() {
        MainPage mainPage = createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(".//*[@test-attr='button_search']",mainPage.buttonSearch());
        assertEquals(".//*[@test-attr='input_search']",mainPage.textInputSearch());
    }

    private MainPage createPage(Class clazz) {

        return (MainPage) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                (proxy, method, methodArgs) -> {
                    Annotation[] annotations = method.getAnnotations();
                    if (annotations != null && annotations.length > 0) {
                        for (Annotation anno : annotations) {
                            if (anno.annotationType().equals(Selector.class)) {
                                 return ((Selector)anno).xpath();
                            }
                        }
                    }
                    throw new RuntimeException("Method is not annotated");
                });

    }
}