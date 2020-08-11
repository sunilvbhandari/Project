package com.corona.VirusTrcaker;

public class Detail {
	private String state,country,lat,longt,cases;
	public Detail(String state, String country, String lat, String longt, String cases) {
		super();
		this.state = state;
		this.country = country;
		this.lat = lat;
		this.longt = longt;
		this.cases = cases;
	}
	
	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getLat() {
		return lat;
	}

	public String getLongt() {
		return longt;
	}

	public String getCases() {
		return cases;
	}

	@Override
	public String toString() {
		return "Detail [state=" + state + ", country=" + country + ", lat=" + lat + ", longt=" + longt + ", cases="
				+ cases + "]";
	}
	

}
