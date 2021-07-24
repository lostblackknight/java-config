package io.github.lostbalckknight.api;

import java.lang.annotation.*;


/**
 * 属性映射，在枚举类的属性上使用
 * <p>建立{@link AbstractResult#code}，{@link AbstractResult#message}与{@link AbstractResult#status}之间的映射
 * <p>你也可以在{@link AbstractResult}的实现类中自定义属性，使用自定义属性来建立与{@link AbstractResult#status}之间的映射
 * <p>注意：
 * <ul>
 *     <li>枚举类中的属性必须有对应的getter方法，且属性的类型必须与要映射的属性的类型保持一致</li>
 *     <li>如果枚举类中的属性名和{@link AbstractResult}以及其实现类中的属性名一致，可以不使用 {@link FieldMapping}</li>
 * </ul>
 *
 * @author chensixiang chensixiang1234@gmail.com
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMapping {

    /**
     * {@link AbstractResult} 以及其实现类中的属性名
     */
    String value();
}
