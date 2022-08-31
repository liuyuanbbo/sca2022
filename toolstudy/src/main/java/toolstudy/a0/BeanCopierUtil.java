package toolstudy.a0;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class BeanCopierUtil {
    private BeanCopierUtil() {
    }

    public static <S, T> T copy(S source, Supplier<T> supplier) {
        return copy(source, supplier, null);
    }

    public static <S, T> T copy(S source, Supplier<T> supplier, Converter converter) {
        T t = supplier.get();
        BeanCopier beanCopier;
        if (converter == null) {
            beanCopier = BeanCopier.create(source.getClass(), t.getClass(), false);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), t.getClass(), true);
        }
        beanCopier.copy(source, t, converter);
        return t;
    }

    public static <S, T> List<T> copyList(List<S> sources, Supplier<T> supplier) {
        return copyList(sources, supplier, null);
    }

    public static <S, T> List<T> copyList(List<S> sources, Supplier<T> supplier, Converter converter) {
        return sources.stream().map(s -> copy(s, supplier, converter)).collect(Collectors.toList());
    }
}