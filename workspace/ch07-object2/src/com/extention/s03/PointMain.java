package com.extention.s03;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocation() {
		return "x : " + x + ", y: " + y;
	}
}

class Point3D extends Point{
	int z;
	
	public Point3D(int x, int y, int z) {
		//super()는 항상 맨 위에 있어야 함
		super(x, y);
		this.z = z;
	}
		
	public String getLocation(){
		return "x : " + x + ", y: " + y + ", z: " + z;
	}
}

public class PointMain {
	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3);
		System.out.println(p.getLocation());
		
	}
}
