package com.vcommunity.server.core.modules.utils;

import java.util.Date;

public interface Clock {

	static final Clock DEFAULT = new DefaultClock();

	Date getCurrentDate();

	long getCurrentTimeInMillis();

	public static class DefaultClock implements Clock {

		@Override
		public Date getCurrentDate() {
			return new Date();
		}

		@Override
		public long getCurrentTimeInMillis() {
			return System.currentTimeMillis();
		}
	}

	public static class MockClock implements Clock {

		private long time;

		public MockClock() {
			this(0);
		}

		public MockClock(Date date) {
			this.time = date.getTime();
		}

		public MockClock(long time) {
			this.time = time;
		}

		@Override
		public Date getCurrentDate() {
			return new Date(time);
		}

		@Override
		public long getCurrentTimeInMillis() {
			return time;
		}

		public void update(Date newDate) {
			time = newDate.getTime();
		}

		public void update(long newTime) {
			this.time = newTime;
		}

		public void increaseTime(int millis) {
			time += millis;
		}

		public void decreaseTime(int millis) {
			time -= millis;
		}
	}

}
