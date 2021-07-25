package task02;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //on class level
public @interface TestMethodInfo {

    //Приоритет теста
    Priority priority() default Priority.Major;

    //Автор теста
    String author() default "Bill Gates";

    //Дата последних изменений в тесте
    String lastModified() default "01.01.2019";
}