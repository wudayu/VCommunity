package com.vcommunity.server.metrics;

public class CounterMetric {
	public long totalCount;
	public long meanRate;
	public long latestCount;
	public long latestRate;

	@Override
	public String toString() {
		return "CounterMetric [totalCount=" + totalCount + ", meanRate=" + meanRate + ", latestCount=" + latestCount
				+ ", latestRate=" + latestRate + "]";
	}
}
