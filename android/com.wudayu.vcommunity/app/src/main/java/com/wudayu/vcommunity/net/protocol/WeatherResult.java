package com.wudayu.vcommunity.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wudayu.vcommunity.model.VcWeather;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 31, 2014, 3:52:30 PM
 * @Description: WeatherResult是根据气象台接口所单独设定的数据对象，接收天气Object Json
 *
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResult {

	@JsonProperty(value = "weatherinfo")
	private VcWeather weather;

	public VcWeather getWeather() {
		return weather;
	}

	public void setWeather(VcWeather weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "WeatherResult [weather=" + weather + "]";
	}

}
