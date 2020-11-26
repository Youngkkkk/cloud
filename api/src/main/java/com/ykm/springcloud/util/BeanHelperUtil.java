package com.ykm.springcloud.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * <p>描述: [数据类型转换] </p>
 *
 * @author <a href="mailto:liyongkai@cqhyxk.com" rel="nofollow">李永楷</a>
 * @date 2020/10/1 21:21
 */
public class BeanHelperUtil {


    /**
     * 拷贝指定源列表到指定目标bean类型。并返回目标bean列表
     *
     * @param targetClazz 目标bean类型
     * @param sourceList  源bean列表
     * @param <T>         指目标bean类型
     * @param <D>         指代源bean类型
     * @return 返回指定目标bean目标类型列表
     */
    public static <T, D> List<T> copyForList(Class<T> targetClazz, List<D> sourceList) {
        if (Objects.isNull(sourceList) || Objects.isNull(targetClazz)) {
            return null;
        }
        return sourceList.stream().filter(Objects::nonNull).map(d -> {
            T t = null;
            try {
                t = targetClazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            if (Objects.nonNull(t)) {
                BeanUtils.copyProperties(d, t);
            }
            return t;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * 拷贝指定源列表到指定目标bean类型。并返回目标bean列表
     * List<UserDto> userDto = SysncMappingUtils.copyForList(UserDto::new, userDos);
     *
     * @param targetSupplier 目标bean提供者
     * @param sourceList     源bean列表
     * @param <T>            指目标bean类型
     * @param <D>            指代源bean类型
     * @return 返回指定目标bean目标类型列表
     */
    public static <T, D> List<T> copyForList(Supplier<T> targetSupplier, List<D> sourceList) {
        if (Objects.isNull(sourceList) || Objects.isNull(targetSupplier)) {
            return null;
        }
        return sourceList.stream().filter(Objects::nonNull).map(d ->
                copyForBean(targetSupplier, d))
                .filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * 拷贝指定bean到bean
     * UserDto userDto=SysncMappingUtils.copyForBean(UserDto::new, useDo);
     *
     * @param targetSupplier 目标Bean提供者
     * @param d              源bean
     * @param <T>            指目标bean类型
     * @param <D>            指代源bean类型
     * @return 返回指定目标bean目标类型
     */
    public static <T, D> T copyForBean(Supplier<T> targetSupplier, D d) {
        if (Objects.isNull(targetSupplier) || Objects.isNull(d)) {
            return null;
        }
        T t = null;
        t = targetSupplier.get();
        if (Objects.nonNull(t)) {
            BeanUtils.copyProperties(d, t);
        }
        return t;
    }

    /**
     * 拷贝指定bean到bean
     * @param input
     * @param output
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> T convert(S input, T output) {
        BeanUtils.copyProperties(input, output);
        return output;
    }

}
