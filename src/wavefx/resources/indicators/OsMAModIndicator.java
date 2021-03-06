package com.dukascopy.indicators;

import com.dukascopy.api.indicators.IIndicator;
import com.dukascopy.api.indicators.IIndicatorContext;
import com.dukascopy.api.indicators.IndicatorInfo;
import com.dukascopy.api.indicators.IndicatorResult;
import com.dukascopy.api.indicators.InputParameterInfo;
import com.dukascopy.api.indicators.IntegerRangeDescription;
import com.dukascopy.api.indicators.OptInputParameterInfo;
import com.dukascopy.api.indicators.OutputParameterInfo;

/**
 * @author S.Vishnyakov
 * Date: Dec 17, 2009
 */

public class OsMAModIndicator implements IIndicator {
    private IndicatorInfo indicatorInfo;
    private InputParameterInfo[] inputParameterInfos;
    private OptInputParameterInfo[] optInputParameterInfos;
    private OutputParameterInfo[] outputParameterInfos;
    private double[][] inputs = new double[1][];
    private int fastPeriod = 12;
    private int slowPeriod = 26;
    private int signalPeriod = 9;
    private double[][] outputs = new double[1][];
    private IIndicator macd;

    public void onStart(IIndicatorContext context) {
        macd = context.getIndicatorsProvider().getIndicator("MACD");
        macd.setOptInputParameter(0, fastPeriod);
        macd.setOptInputParameter(1, slowPeriod);
        macd.setOptInputParameter(2, signalPeriod);
        indicatorInfo = new IndicatorInfo("OsMAmod", "Moving Average of Oscillator", "Momentum Indicators",
                false, false, true, 1, 3, 1);
        inputParameterInfos = new InputParameterInfo[] {new InputParameterInfo("Input data", InputParameterInfo.Type.DOUBLE)};
        optInputParameterInfos = new OptInputParameterInfo[] {
            new OptInputParameterInfo("Fast period", OptInputParameterInfo.Type.OTHER, new IntegerRangeDescription(12, 3, 1000, 1)),
            new OptInputParameterInfo("Slow period", OptInputParameterInfo.Type.OTHER, new IntegerRangeDescription(26, 3, 1000, 1)),
            new OptInputParameterInfo("Signal period", OptInputParameterInfo.Type.OTHER, new IntegerRangeDescription(9, 3, 1000, 1))
        };
        outputParameterInfos = new OutputParameterInfo[] {new OutputParameterInfo("OsMAmod", OutputParameterInfo.Type.DOUBLE,
                OutputParameterInfo.DrawingStyle.HISTOGRAM)};
    }

    public IndicatorResult calculate(int startIndex, int endIndex) {
        //calculating startIndex taking into account lookback value
        if (startIndex - getLookback() < 0) {
            startIndex -= startIndex - getLookback();
        }

        if (startIndex > endIndex) {
            return new IndicatorResult(0, 0);
        }
        macd.setOptInputParameter(0, fastPeriod);
        macd.setOptInputParameter(1, slowPeriod);
        macd.setOptInputParameter(2, signalPeriod);

        double[] macdA = new double[endIndex + 1 - macd.getLookback()];
        double[] macdA2 = new double[endIndex + 1 - macd.getLookback()];
        double[] macdA3 = new double[endIndex + 1 - macd.getLookback()];
        macd.setInputParameter(0, inputs[0]);
        macd.setOutputParameter(0, macdA);
        macd.setOutputParameter(1, macdA2);
        macd.setOutputParameter(2, macdA3);
        IndicatorResult dMACDResult = macd.calculate(startIndex, endIndex);

        int i, k;
        for (i = 0, k = dMACDResult.getNumberOfElements(); i < k; i++) {
            outputs[0][i] =  macdA3[i];
        }
        return new IndicatorResult(startIndex, i);
    }

    public IndicatorInfo getIndicatorInfo() {
        return indicatorInfo;
    }

    public InputParameterInfo getInputParameterInfo(int index) {
        if (index <= inputParameterInfos.length) {
            return inputParameterInfos[index];
        }
        return null;
    }

    public int getLookback() {
        return macd.getLookback();
    }

    public int getLookforward() {
        return 0;
    }

    public OptInputParameterInfo getOptInputParameterInfo(int index) {
        if (index <= optInputParameterInfos.length) {
            return optInputParameterInfos[index];
        }
        return null;
    }

    public OutputParameterInfo getOutputParameterInfo(int index) {
        if (index <= outputParameterInfos.length) {
            return outputParameterInfos[index];
        }
        return null;
    }

    public void setInputParameter(int index, Object array) {
        inputs[index] = (double[]) array;
    }

    public void setOptInputParameter(int index, Object value) {
        if (index == 0) {
            fastPeriod = (Integer) value;
            macd.setOptInputParameter(0, fastPeriod);
        } else if (index == 1) {
            slowPeriod = (Integer) value;
            macd.setOptInputParameter(1, slowPeriod);
        } else {
            signalPeriod = (Integer) value;
        macd.setOptInputParameter(2, signalPeriod);
        }
    }

    public void setOutputParameter(int index, Object array) {
        outputs[index] = (double[]) array;
    }
}
