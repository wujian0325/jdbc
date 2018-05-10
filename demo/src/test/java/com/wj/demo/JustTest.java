package com.wj.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * created 2018-04-16 16:28
 *
 * @author 吴健
 */
@Slf4j
public class JustTest {

    @Test
    public void test () throws Exception {
        String s = "a'0112%'";
        log.info(s.substring(s.indexOf("'") + 1, s.lastIndexOf("'") - 1));
    }
}
