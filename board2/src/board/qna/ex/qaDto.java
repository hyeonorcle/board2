package board.qna.ex;

import java.sql.Timestamp;

public class qaDto {
	
	private int qa_id;
	private String qa_name;
	private String qa_sub;
	private String qa_con;
	private Timestamp qa_date;
	private int qa_read;
	private int qa_count;
	public int getQa_id() {
		return qa_id;
	}
	public void setQa_id(int qa_id) {
		this.qa_id = qa_id;
	}
	public String getQa_name() {
		return qa_name;
	}
	public void setQa_name(String qa_name) {
		this.qa_name = qa_name;
	}
	public String getQa_sub() {
		return qa_sub;
	}
	public void setQa_sub(String qa_sub) {
		this.qa_sub = qa_sub;
	}
	public String getQa_con() {
		return qa_con;
	}
	public void setQa_con(String qa_con) {
		this.qa_con = qa_con;
	}
	public Timestamp getQa_date() {
		return qa_date;
	}
	public void setQa_date(Timestamp qa_date) {
		this.qa_date = qa_date;
	}
	public int getQa_read() {
		return qa_read;
	}
	public void setQa_read(int qa_read) {
		this.qa_read = qa_read;
	}
	public int getQa_count() {
		return qa_count;
	}
	public void setQa_count(int qa_count) {
		this.qa_count = qa_count;
	}	

}
