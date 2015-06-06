package com.vcommunity.server.core.metrics.exporter;


import com.vcommunity.server.core.metrics.Counter;
import com.vcommunity.server.core.metrics.Gauge;
import com.vcommunity.server.core.metrics.Histogram;
import com.vcommunity.server.core.metrics.Timer;

public interface MetricRegistryListener {

	void onGaugeAdded(String name, Gauge gauge);

	void onCounterAdded(String name, Counter counter);

	void onHistogramAdded(String name, Histogram histogram);

	void onTimerAdded(String name, Timer timer);

	void onGaugeRemoved(String name);

	void onCounterRemoved(String name);

	void onHistogramRemoved(String name);

	void onTimerRemoved(String name);
}
