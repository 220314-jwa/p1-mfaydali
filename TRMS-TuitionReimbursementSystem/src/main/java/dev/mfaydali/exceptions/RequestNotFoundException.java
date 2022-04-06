package dev.mfaydali.exceptions;

public class RequestNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RequestNotFoundException(String message) {
		super("Request cannot be found in the database, check your request again.");
	}

}
