
public class Guest {
private String name;
private long MobileNum;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobileNum() {
	return MobileNum;
}
public void setMobileNum(long mobileNum) {
	MobileNum = mobileNum;
}
@Override
public String toString() {
	return "Guest [name=" + name + ", MobileNum=" + MobileNum + "]";
}
public Guest(String name, long mobileNum) {
	super();
	this.name = name;
	MobileNum = mobileNum;
}

}
