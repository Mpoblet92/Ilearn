package Model;

public class PlanOfStudy {
	private String major, pos, areaA, areaB, areaC, areaD, areaE, areaF, areaMajor, areaMajorElec, areaOther, areaElec;
	
	public PlanOfStudy(String major, String pos, String areaA, String areaB, String areaC, String areaD, String areaE, String areaF, String areaMajor, String areaMajorElec, String areaOther, String areaElec) {
		this.major = major;
		this.pos = pos;
		this.areaA = areaA;
		this.areaB = areaB;
		this.areaC = areaC;
		this.areaD = areaD;
		this.areaE = areaE;
		this.areaF = areaF;
		this.areaMajor = areaMajor;
		this.areaMajorElec = areaMajorElec;
		this.areaOther = areaOther;
		this.areaElec = areaElec;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getAreaA() {
		return areaA;
	}

	public void setAreaA(String areaA) {
		this.areaA = areaA;
	}

	public String getAreaB() {
		return areaB;
	}

	public void setAreaB(String areaB) {
		this.areaB = areaB;
	}

	public String getAreaC() {
		return areaC;
	}

	public void setAreaC(String areaC) {
		this.areaC = areaC;
	}

	public String getAreaD() {
		return areaD;
	}

	public void setAreaD(String areaD) {
		this.areaD = areaD;
	}

	public String getAreaE() {
		return areaE;
	}

	public void setAreaE(String areaE) {
		this.areaE = areaE;
	}

	public String getAreaF() {
		return areaF;
	}

	public void setAreaF(String areaF) {
		this.areaF = areaF;
	}

	public String getAreaMajor() {
		return areaMajor;
	}

	public void setAreaMajor(String areaMajor) {
		this.areaMajor = areaMajor;
	}

	public String getAreaMajorElec() {
		return areaMajorElec;
	}

	public void setAreaMajorElec(String areaMajorElec) {
		this.areaMajorElec = areaMajorElec;
	}

	public String getAreaOther() {
		return areaOther;
	}

	public void setAreaOther(String areaOther) {
		this.areaOther = areaOther;
	}

	public String getAreaElec() {
		return areaElec;
	}

	public void setAreaElec(String areaElec) {
		this.areaElec = areaElec;
	}
	
}
