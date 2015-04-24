package com.vcommunity.server.metrics;


import com.vcommunity.server.metrics.utils.Clock;

public class Timer {

	public static Clock clock = Clock.DEFAULT;

	public TimerMetric latestMetric = new TimerMetric();

	private Counter counter;
	private Histogram histogram;

	public Timer(Double... pcts) {
		counter = new Counter();
		histogram = new Histogram(pcts);
	}

	public void update(long start) {
		histogram.update(System.currentTimeMillis() - start);
		counter.inc();
	}

	public TimerContext start() {
		return new TimerContext(this, clock.getCurrentTime());
	}

	private void stopTimer(long startTime) {
		final long elapsed = clock.getCurrentTime() - startTime;
		histogram.update(elapsed);
		counter.inc();
	}

	public TimerMetric calculateMetric() {
		TimerMetric metric = new TimerMetric();
		metric.counterMetric = counter.calculateMetric();
		metric.histogramMetric = histogram.calculateMetric();
		latestMetric = metric;
		return metric;
	}

	@Override
	public String toString() {
		return "Timer [latestMetric=" + latestMetric + ", counter=" + counter + ", histogram=" + histogram + "]";
	}

	public static class TimerContext {
		private final Timer timer;
		private final long startTime;

		private TimerContext(Timer timer, long startTime) {
			this.timer = timer;
			this.startTime = startTime;
		}

		public void stop() {
			timer.stopTimer(startTime);
		}
	}
}
