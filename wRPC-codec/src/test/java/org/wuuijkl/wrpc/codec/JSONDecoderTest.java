package org.wuuijkl.wrpc.codec;

import junit.framework.TestCase;

public class JSONDecoderTest extends TestCase {

    public void testEncode() {
        Encoder encoder = new JSONEncoder();
        TestBean testBean = new TestBean();
        testBean.setAge(18);
        testBean.setName("wade");

        byte[] bytes = encoder.encode(testBean);
        assertNotNull(bytes);
    }

    public void testDecode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean1 = new TestBean();
        bean1.setAge(18);
        bean1.setName("wade");

        byte[] bytes = encoder.encode(bean1);

        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes, TestBean.class);
        assertEquals(bean1.getName(),bean2.getName());
        assertEquals(bean1.getAge(),bean2.getAge());
    }
}