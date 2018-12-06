/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.math;

import Catalano.Statistics.Tools;

import java.util.List;


/**
 * file encoding: utf-8
 * Function : 个人java统计学辅助工具
 * Create : 2018/12/5 17:45
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
public class Statistics {

    /**
     * 对list求0.95置信区间  alpha
     * [mean（x）-z(alpha/2)*(sigma/sqrt(n)),mean（x）+z(alpha/2)*(sigma/sqrt(n))]
     * 置信水平1-alpha =0.95
     * mean 平均值；z(alpha/2)概率度，可查表得到，1-alpha =0.95时候，z(alpha/2)=1.9599639845400543D；sigma/sqrt(n) 样本均值标准差；sigma标准差；n样本量
     *
     * @param nums double[]
     * @return 0.95置信区间+区间变化值
     */
    public static double[] get95PercentConfidenceInterval(double nums[]) {
        final double p95 =1.9599639845400543D;
        double sigma = Tools.StandartDeviation(nums);
        double mean = Tools.Mean(nums);
        double min = mean - p95 * (sigma / Math.sqrt((double) nums.length));
        double max =  mean + p95 * (sigma / Math.sqrt((double) nums.length));
        double change = max - min;
        return new double[]{min, max, change};
    }
}
