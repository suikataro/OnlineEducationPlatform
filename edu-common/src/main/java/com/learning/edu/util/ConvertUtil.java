package com.learning.edu.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {
    //transfer two refular java object
    //BeanCopier from cglib
    public static <S,T> T convert(S source,T target){
        if(source == null || target == null){
            return null;
        }
        BeanCopier copier = BeanCopier.create(source.getClass(),target.getClass(),false);
        T result = target;
        copier.copy(source,result,null);
        return result;
    }

    // only need to pass target java class byte code
    public static <S,T> T convert(S source, Class<T> target) {
        try {
            return convert(source,target.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * copy list byte code of target class
     */
    public static <S,T> List<T> convertList(List<S> source, Class<T> target){
        if(source == null){
            return null;
        }
        return source.stream().map(item -> {
            T result = null;
            try {
                result = target.newInstance();
                convert(item,result);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return result;
        }).collect(Collectors.toList());
    }
}
