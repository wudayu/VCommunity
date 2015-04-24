package com.vcommunity.server.metrics;

public class TimerMetric {
	public CounterMetric counterMetric;
	public HistogramMetric histogramMetric;

	@Override
	public String toString() {
		return "TimerMetric [counterMetric=" + counterMetric + ", histogramMetric=" + histogramMetric + "]";
	}
}
