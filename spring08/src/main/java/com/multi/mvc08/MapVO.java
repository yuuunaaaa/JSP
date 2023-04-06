package com.multi.mvc08;

public class MapVO {
	String name;
	double latitude;
	double longitude;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "MapVO [name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
