package com.vcommunity.server.metrics;

import com.vcommunity.server.metrics.exporter.MetricRegistryListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class MetricRegistry {

	public static final MetricRegistry INSTANCE = new MetricRegistry();

	private Double[] defaultPcts = new Double[] {};

	private ConcurrentMap<String, Gauge> gauges = new ConcurrentHashMap<String, Gauge>();
	private ConcurrentMap<String, Counter> counters = new ConcurrentHashMap<String, Counter>();
	private ConcurrentMap<String, Histogram> histograms = new ConcurrentHashMap<String, Histogram>();
	private ConcurrentMap<String, Timer> timers = new ConcurrentHashMap<String, Timer>();

	private List<MetricRegistryListener> listeners = new ArrayList<MetricRegistryListener>();

	public static String name(String name, String... subNames) {
		final StringBuilder builder = new StringBuilder(name);
		if (subNames != null) {
			for (String s : subNames) {
				if ((s != null) && !s.isEmpty()) {
					builder.append('.').append(s);
				}
			}
		}
		return builder.toString();
	}

	public void registerGauge(String name, Gauge gauge) {
		gauges.put(name, gauge);
	}

	public Counter counter(String name) {
		if (counters.containsKey(name)) {
			return counters.get(name);
		} else {
			Counter counter = new Counter();
			return register(counters, name, counter);
		}
	}

	public Histogram histogram(String name, Double... pcts) {
		if (histograms.containsKey(name)) {
			return histograms.get(name);
		} else {
			Histogram histogram = new Histogram(((pcts != null) && (pcts.length > 0)) ? pcts : defaultPcts);
			return register(histograms, name, histogram);
		}
	}

	public Timer timer(String name, Double... pcts) {
		if (timers.containsKey(name)) {
			return timers.get(name);
		} else {
			Timer timer = new Timer(((pcts != null) && (pcts.length > 0) ? pcts : defaultPcts));
			return register(timers, name, timer);
		}
	}

	public void clearAll() {
		for (MetricRegistryListener listener : listeners) {
			for (String key : gauges.keySet()) {
				listener.onGaugeRemoved(key);
			}

			for (String key : counters.keySet()) {
				listener.onCounterRemoved(key);
			}

			for (String key : histograms.keySet()) {
				listener.onHistogramRemoved(key);
			}

			for (String key : timers.keySet()) {
				listener.onTimerRemoved(key);
			}
		}

		gauges.clear();
		counters.clear();
		histograms.clear();
		timers.clear();
	}

	private <T> T register(ConcurrentMap<String, T> metrics, String name, T newMetric) {
		T existingMetric = metrics.putIfAbsent(name, newMetric);
		if (existingMetric != null) {
			return existingMetric;
		} else {
			notifyNewMetric(name, newMetric);
			return newMetric;
		}
	}

	private void notifyNewMetric(String name, Object newMetric) {
		for (MetricRegistryListener listener : listeners) {
			if (newMetric instanceof Gauge) {
				listener.onGaugeAdded(name, (Gauge) newMetric);
			}
			if (newMetric instanceof Counter) {
				listener.onCounterAdded(name, (Counter) newMetric);
			}
			if (newMetric instanceof Histogram) {
				listener.onHistogramAdded(name, (Histogram) newMetric);
			}
			if (newMetric instanceof Timer) {
				listener.onTimerAdded(name, (Timer) newMetric);
			}
		}
	}

	public Map<String, Gauge> getGauges() {
		return gauges;
	}

	public Map<String, Counter> getCounters() {
		return counters;
	}


	public Map<String, Histogram> getHistograms() {
		return histograms;
	}

	public Map<String, Timer> getTimers() {
		return timers;
	}

	public void setDefaultPcts(Double[] defaultPcts) {
		this.defaultPcts = defaultPcts;
	}

	public void addListener(MetricRegistryListener listener) {
		listeners.add(listener);
	}
}
