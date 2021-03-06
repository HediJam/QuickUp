package ir.kooisup.jam;
import java.util.ArrayList;

public class Quiz {
	private int qzID;
	private int score1;
	private int score2;
	private int finishTime1;
	private int finishTime2;
	private String category;
	private String uid1;
	private String uid2;
	ArrayList<Integer> qsIDs;
	
	public Quiz(String category, int qzID, ArrayList<Integer> qsIDs) {
		this.category=category;
		this.qzID=qzID;
		this.score1=this.score2=0;
		this.finishTime1=this.finishTime2=0;
		this.uid1="";
		this.uid2="";
		this.qsIDs=qsIDs;
	}
	
	public Quiz(int qzID, int score1, int score2, int finishTime1, int finishTime2, 
			String category, String uid1, String uid2, ArrayList<Integer> qsIDs) {
		this.qzID=qzID;
		this.score1=score1;
		this.score2=score2;
		this.finishTime1=finishTime1;
		this.finishTime2=finishTime2;
		this.category=category;
		this.uid1=uid1;
		this.uid2=uid2;
		this.qsIDs=qsIDs;
	}
	

	public ArrayList<Integer> getQsIDs() {
		return qsIDs;
	}

	public void setQsIDs(ArrayList<Integer> qsIDs) {
		this.qsIDs = qsIDs;
	}

	
	public int getQzId() {
		return qzID;
	}
	
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	public int getFinishTime1() {
		return finishTime1;
	}
	public int getFinishTime2() {
		return finishTime2;
	}
	public String getCategory() {
		return category;
	}
	public String getUid1() {
		return uid1;
	}
	public String getUid2() {
		return uid2;
	}
	public void setQzId(int qzID) {
		this.qzID = qzID;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public void setFinishTime1(int finishTime1) {
		this.finishTime1 = finishTime1;
	}
	public void setFinishTime2(int finishTime2) {
		this.finishTime2 = finishTime2;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setUid1(String uid1) {
		this.uid1 = uid1;
	}
	public void setUid2(String uid2) {
		this.uid2 = uid2;
	}
	
	public int getScore(String uid){
		if(uid.equals(uid1)) return score1;
		else if(uid.equals(uid2)) return score2;
		return 0;
	}
	
	public int numPlayed() {
		if(uid1.equals("")) return 0;
		else if(uid2.equals("")) return 1;
		return 2;
	}
	
	public int numFinished() {
		if(finishTime1 ==0 && finishTime2 ==0) return 0;
		else if(finishTime1 ==0 && finishTime2 !=0) return 1;
		else if(finishTime1 !=0 && finishTime2 ==0) return 1;
		else if(finishTime1 !=0 && finishTime2 !=0) return 2;
		return -1;
	}
	
	public boolean hasOponentFinished(String uid) {
		if(uid.equals(uid1)) return finishTime2!=0;
		if(uid.equals(uid2)) return finishTime1!=0;
		return false;
	}

	@Override
	public String toString() {
		return "Quiz [qzID=" + qzID + ", score1=" + score1 + ", score2=" + score2 + ", finishTime1=" + finishTime1
				+ ", finishTime2=" + finishTime2 + ", category=" + category + ", uid1=" + uid1 + ", uid2=" + uid2
				+ ", qsIDs=" + qsIDs + "]";
	}
	
	String winner() {
		if(uid1.equals("") || uid2.equals("")) return "";
		if (score1>score2) return uid1;
		if (score2>score1) return uid2;
		if(finishTime1<finishTime2) return uid1;
		return uid2;
	}
	
	String strongWinner() {
		if(uid1.equals("") || uid2.equals("")) return "";
		if (score1>=score2 && finishTime1*2<=finishTime2) return uid1;
		if (score2>=score1 && finishTime2*2<=finishTime1) return uid2;
		return "";
	}
	
}
