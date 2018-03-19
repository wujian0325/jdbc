package com.wj.demo.controller;

import com.wj.demo.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TransformTest extends ApplicationTests {

    @Autowired
    private Transform transform;

    @Test
    public void test() {
        transform.tran();
    }

}