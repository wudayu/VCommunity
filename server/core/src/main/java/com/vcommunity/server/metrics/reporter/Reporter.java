package com.vcommunity.server.metrics.reporter;

import com.vcommunity.server.metrics.Counter;
import com.vcommunity.server.metrics.Gauge;
import com.vcommunity.server.metrics.Histogram;
import com.vcommunity.server.metrics.Timer;

import java.util.Map;


/**
 * Reporter的公共接口，被ReportScheduler定时调用。
 * 
 * @author Calvin
 * 
 */
public interface Reporter {
	void report(Map<String, Gauge> gauges, Map<String, Counter> counters, Map<String, Histogram> histograms,
				Map<String, Timer> timers);
}
