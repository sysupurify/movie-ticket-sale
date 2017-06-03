package org.sysupurify.tickets.business.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@ManyToOne
	@JoinColumn(name = "screening_id")
	private Screening screening = null;

	private int row = 0;
	private int col = 0;
	private boolean empty = true;

	public Seat(final Screening screening, final int row, final int col) {
		this.screening = screening;
		this.row = row;
		this.col = col;
	}

	boolean getEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
