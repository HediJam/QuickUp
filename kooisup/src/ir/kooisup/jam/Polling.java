package ir.kooisup.jam;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class Polling implements Serializable {

	int sample = 0;
	String category;

	public int getSample() {
		return sample;
	}

	public void setSample(int sample) {
		this.sample = sample;
	}

	public Polling() {
		// TODO Auto-generated constructor stub
	}

	public void waitingForSubject() {
		sample++;
		System.out.println("waitingFor subject bad bad az invitation nayad----");
		DBHandler db = DBHandler.getInstance();
		int state = db.anyRequest();
		if (state > -1) {
			System.out.println("maful bere tu safe invitiation");
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			try {
				System.out.println("in age umad un nayad----");
				ec.redirect(ec.getRequestContextPath() + "/" + "invitation.xhtml?quizId=" + state);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void searchOpp() {
		System.out.println("start searching...");
		DBHandler db = DBHandler.getInstance();
		db.basicInit();
		System.out.println(category);
		Quiz quiz = db.createQuiz("math");
		HttpSession hs = Util.getSession();
		db.onlineRequest(quiz.getQzId(), (String) hs.getAttribute("username"));
		while (!db.hasAccepted(quiz.getQzId()));
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/" + "quiz2.xhtml?id=" + quiz.getQzId() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirect to quiz online
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
