package org.wuuijkl.wrpc.example;

/**
 * @Author wade
 * @Date 2022/3/20 12:20
 * @Description
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}
