package com.pyq.study.mvelTest;

import lombok.Data;

import java.util.List;

/**
 * Created by pangyueqiang on 17/6/13.
 */
@Data
public class ClassA {
    private Integer aAge;
    private String aName;
    private ClassB classB;
    private List<ClassC> classC;
}
