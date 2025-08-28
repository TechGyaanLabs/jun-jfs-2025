package com.careerit.lutil;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertorUtil {

        private final ModelMapper modelMapper = new ModelMapper();

        public  <D, T> D convert(final T entity, Class<D> outClass) {
                return modelMapper.map(entity, outClass);
        }

        public  <D, T> List<D> convert(final List<T> entityList, Class<D> outClass) {
                return entityList.stream()
                        .map(entity -> modelMapper.map(entity, outClass))
                        .collect(Collectors.toList());
        }

}
