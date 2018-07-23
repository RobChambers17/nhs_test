/**
 * 
 */
/**
 * @author robert.b.chambers
 *
 */
package com.logicbig.example;

public enum Frequency {
    WEEK("Weekly", "1"), 
    TWO_WEEK("Fourtnighly", "2"), 
    FOUR_WEEK("Every four weeks", "4"), 
    MONTH("Monthly", "0"), 
    QUARTER("Quarterly", "13"), 
    YEAR("Yearly", "52");

	private final String weeklyInterval;
	private final String text;

	private Frequency(final String text, final String weeklyInterval) {
		this.text = text;
		this.weeklyInterval = weeklyInterval;
	}

	public String getText() {
		return this.text;
	}

	public String getWeeklyInterval() {
		return this.weeklyInterval;
	}
}
	
