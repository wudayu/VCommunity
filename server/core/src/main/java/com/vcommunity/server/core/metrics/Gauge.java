package com.vcommunity.server.core.metrics;

public abstract class Gauge {

	public Number latestMetric;

	public void calculateMetric() {
		latestMetric = getValue();
	}

	protected abstract Number getValue();

	@Override
	public String toString() {
		return "Gauge [latestMetric=" + latestMetric + "]";
	}
}
